package com.markettime.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.markettime.aop.LoggedIn;
import com.markettime.context.UserContext;
import com.markettime.model.dto.request.AddProductRequestDto;
import com.markettime.model.entity.ProductEntity;
import com.markettime.model.entity.ProductTagEntity;
import com.markettime.model.entity.UserEntity;
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

    @Autowired
    private UserContext userContext;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTagRepository productTagRepository;

    // @Autowired
    // private ProductImageRepository productImageRepository;

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

        saveProductTags(addProductRequestDto.getTags(), productEntity);

        // saveProductImages();

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
