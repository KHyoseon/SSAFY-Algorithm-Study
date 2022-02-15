package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 주사위의 정보를 저장할 클래스
class Dice{
	// nums: 주사위의 눈이 저장된 리스트
	// nti(num to index): 눈의 숫자를 통해 리스트의 인덱스를 얻기 위한 map
	List<Integer> nums;
	Map<Integer, Integer> nti;
	
	public Dice() {
		
	}
	public Dice(List<Integer> nums, Map<Integer, Integer> nti) {
		this.nums = nums;
		this.nti = nti;
	}
}
public class Main_2116_주사위_쌓기 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, sum = 0, max = 0, num = 0, nup = 0, ndown = 0, iup = 0, idown = 0, delta = 6;
		Dice dice;
		List<Integer> nums;
		Map<Integer, Integer> nti;
		// 각 면과 마주보는 면을 구하기 위한 map
		Map<Integer, Integer> pair = new HashMap<Integer, Integer>() {{
			put(0, 5);
			put(1, 3);
			put(2, 4);
			put(3, 1);
			put(4, 2);
			put(5, 0);
		}};
		// 주사위 객체를 저장할 리스트
		List<Dice> dices = new ArrayList<Dice>();
		
		N = Integer.parseInt(br.readLine());
		
		// 정보를 입력 받아서 주사위 객체를 만들고 리스트에 추가
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			nums = new ArrayList<Integer>(6);
			nti = new HashMap<Integer, Integer>();
			for(int j = 0; j < 6; j++) {
				num = Integer.parseInt(st.nextToken());
				nums.add(num);
				nti.put(num, j);
			}
			dice = new Dice(nums, nti);
			dices.add(dice);
		}
		
		// 1번 주사위의 각 면에 대해서 모두 수행
		// ndown: 아랫면의 수, idown: 아랫면의 인덱스, nup: 윗면의 수, iup: 윗면의 인덱스
		for(int i = 0; i < 6; i++) {
			nup = dices.get(0).nums.get(i);
			for(int j = 0; j < dices.size(); j++) {
				// 이전 주사위의 윗면과 현재 주사위의 아랫면이 같은 수
				ndown = nup;
				// 현재 주사위의 아랫면의 인덱스를 아랫면 수를 통해 구함
				idown = dices.get(j).nti.get(ndown);
				// 아랫면 인덱스를 통해 윗면의 인덱스를 구함
				iup = pair.get(idown);
				// 윗면의 인덱스를 통해 윗면의 수를 구함
				nup = dices.get(j).nums.get(iup);
				// 최대값을 찾아야하기 때문에 변화량 delta는 항상 6을 기본으로 설정
				// 단, ndown이나 nup에 6이 있을 경우 6을 사용할 수 없기 때문에 5로 변경
				// 5도 6과 같음. 5를 사용 불가능할 경우 delta를 4로 변경
				if(ndown == 6 || nup == 6) {
					delta = 5;
					if(ndown == 5 || nup == 5) {
						delta = 4;
					}
				}
				// 변화량을 sum에 합산
				sum += delta;
				delta = 6;
			}
			// 이번 경우의 최종 합산값이 전체 결과의 최대값보다 크다면 갱신
			if(max < sum)
				max = sum;
			sum = 0;
		}
		
		System.out.println(max);
	}
}
