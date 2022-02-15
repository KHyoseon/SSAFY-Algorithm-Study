package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 0, num = 0;
		// 반복 종료를 위한 boolean 변수
		boolean end = false;
		String str = "";
		// 문양별 카드 보유 수를 저장하는 배열
		int[] count;
		// 각 카드 보유 여부를 저장하는 배열
		boolean[][] cards;
		// 각 문양과 인덱스 번호를 연결하는 map
		Map<Character, Integer> label = new HashMap<Character, Integer>() {{
			put('S', 0);
			put('D', 1);
			put('H', 2);
			put('C', 3);
		}};
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			cards = new boolean[4][13];
			count = new int[4];
			end = false;
			
			str = br.readLine();
			// 문양 + 숫자의 3자리가 반복되므로 인덱스를 3씩 증가시킴
			for(int i = 0; i < str.length(); i += 3) {
				num = Integer.parseInt(str.substring(i + 1, i + 3));
				// 문자열에서 읽은 카드를 기록
				if(cards[label.get(str.charAt(i))][num - 1] == false) {
					cards[label.get(str.charAt(i))][num - 1] = true;
					count[label.get(str.charAt(i))]++;
				// 이미 보유하고 있는 카드가 다시 읽힐 경우 ERROR 출력하고 반복 종료
				}else {
					sb.append("ERROR\n");
					end = true;
					break;
				}
			}
			if(end == true)
				continue;
			for(int i = 0; i < count.length; i++)
				sb.append(13 - count[i] + " ");
			sb.setLength(sb.length() - 1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
