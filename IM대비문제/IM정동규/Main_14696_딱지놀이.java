package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14696_딱지놀이 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, card = 0;
		// A와 B가 가지고 있는 카드에 그려진 문양의 수를 저장하는 배열
		int[][] cards = new int[2][4];
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < cards.length; j++) {
				st = new StringTokenizer(br.readLine());
				card = Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens())
					cards[j][Integer.parseInt(st.nextToken()) - 1]++;
			}
			
			// 별, 동그라미, 네모, 세모 순서대로 승리 조건 구성, 전부 같으면 무승부
			if(cards[0][3] > cards[1][3]) {
				sb.append("A\n");
			}else if(cards[0][3] < cards[1][3]) {
				sb.append("B\n");
			}else {
				if(cards[0][2] > cards[1][2]) {
					sb.append("A\n");
				}else if(cards[0][2] < cards[1][2]) {
					sb.append("B\n");
				}else {
					if(cards[0][1] > cards[1][1]) {
						sb.append("A\n");
					}else if(cards[0][1] < cards[1][1]) {
						sb.append("B\n");
					}else {
						if(cards[0][0] > cards[1][0]) {
							sb.append("A\n");
						}else if(cards[0][0] < cards[1][0]) {
							sb.append("B\n");
						}else {
							sb.append("D\n");
						}
					}
				}
			}
			// 라운드마다 문양 수 초기화
			for(int j = 0; j < cards.length; j++)
				Arrays.fill(cards[j], 0);
		}
		System.out.println(sb);
	}
}
