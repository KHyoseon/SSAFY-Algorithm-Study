

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2559 수열
public class Q17_IMBJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = -99999;
		
		int N = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<=N-cnt;i++) {
			int temp = 0;
			for(int j=i;j<i+cnt;j++) {
				temp += arr[j];
			}
			if(max < temp)
				max = temp;
		}
		System.out.println(max);
	}
}
