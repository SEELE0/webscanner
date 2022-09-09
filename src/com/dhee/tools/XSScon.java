package com.dhee.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class XSScon {

    public static boolean xssGetConnect(String url,String payload,String actionName,List<String> param,String oldPayload){
        boolean flag=false;
        URL u;
        HttpURLConnection con;
        BufferedReader read=null;
        try {
            String tempStr;
            url=url.substring(0,url.lastIndexOf("/")+1);//截取url中的目录
            url=url+actionName+"?";//拼接目录和actionName
            for(String a:param) {//遍历param中的每一个参数
                if(a.equals(param.get(param.size()-1))) {//如果是最后一个参数，则不需要拼接&
                    url+=a+"="+payload;
                    break;
                }
                url+=a+"="+payload+"&";//拼接参数和payload
            }
            u=new URL(url);
            con=(HttpURLConnection)u.openConnection();
            if(con==null) {
                flag=false;
            }
            InputStream is=con.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            read= new BufferedReader(isr);

            while((tempStr=read.readLine())!=null){
                if(tempStr.contains(oldPayload)) {
                    flag=true;
                    break;
                }
            }

        } catch (Exception e) {

        }finally {
            try {
                read.close();
            } catch (IOException e) {

            }
        }

        return flag;
    }

}
