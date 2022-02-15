

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2605 줄 세우기
public class Q02_IMBJ2605_줄_세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<Integer> list = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			list.add(temp, i);
		}
		for(int i = list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
		
	}
}
