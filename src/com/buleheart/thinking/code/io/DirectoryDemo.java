package com.buleheart.thinking.code.io;

import java.io.File;

public class DirectoryDemo {
	public static void main(String[] args){
		PPrint.pformat(Directory.walk(".").dirs);
		for (File file : Directory.local(".", "T.*")) 
			print(file);
		print("---------------");
	}

	private static void print(Object c) {
		System.out.println();
		
	}
}
