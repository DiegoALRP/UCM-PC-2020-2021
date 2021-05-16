package parte2_1;

public class MainParte2_1 {

	public static void main(String[] args) {
		
		Parte2_1 parte2_1 = new Parte2_1();
		
		int numInterations = 1;
		int numProcess = 10;
		int tamBuffer = 10;
		for (int i = 0; i < numInterations; i++) {
			
			System.out.println("-----------------------");
			System.out.println("START");
			
			//parte2.start(numProcess);
			parte2_1.start(numProcess, tamBuffer);
			System.out.println("FINISH");
		}
		
		System.out.println("-----------------------");
	}
}
