package com.dhee.entity;

public class URLEntity {

	private String id;
	private String url;
	private String sql;
	private String userId;
	private String xss;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public void setXss(String xss) {
		this.xss = xss;
	}
	public  String getXss() {
		return xss;
	}
}
