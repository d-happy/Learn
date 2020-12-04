package com.kh.sample01.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class MyFileUploadUtil {

	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid :" + uuid); // xxxxx_smile.jpg
		// G:/user_pic/2020/12/4/uuid_originalName -> user_pic 값, 이런 경로로 이미지 넣을 거임
		String datePath = calcPath(uploadPath); // G:/user_pic/2020/12/4
		String filePath = datePath + "/" + uuid + "_" + originalName;
		File target = new File(filePath); // 위 경로에 해당되는 파일 (실제 파일은 아니고? 걍 객체 하나?)
		FileCopyUtils.copy(fileData, target); // 실제 있는 데이터 복사해서 File target 진짜 있는 파일로 만들어줌
		return filePath;
	}
	
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
				
		String dateString = year + "/" + month + "/" + date;
		// -> 2020/12/4
		String datePath = uploadPath + "/" + dateString;
		// -> G:/user_pic/2020/12/4
		System.out.println("datePath :" + datePath);
		
		File f = new File(datePath);
		if (!f.exists()) {
			System.out.println("not");
			f.mkdirs(); 
			// mkdirs(); -> 상위 1 폴더 - 상위 2 폴더 - 해당되는 f(폴더, 파일..)
			// 위 메소드는 상위 n 폴더랑, 파일 다 같이 생성해줌
		}
		
		return datePath;
	}
	
	public static boolean isImage(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		String extName = fileName.substring(dotIndex + 1);
		String upper = extName.toUpperCase();
		if (!upper.equals("JPG") && !upper.equals("PNG") && !upper.equals("GIF")) {
			return false;
		} else {
			return true;
		}
	}
	
} //MyFileUploadUtil 
