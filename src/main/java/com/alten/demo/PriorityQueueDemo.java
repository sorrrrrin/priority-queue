package com.alten.demo;

import com.alten.PriorityQueue;

/**
 * This is the scenario described in the specifications, with the patiens ariving at the hospital with different priorities.
 * 
 */
public class PriorityQueueDemo {
	
	public static void main(String[] args) {
		PriorityQueue<PatientBean> priorityQueue = new PriorityQueue<>();
		
		priorityQueue.add(new PatientBean(){{setName("patient 1");}}, null); // adds the patient with the lowest priority so far
		priorityQueue.add(new PatientBean(){{setName("patient 2");}}, null); // adds the patient with the lowest priority so far
		priorityQueue.add(new PatientBean(){{setName("patient 3");}}, null); // adds the patient with the lowest priority so far

		// adds the last patient with highest priority due too his complications, 
		// so now we have queue = "patient 0", "patient 1", "patient 2", "patient 3"
		priorityQueue.add(new PatientBean(){{setName("patient 0");}}, 0);
		
		System.out.println("queue length: " + priorityQueue.length()); // it should show 4
		
		priorityQueue.changePriority(2, 0); // change patient 2 priority to highest
		
		System.out.println(priorityQueue.get().getName()); // renders: patient 2
		System.out.println(priorityQueue.get().getName()); // renders: patient 0
		System.out.println(priorityQueue.get().getName()); // renders: patient 1
		System.out.println(priorityQueue.get().getName()); // renders: patient 3
		
		// this demo could have been done with threads as well, instantiating each thread something like below, 
		// it should work having the code synchronized.
		//
		// I tested it as well adding some Thread.sleep(...) inside the add, changePriority, etc. methods, 
		// so that I delay their execution to make each thread waiting its turn when using synchronized, 
		// and to see they fail when not using the synchronized code.
		//
		//		Thread t1 = new Thread(new Runnable() {
		//			@Override
		//			public void run() {
		//				priorityQueue.changePriority(priorityQueue.length()-1, 0);
		//			}
		//		});
		//		t1.start()					
		
	}
}
