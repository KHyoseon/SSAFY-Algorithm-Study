import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3109 {
	//이동방향
	static int[] dr= {-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 세로(1~10,000), 가로(5~500)
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 빵집 주변 정보
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 파이프라인 개수
		int count = 0;
		
		//각 라인 왼쪽 끝에서 dfs로 파이프라인 깔기
		for(int i=0;i<R;i++) {
			//빵집 도착 성공 파이프라인 개수 추가
			if(search(i,0,map)) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static boolean search(int r,int c,char[][] map) {
		//빵집 도착하면 true 반환
		if(c==map[0].length-1) return true;
		//못가면 종료
		if(r<0 || r>=map.length) return false;
		//이미 방문한 곳이면 종료
		if(map[r][c]=='x') return false;
		
		//현재 위치 방문 표시
		map[r][c]='x';
		//우상 우 우하 순서대로 가보기
		for(int i=0;i<3;i++) {
			//빵집 도착 성공해서 true가 돌아오면
			if(search(r+dr[i],c+1,map)) {
				//true 반환
				return true;
			}
		}
		return false;
	}
}
