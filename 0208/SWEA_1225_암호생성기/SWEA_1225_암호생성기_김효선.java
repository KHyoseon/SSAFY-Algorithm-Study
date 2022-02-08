package ws0208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1225. 암호 생성기

public class Solution1225 {
	/*
		1
		10 6 12 8 9 4 1 3
	
		#1 3 9 4 9 4 4 3 0
	*/
	// static String str = "1\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"2\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"3\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"4\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"5\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"6\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"7\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"8\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"9\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647\r\n" + 
	// 		"10\r\n" + 
	// 		"2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647 2147483647";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new StringReader(str));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++){
			int tc = Integer.parseInt(br.readLine());
			sb.append("#"+tc+" ");
			
			st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();
			
			int MIN = Integer.MAX_VALUE;
			int inputs[] = new int[8];
			for(int i=0; i<8; i++) {
				inputs[i] = Integer.parseInt(st.nextToken());
				MIN = Math.min(MIN, inputs[i]);
			}
			
			int div = MIN/15;
			
			for(int j=0; j<8; j++) {
				inputs[j] -= (div-1)*15;
				q.offer(inputs[j]);
			}
			
			int tmp, i=0;
			while(true) {
				tmp = q.poll()-((i%5)+1);
				if(tmp<=0) {
					q.offer(0);
					break;
				}
				q.offer(tmp);
				i++;
			}
			
			for (Integer integer : q) {
				sb.append(integer+" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
