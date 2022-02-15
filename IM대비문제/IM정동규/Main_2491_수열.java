package com.ssafy.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2491_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0;
		int[] arr;
		int[][] res;
		
		N = Integer.parseInt(br.readLine());
		// 입력 받은 각 위치의 값을 저장하는 배열
		arr = new int[N];
		// 현재 위치를 포함하는 왼쪽(res[0]) 또는 오른쪽(res[1])에서 시작된 연속된 수열의 길이를 저장하는 배열
		res = new int[2][N];
		res[0][0] = 1;
		res[1][res[1].length - 1] = 1;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		// 왼쪽에서 오른쪽 끝으로 가면서 반복을 수행
		for(int i = 1; i < arr.length; i++) {
			// 현재 위치에서 왼쪽에 저장된 arr값을 확인
			// 현재 arr값이 왼쪽 arr 값보다 크거나 같다면 수열이 이어지므로 이전 res 값에 +1을 한 값을 저장
			if(arr[i - 1] <= arr[i])
				res[0][i] = res[0][i - 1] + 1;
			// 그렇지 않다면 본인만 포함되는 수열의 길이인 1을 저장
			else
				res[0][i] = 1;
		}
		// 거꾸로 오른쪽 끝에서 왼쪽으로 위와 같은 동작을 수행
		for(int i = arr.length - 2; i >= 0; i--) {
			if(arr[i + 1] <= arr[i])
				res[1][i] = res[1][i + 1] + 1;
			else
				res[1][i] = 1;
		}
		
		// 최대값을 쉽게 찾기 위해 정렬
		Arrays.sort(res[0]);
		Arrays.sort(res[1]);
		
		// 최대값 출력
		if(res[0][res[0].length - 1] > res[1][res[1].length - 1])
			System.out.println(res[0][res[0].length - 1]);
		else
			System.out.println(res[1][res[1].length - 1]);
	}
}
