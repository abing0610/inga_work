package com.inga.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	private boolean waxOn = false;
	public synchronized void waxed(){
		waxOn = true;
		notifyAll();
	}
	public synchronized void buffed(){
		waxOn = false;
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn == false){
			wait();
		}
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn == true){
			wait();
		}
	}
	
}


class WaxOn implements Runnable {

	private Car car;
	public WaxOn(Car c){
		car = c;
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				System.out.println("wax on!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			// TODO: handle exceptione
			System.out.println("exiting via interarupted");
		}
		System.out.println("ending wax on task!");
	}
}

class WaxOff implements Runnable{
	
	private Car car;
	public WaxOff(Car c){
		car = c;
	}
	public void run(){
		try {
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("wax off!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("exiting via interrupted");
		}
		System.out.println("exiting wax off task!");
	}
}


public class WaxOnMatic {
	
	public static void main(String[] args) throws InterruptedException {
		
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		
		TimeUnit.SECONDS.sleep(5);
		
		exec.shutdownNow();
		
		
	}
	

}
