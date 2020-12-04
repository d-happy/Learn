package com.kh.sample02.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class MyUploadFileUtil {

	public static String getfilePath(String filePath, String originalName, byte[] fileData) throws Exception {
		UUID uuid = UUID.randomUUID();
		String datePath = calc(filePath);
		String fileMakePath = datePath + "/" + uuid + "_" + originalName;
		File file = new File(fileMakePath);
		FileCopyUtils.copy(fileData, file);
		
		return fileMakePath;
	}
	
	public static String calc(String filePath) throws Exception {
		Calendar calc = Calendar.getInstance();
		int year = calc.get(Calendar.YEAR);
		int month = calc.get(Calendar.MONTH) + 1;
		int date = calc.get(Calendar.DATE) + 20;
		String dateString = year + "/" + month + "/" + date;
		String datePath = filePath + "/" + dateString;
		System.out.println("datePath :" + datePath);
		File f = new File(datePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		return datePath;
	}
	
	public static boolean isImage(String fileName) {
		int dotIndex = fileName.lastIndexOf(".");
		String extName = fileName.substring(dotIndex + 1);
		System.out.println("extName :" + extName);
		String upper = extName.toUpperCase();
		System.out.println("upper :" + upper);
		if (!upper.equals("JPG") && !upper.equals("PNG") && !upper.equals("GIF")) {
			return false;
		} else {
			return true;
		}
	}
	
}
