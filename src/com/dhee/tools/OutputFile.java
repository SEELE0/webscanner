package com.dhee.tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.dhee.entity.URLEntity;

public class OutputFile {//生成文件
	
	public boolean output(List<URLEntity> list){
		BufferedWriter bw =null;
		try {
			bw = new BufferedWriter(new FileWriter("D:/网络安全实训/Web漏洞检测/webScaner/report.txt"));//文件路径
			bw.write("检测报告");//写入文件
			bw.newLine();
			bw.write("检测内容如下:");
			bw.newLine();
			for (URLEntity urlEntity : list) {
				if (Objects.equals(urlEntity.getSql(), "1")) {
					bw.write(urlEntity.getUrl()+"，该URL SQL注入点检测结果为: 存 在");
					bw.newLine();
				}
				if (Objects.equals(urlEntity.getSql(), "2")) {
					bw.write(urlEntity.getUrl()+"，该URL SQL注入点检测结果为: 不 存 在");
					bw.newLine();
				}
//				bw.write(urlEntity.getUrl()+"，该URL SQL注入结果为:"+urlEntity.getSql());
				bw.newLine();
				if (Objects.equals(urlEntity.getXss(), "1")) {
					bw.write(urlEntity.getUrl()+"，该URL XSS漏洞检测结果为: 存 在");
					bw.newLine();
				}
				if (Objects.equals(urlEntity.getXss(), "2")) {
					bw.write(urlEntity.getUrl()+"，该URL XSS漏洞检测结果为: 不 存 在");
					bw.newLine();
				}
//				bw.write(urlEntity.getUrl()+"，该URL XSS漏洞检测结果为:"+urlEntity.getXss());
				bw.newLine();
			}
//			bw.write("1:代表存在注入点，2:代表不存在注入点");
//			bw.newLine();
			bw.write("本次共检测"+list.size()+"个URL地址。");
			bw.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			if(bw != null ){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}

}
