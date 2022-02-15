package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int w = 0, h = 0, cut = 0, dir = 0, num = 0;
		// 최종적으로 계산된 사각형들의 넓이가 저장 될 리스트
		List<Integer> list = new ArrayList<>();
		
		// 가로(또는 세로)의 잘린 위치를 저장하기 위한 2차원 리스트
		List<List<Integer>> point = new ArrayList<>(2);
		point.add(new ArrayList<>());
		point.add(new ArrayList<>());
		
		// 위의 point를 이용하여 각 변의 길이를 구하여 저장하는 2차원 리스트
		List<List<Integer>> dist = new ArrayList<>(2);
		dist.add(new ArrayList<>());
		dist.add(new ArrayList<>());
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		// 원활한 변의 길이 계산을 위해 시작점과 끝점의 위치를 저장
		point.get(0).add(0);
		point.get(0).add(h);
		point.get(1).add(0);
		point.get(1).add(w);
		
		// 입력 받은 잘린 위치를 저장
		cut = Integer.parseInt(br.readLine());
		for(int i = 0; i < cut; i++) {
			st = new StringTokenizer(br.readLine());
			dir = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			
			point.get(dir).add(num);
		}
		// 가로와 세로의 잘린 위치를 오름차순 정렬
		for(int i = 0; i < point.size(); i++)
			Collections.sort(point.get(i));
		
		// 정렬된 가로와 세로의 잘린 위치 정보를 이용하여 각 사각형의 변의 길이 계산
		for(int i = 0; i < point.size(); i++) {
			for(int j = 1; j < point.get(i).size(); j++)
				dist.get(i).add(point.get(i).get(j) - point.get(i).get(j - 1));
		}
		// 계산한 변의 길이를 이용하여 각 사각형의 넓이 계산
		for(int i = 0; i < dist.get(0).size(); i++) {
			for(int j = 0; j < dist.get(1).size(); j++)
				list.add(dist.get(0).get(i) * dist.get(1).get(j));
		}
		// 넓이가 저장된 리스트를 정렬
		Collections.sort(list);
		
		// 가장 큰 값 출력
		System.out.println(list.get(list.size() - 1));
	}
}
