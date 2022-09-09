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
	//������ǩ
	public void handleSimpleTag(Tag t, MutableAttributeSet a, int pos) {
		String href = (String) a.getAttribute(HTML.Attribute.HREF);
		String src = (String) a.getAttribute(HTML.Attribute.SRC);
		String action = (String) a.getAttribute(HTML.Attribute.ACTION);
//		 System.out.println(t+"��ǩ��href���ԣ�\t---��"+href);
//		 System.out.println(t+"��ǩ��src���ԣ�\t---��"+src);
//		System.out.println(t+"��ǩ��ACTION���ԣ�\t---��"+action);


		if (href != null && !"".equals(href.trim())) {

			if(href.startsWith("//")){
				href=http.concat(href);

			}
			System.out.println(t+"��ǩ��href����11��\t---��"+href);
//			urlList.add(href);
			urlList.add(url+href);
		}
		if (src != null && !"".equals(src.trim())) {  //||"".equals(src.trim())

			if(src.startsWith("//")){
				src=http.concat(src);
			}
			System.out.println(t+"��ǩ��src����11��\t---��"+src);
//			urlList.add(src);
			urlList.add(url+src);
		}
		if (action != null && !"".equals(action.trim())) {  //||"".equals(src.trim())

			if(action.startsWith("//")){
				action=http.concat(action);
			}
			System.out.println(t+"��ǩ��ACTION����11��\t---��"+action);
//			urlList.add(action);
			urlList.add(url+action);
		}


	}

	@Override
	//����˫��ǩ
	public void handleStartTag(Tag t, MutableAttributeSet a, int pos) {
		String href = (String) a.getAttribute(HTML.Attribute.HREF);
		String src = (String) a.getAttribute(HTML.Attribute.SRC);
		String action = (String) a.getAttribute(HTML.Attribute.ACTION);
		// System.out.println(t+"��ǩ��action���ԣ�\t---��"+action);
		System.out.println(t+"��ǩ��href���ԣ�\t---��"+href);
		System.out.println(t+"��ǩ��src���ԣ�\t---��"+src);
		System.out.println(t+"��ǩ��ACTION���ԣ�\t---��"+action);

		if (href != null&&!"".equals(href.trim())) {

			if(href.startsWith("//")){
				href=http.concat(href);
			}
			System.out.println(t+"��ǩ��href����22��\t---��"+href);
//			urlList.add(href);
			urlList.add(url+href);
		}
		if (src != null&&!"".equals(src.trim())) {  //||"".equals(src.trim())

			if(src.startsWith("//")){
				src=http.concat(src);
			}
			System.out.println(t+"��ǩ��src����22��\t---��"+src);
//			urlList.add(src);
			urlList.add(url+src);
		}
		if (action != null&&!"".equals(action.trim())) {

			if(action.startsWith("//")){
				action=http.concat(action);
			}
			System.out.println(t+"��ǩ��ACTION����22��\t---��"+action);
//			urlList.add(action);
			urlList.add(url+action);
		}

	}

}
