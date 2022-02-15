/**
 * 2805. 농작물 수확하기
 * 
 * 220204
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2805 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();

		for (int t = 0; t < T; t++) {
			// 농장 크기 한변
			int N = Integer.parseInt(br.readLine());
			// 앞에 수확 못하는거 개수
			int blank = N / 2;
			// 수익
			int sum = 0;

			// 농작물 가치 줄별로 입력받으면서 수확 가능한 값은 더하기
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = blank; j < N-blank; j++) {
					sum += line[j]-'0';
				}
				if (i<N/2)
					blank--;
				else
					blank++;
			}
			
			//수익 결과 저장
			sb.append("#"+(t+1)+" "+sum+"\n");
		}
		
		//출력
		System.out.println(sb.toString());
	}
}
