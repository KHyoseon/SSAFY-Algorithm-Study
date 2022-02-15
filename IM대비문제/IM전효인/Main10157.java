/**
 * 백준 10157. 자리배정
 * 
 * 220213
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10157 {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//가로 세로
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		//대기 관객 수
		int K=Integer.parseInt(br.readLine());
		
		//좌석 배정 불가능한 경우: 0 출력 후 종료
		if(K>C*R) {
			System.out.println(0);
			return;
		}
		
		//해당 칸 방문 여부 저장하는 배열
		boolean[][] visited=new boolean[R][C];
		//이동 방향 배열(우하좌상)
		int[] dr= {0,1,0,-1};
		int[] dc= {1,0,-1,0};
		//현재 방향
		int dir=0;
		//현재 위치
		int r=0;
		int c=0;
		//배정한 좌석 개수
		int count=1;
		
		while(count<K) {
			//현재 위치 방문 처리
			visited[r][c]=true;
			
			//다음칸이...
			int nr=r+dr[dir];
			int nc=c+dc[dir];
			//벽 넘어가거나 이미 방문한 칸이면 방향 전환
			if(nr<0 || nc<0 || nr>=R || nc>=C || visited[nr][nc]) {
				dir++;
				//dir 4되면 0으로, 벽 한칸씩 안으로
				dir=(dir<4?dir:dir-4);
				continue;
			}
			//현재 위치 다음 위치로 이동
			r=nr;
			c=nc;
			//배정한 자리수 하나 증가
			count++;
		}
		//결과(마지막 좌석 위치) 출력
		System.out.println((r+1)+" "+(c+1));
	}
}
