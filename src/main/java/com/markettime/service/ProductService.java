package com.markettime.service;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.markettime.aop.LoggedIn;
import com.markettime.context.UserContext;
import com.markettime.exception.ServiceValidationException;
import com.markettime.model.dto.request.AddProductImageDto;
import com.markettime.model.dto.request.AddProductRequestDto;
import com.markettime.model.entity.ImageTypeEntity;
import com.markettime.model.entity.ProductEntity;
import com.markettime.model.entity.ProductImageEntity;
import com.markettime.model.entity.ProductTagEntity;
import com.markettime.model.entity.UserEntity;
import com.markettime.repository.ImageTypeRepository;
import com.markettime.repository.ProductRepository;
import com.markettime.repository.ProductTagRepository;
import com.markettime.repository.UserRepository;
import com.markettime.util.BeanMapperUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class ProductService {

    private static final String TEMP_IMAGE_URL = "http://smilecreations-music-label.com/wp-content/uploads/2016/07/new2.png";

    @Autowired
    private UserContext userContext;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTagRepository productTagRepository;

    @Autowired
    private ImageTypeRepository imageTypeRepository;

    // @Autowired
    // private ProductImageRepository productImageRepository;

    @Autowired
    private ImageCache imageCache;

    @Value("#{cloudinary.cloud.name}")
    private String cloudinaryCloudName;

    @Value("#{cloudinary.api.key}")
    private String cloudinaryApiKey;

    @Value("#{cloudinary.api.secret}")
    private String cloudinaryApiSecret;

    /**
     *
     * @return
     */
    @LoggedIn
    public List<String> getImageTypes() {
        // @formatter:off
        return imageTypeRepository.findAll()
                .stream()
                .map(ImageTypeEntity::getType)
                .collect(Collectors.toList());
        // @formatter:on
    }

    /**
     *
     */
    @LoggedIn
    public void prepareCache() {
        Long userId = userContext.getUserId();
        imageCache.clear(userId);
        imageCache.initialize(userId);
    }

    /**
     *
     * @param addProductImageDto
     */
    @LoggedIn
    public void cacheImage(AddProductImageDto addProductImageDto) {
        validateImage(addProductImageDto);
        Long userId = userContext.getUserId();
        imageCache.addImage(userId, addProductImageDto);
    }

    private void validateImage(AddProductImageDto addProductImageDto) {
        String imageType = addProductImageDto.getType();
        // @formatter:off
        boolean isValidType = imageTypeRepository.findAll().stream()
                .map(ImageTypeEntity::getType)
                .anyMatch(type -> type.equals(imageType));
        // @formatter:on
        if (!isValidType) {
            throw new ServiceValidationException(String.format("Unknown image type: %s", imageType));
        }
    }

    /**
     *
     * @param weight
     */
    @LoggedIn
    public void uncacheImage(int weight) {
        Long userId = userContext.getUserId();
        imageCache.removeImage(userId, weight);
        imageCache.recalibrateWeights(userId);
    }

    /**
     *
     * @param addProductRequestDto
     */
    @LoggedIn
    public void addProduct(AddProductRequestDto addProductRequestDto) {
        UserEntity userEntity = userRepository.find(userContext.getUserId());

        ProductEntity productEntity = BeanMapperUtil.map(addProductRequestDto, ProductEntity.class);
        productEntity.setUser(userEntity);

        productRepository.persist(productEntity);

        saveProductImages(productEntity);
        saveProductTags(addProductRequestDto.getTags(), productEntity);
    }

    private void saveProductImages(ProductEntity productEntity) {
        Long userId = userContext.getUserId();
        List<AddProductImageDto> productImages = imageCache.getImages(userId);
        for (AddProductImageDto addProductImageDto : productImages) {
            ProductImageEntity productImageEntity = BeanMapperUtil.map(addProductImageDto, ProductImageEntity.class);
            productImageEntity.setProduct(productEntity);
            productImageEntity.setImageType(imageTypeRepository.findByType(addProductImageDto.getType()));
            if (addProductImageDto.getImageData() != null) {
                String imageUuid = saveImageToDisk(addProductImageDto);
                productImageEntity.setUrl(TEMP_IMAGE_URL + imageUuid);
            }
        }
    }

    private String saveImageToDisk(AddProductImageDto addProductImageDto) {
        String imageUuid = UUID.nameUUIDFromBytes(addProductImageDto.getImageData()).toString();
        return imageUuid;
    }

    private void saveProductTags(String tags, ProductEntity productEntity) {
        // @formatter:off
        Arrays.stream(tags.split(","))
            .map(tag -> tag.trim())
            .forEach(tag -> {
                ProductTagEntity productTagEntity = new ProductTagEntity();
                productTagEntity.setName(tag);
                productTagEntity.setProduct(productEntity);
                productTagRepository.persist(productTagEntity);
        });
        // @formatter:on
    }

    public void uploadImage(AddProductImageDto addProductImageDto) {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", cloudinaryCloudName, "api_key",
                cloudinaryApiKey, "api_secret", cloudinaryApiSecret));
        File file = new File
    }

}
