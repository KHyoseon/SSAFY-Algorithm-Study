package ws0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int five = N/5;
		int three = 0;
		N %=5;
		while(five>=0) {
			if(N%3 == 0) {
				three = N/3;
				N%= 3;
				break;
			}
			five--;
			N+=5;
		}
		
		System.out.println(N==0?five+three:-1);
	}
}
