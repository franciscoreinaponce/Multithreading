package com.franciscoreina;

// Making use of the synchronized modifier.
// Useful for synchronizing access to objects shared by multiple threads (avoid race conditions).

public class App5_SynchronizedKeyword {

	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {
		App5_SynchronizedKeyword app = new App5_SynchronizedKeyword();
		app.doWork();
	}

	public void doWork() {

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					increment();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("Count is: " + count);

	}

}
