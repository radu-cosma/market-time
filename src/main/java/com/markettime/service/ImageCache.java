package com.markettime.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.markettime.model.dto.request.AddProductImageDto;

/**
 *
 * @author Radu Cosma
 *
 */
@Component
public class ImageCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageCache.class);

    private static Map<Long, UserImages> imageCache;
    static {
        imageCache = new HashMap<>();
    }

    /**
     *
     * @return
     */
    public String initialize(Long userId) {
        String accessKey = UUID.randomUUID().toString();
        UserImages userImages = new UserImages();
        // userImages.accessKey = accessKey;
        userImages.images = new ArrayList<>();
        imageCache.put(userId, userImages);
        return accessKey;
    }

    /**
     *
     */
    public void clear(Long userId) {
        if (imageCache.containsKey(userId)) {
            imageCache.remove(userId);
        } else {
            LOGGER.info("No cached images for user with id={}", userId);
        }
    }

    /**
     *
     * @param addProductImageDto
     */
    public void addImage(Long userId, AddProductImageDto addProductImageDto) {
        UserImages userImages = imageCache.get(userId);
        if (userImages != null) {
            userImages.images.add(addProductImageDto);
        } else {
            LOGGER.error("Image cache is not initialized for user with id={}", userId);
        }
    }

    /**
     *
     * @param userId
     * @param weight
     */
    public void removeImage(Long userId, int weight) {
        UserImages userImages = imageCache.get(userId);
        // @formatter:off
        userImages.images.removeIf(productImage -> productImage.getWeight() == weight);
        // @formatter:on
    }

    /**
     *
     * @param userId
     */
    public void recalibrateWeights(Long userId) {
        UserImages userImages = imageCache.get(userId);
        // userImages.images.
    }

    /**
     *
     * @return
     */
    public List<AddProductImageDto> getImages(Long userId) {
        return imageCache.get(userId).images;
    }

    private class UserImages {

        // private String accessKey;
        private List<AddProductImageDto> images;

    }

}
