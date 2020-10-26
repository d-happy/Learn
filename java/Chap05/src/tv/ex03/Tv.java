package tv.ex03;

public class Tv {
	private boolean power;       //전원상태
	private int channel;         //채널 1~15
	private int volume;          //볼륨 0~1
	private int orgVolume;       //원래 볼륨
	private boolean mute;        //음소거
	
	//전원 on/off 
	void power() {	
	// void 메소드는 자신이 일을 시작하고 마무리합니다. return 메소드는 일의 중간 계산을 처리하고 이를 반환합니다.
		if (power==false) {
			power=true;
			System.out.println("티비 켜집니다-전원 On"); 
			
		} else {
			power=false;
			System.out.println("티비 꺼짐니다-전원 Off"); 
		}
	}
	
	//채널 올리기
	void channelUp() {
		if (channel<15) {
			channel++;
		} else {
			channel=1;
		}
		System.out.println("채널이 올라갑니다-현재채널Ch: "+channel);
	}
	//채널 내리기
	void channelDown() {
		if (channel>1) {
			channel--;
		} else {
			channel=15;
		}
		System.out.println("채널이 내려갑니다-현재채널Ch: "+channel);
	}
	//볼륨 올리기
	void volumeUp() {
		if (volume<10) {
			volume++;
		}
		System.out.println("소리가 커집니다-현재볼륨Vol: "+volume);
	}
	//볼륨 내리기
	void volumeDown() {
		if (volume>0) {
			volume--;
		}
		System.out.println("소리가 작아집니다-현재볼륨Vol: "+volume);
	}
	//음소거
	void mute() {
		if (mute==false) {
			orgVolume=volume; //a,b값 교환할 때 tran 필요한 구조
			volume=0;
			System.out.println("음소거 되었습니다-현재볼륨Vol: "+volume);
			mute=true; //음소거 뒤에 mute 값 변경
		} else {
			volume=orgVolume;
			System.out.println("소리가 다시 켜집니다-현재볼륨Vol: "+volume);
			mute=false;
		}	
	}
}
