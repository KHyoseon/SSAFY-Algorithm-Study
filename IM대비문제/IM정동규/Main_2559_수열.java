package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2559_수열 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, K = 0, sum = 0, max = -10000001;
		int[] tems;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tems = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			tems[i] = Integer.parseInt(st.nextToken());
		
		// K 값에 따라 나올 수 있는 결과의 경우가 0 ~ (N - K)이므로 그만큼 반복
		for(int i = 0 ; i <= N - K; i++) {
			// 시작점부터 K개만큼 더하고 다 더한 뒤에는 max와 비교하여 갱신
			for(int j = i; j < i + K; j++)
				sum += tems[j];
			if(max < sum)
				max = sum;
			sum = 0;
		}
		
		System.out.println(max);
	}
}
