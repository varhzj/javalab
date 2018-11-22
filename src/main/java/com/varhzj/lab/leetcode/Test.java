package com.varhzj.lab.leetcode;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					System.out.println(i);
				}
			}
		});
		t1.start();
		t1.join();
        System.out.println("end");
	}

}
