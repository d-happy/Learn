package sec02.exam03;

public class WorkerMain {

	public static void main(String[] args) {
		
		Worker[] workers = {
				new Programmer(),
				new Designer(),
				new Salesman(),
				new Worker()
		};
		
		for (int i=0; i<workers.length; i++) {
			workers[i].work();
		}
		
		

	}

}
