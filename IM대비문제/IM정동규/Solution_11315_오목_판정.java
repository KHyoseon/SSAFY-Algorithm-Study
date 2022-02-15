package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11315_오목_판정 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// →, ↘, ↓, ↙ 순서대로 탐색하기 위한 dx와 dy
		int[] dx = {1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1};
		
		int T = 0, N = 0, count = 1, nx = 0, ny = 0;
		String[] board;
		// 해당 칸의 해당 방향으로 방문 여부를 저장하는 배열
		boolean[][][] visit;
		
		T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			N = Integer.parseInt(br.readLine());
			board = new String[N];
			visit = new boolean[N][N][4];
			
			for(int i = 0; i < N; i++)
				board[i] = br.readLine();
			// 돌이 놓여진 판을 순서대로 탐색
			search: for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[i].length(); j++){
					// 돌이 놓여진 칸일 경우 방문 여부를 저장하고 위에서 만든 방향을 따라 탐색하면서 오목 판정
					if(board[i].charAt(j) == 'o') {
						for(int d = 0; d < dx.length; d++) {
							visit[i][j][d] = true;
							nx = j;
							ny = i;
							// 연속으로 이어진 돌이 5개 이상이 되면 반복 종료
							while(count < 5) {
								nx += dx[d];
								ny +=  dy[d];
								if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
									// 아직 방문한 적 없는 칸일 경우 방문
									if(visit[ny][nx][d] == false) {
										visit[ny][nx][d] = true;
										if(board[ny].charAt(nx) == 'o')
											count++;
										else
											break;
									}else
										break;
								}else {
									break;
								}
							}
							// 연속된 돌이 5개 이상인 경우 테스트 케이스 종료
							if(count >= 5)
								break search;
							// 아닌 경우 다음 탐색 시작
							count = 1;
						}
					}
				}
			}
			if(count >= 5)
				sb.append("YES\n");
			else
				sb.append("NO\n");
			count = 1;
		}
		System.out.println(sb);
	}
}
