package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형_네개의_합집합의_면적_구하기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 4, x = 0, y = 0,  p = 0, q = 0, res = 0;
		// 해당 칸에 색종이가 있는지 여부를 저장하는 배열
		boolean[][] paper = new boolean[100][100];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			// 주어진 좌표만큼 색종이가 있음을 표시
			for(int n = y; n < q; n++) {
				for(int m = x; m < p; m++)
					paper[n][m] = true;
			}
		}
		// 전체를 탐색하면서 색종이가 올라가 있는 칸 수를 계산
		for(int i = 0; i < paper.length; i++) {
			for(int j = 0; j < paper[i].length; j++) {
				if(paper[i][j] == true)
					res++;
			}
		}
		// 각 칸의 크기가 1이므로 그대로 출력
		System.out.println(res);
	}
}
