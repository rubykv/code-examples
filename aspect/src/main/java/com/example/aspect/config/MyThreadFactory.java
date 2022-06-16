package com.example.aspect.config;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
	static int i = 1;

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, "" + i);
		i++;
		return t;
	}

}
