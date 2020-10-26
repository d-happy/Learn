package inherit.ex03;

public class TvMain {

	public static void main(String[] args) {
		InternetTv tv1=new InternetTv();
		tv1.volume=1;
		tv1.channel=1;
		SubtitleTv tv2=new SubtitleTv();
		tv2.volume=2;
		tv2.channel=2;
		
		Tv[] arrTv=new Tv[2];	
		arrTv[0]=tv1;
		arrTv[1]=tv2;
		
		for (int i=0; i<arrTv.length; i++) {
			arrTv[i].showInfo();
		}
		
	} //main

} //class
