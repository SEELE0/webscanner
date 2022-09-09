package com.dhee.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;
import com.dhee.service.xssService;
import com.opensymphony.xwork2.ActionSupport;

public class XssAction extends ActionSupport implements ServletRequestAware{
    private URLEntity urlEntity;
    private HttpServletRequest httpServletRequest;
    private  xssService xssService = new xssService();
    public void setServletRequest(HttpServletRequest httpServletRequest) {  //实现接口类方法
        this.httpServletRequest= httpServletRequest;
    }
    public URLEntity getUrlEntity() {
        return urlEntity;
    }
    public void setUrlEntity(URLEntity urlEntity) {
        this.urlEntity = urlEntity;
    }
    public String xss(){
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("userInfo")!=null){
            boolean a=xssService.check(urlEntity.getUrl());
            if(a){
                boolean b =xssService.checkxss(urlEntity.getUrl());
                System.out.println(b);
                session.setAttribute("xss", b);
                UserEntity userEntity = (UserEntity)session.getAttribute("userInfo");
                if(b){
                    urlEntity.setXss("1");
                }else{
                    urlEntity.setXss("2");
                }
                urlEntity.setUserId(userEntity.getId());
                xssService.stockUrl(urlEntity);
            }
        }

        return SUCCESS;
    }
}
