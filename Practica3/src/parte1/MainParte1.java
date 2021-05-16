package parte1;

public class MainParte1 {

	public static void main(String[] args) {

		Parte1 parte1 = new Parte1();
		
		int numInterations = 20;
		int numProcess = 4;
		for (int i = 0; i < numInterations; i++) {
			
			System.out.println("-----------------------");
			System.out.println("START");
			
			parte1.start(numProcess);
			System.out.println("FINISH");
		}
		
		System.out.println("-----------------------");
	}

}
