package tv.ex01;

public class Tv {
	boolean power; //전원상태
	int channel;  //채널
	int volume;   //볼륨
	
	//전원 on/off
	void power() {
		if (power==false) {
			power=true;
			System.out.println("티비 켜짐"); 
			
		} else {
			power=false;
			System.out.println("티비 꺼짐"); 
		}
	}
	
	//채널 올리기
	void channelUp() {
		channel++;
		System.out.println("현재채널: "+channel);
	}
	//채널 내리기
	void channelDown() {
		channel--;
		System.out.println("현재채널: "+channel);
	}
	//볼륨 올리기
	void volumeUp() {
		if (volume<10) {
			volume++;
		}
		System.out.println("현재볼륨: "+volume);
	}
	//볼륨 내리기
	void volumeDown() {
		if (volume>0) {
			volume--;
		}
		System.out.println("현재볼륨: "+volume);
	}

}
