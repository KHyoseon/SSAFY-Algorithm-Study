
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026 {
	static char[][] pic;
	static boolean[][] visitedX;
	static boolean[][] visitedO;
	//이동방향(상하좌우)
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//그림 한변 길이(1~100)
		int N=Integer.parseInt(br.readLine());
		//그림 입력받기
		pic=new char[N][N];
		for(int i=0;i<N;i++) {
			pic[i]=br.readLine().toCharArray();
		}
		
		//적록색약 아닌 사람, 적록색약인 사람이 보는 구역 수
		int countX=0;
		int countO=0;
		//그림 칸 방문 여부
		visitedX=new boolean[N][N];
		visitedO=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//적록색약 아닌 경우
				if(!visitedX[i][j]) {
					bfsX(i,j,N);
					countX++;
				}
				//적록색약인 경우 각각 탐색 후 그룹 수 추가
				if(!visitedO[i][j]) {
					bfsO(i,j,N);
					countO++;
				}
			}
		}
		System.out.println(countX);
		System.out.println(countO);
	}
	
	//적록색약 아닌 경우
	public static void bfsX(int r,int c,int N) {
		Queue<int[]> q=new LinkedList<>();
		
		//첫번째 원소 큐에 넣고 방문처리
		q.offer(new int[]{r,c});
		visitedX[r][c]=true;
		
		while(!q.isEmpty()) {
			//큐 맨앞에서 원소 빼고 탐색 처리
			int[] cur=q.poll();
			
			//current의 상하좌우 처리
			for(int i=0;i<4;i++) {
				int nr=cur[0]+dr[i];
				int nc=cur[1]+dc[i];
				//범위 밖이면 건너뛰기
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				
				//방문 가능하면 큐에 넣고 방문처리
				//아직 방문 처리 안됨 and 색 같음
				if(!visitedX[nr][nc] && pic[nr][nc]==pic[cur[0]][cur[1]]) {
					q.offer(new int[] {nr,nc});
					visitedX[nr][nc]=true;
				}
			}
		}
	}
	
	//적록색약인 경우
	public static void bfsO(int r,int c,int N) {
		Queue<int[]> q=new LinkedList<>();
		
		//첫번째 원소 큐에 넣고 방문처리
		q.offer(new int[]{r,c});
		visitedO[r][c]=true;
		
		while(!q.isEmpty()) {
			//큐 맨앞에서 원소 빼고 탐색 처리
			int[] cur=q.poll();
			
			//current의 상하좌우 처리
			for(int i=0;i<4;i++) {
				int nr=cur[0]+dr[i];
				int nc=cur[1]+dc[i];
				//범위 밖이면 건너뛰기
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				
				//방문 가능하면 큐에 넣고 방문처리
				//아직 방문 처리 안됨 and (색 같음 or 색이 둘다 B가 아님)
				if(!visitedO[nr][nc] && (pic[nr][nc]==pic[cur[0]][cur[1]] || pic[nr][nc]!='B'&&pic[cur[0]][cur[1]]!='B')) {
					q.offer(new int[] {nr,nc});
					visitedO[nr][nc]=true;
				}
			}
		}
	}
}
