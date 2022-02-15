/**
 * 백준 2559. 수열
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//전체 날짜 수
		int N=Integer.parseInt(st.nextToken());
		//합할 날짜 수
		int K=Integer.parseInt(st.nextToken());
		
		//처음 K일의 온도 합
		int sum=0;
		//입력되는 온도 수열
		int[] temp=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			temp[i]=Integer.parseInt(st.nextToken());
			if(i<K) {
				sum+=temp[i];
			}
		}
		
		//K일의 온도 합 앞에서부터 구하면서 최대값 구하기
		int max=sum;
		for(int i=0;i<N-K;i++) {
			sum=sum-temp[i]+temp[i+K];
			if(sum>max) {
				max=sum;
			}
		}
		System.out.println(max);
	}
}
