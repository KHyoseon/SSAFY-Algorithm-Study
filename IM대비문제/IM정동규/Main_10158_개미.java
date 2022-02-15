package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Java11은 시간초과가 발생하므로 Java8로 돌려야 함

// 가로 또는 세로에 대한 정보를 저장
// end: 끝지점 좌표, start: 개미의 시작 지점 좌표, t: 남은 이동 시간
class Info{
	int end;
	int start;
	int t;
}
public class Main_10158_개미 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int delta = 0;
		int[] d = {0, 0};
		int[] dir = {1, -1};
		int[] res = new int[2];
		// 개미의 이동을 가로와 세로로 나눠서 생각하기 위해 가로(x)와 세로(y)에 대한 정보를 따로 생성
		Info x = new Info(), y = new Info();
		Info[] info = new Info[2];
		
		st = new StringTokenizer(br.readLine());
		x.end = Integer.parseInt(st.nextToken());
		y.end = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		res[0] = Integer.parseInt(st.nextToken());
		x.start = res[0];
		res[1] = Integer.parseInt(st.nextToken());
		y.start = res[1];
		
		x.t = Integer.parseInt(br.readLine());
		y.t = x.t;
		
		// 가로(또는 세로) 방향으로  최대 길이의 2배만큼 움직이면 처음 위치로 돌아옴
		// 그러므로 최대 길이의 2배로 나눈 나머지 만큼만 이동을 고려하면 원하는 결과를 얻을 수 있음
		x.t %= (x.end * 2);
		y.t %= (y.end * 2);
		
		info[0] = x;
		info[1] = y;
		// 남은 시간만큼 가로, 세로 각각 이동시켜서 결과 계산
		for(int i = 0; i < info.length; i++) {
			delta = info[i].end - info[i].start;
			while(info[i].t - delta >= 0) {
				info[i].t -= delta;
				res[i] += delta * dir[d[i]];
				d[i]++;
				if(d[i] == 2)
					d[i] = 0;
				
				delta = info[i].end;
			}
			res[i] += info[i].t * dir[d[i]];
		}
		System.out.println(res[0] + " " + res[1]);
	}
}
