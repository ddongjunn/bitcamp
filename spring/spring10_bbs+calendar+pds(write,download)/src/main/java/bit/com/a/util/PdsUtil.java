package bit.com.a.util;

import java.util.Date;

public class PdsUtil {
	public static String getNewFileName(String f) {
		String filename = "";
		String fpost = "";
		
		if(f.indexOf('.') >= 0) { //확장자 명이 존재
			fpost = f.substring(f.indexOf('.')); //abc.txt -> .txt를 저장
			filename = new Date().getTime() + fpost; //123123423.txt
		}else { //확장자 명이 없는 파일
			filename = new Date().getTime() + ".tmp";
		}
		
		return filename;
	}
}
