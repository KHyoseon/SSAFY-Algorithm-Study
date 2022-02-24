package com.ssafy.w0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		if(this.y == o.y)
			return this.x - o.x;
		else
			return this.y - o.y;
	}
}

public class BOJ_16236_아기_상어 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		int N = 0, size = 2, x = 0, y = 0, minTime = 0, time = 0, nx = 0, ny = 0, res = 0, ate = 0;
		Point front;
		int[][] map;
		boolean[][] visited;
		Queue<Point> temp, que;
		PriorityQueue<Point> pq;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = j;
					y = i;
				}
			}
		}
		
		while(true) {
			time = 1;
			minTime = 0;
			visited = new boolean[N][N];
			pq = new PriorityQueue<>();
			que = new LinkedList<>();		
			que.offer(new Point(x, y));
			visited[y][x] = true;
			
			while(minTime == 0 && que.size() != 0) {
				temp = new LinkedList<>();
				while(!que.isEmpty()) {
					front = que.poll();
					
					for(int d = 0; d < dx.length; d++) {
						nx = front.x + dx[d];
						ny = front.y + dy[d];
						
						if(nx >= 0 && nx < N && ny >= 0 && ny < N && visited[ny][nx] == false) {
							visited[ny][nx] = true;
							if(map[ny][nx] == size || map[ny][nx] == 0) {
								temp.offer(new Point(nx, ny));
							}else if(map[ny][nx] < size) {
								minTime = time;
								pq.offer(new Point(nx, ny));
							}
						}
					}
				}
				que = temp;
				time++;
			}
			if(pq.size() == 0) {
				break;
			}else {
				map[y][x] = 0;
				front = pq.poll();
				x = front.x;
				y = front.y;
				res += minTime;
				map[y][x] = 9;
				ate++;
				if(ate == size) {
					size++;
					ate = 0;
				}
			}
		}
		sb.append(res);
		System.out.println(res);
	}
}
