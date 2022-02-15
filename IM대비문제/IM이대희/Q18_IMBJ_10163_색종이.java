

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10163 색종이
public class Q18_IMBJ_10163_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int[N][4];
		
		int[][] board = new int[1001][1001];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			for(int j=arr[i][0];j<arr[i][0]+arr[i][2];j++) {
				for(int k=arr[i][1];k<arr[i][1]+arr[i][3];k++)
					board[j][k] = i+1;
			}
		}
		for(int i=0;i<N;i++) {
			int cnt = 0;
			for(int j=arr[i][0];j<arr[i][0]+arr[i][2];j++) {
				for(int k=arr[i][1];k<arr[i][1]+arr[i][3];k++) {
					if(board[j][k] == i+1)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
		
	}
}
