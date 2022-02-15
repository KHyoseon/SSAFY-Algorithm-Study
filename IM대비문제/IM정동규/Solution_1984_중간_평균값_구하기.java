package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1984_중간_평균값_구하기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, max = 0, min = 0, num = 0, res = 0;
		double sum = 0.0, avg = 0.0;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			sum = 0.0;
			avg = 0.0;
			max = 0;
			min = 10000;
			
			st = new StringTokenizer(br.readLine());
			// 입력을 받으면 sum에 더하고 최대값, 최소값 비교 후 갱신
			for(int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				sum += num;
				if(max < num)
					max = num;
				if(min > num)
					min = num;
			}
			// sum에서 최대값, 최소값 제외한 후 평균 계산 및 반올림
			sum -= max;
			sum -= min;
			avg = sum / 8;
			res = (int)(avg + 0.5);
			
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
}
