/**
 * SWEA 3499. 퍼펙트 셔플
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3499 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			//카드 장 수
			int N=Integer.parseInt(br.readLine());
			
			//입력 받은 카드
			List<String> deck=Arrays.asList(br.readLine().split(" "));
			//반 나눴을 때 왼쪽 덱
			List<String> left=new ArrayList<>();
			//오른쪽 덱
			List<String> right=new ArrayList<>();
			
			//반 나눌 기준점(홀수면 왼쪽에 한개 더 많게)
			int half=N/2;
			if(N%2==1) {
				half++;
			}
			
			//덱 반으로 나누기
			left=deck.subList(0, half);
			right=deck.subList(half, N);
			
			//결과 덱에 번갈아가면서 추가
			List<String> result=new ArrayList<>();
			for(int i=0;i<half;i++) {
				//왼쪽 추가
				result.add(left.get(i));
				
				//왼쪽이 하나 더 많은 경우, 오른쪽 추가는 건너뛰기
				if(right.size()<=i) continue;
				//오른쪽 추가
				result.add(right.get(i));
			}
			
			//결과 저장
			for(int i=0;i<N;i++) {
				sb.append(result.get(i)).append(" ");
			}
			sb.append("\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
