package interfac.ex01;

public interface IUsbPort {
	public static final double WIDTH=5.5;
	double HEIGHT=1.2; //���ʷ� �� ����
	
	public abstract void read();
	public abstract void write();
	
}
