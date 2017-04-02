package com.markettime.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.markettime.aop.LoggedIn;
import com.markettime.context.UserContext;
import com.markettime.exception.ServiceValidationException;
import com.markettime.model.dto.request.AddProductImageDto;
import com.markettime.model.dto.request.AddProductRequestDto;
import com.markettime.model.dto.request.RemoveProductImageDto;
import com.markettime.model.entity.ImageTypeEntity;
import com.markettime.model.entity.ProductEntity;
import com.markettime.model.entity.ProductImageEntity;
import com.markettime.model.entity.ProductTagEntity;
import com.markettime.model.entity.UserEntity;
import com.markettime.repository.ImageTypeRepository;
import com.markettime.repository.ProductImageRepository;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

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

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ImageCache imageCache;

    @Autowired
    private Cloudinary cloudinary;

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
     * @return
     */
    @LoggedIn
    public String prepareCache() {
        Long userId = userContext.getUserId();
        return imageCache.initialize(userId);
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
        if (!(addProductImageDto.getImageData() == null ^ addProductImageDto.getUrl() == null)) {
            throw new ServiceValidationException("Image data and image URL cannot be both present or absent.");
        }
    }

    /**
     *
     * @param weight
     */
    @LoggedIn
    public void uncacheImage(RemoveProductImageDto removeProductImageDto) {
        Long userId = userContext.getUserId();
        imageCache.removeImage(userId, removeProductImageDto);
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

        saveProductImages(productEntity, addProductRequestDto.getAddProductSessionId());
        saveProductTags(addProductRequestDto.getTags(), productEntity);
    }

    private void saveProductImages(ProductEntity productEntity, String addProductSessionId) {
        Long userId = userContext.getUserId();
        List<AddProductImageDto> productImages = imageCache.getImages(userId, addProductSessionId);
        imageCache.remove(userId, addProductSessionId);
        for (AddProductImageDto addProductImageDto : productImages) {
            ProductImageEntity productImageEntity = BeanMapperUtil.map(addProductImageDto, ProductImageEntity.class);
            productImageEntity.setProduct(productEntity);
            productImageEntity.setImageType(imageTypeRepository.findByType(addProductImageDto.getType()));
            if (addProductImageDto.getImageData() != null) {
                String cloudinaryImageUrl = uploadImageToCloudinary(addProductImageDto);
                if (cloudinaryImageUrl != null) {
                    productImageEntity.setUrl(cloudinaryImageUrl);
                } else {
                    // TODO: save on disk for retrying later
                }
            }
            productImageRepository.persist(productImageEntity);
        }
    }

    private String uploadImageToCloudinary(AddProductImageDto addProductImageDto) {
        String cloudinaryImageUrl = null;
        try {
            @SuppressWarnings("rawtypes")
            Map uploadResult = cloudinary.uploader().upload(addProductImageDto.getImageData(),
                    ObjectUtils.asMap("filename", addProductImageDto.getName()));
            if (uploadResult.containsKey("url")) {
                cloudinaryImageUrl = (String) uploadResult.get("url");
            }
        } catch (Exception e) {
            LOGGER.error(String.format("An exception occurred while uploading %s", addProductImageDto), e);
        }
        return cloudinaryImageUrl;
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

}
