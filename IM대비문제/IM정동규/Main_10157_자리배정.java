package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 우선 이동 규칙을 찾아보면 다음과 같음
		/*	1번째 이동		2번쨰 이동		3번쨰 이동		4번째 이동		5번째 이동	...
		방향      +y		  +x		  -y		  -x		  +y	...
		
		이동량     R		 C - 1		 R - 1		 C - 2		 R - 2	...
		 */
		// 위 내용을 바탕으로 아래의 내용들을 설정
		// dx(x방향 부호), dy(y방향 부호), dir(이동 방향),
		// rc(R인지 C인지 결정), gap(R 또는 C에서 뺄 상수),
		// sub(위의 정보를 통합하여 최종적으로 이동하는 이동량)
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		int[] rc;
		
		int C = 0, R = 0, K = 0, sub = 0, gap = 0, dir = 0, x = 1, y = 0;
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		rc = new int[]{C, R};
		sub = rc[1];
		
		// 전체 좌석의 수보다 구하려는 좌석 번호가 크다면 0 출력
		if(R * C < K) {
			sb.append(0);
		// 그 외에는 위에서 구한 규칙에 따라 이동
		}else {
			while(K - sub > 0) {
				K -= sub;
				x += dx[dir] * sub;
				y += dy[dir] * sub;
				
				if(dir % 2 == 0)
					gap++;
				sub = rc[dir % 2] - gap;
				
				dir++;
				if(dir == 4)
					dir = 0;
			}
			// 반복을 돌고 남은 K만큼 이동
			x += dx[dir] * K;
			y += dy[dir] * K;
			// 출력
			sb.append(x + " " + y);
		}
		System.out.println(sb);
	}
}
