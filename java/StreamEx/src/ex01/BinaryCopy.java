package ex01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopy {

	public static void main(String[] args) throws Exception { //Exception ���� ó�� �̷��?!
		
		// throws IOException �� �ͼ���(����)�� �߻��ϸ� �ش� Ŭ�������� ����� �ȴٴ� ���Դϴ�. 
		//��� Ư�̻����� ����(throw)�����ٴ� ���� 
		//���� �� �κ��� ���δ� try ~ catch ���� �ִٸ� ƨ�������� ���ܸ� �ڵ鸵�� ���� �ֽ��ϴ�.
		
		//���� �ð�
		long startTime = System.currentTimeMillis(); //�и�������(1/1000) ������ ���� �ð��� ����
		File src = new File("G:\\workspace\\java\\jdk.exe");
		File dst = new File("G:\\workspace\\java\\jdk_copy.exe");
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//����, ���� -> ���� �а� ���� -> ���۷� ������ ��Ƽ� �ӵ� ������ ���� 
		
		while (true) {
			int readData = bis.read();
			if (readData == -1) {
				break;
			}
			bos.write(readData); //������ �ִٸ� �����Ѵ�
		}
		
		bis.close();
		bos.close(); //���� �� ����
		
		System.out.println("���� ���� �Ϸ�"); //������ �Ʒ��� ��� �ڵ� ���� �ڿ� ���, ���� ���� Ȯ�� ����
		//������ �ð�
		long endTime = System.currentTimeMillis();
		System.out.println("�ɸ� �ð� : "+(endTime-startTime)); //�����ϴµ� �ɸ� �ð� ��� 
		

	}//main

}//class
