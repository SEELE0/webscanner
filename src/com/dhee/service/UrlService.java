package com.dhee.service;

import java.util.List;

import com.dhee.dao.UrlDao;
import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;
import com.dhee.tools.OutputFile;

public class UrlService {
	
	private UrlDao urlDao = new UrlDao();
	
	public List<URLEntity> getUrlByUserId(UserEntity userEntity){
		return urlDao.selectByUserId(userEntity);
	}
	
	public void delUrl(String urlId){
		urlDao.delUrl(urlId);
	}
	
	public boolean getUrl(UserEntity userEntity){
		List<URLEntity>  list = urlDao.selectURL(userEntity);
		return new OutputFile().output(list);
	}

}
