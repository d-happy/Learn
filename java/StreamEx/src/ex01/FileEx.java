package ex01;

import java.io.File;
import java.util.Date;

public class FileEx {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//���α׷������� ���� : ����, ����(���͸�)
		File f1 = new File("G:\\workspace\\java\\Hello.java");
		System.out.println(f1);
		File f2 = new File("G:\\workspace\\java");
		System.out.println(f2);
		
		//��������
		if (f1.isFile()) { //is - boolean ǥ��
			System.out.println("f1�� �����̴�"); //Hello.java == ����
		} else {
			System.out.println("f1�� ������ �ƴϴ�");
		}
		if (f2.isFile()) {
			System.out.println("f2�� �����̴�");
		} else {
			System.out.println("f2�� ������ �ƴϴ�");
		}
		//����(���͸�)����
		if (f1.isDirectory()) {
			System.out.println("f1�� �����̴�");
		} else {
			System.out.println("f1�� ������ �ƴϴ�");
		}
		if (f2.isDirectory()) { 
			System.out.println("f2�� �����̴�"); //java == ����
		} else {
			System.out.println("f2�� ������ �ƴϴ�");
		}
		
		//���� ����� - make directory - mkdir()
		File f3 = new File("G:\\workspace\\javs2");
		
		if (!f3.exists()) { //�������� �ʴ´ٸ�
			f3.mkdir();     //���� ����
		}
		
		//���� ���� ����
		File f4 = new File("G:\\workspace\\java3\\dir1\\dir2\\dir3");
		if (!f4.exists()) {
			f4.mkdirs(); //���� ������ ����
		}
		
		//���� ���
		File f5 = new File("G:\\workspace\\html"); //html ���� -> new File
		String[] names = f5.list(); //����Ʈ ����
		
		
//		System.out.println(names);
		
		
		for (String name : names) {
			
			File temp = new File("G:\\workspace\\html\\"+name); //html ������ ���Ͽ� ���� ��ü ����
			
			
			//�ð� ���ϱ�
			long l = temp.lastModified(); //timestamp - 1970/01/01/00:00
			Date d = new Date(l);
			
			int year = d.getYear() + 1900;
			int month = d.getMonth() + 1; //0���� ����
			int date = d.getDate();
			int hour = d.getHours();
			int minute = d.getMinutes();
			int second = d.getSeconds();
			
			System.out.printf("%s-%s-%s %s:%s:%s \t", 
					make2digits(year), 
					make2digits(month), 
					make2digits(date), 
					make2digits(hour), 
					make2digits(minute), 
					make2digits(second));
			
			if (temp.isDirectory()) {
				System.out.print("<DIR>\t");
			} else {
				System.out.print("\t");
			}
			
			System.out.print(name+"\t"); //����(����, ����) �̸����� ���
			
			//���� ũ��
			long len = temp.length();
			System.out.println(len);
			
		}
		
		
		
	}//main
	
	
	public static String make2digits (int i) {
//		if (i < 10) {
//			return "0"+i;
//		} else {
//			return ""+i;
//		}
		return (i<10) ? ("0"+i) : ""+i ;
	}
	

}//class
