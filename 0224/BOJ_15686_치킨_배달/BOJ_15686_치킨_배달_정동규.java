package com.ssafy.w0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨_배달 {
	
	static class Point{
		int x;
		int y;
		
		public Point() {
			
		}
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, M = 0, num = 0;
		Point home, place;
		int[][] dists;
		List<Integer> selected;
		List<Point> homes = new ArrayList<Point>(), places = new ArrayList<Point>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				num = Integer.parseInt(st.nextToken());
				
				switch(num) {
				case 1:
					homes.add(new Point(j, i));
					break;
				case 2:
					places.add(new Point(j, i));
					break;
				default:
					break;
				}
			}
		}
		selected = new ArrayList<>();
		dists = new int[homes.size()][places.size()];

		for(int i = 0; i < homes.size(); i++) {
			for(int j = 0; j < places.size(); j++) {
				home = homes.get(i);
				place = places.get(j);
				dists[i][j] = Math.abs(home.x - place.x) + Math.abs(home.y - place.y);
			}
		}
		
		comb(dists, places.size(), M, selected, 0);
		
		sb.append(min);
		System.out.println(sb);
	}
	
	private static void comb(int[][] dists, int size, int M, List<Integer> selected, int start) {
		if(selected.size() == M) {
			int res = 0, submin = 0;
			
			for(int i = 0; i < dists.length; i++) {
				submin = Integer.MAX_VALUE;
				for(int j = 0; j < selected.size(); j++) {
					if(submin > dists[i][selected.get(j)])
						submin = dists[i][selected.get(j)];
				}
				res += submin;
			}
			
			if(min > res)
				min = res;
			
			return;
		}
		
		if(size - start > M - selected.size())
			comb(dists, size, M, selected, start + 1);				
		selected.add(start);
		comb(dists, size, M, selected, start + 1);
		selected.remove(selected.size() - 1);
	}
}
