package lotto.ex04;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine machine=new LottoMachine();
		machine.createBalls();
		machine.suffleBalls();
		machine.getBall6();
		
	}
}
