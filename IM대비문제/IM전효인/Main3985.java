/**
 * 백준 3985. 롤 케이크
 * 
 * 220211
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3985 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//롤 케이크 길이
		int L=Integer.parseInt(br.readLine());
		//방청객 수
		int N=Integer.parseInt(br.readLine());
		
		//케이크 상태: 해당 칸 받은 사람 번호 저장
		int[] cake=new int[L+1];
		//방청객이 원하는 케이크 길이
		int[] len=new int[N+1];
		//실제로 받은 케이크 길이
		int[] count=new int[N+1];
		
		//원하는 최대 길이, 실제 최대 길이
		int maxLen=0;
		int maxCount=0;
		//원하는 길이가, 받은 길이가 가장 긴 방청객 번호
		int maxLenNum=0;
		int maxCountNum=0;
		
		for(int n=1;n<=N;n++) {
			st=new StringTokenizer(br.readLine());
			//방청객이 적어낸 케이크 시작, 끝 번호 입력받기
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			//방청객이 원하는 케이크 길이
			len[n]=end-start+1;
			if(len[n]>maxLen) {
				maxLen=len[n];
				maxLenNum=n;
			}
			//실제로 받은 케이크 길이
			for(int i=start;i<=end;i++) {
				//케이크 아직 남은 칸이면 내가 받고 받은 개수 추가
				if(cake[i]==0) {
					cake[i]=n;
					count[n]++;
					if(count[n]>maxCount) {
						maxCount=count[n];
						maxCountNum=n;
					}
				}
			}
		}
		
		//결과 출력
		System.out.println(maxLenNum+"\n"+maxCountNum);
	}
}
