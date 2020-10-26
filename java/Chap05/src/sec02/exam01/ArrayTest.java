package sec02.exam01;

public class ArrayTest {

	public static void main(String[] args) {
		//배열도 객체다
		
		int[] arr1= {1,2,3}; //int arr1[]= {1,2,3}; C언어
		System.out.println(arr1); //힙, 해쉬태그(주소?) 나옴
		
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		String[] arr2=new String[3]; //new 타입[갯수]
		//System.out.println(arr2);
		arr2[0]="Hello";
		arr2[1]="java";
		arr2[2]="!";
		System.out.println(arr2);
		
		for (int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		double[] arr3=new double[] {1.0, 1.1, 1.2};
		for (int i=0; i<arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		
		int[] balls=new int[45];
		
		for (int i=0; i<balls.length; i++) {
//			System.out.println(balls[0]); //0
			balls[i]=i+1;
		}
		
		for (int i=0; i<balls.length; i++) {
			System.out.println(balls[i]+" ");
		}
		
		for (int i=1; i<=90; i++) {
			int rand=(int)(Math.random()*44)+1;
			int temp=balls[0];
			balls[0]=balls[rand];
			balls[rand]=temp;
		}
		System.out.println();
		
		for (int i=1; i<=6; i++) {
			System.out.println(balls[i]+" ");
		}
		
		
	}
}
