package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// BOJ 2578 - 빙고
public class Main_2578_빙고 {
	// 가로, 세로, / 대각선, \ 대각선 순서로 방향 설정
	// 사회자가 부른 수 기준으로 이동하기 때문에 각 방향을 2개로 분햘 ex)가로: 왼쪽(-1), 오른쪽(1)
	static int[][] dx = {{-1, 1}, {0, 0}, {-1, 1}, {-1, 1}};
	static int[][] dy = {{0, 0}, {-1, 1}, {-1, 1}, {1, -1}};
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int res = 0, bingo = 0, curx = 0, cury = 0, nextx = 0, nexty = 0, count = 1;
		int[] cur;
		boolean end = false;
		boolean[][] board = new boolean[5][5];
		// 사회자가 부른 수를 통해 그 수의 좌표를 알아내기 위한 map
		Map<Integer, int[]> point = new HashMap<Integer, int[]>();
		
		// 입력을 받아서 빙고판 생성
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				point.put(Integer.parseInt(st.nextToken()), new int[] {i, j});
		}
		
		// 사회자가 부르는 수를 차례로 받음
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				cur = point.get(Integer.parseInt(st.nextToken()));
				// 사회자가 부른 수의 자리에 색칠
				board[cur[0]][cur[1]] = true;
				
				// 각 방향으로 탐색해서 빙고를 판정
				for(int d = 0; d < 4; d++) {
					// 색칠한 칸이 몇개까지 이어지는지 저장하기 위한 변수
					count = 1;
					for(int m = 0; m < 2; m++) {
						curx = cur[1];
						cury = cur[0];
						nextx = curx + dx[d][m];
						nexty = cury + dy[d][m];
						while(nextx >= 0 && nextx < 5 && nexty >= 0 && nexty < 5) {
							if(board[nexty][nextx]) {
								count++;
								curx = nextx;
								cury = nexty;
								nextx = curx + dx[d][m];
								nexty = cury + dy[d][m];
							}else {
								break;
							}
						}
					}
					// 색칠한 칸 5개가 줄을 만들면 빙고 +1
					if(count == 5)
						bingo++;
					// 빙고가 3개면 종료(end = true)
					if(bingo == 3) {
						res = i * 5 + j + 1;
						end = true;
						break;
					}
				}
				if(end)
					break;
			}
			if(end)
				break;
		}
		
		System.out.println(res);
	}
}
