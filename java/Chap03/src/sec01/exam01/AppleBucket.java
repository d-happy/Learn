package sec01.exam01;

public class AppleBucket {

	public static void main(String[] args) {
		
		int apple=123;
		int bucket=10;
		
		int result1=apple/bucket; 
//		System.out.println(result1); //int라서 12.3의 0.3은 날아감

		int result2=apple%bucket;
		
		/*
		int addCount=(apple%bucket==0)? 0 : 1 ;
		int totalCount=result1+addCount;
		System.out.printf("바구니 갯수 : %d개", totalCount);
		*/
		
		String Result=(result2==0) ? result1+"개 입니다.":(result1+1)+"개 입니다.";
		//나머지가 !0 == result1 값보다 바구니 1개 더 필요 
			
		System.out.println("사과 담는 바구니의 갯수는 "+Result);
	}
}