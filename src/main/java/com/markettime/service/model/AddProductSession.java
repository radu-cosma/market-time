package com.markettime.service.model;

/**
 *
 * @author Radu Cosma
 *
 */
public class AddProductSession {

    private Long userId;
    private String addProductSessionId;

    public AddProductSession(Long userId, String addProductSessionId) {
        this.userId = userId;
        this.addProductSessionId = addProductSessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getAddProductSessionId() {
        return addProductSessionId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (addProductSessionId == null ? 0 : addProductSessionId.hashCode());
        result = prime * result + (userId == null ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AddProductSession other = (AddProductSession) obj;
        if (addProductSessionId == null) {
            if (other.addProductSessionId != null) {
                return false;
            }
        } else if (!addProductSessionId.equals(other.addProductSessionId)) {
            return false;
        }
        if (userId == null) {
            if (other.userId != null) {
                return false;
            }
        } else if (!userId.equals(other.userId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AddProductSession [userId=").append(userId).append(", addProductSessionId=")
                .append(addProductSessionId).append("]");
        return builder.toString();
    }

}
