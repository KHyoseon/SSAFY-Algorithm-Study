package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Algo2_구미_5반_정동규 {
	public static void main(String[] args) throws IOException {
		// 출력을 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 입력을 위한 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받은 문자열을 나누기 위한 StringTokenizer
		StringTokenizer st;
		
		// 테스트 케이스의 수를 의미하는 T와 문제의 입력 부분에 주어진 N, S, M
		int T = 0, N = 0, S = 0, M = 0;
		// 동아리원 3명의 점수 합을 저장하기 위한 변수
		int sum = 0;
		// 클럽 가입 조건을 통과했는지 여부를 판단하는 변수
		boolean pass = true;
		// 각 동아리원의 점수를 저장하기 위한 배열
		int[] X;
		// 최종적으로 클럽에 가입한 동아리를 저장하는 리스트
		List<int[]> res = new ArrayList<>();
		
		// "시간: 30개의 테스트케이스를 합쳐서 20초"라고 했기 때문에 테스트케이스는 30개로 설정
		T = 30;
		// 테스트케이스 수 만큼 반복
		for(int t = 1; t <= T; t++) {
			// 각 테스트 케이스의 결과 앞에 출력되는 "#t "를 StringBuilder에 넣음
			sb.append("#" + t + " ");
			
			// N, S, M의 구분을 위해 입력 받은 줄을 " "을 기준으로 나눔
			st = new StringTokenizer(br.readLine(), " ");
			
			// 나눠진 문자열의 각 부분을 N, S, M에 할당
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 이전 테스트케이스의 결과가 남아있을 수 있기 때문에 res를 초기화
			res.clear();
			
			// 신청한 동아리의 수 만큼 반복
			for(int i = 0; i < N; i++) {
				// 각 동아리원의 점수 구분을 위해 입력 받은 줄을 " "을 기준으로 나눔
				st = new StringTokenizer(br.readLine(), " ");
				
				// 동아리원들의 점수를 저장할 배열을 생성, 동아리원이 3명이므로 공간을 3으로 설정
				X = new int[3];
				// 클럽 가입 조건은 만족했음을 가정하고 이후 불만족인 경우 값을 변경하는 방법을 사용
				pass = true;
				// 이전 동아리에 대한 계산 결과가 남아있을 수 있으므로 sum을 0으로 초기화
				sum = 0;
				
				// 동아리원의 수 만큼 반복
				for(int j = 0; j < X.length; j++) {
					// 앞서 나눴던 문자열에서 각 동아리원의 점수 정보를 얻어와서 저장
					X[j] = Integer.parseInt(st.nextToken());
					// 각 동아리원의 점수를 합산 점수에 더함
					sum += X[j];
					// 만약 각 동아리원의 점수가 기준을 넘지 못했다면 통과 여부를 false로 변경
					if(X[j] < M)
						pass = false;
				}
				// 만약 동아리원들의 합산 점수가 기준을 넘지 못했다면 통과 여부를 false로 변경
				if(sum < S)
					pass = false;
				
				// 통과 여부에 따라 최종 결과에 추가하거나 다음 반복 진행
				if(pass)
					res.add(X);
			}
			// 스마트클럽에 가입 가능한 동아리의 수를 StringBuilder에 추가
			sb.append(res.size() + "\n");
			// res에 저장된 동아리 수 만킄 반복
			for(int i = 0; i < res.size(); i++) {
				// 각 동아리원의 수 만큼 반복
				for(int j = 0; j < res.get(i).length; j++)
					// 각 동아리원의 점수를 StringBuilder에 공백을 포함하여 저장
					sb.append(res.get(i)[j] + " ");
			}
			// 각 테스트케이스의 결과의 마지막에 남는 공백을 제거하기 위해 StringBuilder의 크기를 조정
			sb.setLength(sb.length());
			// 각 테스트케이스의 결과를 세로로 출력하기 위해 개행을 추가
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
