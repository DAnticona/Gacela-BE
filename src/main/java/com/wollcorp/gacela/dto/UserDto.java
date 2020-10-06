package com.wollcorp.gacela.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private Long lastLoginDate;
	private String createdBy;
	private String lastModifiedBy;
	private Long createdDate;
	private Long lastModifiedDate;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the lastLoginDate
	 */
	public Long getLastLoginDate() {
		return lastLoginDate;
	}
	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Long lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	/**
	 * @param lastModifiedBy the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	/**
	 * @return the createdDate
	 */
	public Long getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the lastModifiedDate
	 */
	public Long getLastModifiedDate() {
		return lastModifiedDate;
	}
	/**
	 * @param lastModifiedDate the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	@Override
	public String toString() {
		return "UsuarioDto [username=" + username + ", password=" + password + ", lastLoginDate=" + lastLoginDate
				+ ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
}
