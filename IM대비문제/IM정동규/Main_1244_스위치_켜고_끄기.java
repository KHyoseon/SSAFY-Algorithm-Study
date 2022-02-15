package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치_켜고_끄기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, std = 0, gen = 0, btn = 0, delta = 0, left = 0, right = 0, count = 0;
		// 스위치의 상태를 저장하는 배열
		int[] states;
		
		N = Integer.parseInt(br.readLine());
		states = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			states[i] = Integer.parseInt(st.nextToken());
		
		std = Integer.parseInt(br.readLine());
		for(int i = 0; i < std; i++) {
			st = new StringTokenizer(br.readLine());
			gen = Integer.parseInt(st.nextToken());
			btn = Integer.parseInt(st.nextToken());
			delta = btn;
			left = btn - 1;
			right = btn + 1;
			// 남학생일 경우 주어진 버튼의 배수에 해당하는 스위치를 토글
			if(gen == 1) {
				while(btn <= states.length) {
					toggle(states, btn - 1);
					btn += delta;
				}
			// 여학생일 경우
			}else if(gen == 2) {
				// 선택된 번호를 토글
				toggle(states, btn - 1);
				
				// 선택된 번호의 양 옆으로 이동하면서 값이 같으면 토글 후 진행, 없으면 반복 정지
				while(left > 0 && right <= N) {
					if(states[left - 1] != states[right - 1])
						break;
					toggle(states, left - 1);
					toggle(states, right - 1);
					
					left--;
					right++;
				}
			}
		}
		// 결과를 20개씩 출력
		for(int i = 0; i < states.length; i++) {
			sb.append(states[i]);
			count++;
			
			if(count % 20 != 0)
				sb.append(" ");
			else
				sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	// 스위치가 켜져있으면 끄고 꺼져있으면 켜는 함수
	private static void toggle(int[] states, int num) {
		if(states[num] == 1)
			states[num] = 0;
		else if(states[num] == 0)
			states[num] = 1;
	}
}
