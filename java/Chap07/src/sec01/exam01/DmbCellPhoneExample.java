package sec01.exam01;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
//		DmbCellPhone dmb1=new DmbCellPhone(); 
		//������ ������ ������ ���� �⺻�� ����
		
		DmbCellPhone dmbCellPhone=
				new DmbCellPhone("�ڹ���", "����", 10);
		System.out.println("��: "+dmbCellPhone.model);
		System.out.println("����: "+dmbCellPhone.color);
		System.out.println("ä��: "+dmbCellPhone.channel);
		
		//��ӹ��� �޼ҵ�
		dmbCellPhone.powerOn();
		dmbCellPhone.powerOff();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("����~");
		dmbCellPhone.receiveVoice("�Ⱦ�~");
		dmbCellPhone.hangUp();
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(20);
		dmbCellPhone.turnOffDmb();
	
	}//main

} //class
