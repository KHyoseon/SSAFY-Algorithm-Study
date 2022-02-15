/**
 * 백준 1244. 스위치 켜고 끄기
 * 
 * 220204
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1244 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 스위치 개수
		int N = Integer.parseInt(br.readLine());
		// 스위치(인덱스==번호)
		int[] nx = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nx[i] = Integer.parseInt(st.nextToken());
		}

		// 학생수
		int stuNum = Integer.parseInt(br.readLine());
		
		// 학생 성별, 받은 스위치 번호 읽어서 스위치 켜고 끄기
		for (int i = 0; i < stuNum; i++) {
			st = new StringTokenizer(br.readLine());
			//성별, 스위치 번호
			int gender=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			
			// 남자면 받은 스위치 번호 배수 번호 상태 전환
			if (gender==1) {
				for(int j=num;j<=N;j+=num) {
					if(nx[j]==0)
						nx[j]=1;
					else
						nx[j]=0;
				}
			}
			// 여자면 받은 스위치 번호 중심으로 대칭되는 범위 상태 전환
			else if(gender==2) {
				int count=1;
				while(true) {
					//좌우 스위치 번호
					int l=num-count;
					int r=num+count;
					//한칸 나갔을 때 범위 벗어나면 while문 나가기
					if(l<1 || r<1 || l>N || r>N) {
						break;
					}
					//좌우 대칭 아니게 되면 while문 나가기
					if(nx[l]!=nx[r])
						break;
					count++;
				}
				//좌우 대칭인 범위 스위치 상태 전환
				count--;
				for(int j=num-count;j<=num+count;j++) {
					if(nx[j]==0)
						nx[j]=1;
					else
						nx[j]=0;
				}
			}
		}
		
		//출력
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(nx[i]);
			if(i%20==0)
				sb.append("\n");
			else
				sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
