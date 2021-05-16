package parte2;

public class MainParte2 {

	public static void main(String[] args) {
		
		Parte2 parte2 = new Parte2();
		Parte2NM parte2NM = new Parte2NM();
		
		int numInterations = 10;
		int numProcess = 5;
		int tamBuffer = 5;
		for (int i = 0; i < numInterations; i++) {
			
			System.out.println("-----------------------");
			System.out.println("START");
			
			//parte2.start(numProcess);
			parte2NM.start(numProcess, tamBuffer);
			System.out.println("FINISH");
		}
		
		System.out.println("-----------------------");
	}

}
