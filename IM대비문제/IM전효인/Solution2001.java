/**
 * SWEA 2001. 파리 퇴치
 * 
 * 220204
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2001 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//테스트 케이스 개수
		int T=Integer.parseInt(br.readLine());
		//출력할 결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=0;t<T;t++) {
			st=new StringTokenizer(br.readLine());
			//영역 크기(5~15)
			int N=Integer.parseInt(st.nextToken());
			//파리채 크기(2~N)
			int M=Integer.parseInt(st.nextToken());
			
			//영역 만들고 영역 내 파리 수(0~30) 입력받기
			int[][] area=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					area[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//한번에 잡을 수 있는 최대 파리수 구하기
			int max=0;
			//영역 안의...
			for(int r=0;r<(N-M+1);r++) {
				for(int c=0;c<(N-M+1);c++) {
					int sum=0;
					//파리채 안의 합 구하기
					for(int i=r;i<(r+M);i++) {
						for(int j=c;j<(c+M);j++) {
							sum+=area[i][j];
						}
					}
					//최대값 갱신
					if(sum>max) {
						max=sum;
					}
				}
			}
			//결과 저장
			sb.append("#"+(t+1)+" "+max+"\n");
		}
		
		//출력
		System.out.println(sb.toString());
	}
}
