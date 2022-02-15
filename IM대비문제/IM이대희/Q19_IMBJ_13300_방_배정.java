

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13300	방 배정
public class Q19_IMBJ_13300_방_배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[][] arr = new int[6][2];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			arr[grade-1][gender]++;
		}
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++) {
				cnt += arr[i][j]/max;
				if(arr[i][j] % max != 0)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
