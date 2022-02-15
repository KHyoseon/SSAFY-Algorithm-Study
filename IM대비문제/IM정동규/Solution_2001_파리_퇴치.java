package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리_퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, N = 0, M = 0, sum = 0, max = 0;
		int[][] space;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			space = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++)
					space[i][j] = Integer.parseInt(st.nextToken());
			}
			// 1~2번쨰 반복문은 파리채의 이동을 의미
			for(int i = 0; i <= N - M; i++) {
				for(int j = 0; j <= N - M; j++) {
					//3~4번쨰 반복문은 파리채 내에서 파리의 수 탐색
					for(int y = i; y < i + M; y++) {
						for(int x = j; x < j + M; x++)
							sum += space[y][x];
					}
					if(max < sum)
						max = sum;
					sum = 0;
				}
			}
			System.out.println("#" + t + " " + max);
			max = 0;
		}
	}
}
