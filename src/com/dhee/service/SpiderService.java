package com.dhee.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit;

import com.dhee.dao.SpiderDao;
import com.dhee.entity.URLEntity;
import com.dhee.entity.UserEntity;
import com.dhee.tools.MyHTMLEditorKit;
import com.dhee.tools.MyParser;


public class SpiderService {
	private SpiderDao spiderDao = new SpiderDao();

	public List<String> scan(URLEntity urlEntity) {
		List<String> list = new ArrayList<String>();
		try {
			URL url = new URL(urlEntity.getUrl()); //打开网页
			//抽象类URLConnection是表示应用程序和 URL 之间的通信链接的所有类的超类。此类的实例可用于读取和写入 URL 引用的资源。
			//通常，创建到 URL 的连接是一个多步骤的过程：
			//连接对象是通过在 URL 上调用openConnection方法来创建的。
			//设置参数和一般请求属性被操纵。
			//与远程对象的实际连接是使用connect方法建立的。
			//远程对象变为可用。可以访问远程对象的标头字段和内容
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();//字节输入流

			//读取网页内容
			InputStreamReader isr = new InputStreamReader(is); //字节输入流
			BufferedReader br = new BufferedReader(isr); //缓冲字符输入流

			HTMLEditorKit.Parser parser = new MyHTMLEditorKit().getParser();
			MyParser mp = new MyParser(urlEntity.getUrl());  //自定义解析器
			parser.parse(br, mp, true);//解析网页将字符流传入解析器
			list = mp.getUrlList();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL不正确");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<String> checkUrl(List<String> allUrl,UserEntity user){
		List<String> enableUrl = new ArrayList<String>();
		for (String myUrl : allUrl) {
			try {
				URL url = new URL(myUrl);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();//测试连接url
				//从 HTTP 响应消息中获取状态代码。例如，在以下状态行的情况下：
				//  HTTP/1.0 200 OK
				//  HTTP/1.0 401 Unauthorized
				//
				//它将分别返回 200 和 401。如果无法从响应中识别出任何代码（即响应不是有效的 HTTP），则返回 -1。
				int statusCode = con.getResponseCode();
				if(statusCode == 200){
					enableUrl.add(myUrl);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		spiderDao.insert(enableUrl,user);//插入数据库
		return enableUrl;
	}

}
