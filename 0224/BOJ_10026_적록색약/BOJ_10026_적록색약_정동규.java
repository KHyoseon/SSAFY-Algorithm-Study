package com.ssafy.w0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {
	
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
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0;
		char color = '0';
		String str = "";
		int[] counts = new int[2];
		char[][][] pictures;
		boolean[][] visited;
		
		N = Integer.parseInt(br.readLine());
		pictures = new char[2][N][N];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < N; j++) {
				pictures[0][i][j] = str.charAt(j);
				
				if(str.charAt(j) == 'G')
					pictures[1][i][j] = 'R';
				else
					pictures[1][i][j] = str.charAt(j);
			}
		}
		
		for(int p = 0; p < 2; p++) {
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] == false) {
						visited[i][j] = true;
						color = pictures[p][i][j];
						dfs(pictures[p], color, visited, new Point(j, i));
						counts[p]++;
					}
				}
			}
		}
		sb.append(counts[0]).append(" ").append(counts[1]).append("\n");
		System.out.println(sb);
	}
	
	private static void dfs(char[][] picture, char color, boolean[][] visited, Point p) {
		int x = 0, y = 0;
		
		for(int d = 0; d < dx.length; d++) {
			x = p.x + dx[d];
			y = p.y + dy[d];
			
			if(x >= 0 && x < picture.length && y >= 0 && y < picture.length && visited[y][x] == false) {
				if(picture[y][x] == color) {
					visited[y][x] = true;
					dfs(picture, color, visited, new Point(x, y));
				}
			}
		}
	}
}
