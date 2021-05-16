package parte1;

public class Main {

	public static void main(String[] args) {
		
		Parte1 parte1 = new Parte1();
		
		for (int i = 0; i < 2; i++) {
			
			System.out.println("------------------");
			System.out.println("START");
			
			parte1.start();
			
			System.out.println("FINISH");
			//System.out.println("------------------");
		}
		
		System.out.println("------------------");
	}

}
