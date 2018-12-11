package com.buleheart.thinking.code.singleton;
//enum 类型本身就是final,不允许被继承
public class EnumSingleton {
	private EnumSingleton(){	
	}
	private enum EnumHolder{
		INSTANCE;
		private EnumSingleton instance;
		EnumHolder(){
			this.instance =  new EnumSingleton();
		}
		private EnumSingleton getInstance(){
			return instance;
		}
	}
	public static EnumSingleton  getInstance(){
		return EnumHolder.INSTANCE.getInstance();
	}

}
