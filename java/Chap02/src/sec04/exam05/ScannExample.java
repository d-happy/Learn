package sec04.exam05;

//import java.io.IOException;
import java.util.Scanner;

public class ScannExample {
	
	public static void main(String[] args) {
		//Ű����� ����� ��ĳ�ʸ� �ϳ� ����
		Scanner scanner=new Scanner(System.in);
		
		while (true) {
			String str=scanner.nextLine();
			System.out.println("str: "+str);
			if (str.equals("q")) {
				break;
			}
		}
		System.out.println("����");
		scanner.close(); //��ĳ�� �ݱ�(����)
	}
}