package inherit.ex01;

public class TvMain {

	public static void main(String[] args) {
		InternetTv tv1=new InternetTv();
		tv1.channel=1;
		tv1.volume=2;
		System.out.println(tv1.channel);
		System.out.println(tv1.volume);
		tv1.showInfo();
		
		InternetTv tv2=new InternetTv();
		tv1.corp="KT";
		tv2.corp="LG";
		
		System.out.println("---------------");
		tv1.showInfo();
		tv2.showInfo();
		System.out.println("---------------");
		tv1.showInterInfo();
		tv2.showInterInfo();
		
	} //main

} //class
