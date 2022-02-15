package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// BOJ 2309 - 일곱 난쟁이
public class Main_2309_일곱_난쟁이 {
	private static List<Integer> temp = new ArrayList<>();
	private static List<Integer> res;
	
	private static boolean end = false;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력받은 정보를 저장하는 배열
		int[] info = new int[9];
		
		for(int i = 0; i < 9; i++)
			info[i] = Integer.parseInt(br.readLine());
		// 7명의 키의 합이 100인 경우를 찾는 함수
		search(info, 0, 0);
		
		// 오름차순 출력을 위해 정렬 후 출력
		Collections.sort(res);
		for(int i = 0; i < res.size(); i++)
			sb.append(res.get(i) + "\n");
		System.out.println(sb);
	}
	
	private static void search(int[] info, int start, int height){
		// 정답을 찾았다면 남은 경우는 모두 리턴
		if(end)
			return;
		// 선택한 값이 7개일 때 키가 100이면 정답이라고 판단
		if(temp.size() == 7) {
			if(height == 100) {
				res = new ArrayList<>(temp);
				end = true;
			}
			return;
		}
		// 현재 상태에서 남은 배열 끝까지 다 포함해도 7명이 안되기 때문에 리턴
		if(start - temp.size() > 2)
			return;
		
		// 지금까지의 키의 합과 현재 값을 더한 것이 100이하면 현재 값을 선택한 경우를 체크
		if(height + info[start] <= 100) {
			temp.add(info[start]);
			search(info, start + 1, height + info[start]);
			temp.remove(temp.size() - 1);
		}
		// 현재 수를 선택하지 않는 경우 체크
		search(info, start + 1, height);
	}
}
