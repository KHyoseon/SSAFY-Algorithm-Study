package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 기둥의 정보를 저장할 클래스
class Pillar{
	int loc;
	int height;
	
	public Pillar() {
		
	}
	public Pillar(int loc, int height) {
		this.loc = loc;
		this.height = height;
	}
}
// 기둥 정렬을 위한 Comparator
// 높이를 기준으로 내림차순, 높이가 같으면 좌포를 기준으로 오름차순
class Comp implements Comparator<Pillar>{

	@Override
	public int compare(Pillar p1, Pillar p2) {
		if(p1.height < p2.height) {
			return 1;
		}else if(p1.height > p2.height) {
			return -1;
		}else {
			if(p1.loc < p2.loc)
				return -1;
			else
				return 1;
		}
	}
}
public class Main_2304_창고_다각형 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 가장 긴 기둥을 찾고 그 기둥을 기준으로 왼쪽과 오른쪽에 남은 기둥 중 가장 긴 기둥을 찾는 방법을 사용
		// 가장 긴 기둥이 여러 개일 경우 가장 긴 기둥 중 가장 왼쪽과 가장 오른쪽의 기둥을 기준으로 진행
		
		int N = 0, L = 0, H = 0, left = 0, right = 0, index = 0, sum = 0, height = 0;
		Pillar temp;
		Comp comp = new Comp();
		List<Pillar> list;
		
		// 기둥들의 정보를 입력 받고 위에서 만든 기둥 정렬 기준에 따라 정렬
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<Pillar>(N);
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			temp = new Pillar(L, H);
			list.add(temp);
		}
		Collections.sort(list, comp);
		
		// 가장 긴 기둥을 찾고 기둥이 1개일 때와 여러 개일 때의 경우에 따라 분기
		// index는 list 탐색을 위한 변수
		if(list.size() != 1) {
			// 가장 긴 기둥이 한 개일 경우 왼쪽 오른쪽 탐색 기준 모두 가장 긴 기둥으로 설정
			// 가장 긴 기둥의 넓이를 합산값에 더해주고 리스트의 다음 값부터 탐색하기 위해 index를 변경
			if(list.get(0) != list.get(1)) {
				left = list.get(0).loc;
				right = list.get(0).loc;
				sum += list.get(0).height;
				index = 1;
			}else {
				// 가장 긴 기둥이 여러 개일 경우 가장 긴 기둥 중 가장 왼쪽에 있는 기둥을 왼쪽 탄색 기준으로 설정
				left = list.get(0).loc;
				// list를 하나씩 이동하면서 값이 변경될 때 오른쪽 탐색 기준이 될 기둥을 설정
				for(int i = 1; i < list.size(); i++) {
					if(list.get(0).height != list.get(i).height) {
						right = list.get(i - 1).loc;
						sum += list.get(0).height * (right - left + 1);
						index = i;
						break;
					}
				}
				// 끝까지 탐색을 했지만 right가 0일 경우는 처음부터 끝까지 같은 높이의 기둥인 경우
				// 오른쪽 기준값을 설정한 뒤 합산값에 넓이를 더해주고 index를 리스트 끝으로 변경
				if(right == 0) {
					right = list.get(list.size() - 1).loc;
					sum += list.get(0).height * (right - left + 1);
					index = list.size();
				}
			}
			// 아직 리스트를 다 탐색하지 않았다면 바로 다음 기둥이 이미 탐색한 기둥을 제외한 것들 중 가장 긴 기둥일 것
			while(index < list.size()) {
				// 높이가 같은 경우 위치에 따라 오름차순 정렬이므로 가장 먼저 보는 기둥이 같은 길이 중 가장 왼쪽에 있는 기둥
				// 만약 그 기둥의 위치가 왼쪽 탐색 기준보다 더 왼쪽에 있다면 이전 기둥 다음으로 왼쪽에서 가장 긴 기둥으로 사용 가능
				if(list.get(index).loc < left) {
					sum += list.get(index).height * (left - list.get(index).loc);		
					left = list.get(index).loc;
				//오른쪽도 위와 마찬가지
				}else if(list.get(index).loc > right) {
					height = list.get(index).height;
					index++;
					// 같은 높이 중 가장 오른쪽에 있는 값을  찾는 과정
					while(index < list.size()) {
						if(height != list.get(index).height) {
							sum += height * (list.get(index - 1).loc - right);
							right = list.get(index - 1).loc;
							break;
						}
						index++;
					}
					if(index >= list.size())
						sum += height * (list.get(list.size() - 1).loc - right);
				}else {
					index++;
				}
			}
		}else {
			sum += list.get(0).height;
		}
		
		System.out.println(sum);
	}
}
