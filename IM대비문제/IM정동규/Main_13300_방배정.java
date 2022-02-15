package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13300_방배정 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, K = 0, S = 0, Y = 0, res = 0;
		// 현재 배정된 학생 수를 저장하는 배열
		int[][] stds = new int[2][6];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 계산 편의성을 위해 미리 K만큼 배정
		for(int i = 0; i < stds.length; i++)
			Arrays.fill(stds[i], K);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			
			// 배정된 인원이 K명을 넘어갈 경우 필요한 방 +1
			stds[S][Y - 1]++;
			if(stds[S][Y - 1] == K + 1) {
				stds[S][Y - 1] = 1;
				res++;				
			}
		}
		System.out.println(res);
	}
}
