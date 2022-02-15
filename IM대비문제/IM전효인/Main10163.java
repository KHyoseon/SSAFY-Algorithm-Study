/**
 * 백준 10163. 색종이
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10163 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//격자 이차원 배열
		//색종이 보이는 부분은 색종이 번호 표기
		int[][] board=new int[1001][1001];
		
		//색종이 수
		int N=Integer.parseInt(br.readLine());
		//각 색종이가 칠해진 칸 수
		int[] count=new int[N+1];
		
		//색종이 입력받으면서 격자에 놓기
		StringTokenizer st;
		for(int n=1;n<=N;n++) {
			//입력 내용: n번 색종이의 (r,c), r방향 길이, c방향 길이
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			//이번 색종이 격자에 놓기
			for(int i=r;i<r+h;i++) {
				for(int j=c;j<c+w;j++) {
					//비어있으면 그냥 놓고 개수 추가
					if(board[i][j]==0) {
						board[i][j]=n;
						count[n]++;
					}
					//안 비어있으면 그 번호 개수 하나 줄이고, 내거 놓고 개수 추가
					else {
						count[board[i][j]]--;
						board[i][j]=n;
						count[n]++;
					}
				}
			}
		}
		
		//결과 출력
		StringBuilder sb=new StringBuilder();
		for(int n=1;n<=N;n++) {
			sb.append(count[n]).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
