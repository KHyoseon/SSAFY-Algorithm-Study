package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2635_수_이어가기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, K = 0, max = 2, count = 2, first = 0, second = 0, res = 0;
		String answer = "", temp = "";
		
		N = Integer.parseInt(br.readLine());
		// K가 1~30000인 모든 경우에 대해 계산
		for(int k = 1; k <= N; k++) {
			// 초기 값 설정
			first = N;
			second = k;
			count = 2;
			temp = new String(first + " " + second + " ");
			
			res = first - second;
			// 주어진 규칙에 따라 반복을 돌면서 음수가 나오면 멈춤
			while(res >= 0) {
				temp += res + " ";
				first = second;
				second = res;
				count++;
				
				res = first - second;
			}
			// 이번 반복의 결과가 전체 최대값보다 크다면 값과 정답 문자열 갱신
			if(max < count) {
				max = count;
				answer = temp;
			}
		}
		sb.append(max + "\n");
		sb.append(answer);
		
		System.out.println(sb);
	}
}
