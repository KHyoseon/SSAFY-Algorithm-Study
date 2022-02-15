

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10157	자리배정
public class Q09_IMBJ_10157_자리배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int trigger = 1;		//1일때 row 아래로, 2일때 col 오른쪽으로, 3일때 row 위로, 4일때 col 왼쪽으로
		int rpos = 0;
		int cpos = 0;
		int[][] arr = new int[r][c];
		
		for(int cnt=1;cnt<=r*c;cnt++) {
			arr[rpos][cpos] = cnt;
			switch(trigger) {
			case 1:
				if(rpos+1 == r || arr[rpos+1][cpos] != 0) {
					trigger = 2;
					cpos = cpos+1;
				}else {
					rpos = rpos+1;
				}
				break;
			case 2:
				if(cpos+1 == c || arr[rpos][cpos+1] != 0) {
					trigger = 3;
					rpos = rpos-1;
				}else {
					cpos = cpos+1;
				}
				break;
			case 3:
				if(rpos-1 <0 || arr[rpos-1][cpos] != 0) {
					trigger = 4;
					cpos = cpos-1;
				}else {
					rpos = rpos-1;
				}
				break;
			case 4:
				if(arr[rpos][cpos-1] != 0) {
					trigger = 1;
					rpos = rpos+1;
				}else {
					cpos=cpos-1;
				}
				break;
			}
		}
		trigger = 0;
		int searchIdx = Integer.parseInt(br.readLine());
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j] == searchIdx) {
					System.out.print((j+1)+" "+(i+1));
					trigger = 1;
				}
			}
		}
		if(trigger == 0)
			System.out.println("0");
		
	}
}
