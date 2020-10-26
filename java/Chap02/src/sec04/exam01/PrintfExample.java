package sec04.exam01;

public class PrintfExample {

	public static void main(String[] args) {
		// printf, f : format(형식)
		// printf("형식", , , )
		int age=20;
		System.out.println("나이는 "+age+"살 입니다.");
		System.out.printf("나이는 %d살 입니다.\n", age);
		
		String name="바나나";
		System.out.println("나이는 "+age+"살 이고, 이름은 "+name+"입니다.");
		System.out.printf("나이는 %d살 이고, 이름은 %s입니다.\n", age, name);
		System.out.printf("우리반 출석률 100%%\n");
		
		int price=100;
		System.out.printf("가격은 %6d원입니다.\n", price); //자릿수6-나머지 공백(좌)
		System.out.printf("가격은 %-6d원입니다.\n", price); //자릿수6-나머지 공백(우)
		
		double pi=3.14;
		System.out.printf("원주율 값은 %f입니다.\n", pi);
		System.out.printf("원주율 값은 %10.2f입니다.\n", pi); //전체자릿수.소순점이하자릿수
		System.out.printf("원주율 값은 %.2f입니다.\n", pi);
	}
}