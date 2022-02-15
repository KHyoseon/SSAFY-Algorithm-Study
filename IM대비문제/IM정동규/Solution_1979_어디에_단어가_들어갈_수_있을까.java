package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1979_어디에_단어가_들어갈_수_있을까 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// →, ↓ 방향에 대한 탐색
		int[] dx = {1, 0};
		int[] dy = {0, 1};
		
		int T = 0, N = 0, K = 0, num = 0, x = 0, y = 0, count = 1, res = 0;
		// 해당 위치에서 해당 방향으로의 탐색 여부를 저장하는 배열
		boolean[][][] visit;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			visit = new boolean[N][N][2];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					num = Integer.parseInt(st.nextToken());
					if(num == 0) {
						visit[i][j][0] = true;
						visit[i][j][1] = true;
					}
				}
			}
			
			res = 0;
			for(int i = 0; i < visit.length; i++) {
				for(int j = 0; j < visit[i].length; j++) {
					for(int d = 0; d < dx.length; d++) {
						x = j;
						y = i;
						count = 1;
						// 탐색한 적 없는 방향의 칸일 경우 탐색 시작
						if(visit[i][j][d] == false) {
							visit[i][j][d] = true;
							x += dx[d];
							y += dy[d];
							while(x >= 0 && x < N && y >= 0 && y < N) {
								// 다음 칸이 탐색한 적 있는 칸일 경우 탐색 종료
								if(visit[y][x][d] == true)
									break;
								// 탐색한 적 없을 경우 탐색 표시와 연속된 칸의 개수를 세면서 진행
								visit[y][x][d] = true;
								count++;
								x += dx[d];
								y += dy[d];
							}
							// 탐색이 종료된 뒤 연속된 칸의 수가 정확히 K개일 경우 결과값 +1
							if(count == K)
								res++;
						}
					}
				}
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
}
