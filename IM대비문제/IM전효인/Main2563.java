/**
 * 백준 2563. 색종이
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2563 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//색종이 수
		int N=Integer.parseInt(br.readLine());
		//도화지(전체 격자) 이차원 배열
		boolean[][] board=new boolean[101][101];
		//색칠한 칸 개수
		int result=0;
		
		StringTokenizer st;
		//색종이 입력받으면서 도화지에 입력
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			
			//아직 안칠해진 칸 칠하기
			for(int i=r;i<r+10;i++) {
				for(int j=c;j<c+10;j++) {
					if(!board[i][j]) {
						board[i][j]=true;
						result++;
					}
				}
			}
		}
		
		//결과 출력
		System.out.println(result);
	}
}
