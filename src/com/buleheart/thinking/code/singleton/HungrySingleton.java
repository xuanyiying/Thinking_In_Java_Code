package com.buleheart.thinking.code.singleton;
//final 不允许被继承被改变
//static 修饰的变量和方法是类变量和类方法，被使用时，被static修饰的方法只执行一次，从而保证了同步，
//如果主动使用 HungrySingleton, 那么instance初始化时就被实例化，变量也会被初始化。
//缺点：长时间占用内存资源
public final class HungrySingleton {
	//实例变量
	//private byte[] data = new byte[1024];
	//HungrySingleton();
	//定义对象时直接初始化
	private static HungrySingleton instance = new HungrySingleton();
	//构造函数私有化，不允许外部 new
	private HungrySingleton(){		
	}
	public static HungrySingleton getInstance(){
		return instance;
	}
	
}
