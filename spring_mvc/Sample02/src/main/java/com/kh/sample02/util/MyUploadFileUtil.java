package com.kh.sample02.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
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
	
	public static void makeThumbnail(String filePath) throws Exception {
		System.out.println("-makeThumbnail-");
		
		// G:/upload/2020/12/9/uuid_name.jpg
		int slashIndex = filePath.lastIndexOf("/");
		String front = filePath.substring(0, slashIndex + 1); // G:/upload/2020/12/9/
		String rear = filePath.substring(slashIndex + 1); //  uuid_name.jpg
		String thumbnailName = front + "sm_" + rear; // G:/upload/2020/12/9/sm_uuid_name
		File orgFile = new File(filePath);
		File thumbfile = new File(thumbnailName);
		
		// 이미 업로드 되어 있는 원본이미지를 메모리에 로딩
		try {
			System.out.println("-resize-");
			BufferedImage srcImage = ImageIO.read(orgFile);
			BufferedImage destImage = Scalr.resize(
					srcImage,                 // 원본 이미지
					Scalr.Method.AUTOMATIC,   // 이미지 비율 자동 조절
					Scalr.Mode.FIT_TO_HEIGHT, // 높이에 맞추기 (폭을)
					100);                     // 해당 높이
			
			ImageIO.write(destImage, getExtName(rear), thumbfile);
		} catch (Exception e) { // 원본 파일에 이름만 수정해서 복사
			e.printStackTrace();
			
			// 업로드 된 파일에 입력 스트림
			BufferedInputStream bis = null;
			// 복사할 파일에 출력 스트림
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(new FileInputStream(orgFile));
				bos = new BufferedOutputStream(new FileOutputStream(thumbfile));
				
				while (true) {							
					try {	
						System.out.println("-while-");
						int i = bis.read(); // 원본 파일에서 읽어서					
						if (i == -1) {      // 다 읽었으면 반복 종료					
							break;				
						}					
						bos.write(i);		// 썸네일 파일로 쓰기			
					} catch (Exception e1) {						
						e1.printStackTrace();					
					}	
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				try {						
					bos.close();	// 출력 스트림 제거		
					bis.close();	// 입려 스트림 제거		
				} catch (Exception e3) {						
					e3.printStackTrace();					
				}		
			} //2-finally
		} //1-catch
	} //makeThumbnail
	
	private static String getExtName(String fileName) {
		// uuid_name.jpg -> JPG
		int dotIndex = fileName.lastIndexOf(".");
		String extName = fileName.substring(dotIndex + 1); 
		// substring(0, dotIndex + 1); uuid_name. 갖고 왔었음...
		return extName.toUpperCase();
	}
	
	public static String calc(String filePath) throws Exception {
		Calendar calc = Calendar.getInstance();
		int year = calc.get(Calendar.YEAR);
		int month = calc.get(Calendar.MONTH) + 1;
		int date = calc.get(Calendar.DATE);
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
	
	public static void deleteFile(String fileName) throws Exception {
		File f = new File(fileName);
		if (f.exists()) {
			f.delete();
		}
		
		if (isImage(fileName)) {
			int slashIndex = fileName.lastIndexOf("/");
			String front = fileName.substring(0, slashIndex + 1);
			String rear = fileName.substring(slashIndex + 1);
			String thumbnailName = front + "sm_" + rear;
			System.out.println("thumbnailName :" + thumbnailName);
			File f2 = new File(thumbnailName);
			if (f2.exists()) {
				while(!f2.delete()) {
					Thread.sleep(100); 
					// 바로바로 삭제 안 됨 (썸네일 만들때 함수?가 물고 있어서?)
					// !f2.delete()<->while 로 안 지워지면 좀 기다리고 다시 삭제 무한 반복 
				}
			}
		}
	}
	
	public static String getShortName(String filename) {
		int underIndex = filename.indexOf("_");
		String shortName = filename.substring(underIndex + 1);
		return shortName;
	}
	
}
