package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2564_경비원 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, M = 0, num = 0, res = 0;
		int[] X = new int[3];
		int[][] stores;
		// 각 변과 맞은 편에 있는 곳을 알아내기 위한 map(1: 북쪽, 2: 남쪽, 3: 서쪽, 4: 동쪽)
		Map<Integer, Integer> pair = new HashMap<Integer, Integer>() {{
			put(1, 2);
			put(2, 1);
			put(3, 4);
			put(4, 3);
		}};
		// 현재 변에서 사용하야 하는 최대값을 알아내기 위한 map
		Map<Integer, Integer> dir = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dir.put(1, M);
		dir.put(2, M);
		dir.put(3, N);
		dir.put(4, N);
		
		num = Integer.parseInt(br.readLine());
		// 가게의 정보를 저장하는 배열
		// stores[i][0]: i번째 가게의 변
		// stores[i][1]: i번째 가게의 변으로부터의 거리
		// stores[i][2]: i번째 가게의 변을 좌표로 변환한 값(북쪽: 0, 남쪽: N, 서쪽: 0, 동쪽: M)
		stores = new int[num][3];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			stores[i][0] = Integer.parseInt(st.nextToken());
			stores[i][1] = Integer.parseInt(st.nextToken());
			switch(stores[i][0]) {
			case 1:
				stores[i][2] = 0;
				break;
			case 2:
				stores[i][2] = N;
				break;
			case 3:
				stores[i][2] = 0;
				break;
			case 4:
				stores[i][2] = M;
				break;
			}
		}
		// X: 경비원, 저장 정보는 stores와 동일
		st = new StringTokenizer(br.readLine());
		X[0] = Integer.parseInt(st.nextToken());
		X[1] = Integer.parseInt(st.nextToken());
		switch(X[0]) {
		case 1:
			X[2] = 0;
			break;
		case 2:
			X[2] = N;
			break;
		case 3:
			X[2] = 0;
			break;
		case 4:
			X[2] = M;
			break;
		}
		
		for(int i = 0; i < stores.length; i++) {
			// 경비원과 상점이 같은 변에 있을 경우
			if(X[0] == stores[i][0]) {
				// 거리 차이 만큼 이동해야 함
				res += Math.abs(X[1] - stores[i][1]);
			// 경비원과 상점이 맞은 편 변에 있을 경우
			}else if(X[0] == pair.get(stores[i][0])) {
				// 양쪽 이동거리 중 더 짧은 쪽으로 이동해야 함
				if(dir.get(X[0]) * 2 - X[1] - stores[i][1] <  X[1] + stores[i][1])
					res += dir.get(X[0]) * 2 - X[1] - stores[i][1];
				else
					res += X[1] + stores[i][1];
				res += N;
			// 경비원과 상점이 이웃하는 변에 있을 경우
			}else {
				// 경비원 위치 -> 상점이 있는 변의 길이와 상점이 있는 위치-> 경비원이 있는 변의 길이만큼 이동해야 함
				res += Math.abs(X[2] - stores[i][1]) + Math.abs(stores[i][2] - X[1]);
			}
		}
		System.out.println(res);
	}
}
