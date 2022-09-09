package com.dhee.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;
import com.dhee.service.UrlService;
import com.opensymphony.xwork2.ActionSupport;

public class UrlAction extends ActionSupport implements ServletRequestAware {

	private UrlService urlService = new UrlService();
	private HttpServletRequest request;
	private String urlId;
	
	

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	public void setServletRequest(HttpServletRequest request) {

		this.request = request;
	}

	public String getUrl() {
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("userInfo");//获取用户信息
		List<URLEntity> list = urlService.getUrlByUserId(user);
		session.setAttribute("urlList", list);
		return SUCCESS;
	}
	
	public String delUrl(){
		urlService.delUrl(urlId);
		HttpSession session = request.getSession();
	UserEntity user = (UserEntity) session.getAttribute("userInfo");
	List<URLEntity> list = urlService.getUrlByUserId(user);
		session.setAttribute("urlList", list);
				return SUCCESS;
				}

public String getFile(){
		HttpSession session = request.getSession();
		UserEntity user = (UserEntity) session.getAttribute("userInfo");
		boolean b = urlService.getUrl(user);
		session.setAttribute("report", b);
		return SUCCESS;
		}
		}