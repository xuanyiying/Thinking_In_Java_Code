package com.buleheart.thinking.code.singleton;

public final class InnerClassSingleton {
	private InnerClassSingleton(){
	}
	//在静态内部类中持有innerClassSingleton实例，并且可以直接被初始化
	private static class Holder{
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}
	public static InnerClassSingleton getInstance(){
		return Holder.instance;
	}
    
    
}
