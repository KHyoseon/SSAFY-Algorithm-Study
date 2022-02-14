package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_5반_정동규 {
	public static void main(String[] args) throws IOException {
		// 출력을 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 입력을 위한 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받은 문자열을 나누기 위한 StringTokenizer
		StringTokenizer st;
		
		// 문제의 입력 부분에 주어진 T, N, X, K, A, B
		int T = 0, N = 0, X = 0, K = 0, A = 0, B = 0;
		
		// 테스트 케이스의 수를 입력 받아서 int형으로 변환
		T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스의 수만큼 반복
		for(int t = 1; t <= T; t++) {
			// 각 테스트 케이스의 결과 앞에 출력되는 "#t "를 StringBuilder에 넣음
			sb.append("#" + t + " ");
			
			// N, X, K의 구분을 위해 입력 받은 줄을 " "을 기준으로 나눔
			st = new StringTokenizer(br.readLine(), " ");
			
			// 나눠진 문자열의 각 부분을 N, X, K에 할당
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());	
			K = Integer.parseInt(st.nextToken());
			
			// 컵을 맞바꾸는 횟수만큼 반복
			for(int k = 0; k < K; k++) {
				// A, B의 구분을 위해 입력 받은 줄을 " "을 기준으로 나눔
				st = new StringTokenizer(br.readLine(), " ");
				
				// 나눠진 문자열의 각 부분을 A, B에 할당
				A = Integer.parseInt(st.nextToken());
				B = Integer.parseInt(st.nextToken());
				
				// 현재 간식이 있는 위치가 A일 경우 B로 이동
				if(A == X)
					X = B;
				// 현재 간식이 있는 위치가 B일 경우 A로 이동
				else if(B == X)
					X = A;
			}
			// 결과를 StringBuilder에 저장하고 각 테스트 케이스 결과를 세로로 출력하기 위해 개행을 넣음
			sb.append(X + "\n");
		}
		System.out.println(sb);
	}
}
