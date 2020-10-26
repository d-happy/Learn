package sec02.exam05;

public class TvMain {

	public static void main(String[] args) {
		InternetTv tv1=new InternetTv();
		tv1.volume=1;
		tv1.channel=1;
		tv1.corp="KT";
		SubtitleTv tv2=new SubtitleTv();
		tv2.volume=2;
		tv2.channel=2;
		tv2.subtitle="ÀÚ¸·";
		
		Tv[] arrTv=new Tv[2];	
		arrTv[0]=tv1;
		arrTv[1]=tv2;
		
		for (int i=0; i<arrTv.length; i++) {
			if (arrTv[i] instanceof InternetTv) { //downcasting
				InternetTv tv=(InternetTv)arrTv[i];
				tv.showInterInfo();
			} else if (arrTv[i] instanceof SubtitleTv) {
				SubtitleTv tv=(SubtitleTv)arrTv[i];
				tv.showsubtitleInfo();
			}
		}
		
		
		
	} //main

} //class
