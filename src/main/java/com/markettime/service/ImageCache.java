package com.markettime.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.markettime.exception.ApplicationException;
import com.markettime.model.dto.request.AddProductImageDto;
import com.markettime.model.dto.request.RemoveProductImageDto;
import com.markettime.service.model.AddProductSession;
import com.markettime.service.model.ProductImagesList;

/**
 *
 * @author Radu Cosma
 *
 */
@Component
public class ImageCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageCache.class);

    private static Map<AddProductSession, ProductImagesList> imageCache;
    static {
        imageCache = new HashMap<>();
    }

    /**
     *
     * @param userId
     */
    public String initialize(Long userId) {
        String addProductSessionId = UUID.randomUUID().toString();
        imageCache.put(new AddProductSession(userId, addProductSessionId), new ProductImagesList());
        return addProductSessionId;
    }

    /**
     *
     * @param addProductSession
     */
    public void clear(Long userId, String addProductSessionId) {
        AddProductSession addProductSession = new AddProductSession(userId, addProductSessionId);
        if (imageCache.containsKey(addProductSession)) {
            imageCache.remove(addProductSession);
        } else {
            LOGGER.info("No cached images for {}", addProductSession);
        }
    }

    /**
     *
     * @param addProductSession
     * @param addProductImageDto
     */
    public void addImage(Long userId, AddProductImageDto addProductImageDto) {
        AddProductSession addProductSession = new AddProductSession(userId,
                addProductImageDto.getAddProductSessionId());
        ProductImagesList productImagesList = imageCache.get(addProductSession);
        productImagesList.setLastAccess(new Date());
        List<AddProductImageDto> productImages = productImagesList.getProductImages();
        if (productImages != null) {
            productImages.add(addProductImageDto);
        } else {
            throw new ApplicationException(String.format("Image cache is not initialized for %s", addProductSession));
        }
    }

    /**
     *
     * @param addProductSession
     * @param weight
     */
    public void removeImage(Long userId, RemoveProductImageDto removeProductImageDto) {
        AddProductSession addProductSession = new AddProductSession(userId,
                removeProductImageDto.getAddProductSessionId());
        ProductImagesList productImagesList = imageCache.get(addProductSession);
        productImagesList.setLastAccess(new Date());
        List<AddProductImageDto> productImages = productImagesList.getProductImages();
        if (productImages != null) {
            productImages.removeIf(productImage -> productImage.getWeight() == removeProductImageDto.getWeight());
            recalibrateWeights(productImages);
        } else {
            throw new ApplicationException(String.format("Image cache is not initialized for %s", addProductSession));
        }
    }

    private void recalibrateWeights(List<AddProductImageDto> productImages) {
        int previousImageWeight = 0;
        for (AddProductImageDto addProductImageDto : productImages) {
            addProductImageDto.setWeight(++previousImageWeight);
        }
    }

    /**
     *
     * @param addProductSession
     * @return
     */
    public List<AddProductImageDto> getImages(Long userId, String addProductSessionId) {
        AddProductSession addProductSession = new AddProductSession(userId, addProductSessionId);
        return imageCache.get(addProductSession).getProductImages();
    }

}
