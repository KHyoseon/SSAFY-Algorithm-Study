//다른분들 코드 너무 궁금하다....
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main17144 {
	static class Dust{
		//좌표
		int r,c;
		//먼지 양
		int dust;
		public Dust(int r, int c, int dust) {
			super();
			this.r = r;
			this.c = c;
			this.dust = dust;
		}
		public void diffusion() {
			int nr,nc;
			//주변에 확산되는 양(현재 양의 1/5)
			int part=dust/5;
			//사방탐색
			for(int i=0;i<4;i++) {
				nr=r+dr[i];
				nc=c+dc[i];
				//새 위치가 범위 밖, 공기청정기면 건너뛰기
				if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
				if(map[nr][nc]==-1) continue;
				//새 위치에 먼지 추가, 현재 위치에 먼지 감소
				map[nr][nc]+=part;
				map[r][c]-=part;
			}
		}
	}
	
	static int R,C;
	static int[][] map;
	//이동방향(상우하좌)
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//가로,세로
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		//T초 지난 후 방에 남은 미세먼지 양 구해야 함
		int T=Integer.parseInt(st.nextToken());
		
		//미세먼지들
		List<Dust> dusts=new ArrayList<>();
		//공기청정기 위치
		int[] cleaner=new int[2];
		
		//방 미세먼지 정보 입력받기
		map=new int[R][C];
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				//미세먼지들 리스트에 저장
				if(map[i][j]>0)
					dusts.add(new Dust(i,j,map[i][j]));
				//공기청정기 위치 저장
				else if(map[i][j]==-1)
					cleaner[1]=i;
			}
		}
		cleaner[0]=cleaner[1]-1;
//		System.out.println(cleaner[0]+" "+cleaner[1]);
		
		//T초동안 미세먼지 확산시키기 & 공기청정기로 순환시키기
		for(int t=0;t<T;t++) {
			//미세먼지 확산시키기
			for(Dust d:dusts) {
				d.diffusion();
			}
//			view();
			
			//공기청정기로 순환시키기
			cleaning(cleaner);
//			view();
			
			//확산, 순환 후 변동된 미세먼지 정보 저장하기
			//직전 미세먼지들 정보 지우고
			dusts.clear();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					//현재 미세먼지들 리스트에 저장
					if(map[i][j]>0)
						dusts.add(new Dust(i,j,map[i][j]));
				}
			}
		}
		//T초가 지난 후 남은 미세먼지 양(공기청정기때문에 -1 두개 있으니 미리 2 추가)
		int result=2;
		for(int i=0;i<R;i++) {
			result+=Arrays.stream(map[i]).sum();
		}
		//결과 출력
		System.out.println(result);
	}
	
	public static void cleaning(int[] cleaner) {
		//위의 반시계방향 순환(당겨올 칸 순서: 상우하좌)
		arrRot(cleaner[0]-1,dr,0,cleaner[1]);
		
		//아래의 시계방향 순환(당겨올 칸 순서: 하우상좌)
		arrRot(cleaner[1]+1,new int[] {1,0,-1,0},cleaner[1],R);
	}
	
	//공기 순환시키기
	//r: 순환 시작한 칸 행 좌표
	//dr: 순환 방향(반시계 or 시계)
	//uR, dR: 위 벽, 아래 벽
	public static void arrRot(int r,int[] dr,int uR,int dR) {
		int dir=0;
		int c=0;
		int nr=r;
		int nc=c;
		while(dir<4) {
			nr=r+dr[dir];
			nc=c+dc[dir];
			if(nr<uR || nc<0 || nr>=dR || nc>=C) {
				dir++;
				continue;
			}
			if(map[nr][nc]==-1) {
				map[r][c]=0;
				break;
			}
			map[r][c]=map[nr][nc];
			r=nr;
			c=nc;
		}
	}
	
	//현재 방 상태 확인
	public static void view() {
		for(int i=0;i<R;i++)
			System.out.println(Arrays.toString(map[i]).replaceAll("[^0-9 -]", ""));
		System.out.println();
	}
}
