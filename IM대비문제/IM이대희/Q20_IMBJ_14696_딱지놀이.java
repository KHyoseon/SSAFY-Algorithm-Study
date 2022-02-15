

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14696 딱지
public class Q20_IMBJ_14696_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			String result = "D";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len1 = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[5];
			for(int j=0;j<len1;j++) 
				arr1[Integer.parseInt(st.nextToken())]++;
			st = new StringTokenizer(br.readLine());
			int len2 = Integer.parseInt(st.nextToken());
			int[] arr2 = new int[5];
			for(int j=0;j<len2;j++) 
				arr2[Integer.parseInt(st.nextToken())]++;
			for(int j=4;j>0;j--) {
				if(arr1[j] == arr2[j])
					continue;
				else {
					result = arr1[j]>arr2[j]?"A":"B";
					break;
				}
			}
			System.out.println(result);
		}
	}
}
