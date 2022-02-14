import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_구미_5반_이명범 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		// 신청한 동아리의 수
		int N = Integer.parseInt(st.nextToken());
		// 팀원 3명의 능력합 조건
		int S = Integer.parseInt(st.nextToken());
		// 개인 능력치 조건
		int M = Integer.parseInt(st.nextToken());
		
		// 테스트케이스 총 30개
		for(int tc = 0; tc < 30; tc++) {
			// 통과한 동아리의 수
			int pass = 0;
			// 동아리의 수만큼 반복문
			club:
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				// 학생
				int[] stu = new int[3];
				
				// 현재 동아리의 능력합
				int tot = 0;

				for (int j = 0; j < 3; j++) {
					// 현재 학생의 능력
					stu[j] = Integer.parseInt(st.nextToken());
					
					// 현재 학생의 능력치가 M보다 작으면 클럽 가입 불가
					if(stu[j] < M) continue club;
					
					// 아니라면 동아리 능력합에 현재 학생 능력을 합해준다.
					tot += stu[j];
				}
				
				// 만약 3명의 능력합이 S보다 크다면
				if (tot >= S) {
					pass++;
					for (int j = 0; j < 3; j++) {
						sb.append(stu[j]).append(" ");
					}
				}
			}
			System.out.println(pass);
			System.out.println(sb);
		}
	}
}
