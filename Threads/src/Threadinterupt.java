public class Threadinterupt implements Runnable {
	private int id;

	public Threadinterupt(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		int i = 0;
		while (!Thread.interrupted()) {
			System.out.printf("thread id : %d - valeur de la boucle %d\n", id, i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.printf(">>> CATCH thread %d - status :%b\n", id, Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
			}
		}
		System.out.printf(">>> FIN EXECUTION thread %d - status :%b\n", id, Thread.currentThread().isInterrupted());
	}
}