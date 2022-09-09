package com.dhee.tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.dhee.entity.URLEntity;

public class OutputFile {//�����ļ�
	
	public boolean output(List<URLEntity> list){
		BufferedWriter bw =null;
		try {
			bw = new BufferedWriter(new FileWriter("D:/���簲ȫʵѵ/Web©�����/webScaner/report.txt"));//�ļ�·��
			bw.write("��ⱨ��");//д���ļ�
			bw.newLine();
			bw.write("�����������:");
			bw.newLine();
			for (URLEntity urlEntity : list) {
				if (Objects.equals(urlEntity.getSql(), "1")) {
					bw.write(urlEntity.getUrl()+"����URL SQLע�������Ϊ: �� ��");
					bw.newLine();
				}
				if (Objects.equals(urlEntity.getSql(), "2")) {
					bw.write(urlEntity.getUrl()+"����URL SQLע�������Ϊ: �� �� ��");
					bw.newLine();
				}
//				bw.write(urlEntity.getUrl()+"����URL SQLע����Ϊ:"+urlEntity.getSql());
				bw.newLine();
				if (Objects.equals(urlEntity.getXss(), "1")) {
					bw.write(urlEntity.getUrl()+"����URL XSS©�������Ϊ: �� ��");
					bw.newLine();
				}
				if (Objects.equals(urlEntity.getXss(), "2")) {
					bw.write(urlEntity.getUrl()+"����URL XSS©�������Ϊ: �� �� ��");
					bw.newLine();
				}
//				bw.write(urlEntity.getUrl()+"����URL XSS©�������Ϊ:"+urlEntity.getXss());
				bw.newLine();
			}
//			bw.write("1:�������ע��㣬2:��������ע���");
//			bw.newLine();
			bw.write("���ι����"+list.size()+"��URL��ַ��");
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
