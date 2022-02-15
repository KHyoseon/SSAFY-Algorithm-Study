package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5356_의석이의_세로로_말해요 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, max = 0;
		String[] board;
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			board = new String[5];
			max = 0;
			// 입력을 받으면서 길이가 가장 긴 단어의 길이를 저장
			// -> 글자를 세로로 탐색할 때 끝을 알기 위함
			for(int i = 0; i < board.length; i++) {
				board[i] = br.readLine();
				if(max < board[i].length())
					max = board[i].length();
			}
			// 각 단어를 앞에서부터 한 글자씩 읽으면서 진행
			for(int i = 0; i < max; i++) {
				for(int j = 0; j < board.length; j++) {
					// 현재 위치를 읽을 수 있는지를 단어의 길이로 판단
					if(board[j].length() > i)
						sb.append(board[j].charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
