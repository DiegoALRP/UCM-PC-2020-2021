package parte1_2;


public class MainParte1_2 {

	public static void main(String[] args) {
		
		Parte1_2 parte1_1 = new Parte1_2();
		
		int numInterations = 1;
		int numProcess = 10;
		int tamBuffer = 5;
		for (int i = 0; i < numInterations; i++) {
			
			System.out.println("-----------------------");
			System.out.println("START");
			
			//parte2.start(numProcess);
			parte1_1.start(numProcess, tamBuffer);
			System.out.println("FINISH");
		}
		
		System.out.println("-----------------------");
	}
}
