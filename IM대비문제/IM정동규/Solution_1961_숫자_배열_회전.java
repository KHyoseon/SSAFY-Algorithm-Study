package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1961_숫자_배열_회전 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, N = 0;
		int[][] arr;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				// 90도 회전을 위해 원본의 왼쪽 아래 인덱스부터 올라오면서 읽고 기록
				for(int j = N - 1; j >= 0; j--)
					sb.append(arr[j][i]);
				sb.append(" ");
				// 180도 회전을 위해 원본의 오른쪽 아래 인덱스부터 왼쪽으로 가면서 읽고 기록				
				for(int j = N - 1; j >= 0; j--)
					sb.append(arr[N - 1 - i][j]);
				sb.append(" ");
				// 270도 회전을 위해 원본의 오른쪽 위 인덱스부터 내려가면서 읽고 기록
				for(int j = 0; j < N; j++)
					sb.append(arr[j][N - 1 - i]);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
