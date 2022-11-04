class MyRunnable implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("DEBUT THREAD");
			Thread.sleep(1000);
			System.out.println("FIN THREAD");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


