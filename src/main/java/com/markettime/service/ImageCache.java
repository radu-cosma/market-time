package com.markettime.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
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
    private static final int ADD_PRODUCT_SESSION_LIFETIME_MILLIS = 60 * 60 * 1000;
    private static final int CACHE_CLEANUP_RATE_MILLIS = 5 * 60 * 1000;

    private static Map<AddProductSession, ProductImagesList> imageCache;
    static {
        imageCache = new HashMap<>();
    }

    /**
     *
     */
    @Scheduled(fixedRate = CACHE_CLEANUP_RATE_MILLIS)
    public void cleanupCache() {
        imageCache.entrySet().removeIf(entry -> System.currentTimeMillis()
                - entry.getValue().getLastAccess().getTime() > ADD_PRODUCT_SESSION_LIFETIME_MILLIS);
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
    public void remove(Long userId, String addProductSessionId) {
        AddProductSession addProductSession = new AddProductSession(userId, addProductSessionId);
        if (imageCache.containsKey(addProductSession)) {
            imageCache.remove(addProductSession);
        } else {
            LOGGER.info("Nothing cached for {}", addProductSession);
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
        getUpdatedProductImagesList(addProductSession).getProductImages().add(addProductImageDto);
    }

    /**
     *
     * @param addProductSession
     * @param weight
     */
    public void removeImage(Long userId, RemoveProductImageDto removeProductImageDto) {
        AddProductSession addProductSession = new AddProductSession(userId,
                removeProductImageDto.getAddProductSessionId());
        List<AddProductImageDto> productImages = getUpdatedProductImagesList(addProductSession).getProductImages();
        productImages.removeIf(productImage -> productImage.getWeight() == removeProductImageDto.getWeight());
        recalibrateWeights(productImages);
    }

    /**
     *
     * @param addProductSession
     * @return
     */
    public List<AddProductImageDto> getImages(Long userId, String addProductSessionId) {
        AddProductSession addProductSession = new AddProductSession(userId, addProductSessionId);
        return getUpdatedProductImagesList(addProductSession).getProductImages();
    }

    private ProductImagesList getUpdatedProductImagesList(AddProductSession addProductSession) {
        ProductImagesList productImagesList = imageCache.get(addProductSession);
        if (productImagesList != null) {
            if (System.currentTimeMillis()
                    - productImagesList.getLastAccess().getTime() <= ADD_PRODUCT_SESSION_LIFETIME_MILLIS) {
                productImagesList.setLastAccess(new Date());
                return productImagesList;
            } else {
                throw new ApplicationException(String.format("Add product session expired for %s", addProductSession));
            }
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

}
