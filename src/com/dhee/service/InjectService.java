package com.dhee.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.dhee.dao.InjectDao;
import com.dhee.entity.InjectEntity;
import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;

public class InjectService {
	private InjectDao injectDao = new InjectDao();

	public boolean inject(URLEntity urlEntity) {
		String url = urlEntity.getUrl();
		System.out.println(url);
		if (!url.contains("?")) {
			url +="?id=";
		}
//		else {
//			if (url.substring(url.indexOf("?") + 1).length() == 0) {
//				return false;
//			}
//		}
		// 读取注入的关键字
		List<InjectEntity> list = injectDao.select();
		// 进行注入payload判断是否存在漏洞
		for (InjectEntity injectEntity : list) {
			url += injectEntity.getSqlInject();//将注入的关键字拼接到url后面
			try {
				URL u = new URL(url);
				URLConnection uCon = u.openConnection();//打开连接

				if (uCon.toString().contains(url)) {//判断是否存在漏洞
					return true;
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	public void stockUrl(URLEntity urlEntity) {
		List<URLEntity> list = injectDao.selectByUrl(urlEntity);
		if (list.size() != 0) {
			// url存在于用户的数据库表中，update
			injectDao.updateUrl(urlEntity);
		} else {
			// url不存在于用户的数据库表中，insert
			injectDao.insertUrl(urlEntity);
		}

	}

}
