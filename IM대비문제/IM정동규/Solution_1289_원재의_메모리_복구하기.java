package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SWEA 1289 - 원재의 메모리 복구하기
public class Solution_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 0, res = 0;
		String rm = "";
		char cur = '0';
		char[] cm;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			rm = br.readLine();
			cm = new char[rm.length()];
			for(int i = 0; i < rm.length(); i++)
				cm[i] = '0';
			
			// 원래의 메모리를 읽으면서 현재 메모리와 일치하지 않을 때 값을 끝까지 변경시키고 횟수 기록
			for(int i = 0; i < rm.length(); i++) {
				if(rm.charAt(i) != cm[i]) {
					cur = rm.charAt(i);
					for(int j = i; j < cm.length; j++)
						cm[j] = cur;
					res++;
				}
			}
			System.out.println("#" + t + " " + res);
			res = 0;
		}
	}
}
