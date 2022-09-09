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
		// ��ȡע��Ĺؼ���
		List<InjectEntity> list = injectDao.select();
		// ����ע��payload�ж��Ƿ����©��
		for (InjectEntity injectEntity : list) {
			url += injectEntity.getSqlInject();//��ע��Ĺؼ���ƴ�ӵ�url����
			try {
				URL u = new URL(url);
				URLConnection uCon = u.openConnection();//������

				if (uCon.toString().contains(url)) {//�ж��Ƿ����©��
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
			// url�������û������ݿ���У�update
			injectDao.updateUrl(urlEntity);
		} else {
			// url���������û������ݿ���У�insert
			injectDao.insertUrl(urlEntity);
		}

	}

}
