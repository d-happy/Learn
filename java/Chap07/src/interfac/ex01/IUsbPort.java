package interfac.ex01;

public interface IUsbPort {
	public static final double WIDTH=5.5;
	double HEIGHT=1.2; //관례로 다 적음
	
	public abstract void read();
	public abstract void write();
	
}
