/**
 * 백준 2669. 직사각형 네개의 합집합의 면적 구하기
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2669 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//전체 면적 이차원 배열
		boolean[][] board=new boolean[101][101];
		//총 칠해진 칸 수
		int result=0;
		
		//직사각형 네개 입력 받기
		for(int n=0;n<4;n++) {
			st=new StringTokenizer(br.readLine());
			//이번 직사각형의 왼쪽아래, 오른쪽 위 꼭지점 좌표
			//x1<x2, y1<y2
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			//직사각형 내의 아직 안 칠해진 칸 칠하기
			for(int i=y1;i<y2;i++) {
				for(int j=x1;j<x2;j++) {
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
