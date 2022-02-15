package algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Algo1_구미_5반_김효선 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 횟수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			/*
			 * N: 종이컵 수
			 * X: 간식이 들어있는 종이컵의 초기 위치
			 * K: 컵 위치 바꾸는 횟수
			 */
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				/*
				 * A, B: 위치를 바꿀 컵의 번호
				 */
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if(A==X) {
					// 간식컵이 들어있는 컵(X==A)과 B의 위치가 바뀌는 경우
					// 간식컵의 위치를 B로 표기한다
					X = B;
				} else if(B==X) {
					// 간식컵이 들어있는 컵(X==B)과 A의 위치가 바뀌는 경우
					// 간식컵의 위치를 A로 표기한다
					X = A;
				}
				// 그 외의 경우는 간식이 들어있지 않은 컵끼리의 교환이므로 신경쓰지 않는다.
			}
			
			sb.append(X+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
	}

}
