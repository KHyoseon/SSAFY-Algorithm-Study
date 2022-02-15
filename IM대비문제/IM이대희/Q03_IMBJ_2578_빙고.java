

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2578 빙고
public class Q03_IMBJ_2578_빙고 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] arr = new String[5][5];
		int result = 0;
		int cnt;
		StringTokenizer st;
		for(int i=0; i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) 
				arr[i][j] = st.nextToken();
		}
		
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				String temp = st.nextToken();
				for(int k=0;k<25;k++) {
					if(arr[k/5][k%5].equals(temp)) {
						arr[k/5][k%5] = "X";
						break;
					}
					
				}
				cnt = 0;
				if(i*5+j>10) {
					for(int k=0; k<5; k++) {
						if(arr[0][k].equals("X")&&arr[1][k].equals("X")&&arr[2][k].equals("X")&&arr[3][k].equals("X")&&arr[4][k].equals("X"))
							cnt++;
					}
					for(int k=0;k<5;k++) {
						if(arr[k][0].equals("X")&&arr[k][1].equals("X")&&arr[k][2].equals("X")&&arr[k][3].equals("X")&&arr[k][4].equals("X"))
							cnt++;
					}
					if(arr[0][0].equals("X")&&arr[1][1].equals("X")&&arr[2][2].equals("X")&&arr[3][3].equals("X")&&arr[4][4].equals("X"))
						cnt++;
					if(arr[0][4].equals("X")&&arr[1][3].equals("X")&&arr[2][2].equals("X")&&arr[3][1].equals("X")&&arr[4][0].equals("X"))
						cnt++;
				}
				if(cnt>=3) {
					result = i*5+j+1;
					break;
				}
			}
			if(result != 0)
				break;
		}
		
		System.out.println(result);
	}
}
