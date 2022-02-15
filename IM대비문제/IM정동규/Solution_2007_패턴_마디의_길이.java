package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2007_패턴_마디의_길이 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// ipat: pattern을 읽을 때 사용하는 index, iword: word를 읽을 때 사용하는 index
		int T = 0, ipat = 0, iword = 0;
		// pattern: 입력 받은 문자열, word: 반복되는 마디
		String pattern = "", word = "";
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			pattern = br.readLine();
			ipat = 0;
			word = "";
			
			// 우선 마디는 pattern의 첫번째 글자라고 가정한 뒤 시작
			word += pattern.charAt(0);
			while(ipat < pattern.length()) {
				iword = 0;
				// pattern과 word의 현재 글자가 일치하면 마디가 되는지 판단하기 위해 반복 시작
				if(pattern.charAt(ipat) == word.charAt(iword)) {
					while(iword < word.length() && ipat < pattern.length()){
						// 도중에 글자가 다르다고 판단 될 경우 pattern의 처음 글자부터 다르다고 판단된 글자까지 복사하여 마디라고 가정
						if(pattern.charAt(ipat++) != word.charAt(iword++)) {
							word = pattern.substring(0, ipat);
							break;
						}
					}
				// 다른 글자가 나올 경우 pattern의 처음 글자부터 현재 글자까지 복사하여 마디라고 가정
				}else {
					word = pattern.substring(0, ipat++ + 1);
				}
			}
			sb.append(word.length() + "\n");
		}
		System.out.println(sb);
	}
}
