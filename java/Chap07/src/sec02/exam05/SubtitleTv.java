package sec02.exam05;

public class SubtitleTv extends Tv {
	String subtitle;

	SubtitleTv() {
		super(); //Tv�� ������ ȣ��
		System.out.println("Hello");
	}
	
	public void showsubtitleInfo() {
		System.out.println("volume: "+volume);
		System.out.println("channel: "+channel);
		System.out.println("subtitle: "+subtitle); 
	}
	

}//class
