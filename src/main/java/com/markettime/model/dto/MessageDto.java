package com.markettime.model.dto;

/**
 * 
 * @author Dana Onisa
 *
 */
public class MessageDto {

	private String companyName;
	private String email;
	private String comments;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "MessageDto [companyName=" + companyName + ", email=" + email + ", comments=" + comments + "]";
	}

}
