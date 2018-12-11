package com.buleheart.thinking.code.singleton;

public final class LazySynchronizedSingleton {
	//volatile 防止重排序
	private volatile static LazySynchronizedSingleton instance = null;
	private LazySynchronizedSingleton(){
		
	}
	//synchronized 修饰方法，保证只有一个线程可以访问，但是会阻塞，效率低下
	/*public synchronized static  LazySynchronizedSingleton getInstance(){
		if(null == instance){
			instance = new LazySynchronizedSingleton();
		}
		return instance;
	}*/
	//改进 double check
	/**
	 * 当两个线程同时满足null == instance 时，只有一个线程进入synchronized 代码块，保证了同步，达到了我们设计的初衷。
	 * 
	 * 
	 * @return
	 */
	public static LazySynchronizedSingleton getInstance(){
		if(null == instance){
			synchronized (LazySynchronizedSingleton.class){
				if(null == instance){
					instance = new LazySynchronizedSingleton();
				}
			}
		}
		return instance;
	}
	/**
	*但是日常使用中可能会有别的成员变量。看下面
	*//*
	*//**
	 * 其它资源（实例变量）
	 *//*
	private byte[] data = new byte[1024];
	Connection conn;
	Socket socket;
	private LazySynchronizedSingleton(){
	}
	public static LazySynchronizedSingleton getInstance(){
		if(null == instance){
			synchronized (LazySynchronizedSingleton.class){
				if(null == instance){
					instance = new LazySynchronizedSingleton();
				}
			}
		}
		return instance;
	}
	*/
}
