package com.ssafy.w0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R = 0, C = 0;
	static char[][] map;
	static int[] dir = {-1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int res = 0;
		String str = "";
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			str = br.readLine();
			for(int j = 0; j < C; j++)
				map[i][j] = str.charAt(j);		
		}
		
		for(int i = 0; i < R; i++) {
			if(search(0, i) == true)
				res++;
		}
			
		sb.append(res);
		System.out.println(res);
	}
	
	private static boolean search(int x, int y) {
		int nx = 0, ny = 0;
		
		if(x == C - 1)
			return true;
		
		nx = x + 1;
		for(int d = 0; d < dir.length; d++) {
			ny = y + dir[d];
			
			if(ny >= 0 && ny < R) {
				if(map[ny][nx] != 'x') {
					map[ny][nx] = 'x';
					if(search(nx, ny) == true)
						return true;
				}
			}
		}
		return false;
	}
}
