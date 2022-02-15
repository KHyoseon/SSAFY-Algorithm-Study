package com.ssafy.w0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2839_설탕_배달_Greedy {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, q = 0, r = 0, res = 0;
		
		N = Integer.parseInt(br.readLine());
		
		// 무게가 5인 봉지의 값을 최대로 설정
		q = N / 5;
		
		// 무게가 5인 봉지를 제외한 나머지 무게
		r = N % 5;
		
		// 나머지 무게가 3으로 나누어 떨어지면 무게 N을 만족하게 되므로 반복 종료
		// 또는 무게 5인 봉지의 수가 -1이 되면 반복 종료
		// 그 외의 경우는 무게 5인 봉지의 수를 1개 줄이고 나머지 무게에 더해줌
		while(r % 3 != 0 && q != -1) {
			q--;
			r += 5;
		}
		// 무게 5인 봉지의 수가 -1이 되면 N을 만들 수 없다는 의미이므로 결과는 -1
		if(q == -1)
			res = -1;
		// 그 외에는 5
		else
			res = q + r / 3;
		
		sb.append(res);
		System.out.println(sb);
	}
}
