import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_5반_이명범 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트케이스의 수는 10개이다
		for (int tc = 0; tc < 10; tc++) {
			// 게임 진행 횟수
			int T = Integer.parseInt(br.readLine());
			
			// 게임 진행 횟수만큼 반복문
			for (int i = 1; i <= T; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				// 종이컵의 수
				int N = Integer.parseInt(st.nextToken());
				// 간식 위치
				int X = Integer.parseInt(st.nextToken());
				// 컵 이동 횟수
				int K = Integer.parseInt(st.nextToken());
				
				// 컵의 개수만큼 배열 생성, 이때 인덱스가 1부터 시작하기 때문에 배열의 크기를 N+1로 생성
				boolean[] cup = new boolean[N + 1];
				// 간식이 있는 컵에는 true로 설정한다.
				cup[X] = true;
				
				// 컵 이동 횟수 만큼 반복문
				for(int j = 1; j <= K; j++) {
					st = new StringTokenizer(br.readLine(), " ");
					
					// 위치를 바꾸는 컵 1
					int input1 = Integer.parseInt(st.nextToken());
					// 위치를 바꾸는 컵 2
					int input2 = Integer.parseInt(st.nextToken());
					
					// 1번과 2번의 컵을 스와핑한다.
					swap(cup, input1, input2);
				}
				
				
				for (int j = 0; j < N; j++) {
					// 간식이 있는 컵을 찾아 출력한다.
					if(cup[j]) sb.append("#").append(i).append(" ").append(j);
				}
				System.out.println(sb);
				sb.setLength(0);
			}
		}
	}
	static void swap(boolean[] cup, int input1, int input2) {
		boolean temp = cup[input1];
		cup[input1] = cup[input2];
		cup[input2] = temp;
	}
}
