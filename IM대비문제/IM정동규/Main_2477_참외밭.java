package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = 0, sum = 0, dir = 0, dist = 0, temp = 1;
		// 각 방향이 나온 횟수를 저장하기 위한 배열
		// 같은 방향이 1번만 나오는 경우가 가장 긴 변(가로 방향 1개, 세로 방향 1개)이 됨 
		int[] count = new int[4];
		// 각 변의 길이 정보를 저장하기 위한 배열, 계산 편의성을 위해 크기는 6 + 1로 설정
		int[] info = new int[7];
		// 방향값을 통해 가장 긴 변을 쉽게 찾기 위한 map
		Map<Integer, Integer> map = new HashMap<>();
		
		num = Integer.parseInt(br.readLine());
		
		// 각 방향과 변에 대한 정보를 입력 받고 저장
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			count[dir - 1]++;
			info[i] = dist;
			map.put(dir - 1, dist);
		}
		// 계산 편의성을 위해 마지막 원소에 첫 변의 길이를 추가
		info[6] = info[0];
		
		// 이웃하는 변끼리의 곱을 모두 더한 뒤 가장 긴 변 2개의 곱을 2번 빼주면 원하는 답을 얻을 수 있음
		// 이 내용은 그림을 직접 그려보면 이해하기 쉬움
		for(int i = 0; i < info.length - 1; i++)
			sum += info[i] * info[i + 1];
		for(int i = 0; i < count.length; i++) {
			if(count[i] == 1)
				temp *= map.get(i);
		}
		sum -= temp * 2;
		
		// 출력
		System.out.println(sum * num);
	}
}
