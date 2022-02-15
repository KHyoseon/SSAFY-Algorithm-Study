package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사각형 정보 저장을 위한 클래스
class Rec{
	int x;
	int y;
	int p;
	int q;
	
	public Rec() {
		
	}
	
	public Rec(Rec rec) {
		this.x = rec.x;
		this.y = rec.y;
		this.p = rec.p;
		this.q = rec.q;
	}
}

public class Main_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 4;
		char res = ' ';
		Rec temp;
		// 사각형 2개의 정보를 저장하는 배열
		Rec[] recs;
		
		for(int t = 0; t < T; t++) {
			recs = new Rec[2];
			
			// 사각형 정보를 입력 받아서 저장
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) {
				temp = new Rec();
				temp.x = Integer.parseInt(st.nextToken());
				temp.y = Integer.parseInt(st.nextToken());
				temp.p = Integer.parseInt(st.nextToken());
				temp.q = Integer.parseInt(st.nextToken());
				recs[i] = temp;
			}
			
			// 조건을 덜 나누기 위해 좌표 값을 기준으로 0번 사각형과 1번 사각형을 설정
			if(recs[0].x > recs[1].x) {
				temp = new Rec(recs[0]);
				recs[0] = recs[1];
				recs[1] = temp;
			}else if(recs[0].x == recs[1].x) {
				if(recs[0].q > recs[1].q) {
					temp = new Rec(recs[0]);
					recs[0] = recs[1];
					recs[1] = temp;			
				}
			}
			
			// 결과를 구하기 위한 조건 분기들, 텍스트로만 보면 이해하기 어렵기 때문에 주어진 조건에 맞게 그림을 그려보면 이해하는데 도움이 됨
			// 꼭지점끼리 만나는 경우에 대한 조건들
			if((recs[0].p == recs[1].x && recs[0].q == recs[1].y) || (recs[0].p == recs[1].x && recs[0].y == recs[1].q)) {
				res = 'c';
			// 변끼리 만나는 경우에 대한 조건들
			}else if(
					(recs[0].y == recs[1].q && recs[0].x <= recs[1].x && recs[0].p > recs[1].x) || 
					(recs[0].p == recs[1].x && recs[0].y < recs[1].q && recs[0].q > recs[1].y) || 
					(recs[0].q == recs[1].y && recs[0].x <= recs[1].x && recs[0].p > recs[1].x)
					) {
				res = 'b';
			// 만나지 않는 경우에 대한 조건들
			}else if(recs[0].q < recs[1].y || recs[0].p < recs[1].x || recs[0].y > recs[1].q) {
				res = 'd';
			// 그 외에는 전부 사각형 모양으로 겹치는 경우
			}else {
				res = 'a';
			}
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
}
