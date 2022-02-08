package hw0207;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 2493. 탑

public class Main2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int tower[] = new int[N];
		int receive[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			tower[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<N; i++) {
			while(!stack.empty()&&tower[stack.peek()]<tower[i]) {
				stack.pop();
			}
			if(!stack.empty())	receive[i] = stack.peek()+1;
			stack.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(receive[i]+" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}
