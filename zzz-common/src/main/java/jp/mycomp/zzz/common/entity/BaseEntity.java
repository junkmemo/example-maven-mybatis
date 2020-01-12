package jp.mycomp.zzz.common.entity;

import java.util.Date;

public class BaseEntity {

	/** 生成日時 */
	private Date createdTimestamp;

	/** 生成ユーザID */
	private String createdUserId;

	/** 更新日時 */
	private Date updatedTimestamp;

	/** 更新ユーザID */
	private String updatedUserId;

	/** バージョン */
	private int version;

	/**
	 * @return createdTimestamp
	 */
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	/**
	 * @param createdTimestamp セットする createdTimestamp
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	/**
	 * @return createdUserId
	 */
	public String getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * @param createdUserId セットする createdUserId
	 */
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * @return updatedTimestamp
	 */
	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	/**
	 * @param updatedTimestamp セットする updatedTimestamp
	 */
	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	/**
	 * @return updatedUserId
	 */
	public String getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * @param updatedUserId セットする updatedUserId
	 */
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * @return version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version セットする version
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/*
	 * (非 Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseEntity [createdTimestamp=" + createdTimestamp + ", createdUserId=" + createdUserId
				+ ", updatedTimestamp=" + updatedTimestamp + ", updatedUserId=" + updatedUserId + ", version=" + version
				+ "]";
	}

}
