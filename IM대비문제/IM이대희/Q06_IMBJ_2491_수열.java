

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2491	수열
public class Q06_IMBJ_2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int[] arr= new int[N];
		for(int i=0;i<N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			int cnt = 1;
			int trigger = 0;								//커지기 시작하면 1, 작아지기 시작하면 -1, 초기 상태 0
			for(int j=i+1;j<N;j++) {
				if(arr[j] == arr[j-1])
					cnt++;
				else if(arr[j] > arr[j-1]) {
					if(trigger == 1)
						cnt++;
					else if(trigger == 0) {
						trigger = 1;
						cnt++;
					}
					else {
						if(cnt > result)
							result = cnt;
						break;
					}
				}
				else {
					if(trigger == -1)
						cnt++;
					else if(trigger == 0) {
						trigger = -1;
						cnt++;
					}
					else {
						if(cnt>result)
							result = cnt;
						break;
					}
				}
			}
			if(cnt>result)
				result = cnt;
		}

		System.out.println(result);
	}
}
