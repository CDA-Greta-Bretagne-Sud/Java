import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task t = new Task(5, "monthreads");
		t.start();

		Thread t2 = new Thread(new MyRunnable());
		t2.start();

		Thread t3 = new Thread(new Threadinterupt(1));
		Thread t4 = new Thread(new Threadinterupt(2));
		t3.start();
		t4.start();
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez le numéro du thread à arrêter : ");
		int num = in.nextInt();
		switch (num) {
		case 1:
			System.out.printf("Etat du thread t1 : %s\n", t3.getState());
			t3.interrupt();
			break;
		case 2:
			System.out.printf("Etat du thread t2 : %s\n", t4.getState());
			t4.interrupt();
			break;

		}
	}
}