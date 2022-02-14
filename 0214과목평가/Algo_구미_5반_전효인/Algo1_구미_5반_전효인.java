import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_5반_전효인 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		//테스트케이스 개수(1~10)
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			
			st=new StringTokenizer(br.readLine());
			//종이컵 수(3~20,000)(사용 안함)
//			int N=Integer.parseInt(st.nextToken());
			st.nextToken();
			//간식 종이컵 번호(1~N)
			int X=Integer.parseInt(st.nextToken());
			//컵 위치 바꾸는 횟수(1~100,000)
			int K=Integer.parseInt(st.nextToken());
			
			//K번의 컵 위치 변경 입력받기
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				//바꾸는 두 컵
				int A=Integer.parseInt(st.nextToken());
				int B=Integer.parseInt(st.nextToken());
				
				//현재 간식이 든 컵이 바꾸는 컵이면 간식 위치 변경
				if(A==X || B==X) {
					if(A==X) {
						X=B;
					}else if(B==X) {
						X=A;
					}
				}
			}
			//결과 (간식 위치한 종이컵 위치) 저장
			sb.append(X).append("\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
