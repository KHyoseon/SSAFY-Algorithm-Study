
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1225 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		//테스트케이스 개수
		int T=10;

		for(int t=0;t<T;t++) {
			//테스트케이스 번호 읽기(사용안함)
			br.readLine();
			// 8자리 숫자 받아서 큐에 넣기..전에 최대한 줄여서 넣기
			Queue<Integer> pw = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			int[] temp=new int[8];
			int min=Integer.MAX_VALUE;
			for(int i=0;i<8;i++) {
				temp[i]=Integer.parseInt(st.nextToken());
				if(temp[i]<min) {
					min=temp[i];
				}
			}
			//5 사이클 돌면 모든 수가 15씩 감소함을 고려해서 줄이기
			min/=15;
			for(int i=0;i<8;i++) {
				//15로 나눠떨어지는 수 감안하기
				pw.offer(temp[i]-(min-1)*15);
			}

			// 0보다 작아지는 숫자 생길때 까지, 사이클 돌면서 맨 앞 숫자 i만큼 감소 후 맨 뒤에 추가
			boolean isDone=false;
			while (!isDone) {
				for (int i = 1; i <= 5; i++) {
					int front = pw.poll()-i;
					if(front<=0) {
						front=0;
						isDone=true;
					}
					pw.offer(front);
					
					if(isDone) break;
				}
			}
			
			//결과 저장
			sb.append("#"+(t+1)+" ");
			while(!pw.isEmpty()){
				sb.append(pw.poll()+" ");
			}
			//마지막 수 0까지 추가
			sb.append("\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
