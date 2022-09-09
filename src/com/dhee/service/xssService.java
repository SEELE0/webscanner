package com.dhee.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.dhee.dao.XssDao;
import com.dhee.entity.URLEntity;
import com.dhee.entity.XSSEntity;
import com.dhee.tools.XSScon;

public class xssService {
    private XssDao xssDao = new XssDao();

    public boolean check(String url) {
        try {
            URL u = new URL(url);
            URLConnection uCon = u.openConnection();
            if(uCon.toString().contains(url)){
                return true;
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block

        } catch (IOException e) {
            // TODO Auto-generated catch block

        }
        return false;
    }
    public boolean checkxss(String url) {
        List<XSSEntity> list = xssDao.select();
        for (XSSEntity xssEntity : list) {
            String payload = xssEntity.getXssPayload();
            String method = "";
            String actionName = "";
            String str;//用于存储每一个payload
            String oldStr;//原始字符串
            List<String> param = new ArrayList<String>();

            Document doc = null;  //该类表示通过Jsoup库加载HTML文档
            String a = payload;
            oldStr = a;
            str = a.replace(" ", "%20");//使用urlencoded方法将payload中的空格替换为%20
            str = str.replace("<", "%3C");
            str = str.replace(">", "%3E");
            try {
                doc = Jsoup.connect(url).get(); //使用url尝试链接并从Web获取HTML
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
//xss攻击常出现在form表单提交过程中所以如下
            Elements e1 = doc.getElementsByTag("form"); //获取所有form标签
            for (Element b : e1) {
                method = b.attr("method");  //获取form标签的method属性
            }

            Elements e2 = doc.select("input");//查找input标签
            for (Element b : e2) {
                if (!b.attr("name").equals("")) {  //获取所有input标签的name属性
                    param.add(b.attr("name"));
                }
            }
            for (Element b : e1) {
                actionName = b.attr("action");  //获取form标签action属性
            }
            if (!e1.isEmpty() && method.equals("GET")) {  //如果form标签存在且method属性为get
                //如果返回true，则说明存在XSS漏洞
                boolean test=XSScon.xssGetConnect(url, str, actionName, param, oldStr);
                System.out.println(XSScon.xssGetConnect(url, str, actionName, param, oldStr));
                if (XSScon.xssGetConnect(url, str, actionName, param, oldStr)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void stockUrl(URLEntity urlEntity) {//插入url
        List<URLEntity> list = xssDao.selectByUrl(urlEntity);
        // url存在于用户的数据库表中，update
        if (list.size() != 0) {
            xssDao.updateUrl(urlEntity);

        } else {
            // url不存在于用户的数据库表中，insert
            xssDao.insertUrl(urlEntity);
        }

    }


}
