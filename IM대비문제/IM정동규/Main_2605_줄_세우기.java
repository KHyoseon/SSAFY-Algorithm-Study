package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BOJ 2605 - 줄 세우기
public class Main_2605_줄_세우기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, num = 0;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<>();
		
		// 1번~N번 학생까지 순서대로 번호를 뽑는 반복문
		for(int i = 1; i <= N; i++) {
			num = Integer.parseInt(st.nextToken());
			// 뽑은 번호가 0이라면 가장 뒤에 값을 삽입
			if(num == 0)
				list.add(i);
			// 뽑은 번호가 0이 아니라면 뽑은 수 만큼 앞으로 이동한 자리에 삽입
			else
				list.add(list.size() - num, i);
		}
		
		// 출력
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())
			sb.append(iter.next() + " ");
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
