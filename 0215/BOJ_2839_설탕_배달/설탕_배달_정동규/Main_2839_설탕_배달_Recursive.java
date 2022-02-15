package com.ssafy.w0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2839_설탕_배달_Recursive {
	static int min = -1;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0;
		
		N = Integer.parseInt(br.readLine());
		
		sugar(N, 0, 0);
		sb.append(min);
		System.out.println(min);
	}
	
	private static void sugar(int N, int weight, int count) {
		if(weight == N) {
			if(min == -1 || min > count)
				min = count;
			return;
		}else if(weight > N) {
			return;
		}else if(weight < N) {
			sugar(N, weight + 5, count + 1);
			sugar(N, weight + 3, count + 1);			
		}
	}
}
