package com.markettime.model;

/**
 * 
 * @author Radu Cosma
 * 
 */
public class Session {

    private String username;
    private char[] passwordChars;
    private String uuid;
    private long lastAccess;

    public Session() {

    }

    public Session(String user, char[] passwrodChars, String uuid, long lastAccess) {
        this.username = user;
        this.passwordChars = passwrodChars;
        this.uuid = uuid;
        this.lastAccess = lastAccess;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char[] getPasswordChars() {
        return passwordChars;
    }

    public void setPasswordChars(char[] passwordChars) {
        this.passwordChars = passwordChars;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(long lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Session [username=").append(username).append(", uuid=").append(uuid).append(", lastAccess=")
                .append(lastAccess).append("]");
        return builder.toString();
    }
}
