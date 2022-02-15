/**
 * 백준 2635. 수 이어가기
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2635 {
	static int max;
	static boolean isUpdated;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//첫번째 수
		int N=Integer.parseInt(br.readLine());
		
		//최대 개수
		max=0;
		//최대 개수의 수들을 만들 수 있는 두번째 수
		int second=0;
		
		for(int i=1;i<=N;i++) {
			//i:두번째 수
			isUpdated=false;
			makeNextNum(N,i,2);
			//max가 갱신되면 second에 i 저장
			if(isUpdated) {
				second=i;
			}
		}
		
		//찾은 두번째 수로 수열 만들어서 출력
		StringBuilder sb=new StringBuilder();
		sb.append(max).append("\n");
		
		sb.append(N).append(" ");
		sb.append(second).append(" ");
		makeNextNum(N, second, sb);
		System.out.println(sb.toString());
	}
	
	//최대 길이 찾는 함수
	public static void makeNextNum(int n1,int n2,int len) {
		int n3=n1-n2;
		if(n3>=0) {
			makeNextNum(n2,n3,len+1);
		}else {
			if(len>max) {
				max=len;
				isUpdated=true;
				return;
			}
		}
	}
	
	//수열 만들어서 문자열에 저장하는 함수
	public static void makeNextNum(int n1,int n2,StringBuilder sb) {
		int n3=n1-n2;
		
		if(n3<0) {
			sb.setLength(sb.length()-1);
			return;
		}
		
		sb.append(n3).append(" ");
		makeNextNum(n2,n3,sb);
	}
}
