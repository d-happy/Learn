package tv.ex01;

public class Tv {
	boolean power; //��������
	int channel;  //ä��
	int volume;   //����
	
	//���� on/off
	void power() {
		if (power==false) {
			power=true;
			System.out.println("Ƽ�� ����"); 
			
		} else {
			power=false;
			System.out.println("Ƽ�� ����"); 
		}
	}
	
	//ä�� �ø���
	void channelUp() {
		channel++;
		System.out.println("����ä��: "+channel);
	}
	//ä�� ������
	void channelDown() {
		channel--;
		System.out.println("����ä��: "+channel);
	}
	//���� �ø���
	void volumeUp() {
		if (volume<10) {
			volume++;
		}
		System.out.println("���纼��: "+volume);
	}
	//���� ������
	void volumeDown() {
		if (volume>0) {
			volume--;
		}
		System.out.println("���纼��: "+volume);
	}

}
