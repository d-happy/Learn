package sec01.exam01;

public class ConditionOpExample {

	public static void main(String[] args) {
		int a=10;
		int b=2;
		String result="";
		
		if (a%b==0) {
			result="�Դϴ�";
		} else {
			result="�� �ƴմϴ�";
		}
		System.out.println("2�� ���"+result);
		
		int c=10;
		int d=3;
		// (���ǽ�) ? A : B
		result=(c%d==0)? "�Դϴ�.":"�� �ƴմϴ�.";
		System.out.println("3�� ���"+result);
	}
}
