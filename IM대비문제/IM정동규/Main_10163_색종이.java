package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, x = 0, y = 0, w = 0, h = 0;
		// 각 색종이의 보이는 면적을 저장하는 배열
		int[] res;
		// 각 칸에 가장 위에 보이는 색종이의 색을 저장하는 배열
		int[][] paper = new int[1001][1001];
		
		N = Integer.parseInt(br.readLine());
		res = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			// 각 색종이의 숫자(1~N)를 해당하는 칸에 기록
			// 나중에 오는 색종이가 먼저 온 색종이를 덮어버리기 때문에 새로운 색종이의 번호로 갱신
			for(int n = y; n < y + h; n++) {
				for(int m = x; m < x + w; m++)
					paper[n][m] = i;
			}
		}
		
		// 최종적으로 만들어진 평면의 각 칸에 있는 수를 읽으면서 카운트
		for(int i = 0; i < paper.length; i++) {
			for(int j = 0; j < paper[i].length; j++) {
				res[paper[i][j]]++;
			}
		}
		
		// 순서대로 출력
		for(int i = 1; i < res.length; i++)
			sb.append(res[i] + "\n");
		System.out.println(sb);
	}
}
