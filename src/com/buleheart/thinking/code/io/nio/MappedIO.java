package com.buleheart.thinking.code.io.nio;

public class MappedIO {
	private static int numOfInts = 4000000;
	private static int numOfUbuffInts = 200000;
	private abstract static class Tester{
		private String name;
		public Tester(String name){
			this.name = name;
		}
		public void runTest(){
			System.out.println(name + ":");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n",duration/1.0e9);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}			
		}
		public abstract void test() throws RuntimeException;
	}
	
	private static Tester[] tests = {
		new Tester("Stream Writes"){
			@Override
			public void test() throws RuntimeException {
			
			}
			
		}
	};
		
}
