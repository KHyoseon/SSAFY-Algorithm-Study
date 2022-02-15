package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3499_퍼펙트_셔플 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, N = 0, dir = 0;
		int[] indexs = new int[2];
		String[] cards;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			// 원래의 덱을 반으로 나눠서 읽기 위한 index를 설정
			indexs[0] = 0;
			indexs[1] = (N + 1) / 2;
			dir = 0;
			cards = new String[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				cards[i] = st.nextToken();
			
			sb.append("#" + t + " ");
			// 반으로 나눈 덱을 번갈아 가면서 읽고 결과를 기록
			for(int i = 0; i < N; i++) {
				sb.append(cards[indexs[dir++]++] + " ");
				if(dir == 2)
					dir = 0;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
