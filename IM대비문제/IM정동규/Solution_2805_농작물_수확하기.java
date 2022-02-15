package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SWEA 2805 - 농작물 수확하기
public class Solution_2805_농작물_수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 0, num = 0, res = 0, center = 0, delta = 0, dir = 1;
		String str = "";
		
		int[][] field;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			num = Integer.parseInt(br.readLine());
			center = num / 2;
			field = new int[num][num];
			for(int i = 0; i < num; i++) {
				str = br.readLine();
				for(int j = 0; j < str.length(); j++)
					field[i][j] = str.charAt(j) - '0';
			}
			
			
			for(int i = 0; i < num; i++) {
				// 현재 줄의 가운데부터 좌우를 나눠서 탐색
				// 한번 반복이 끝날 때마다 범위를 늘리거나 줄이면서 진행
				res += field[i][center];
				for(int j = center - 1; j >= (center - delta); j--)
					res += field[i][j];
				for(int j = center + 1; j <= (center + delta); j++)
					res += field[i][j];
				delta += dir;
				// 탐색이 중간까지 진행됐을 경우 범위를 줄여 나가면서 탐색하기 위해 증감을 변경
				if(delta >= center)
					dir = -1;
			}
			
			System.out.println("#" + t + " " + res);
			res = 0;
			dir = 1;
			delta = 0;
		}
	}
}
