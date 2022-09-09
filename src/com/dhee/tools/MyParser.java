package com.dhee.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTML.Tag;

public class MyParser extends HTMLEditorKit.ParserCallback {

	private List<String> urlList = new ArrayList<String>();
	private String url;

	public MyParser(String url) {
		this.url = url;
	}

	public List<String> getUrlList() {
		return urlList;
	}
	String http="http:";
	@Override
	//处理单标签
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		String href = (String) a.getAttribute(HTML.Attribute.HREF);
		String src = (String) a.getAttribute(HTML.Attribute.SRC);
		String action = (String) a.getAttribute(HTML.Attribute.ACTION);
//		 System.out.println(t+"标签的href属性：\t---》"+href);
//		 System.out.println(t+"标签的src属性：\t---》"+src);
//		System.out.println(t+"标签的ACTION属性：\t---》"+action);


		if (href != null && !"".equals(href.trim())) {

			if(href.startsWith("//")){
				href=http.concat(href);

			}
			System.out.println(t+"标签的href属性11：\t---》"+href);
//			urlList.add(href);
			urlList.add(url+href);
		}
		if (src != null && !"".equals(src.trim())) {  //||"".equals(src.trim())

			if(src.startsWith("//")){
				src=http.concat(src);
			}
			System.out.println(t+"标签的src属性11：\t---》"+src);
//			urlList.add(src);
			urlList.add(url+src);
		}
		if (action != null && !"".equals(action.trim())) {  //||"".equals(src.trim())

			if(action.startsWith("//")){
				action=http.concat(action);
			}
			System.out.println(t+"标签的ACTION属性11：\t---》"+action);
//			urlList.add(action);
			urlList.add(url+action);
		}


	}

	@Override
	//处理双标签
	public void handleStartTag(Tag t, MutableAttributeSet a, int pos) {
		String href = (String) a.getAttribute(HTML.Attribute.HREF);
		String src = (String) a.getAttribute(HTML.Attribute.SRC);
		String action = (String) a.getAttribute(HTML.Attribute.ACTION);
		// System.out.println(t+"标签的action属性：\t---》"+action);
		System.out.println(t+"标签的href属性：\t---》"+href);
		System.out.println(t+"标签的src属性：\t---》"+src);
		System.out.println(t+"标签的ACTION属性：\t---》"+action);

		if (href != null&&!"".equals(href.trim())) {

			if(href.startsWith("//")){
				href=http.concat(href);
			}
			System.out.println(t+"标签的href属性22：\t---》"+href);
//			urlList.add(href);
			urlList.add(url+href);
		}
		if (src != null&&!"".equals(src.trim())) {  //||"".equals(src.trim())

			if(src.startsWith("//")){
				src=http.concat(src);
			}
			System.out.println(t+"标签的src属性22：\t---》"+src);
//			urlList.add(src);
			urlList.add(url+src);
		}
		if (action != null&&!"".equals(action.trim())) {

			if(action.startsWith("//")){
				action=http.concat(action);
			}
			System.out.println(t+"标签的ACTION属性22：\t---》"+action);
//			urlList.add(action);
			urlList.add(url+action);
		}

	}

}
