package parte1_1;

public class MainParte1 {

	public static void main(String[] args) {
		
		Parte1 parte1 = new Parte1();
		
		int numIterations = 15;
		int numProcesos = 100;
		for (int i = 0; i < numIterations; i++) {
			

			System.out.println("-----------------------");
			System.out.println("START");
			
			parte1.start(numProcesos);
			System.out.println("FINISH");
		}
		
		System.out.println("-----------------------");
	}
}
