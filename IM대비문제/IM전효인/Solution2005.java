/**
 * SWEA 2005. 파스칼의 삼각형
 * 
 * 220214
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2005 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append("\n");
			//파스칼의 삼각형 줄 수(1~10)
			int N=Integer.parseInt(br.readLine());
			
			//파스칼의 삼각형 정보 저장할 이차원 배열
			int[][] pascal=new int[N+1][N+1];
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=i;j++) {
					//테두리면 1 저장
					if(j==1 || j==i)
						pascal[i][j]=1;
					//테두리 아니면 왼쪽 위, 바로 위 숫자 더하기
					else 
						pascal[i][j]=pascal[i-1][j-1]+pascal[i-1][j];
					//결과 저장
					sb.append(pascal[i][j]).append(" ");
				}
				//결과 저장
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
