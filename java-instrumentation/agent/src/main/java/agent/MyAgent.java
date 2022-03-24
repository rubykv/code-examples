package agent;

import java.lang.instrument.Instrumentation;

public class MyAgent {
	public static void premain(String args, Instrumentation instr) {
		System.out.println("Inside premain.........");
		instr.addTransformer(new MyTransformer());
	}
}
