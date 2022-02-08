package com.ssafy.w0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1
10 6 12 8 9 4 1 3

#1 3 9 4 9 4 4 3 0
*/

//SWEA 1225 - [S/W 문제해결 기본] 7일차 - 암호생성기
public class Solution_1225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10, t = 0, index = 0, min = 2147483647, cur = -1, sub = 1;
		Queue<Integer> password = new LinkedList<>();
		int[] nums = new int[8];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens())
				nums[index++] = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < nums.length; j++) {
				if(min > (nums[j] - 1) / 15)
					min = (nums[j] - 1) / 15;
			}
			for(int j = 0; j < nums.length; j++)
				nums[j] -= min * 15;
			
			for(int j = 0; j < nums.length; j++)
				password.offer(nums[j]);
			
			while(cur != 0) {
				cur = password.poll();
				cur -= sub++;
				if(cur < 0)
					cur = 0;
				else if(sub > 5)
					sub = 1;
				password.offer(cur);
			}
			
			sb.append("#" + t + " ");
			while(!password.isEmpty())
				sb.append(password.poll() + " ");
			sb.deleteCharAt(sb.lastIndexOf(" "));
			System.out.println(sb);
			sb.delete(0, sb.length());
			min = 2147483647;
			index = 0;
			cur = -1;
			sub = 1;
		}	
	}
}
