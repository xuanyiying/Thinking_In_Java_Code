package com.buleheart.thinking.code.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	public static String read(String filename)throws IOException {
		//Reading input by lines
		BufferedReader in = new BufferedReader(
				new FileReader(filename));
		String s;
		StringBuffer sb = new StringBuffer();
		while ((s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();		
	}
	public static void main(String[] args) throws Exception{
		System.out.println(read("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/BufferedInputFile.java"));
	}
	
	
}
