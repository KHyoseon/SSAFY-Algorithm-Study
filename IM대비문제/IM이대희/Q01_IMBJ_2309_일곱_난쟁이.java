

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2309 일곱 난쟁이
public class Q01_IMBJ_2309_일곱_난쟁이 {
	static int total, arr[], numbers[], resultarr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[7];
		arr = new int[9];
		for(int i=0;i<9;i++)
			arr[i] = Integer.parseInt(br.readLine());
		find(0,0);
		Arrays.sort(resultarr);
		for(int i=0;i<7;i++) {
			System.out.println(resultarr[i]);
		}
	}
	
	public static void find(int cnt, int start) {
		if(cnt==7) {
			int result = 0;
			for(int i=0;i<numbers.length;i++) {
				result += numbers[i];
			}
			if(result == 100) {
				resultarr = new int[7];
				for(int i=0;i<7;i++) {
					resultarr[i] = numbers[i];
				}
			}
			return;
		}
		for(int i=start;i<9;i++) {
			numbers[cnt] = arr[i];
			find(cnt+1, i+1);
		}
	}
}
