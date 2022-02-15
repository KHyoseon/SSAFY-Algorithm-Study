package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1974_스도쿠_검증 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, num = 0, res = 0;
		boolean[][] rows, cols;
		boolean[][][] squares;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			res = 1;
			// 가로, 세로, 3x3 사각형에 1~9까지의 수가 있는지를 판단하기 위한 배열들
			rows = new boolean[9][9];
			cols = new boolean[9][9];
			squares = new boolean[3][3][9];
			
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					num = Integer.parseInt(st.nextToken());
					// 가로, 세로, 사각형 안에 중복되는 숫자가 나올 경우 결과를 0으로 변경
					if(rows[i][num - 1] == true || cols[j][num - 1] == true || squares[i / 3][j / 3][num - 1] == true)
						res = 0;
					// 가로, 세로, 사각형 안에 해당 숫자가 존재함을 기록
					rows[i][num - 1] = true;
					cols[j][num - 1] = true;
					squares[i / 3][j / 3][num - 1] = true;
				}
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
}
