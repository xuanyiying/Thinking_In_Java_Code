package com.buleheart.thinking.code.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		String s;
		while((s = stdin.readLine()) != null)
			System.out.println(s);
		
	}
}
