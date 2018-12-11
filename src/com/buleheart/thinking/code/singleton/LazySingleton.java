package com.buleheart.thinking.code.singleton;
//final 防止被继承
//缺点：多线程情况下并不能保证单例唯一性
public final class LazySingleton {
	//定义实例，但不做任何操作
	private static LazySingleton instance = null;
	//构造方法私有化防止被外部 new
	private LazySingleton(){
		
	}
	public static LazySingleton getInstance(){
		if(null == instance){
			instance = new LazySingleton();
		}
		return instance;
	}

}
