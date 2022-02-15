package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// Day 클래스의 정렬을 위한 비교자
class Comp implements Comparator<Day>{

	@Override
	public int compare(Day o1, Day o2) {
		// 가격이에 따라 내림차순
		if(o1.price > o2.price) {
			return -1;
		}else if(o1.price < o2.price) {
			return 1;
		// 가격이 같을 경우 날짜에 따라 내림차순
		}else {
			if(o1.date > o2.date)
				return -1;
			else
				return 1;
		}
	}
	
}
// 각 날의 정보를 저장하는 클래스
// date: 당일 날짜, price 그 날의 가격
class Day{
	int date;
	long price;
	
	public Day() {
		
	}
	public Day(int date, int price) {
		this.date = date;
		this.price = price;
	}
}
public class Solution_1859_백만_장자_프로젝트 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// index: 정렬된 배열을 읽기 위한 index, date: 원래의 배열을 읽기 위한 index
		int T = 0, N = 0, index = 0, date = 0;
		long res = 0, sum = 0;
		// dayaS: 원래의 Day 정보를 위의 정렬자로 정렬한 결과, daysO: 입력으로 받았던 원래의 Day 정보
		Day[] daysS, daysO;
		Comp comp = new Comp();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			sum = 0;
			index = 0;
			date = 0;
			
			N = Integer.parseInt(br.readLine());
			daysO = new Day[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				daysO[i] = new Day(i, Integer.parseInt(st.nextToken()));
			
			daysS = Arrays.copyOf(daysO, daysO.length);
			Arrays.sort(daysS, comp);
			
			// 정렬된 배열과 원래의 배열 모두 유효 범위 안에 있을 경우 반복
			while(index < daysS.length && date < daysO.length) {
				// index를 통해 정렬된 배열을 읽다가 현재 date보다 오른쪽에 있는 경우
				if(date < daysS[index].date) {
					// 현재 날짜부터 오른쪽으로 이동하면서 가격 비교
					for(int i = date; i < daysS[index].date; i++) {
						// 이윤이 발생할 경우 결과에 더함
						res = daysS[index].price - daysO[i].price;
						if(res > 0)
							sum += res;
					}
					// 다음 date는 방금 목표로 사용했던 date의  + 1로 설정
					date = daysS[index].date + 1;
				}
				// 다음 index로 넘어감
				index++;
			}
			
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}
