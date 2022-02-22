
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1247_2 {
	static class Position{
		int x;
		int y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int calc(Position p) {
			return Math.abs(this.x-p.x)+Math.abs(this.y-p.y);
		}
	}
	
	static int minSum;
	static Position start;
	static Position end;
	static Position[] pos;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결고 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			//고객 수(2~10)
			int N=Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			//회사(출발점) 위치
			start=new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			//집(도착점) 위치
			end=new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			//N명의 고객 위치
			pos=new Position[N];
			for(int i=0;i<N;i++) {
				pos[i]=new Position(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			//최소 이동 거리 합
			minSum=Integer.MAX_VALUE;
			
			//방문 순서 -> 순열로 만들기
			perm(0,0,start,0,N);
			//결과 저장
			sb.append(minSum).append("\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}

	//고객 0~N-1 방문 순서 순열로 다 찾기
	//idx: 직전까지 만들어 놓은 순열 길이
	//flag: 방문 여부 플래그
	//prev: 직전에 방문한 고객
	//sum: 직전까지 거리 합
	//N: 고객 수(pos 길이)
	public static void perm(int idx,int flag,Position prev,int sum,int N) {
		//직전까지 거리 합이 현재 최소 방문 거리보다 길면 종료
		if(sum>=minSum) return;
		//방문 순서 완성되면...
		if(idx==N) {
			//마지막 방문 고객에서 집까지 거리까지 더해서 총합 구하기
			sum+=prev.calc(end);
			//총 거리 갱신
			minSum=Math.min(sum, minSum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if((flag&1<<i)!=0) continue;
			
			//거리 합 구하면서 방문 순서 정하기
			perm(idx+1,flag|1<<i,pos[i],sum+prev.calc(pos[i]),N);
		}
	}
}
