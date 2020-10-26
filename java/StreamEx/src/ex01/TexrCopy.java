package ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TexrCopy {
	public static void main(String[] args) throws FileNotFoundException {
		//����
		File src = new File("G:\\workspace\\java\\test3.txt");
		//���纻
		File dst = new File("G:\\workspace\\java\\test3_copy.text");
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null; 
		//����, ī�� '����'�� ����� -> �д�+���� ���� ���� -> �а� �� ������ ��Ƽ� ���� ���� ����
		
		//���� - Reader, Writer
		try {
			fr = new FileReader(src);
			fw = new FileWriter(dst);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while(true) {
				int readData = br.read(); //<����-�а�-����> �����͸� readData ��� ���� �����ϰ�
				if (readData == -1) {     //read() : 1byte �б�->���� ���� ������ -1 
					break;
				}
				bw.write(readData); //-1(���� ����)�� �ƴϸ� <����-����>�� ��Ƽ� ����
			} 
		} catch (FileNotFoundException e) { //e ��� ����? �����
			System.out.println("������ ã�� �� ����");
			e.printStackTrace(); //e ��� ����? ����� ���� ����, ... ����
		} catch (IOException e) {
			System.out.println("���� ���� ����");
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				System.out.println("���� ����� ����"); 
				//finally ���� try, catch �� �ϵ簣�� ������
				//���� �� �����ϰ� ���� ����� ���� ���
			}
		}
		
		System.out.println("���� ���� �Ϸ�");
		
		
	}//main

}//class
