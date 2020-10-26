package sec01.exam01;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
//		DmbCellPhone dmb1=new DmbCellPhone(); 
		//정의한 생성자 있으면 따로 기본형 없음
		
		DmbCellPhone dmbCellPhone=
				new DmbCellPhone("자바폰", "검정", 10);
		System.out.println("모델: "+dmbCellPhone.model);
		System.out.println("색상: "+dmbCellPhone.color);
		System.out.println("채널: "+dmbCellPhone.channel);
		
		//상속받은 메소드
		dmbCellPhone.powerOn();
		dmbCellPhone.powerOff();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("꺼져~");
		dmbCellPhone.receiveVoice("싫어~");
		dmbCellPhone.hangUp();
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(20);
		dmbCellPhone.turnOffDmb();
	
	}//main

} //class
