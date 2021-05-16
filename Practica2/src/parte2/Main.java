package parte2;

public class Main {

	public static void main(String[] args) {
		
		Parte2RompeEmpate parte2RE = new Parte2RompeEmpate();
		Parte2Ticket parte2Ticket = new Parte2Ticket();
		Parte2Bakery parte2Bakery = new Parte2Bakery();
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println("-----------------------");
			System.out.println("START");
			
			//parte2RE.start(4);
			//parte2Ticket.start(4);
			parte2Bakery.start(4);
			System.out.println("FINISH");
		}
		
		System.out.println("-----------------------");
	}
}
