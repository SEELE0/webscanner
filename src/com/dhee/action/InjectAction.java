package com.dhee.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;
import com.dhee.service.InjectService;
import com.opensymphony.xwork2.ActionSupport;

public class InjectAction extends ActionSupport implements ServletRequestAware{
	private URLEntity urlEntity;
	private HttpServletRequest request;
	private InjectService injectService = new InjectService();
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public URLEntity getUrlEntity() {
		return urlEntity;
	}

	public void setUrlEntity(URLEntity urlEntity) {
		this.urlEntity = urlEntity;
	}

	public String inject() {
		boolean  b= injectService.inject(urlEntity);
		HttpSession session = request.getSession();
		session.setAttribute("sqlInject", b);
		UserEntity userEntity = (UserEntity) session.getAttribute("userInfo");
		if(b){
			urlEntity.setSql("1");
		}else{
			urlEntity.setSql("2");
		}
		urlEntity.setUserId(userEntity.getId());
		injectService.stockUrl(urlEntity);
		return SUCCESS;
	}


}
