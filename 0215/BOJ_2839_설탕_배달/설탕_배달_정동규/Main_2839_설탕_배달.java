package com.ssafy.w0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2839_설탕_배달 {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, min = 0;
		
		// 3~N까지의 무게를 만드는 최소값을 저장하기 위한 배열(N의 최대값이 5000이므로 미리 배열의 크기를 5001로 설정)
		int[] dp = new int[5001];
		
		// 해당 무게를 만들 수 없을 경우 결과를 -1로 출력하기 위해 배열의 값을 모두 -1로 변경
		Arrays.fill(dp, -1);
		
		// 무게 3과 5를 만드는 경우는 결과가 1이기 때문에 미리 1로 설정
		dp[3] = 1;
		dp[5] = 1;
		
		N = Integer.parseInt(br.readLine());
		
		// 3~5까지의 결과는 이미 저장됐기 때문에 6~N까지 반복
		for(int i = 6; i <= N; i++) {
			
			// 최소값을 찾기 위해 min의 초기값을 매우 큰 수로 설정
			min = Integer.MAX_VALUE;
			
			// 숫자 2개로 무게 i를 만들 수 있는 경우는 (3, i - 3) ~ (i / 2, i - i / 2)이므로 3 ~ (i / 2)까지 반복
			// ex) i = 16 -> (3, 13), (4, 12), (5, 11), (6, 10), (7, 9), (8, 8)
			// ex) i = 17 -> (3, 14), (4, 13), (5, 12), (6, 11), (7, 10), (8, 9)
			for(int j = 3; j <= i / 2; j++) {
				// -1인 경우는 만들 수 없는 수이므로 제외
				if(min > dp[j] + dp[i - j] && dp[j] != -1 && dp[i - j] != -1)
					min = dp[j] + dp[i - j];
			}
			
			// min값이 변경되지 않았음 = 무게 i를 만들 수 없음 -> -1
			if(min == Integer.MAX_VALUE)
				min = -1;
			
			// 결과 저장
			dp[i] = min;
		}
		
		sb.append(dp[N]);
		System.out.println(sb);
	}
}
