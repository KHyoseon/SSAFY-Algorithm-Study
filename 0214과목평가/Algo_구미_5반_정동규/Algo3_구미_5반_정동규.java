package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algo3_구미_5반_정동규 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, M = 0, P = 0, min = 1000, count = 0;
		String man = "", hack = "", curman = "", temp = "";
		
		N = Integer.parseInt(br.readLine());
		man = binary(N);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			P = Integer.parseInt(st.nextToken());
			
			hack = binary(P);
			
			if(man.length() > hack.length()) {
				for(int j = 0; j < man.length() - hack.length(); j++)
					temp += "0";
				hack = temp + hack;
				curman = man;
			}else if(man.length() < hack.length()) {
				for(int j = 0; j < hack.length() - man.length(); j++)
					temp += "0";
				curman = temp + man;
			}
			temp = "";
			
			for(int j = 0; j < curman.length(); j++) {
				if(curman.charAt(j) != hack.charAt(j))
					count++;
			}
			if(min > count)
				min = count;
			count = 0;
		}
		sb.append(min);
		System.out.println(sb);
	}
	
	private static String binary(int n) {
		Stack<Integer> stk = new Stack<>();
		String res = "";
		
		while(n > 0) {
			stk.add(n % 2);
			
			n /= 2;
		}
		
		while(!stk.isEmpty())
			res += stk.pop();
		
		return res;
	}
}
