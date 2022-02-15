package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2005_파스칼의_삼각형 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, N = 0, size = 3;
		int[] line;
		int[][] pascal;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");
			
			N = Integer.parseInt(br.readLine());
			pascal = new int[N][];
			
			// 파스칼의 삼각형에서 0 + 1, 1 + 0 을 통해 테두리의 1을 만들기 위해 size는 3으로 시작
			//      0 1 0
			//     0 1 1 0
			//    0 1 2 1 0
			//       ...
			size = 3;
			line = new int[size++];
			line[1] = 1;
			pascal[0] = line;
			
			// 파스칼의 삼각형 규칙에 따라 위의 두 수를 더해서 아래수를 만드는 반복
			for(int i = 1; i < pascal.length; i++) {
				line = new int[size++];
				for(int j = 1; j < line.length - 1; j++)
					line[j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				pascal[i] = line;
			}
			for(int i = 0; i < pascal.length; i++) {
				for(int j = 1; j < pascal[i].length - 1; j++)
					sb.append(pascal[i][j] + " ");
				sb.setLength(sb.length() - 1);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
