package tv.ex04;

public class Tv { //Java Bean
	private boolean power;       //전원상태
	private int channel;         //채널 1~15
	private int volume;          //볼륨 0~1

	public Tv () {
		
	}

	public Tv(int channel, int volume) {
		this.channel = channel;
		this.volume = volume;
	}
	
	public Tv(boolean power, int channel, int volume) {
		this.power = power;
		this.channel = channel;
		this.volume = volume;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		if (1<=channel&&channel<=15) {
			this.channel = channel;
		}
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

} //class
