package com.dhee.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.dhee.entity.UserEntity;
import com.dhee.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware {

	private UserEntity userEntity;
	private UserService userService = new UserService();
	private HttpServletRequest request;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String login() {
		//创建session会话来解决重定向过程中数据无法传递的问题,也可以防止频繁转向过程中数据丢失
		HttpSession session = request.getSession();  //获取session
		UserEntity user = userService.login(userEntity);//调用service层的login方法
		if (user == null) {
			session.setAttribute("loginError", 1);
			return ERROR;
		}
		session.setAttribute("userInfo", user);
			return SUCCESS;

	}

	public String logout() {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		return SUCCESS;
	}

	public String registe() {
		int result = userService.registe(userEntity);
		if (result != 0) {
			return SUCCESS;
		}
		HttpSession session = request.getSession();
		session.setAttribute("regError", 1);
		return ERROR;
	}
}
