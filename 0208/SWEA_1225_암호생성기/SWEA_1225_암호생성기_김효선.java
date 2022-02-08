package ws0208;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> q;
		String input;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<10; t++){
			input = br.readLine();
			int tc = Integer.parseInt(input);
			sb.append("#"+tc+" ");
			
			st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();
			for(int i=0; i<8; i++)
				q.offer(Integer.parseInt(st.nextToken()));
			
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
