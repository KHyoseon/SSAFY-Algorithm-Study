/**
 * SWEA 2007. 패턴 마디의 길이
 * 
 * 220214
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2007 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			//문자열 입력받기(길이 30)
			String line=br.readLine();
			
			//마디 찾기(최대 길이 10)
			for(int i=1;i<=10;i++) {
				//길이 i인 마디 생성
				String pattern=line.substring(0,i);
				//마디가 다음 마디랑 같으면 결과 저장, 빠져나오기
				if(pattern.equals(line.substring(i, 2*i))) {
					sb.append(i).append("\n");
					break;
				}
			}
		}
		//결과 출력하기
		System.out.println(sb.toString());
	}
}
