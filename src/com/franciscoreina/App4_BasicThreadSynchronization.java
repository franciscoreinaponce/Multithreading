package com.franciscoreina;

import java.util.Scanner;

// Making use of the volatile modifier.
// Useful when several threads read from a variable, and only one thread modifies its value.

class Processor extends Thread {

	private volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		running = false;
	}

}

public class App4_BasicThreadSynchronization {

	public static void main(String[] args) {

		Processor p1 = new Processor();
		p1.start();

		System.out.println("Press return to stop...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();

		p1.shutDown();
		
	}

}
