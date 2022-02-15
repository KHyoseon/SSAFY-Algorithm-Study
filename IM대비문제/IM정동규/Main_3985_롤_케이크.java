package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985_롤_케이크 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = 0, N = 0, start = 0, end = 0, count = 0;
		// 케이크 배분 결과를 저장하는 배열
		int[] cake;
		// 가장 많은 케이크 조각을 받을 사람과 수를 저장하는 배열
		// max[0][0]: 가장 많은 조각을 받을 것으로 기대되던 방청객의 번호, max[0][1]: 이 사람이 적었던 케이크의 수
		// max[1][0]: 실제로 가장 많은 조각을 받은 방청객의 번호, max[1][1]: 이 사람이 받은 케이크의 수
		int[][] max = new int[2][2];
		
		L = Integer.parseInt(br.readLine());
		cake = new int[L];
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			// 입력을 받으면서 종이에 적은 케이크 조각의 수가 가장 많은 사람을 찾아서 저장
			if(max[0][1] < end - start + 1) {
				max[0][0] = i;
				max[0][1] = end - start + 1;
			// 케이크의 수가 같을 경우 번호가 작은 사람을 저장
			}else if(max[0][1] == end - start + 1) {
				if(max[0][0] > i)
					max[0][0] = i;
			}
			// 아직 해당 번호의 케이크가 배분되지 않았을 경우 배분
			for(int j = start - 1; j < end; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
					count++;
				}
			}
			// 실제 배분된 결과에 대해서 다시 최대 값과 사람을 찾음
			if(max[1][1] < count) {
				max[1][0] = i;
				max[1][1] = count;
			}else if(max[1][1] == count) {
				if(max[1][0] > i)
					max[1][0] = i;
			}
			count = 0;
		}
		for(int i = 0; i < max.length; i++)
			sb.append(max[i][0] + "\n");
		
		System.out.println(sb);
	}
}
