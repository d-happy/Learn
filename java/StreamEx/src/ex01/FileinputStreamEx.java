package ex01;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class FileinputStreamEx {

	public static void main(String[] args) throws Exception {
		//���Ͽ� ���� �ȱ�
		FileInputStream fis=
				new FileInputStream("G:\\workspace\\java\\Hello.java"); //�ּ� �� ����!!!!!
		//������ �а�
		while (true) {
			int i = fis.read(); //1byte �б�->���� ���� ������ -1
			if (i==-1) {
				break;
			}
			char c = (char)i;
//			System.out.println("i : "+i);
			System.out.print(c); //println �� ���ϱ� �پ �� ����
		}
		//���� ����
		fis.close();

	}

}//class
