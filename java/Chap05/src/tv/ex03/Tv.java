package tv.ex03;

public class Tv {
	private boolean power;       //��������
	private int channel;         //ä�� 1~15
	private int volume;          //���� 0~1
	private int orgVolume;       //���� ����
	private boolean mute;        //���Ұ�
	
	//���� on/off 
	void power() {	
	// void �޼ҵ�� �ڽ��� ���� �����ϰ� �������մϴ�. return �޼ҵ�� ���� �߰� ����� ó���ϰ� �̸� ��ȯ�մϴ�.
		if (power==false) {
			power=true;
			System.out.println("Ƽ�� �����ϴ�-���� On"); 
			
		} else {
			power=false;
			System.out.println("Ƽ�� �����ϴ�-���� Off"); 
		}
	}
	
	//ä�� �ø���
	void channelUp() {
		if (channel<15) {
			channel++;
		} else {
			channel=1;
		}
		System.out.println("ä���� �ö󰩴ϴ�-����ä��Ch: "+channel);
	}
	//ä�� ������
	void channelDown() {
		if (channel>1) {
			channel--;
		} else {
			channel=15;
		}
		System.out.println("ä���� �������ϴ�-����ä��Ch: "+channel);
	}
	//���� �ø���
	void volumeUp() {
		if (volume<10) {
			volume++;
		}
		System.out.println("�Ҹ��� Ŀ���ϴ�-���纼��Vol: "+volume);
	}
	//���� ������
	void volumeDown() {
		if (volume>0) {
			volume--;
		}
		System.out.println("�Ҹ��� �۾����ϴ�-���纼��Vol: "+volume);
	}
	//���Ұ�
	void mute() {
		if (mute==false) {
			orgVolume=volume; //a,b�� ��ȯ�� �� tran �ʿ��� ����
			volume=0;
			System.out.println("���Ұ� �Ǿ����ϴ�-���纼��Vol: "+volume);
			mute=true; //���Ұ� �ڿ� mute �� ����
		} else {
			volume=orgVolume;
			System.out.println("�Ҹ��� �ٽ� �����ϴ�-���纼��Vol: "+volume);
			mute=false;
		}	
	}
}
