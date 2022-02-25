
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576 {
	static class Tomato{
		//좌표
		int r,c;
		//몇번째 날에 익었는지
		int count;
		public Tomato(int r, int c, int count) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}
	
	static int R,C;
	static int[][] box;
	//사방탐색(상하좌우)
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//가로,세로
		C=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		//익은 토마토들
		Queue<Tomato> ripe=new LinkedList<>();
		//안익은 토마토 개수
		int unripe=0;
		
		//토마토 상자 정보 입력받기
		box=new int[R][C];
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				box[i][j]=Integer.parseInt(st.nextToken());
				//0번째 날에 익은 토마토 위치 큐에 저장
				if(box[i][j]==1)
					ripe.offer(new Tomato(i,j,0));
				//안익은 토마토 개수 세기
				else if(box[i][j]==0)
					unripe++;
			}
		}
		
		//익은 토마토에서 bfs -> 결과 출력
		System.out.println(bfs(ripe,unripe));
	}
	
	public static int bfs(Queue<Tomato> ripe,int unripe) {
		//토마토가 다 익는데 걸리는 최소 날짜
		int count=0;
		
		//익은 토마토에서 bfs 탐색
		while(!ripe.isEmpty()) {
			Tomato current=ripe.poll();
			//다 익는데 걸리는 최소 날짜 갱신(마지막에 큐에서 나오는 애의 날짜)
			count=current.count;
			
			//사방탐색
			for(int i=0;i<4;i++) {
				int nr=current.r+dr[i];
				int nc=current.c+dc[i];
				
				//범위 벗어나면 건너뛰기
				if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
				//해당 칸이 안익은 토마토이면 익은 토마토로 바꾸고 안익은 토마토 개수 줄이기
				if(box[nr][nc]==0) {
					box[nr][nc]=1;
					unripe--;
					//인접 토마토 큐에 넣기(좌표, 익은 날짜 넣어서)
					ripe.offer(new Tomato(nr,nc,current.count+1));
				}
			}
		}
		
		//bfs 탐색 끝내고 안익은 토마토 남아있으면 -1 반환
		if(unripe>0) return -1;
		//bfs 탐색 끝내고 다 익는데 걸리는 최소 날짜 반환
		return count;
	}
}
