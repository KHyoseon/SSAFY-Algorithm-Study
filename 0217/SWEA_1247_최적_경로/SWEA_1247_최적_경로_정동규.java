package com.ssafy.w0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos{
	int x;
	int y;
	
	public Pos() {
		
	}

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
public class SWEA_1247_최적_경로 {
	static int min;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, N = 0, x = 0, y = 0;
		boolean[] selected;
		Pos com, home;
		Pos[] guests;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			selected = new boolean[N + 2];
			guests = new Pos[N + 2];
			
			st = new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			com = new Pos(x, y);
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home = new Pos(x, y);
			
			guests[0] = com;
			for(int i = 1; i <= N; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				guests[i] = new Pos(x, y);
			}
			guests[N + 1] = home;
			
			dfs(guests, selected, 0, 0, 0);
			
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(Pos[] guests, boolean[] selected, int sum, int count, int last) {
		int dist = 0;
		
		if(count == guests.length - 2) {
			dist = Math.abs(guests[last].x - guests[guests.length - 1].x) + Math.abs(guests[last].y - guests[guests.length - 1].y);
			if(min > sum + dist)
				min = sum + dist;
			return;
		}
		
		for(int i = 1; i <= guests.length - 2; i++) {
			if(selected[i] == false) {
				dist = Math.abs(guests[last].x - guests[i].x) + Math.abs(guests[last].y - guests[i].y);
				if(sum + dist < min) {
					selected[i] = true;
					dfs(guests, selected, sum + dist, count + 1, i);
					selected[i] = false;
				}
			}
		}
	}
}
