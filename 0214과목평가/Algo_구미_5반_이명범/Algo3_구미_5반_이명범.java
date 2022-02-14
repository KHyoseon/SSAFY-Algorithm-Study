import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo3_구미_5반_이명범 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 관리자 패스워드 최댓값
		int N = Integer.parseInt(br.readLine());
		// 패스워드 개수
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 해커가 사용한 패스워드
		int[] P = new int[M];
		for (int i = 0; i < M; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		// 보안성은 최댓값을 입력한다.
		int max = 0;
		
		for (int i = 0; i <= N; i++) {
			
			// 보안척도는 최솟값을 입력한다
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j < M; j++) {
				// 보안척도 구하기 (XOR을 통해 다른 부분을 1로 표시)
				int value = (i | P[j]) - (i & P[j]);
				// 2진법으로 변환 후 1의 개수 확인
				int degree = securityCount(value);
				min = Math.min(min, degree);
			}
			max = Math.max(max, min);
		}
		
		System.out.println(max);
	}
	
	// 10진법을 2진법으로 변환한 후 1의 개수를 반환하는 메서드
	static int securityCount(int num) {
		int count = 0;
		while(num / 2 > 0) {
			if(num % 2 == 1) count++;
			num /= 2;
		}
		count++;
		return count;
	}
}
