package com.markettime.model.dto;

/**
 *
 * @author Radu Cosma
 *
 */
public class MessageDto {

    private Long id;
    private String title;
    private String content;
    private String date;
    private boolean read;

    public MessageDto() {

    }

    public MessageDto(Long id, String title, String content, String date, boolean read) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.read = read;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MessageDto [id=").append(id).append(", title=").append(title).append(", content=")
                .append(content).append(", date=").append(date).append(", read=").append(read).append("]");
        return builder.toString();
    }

}
