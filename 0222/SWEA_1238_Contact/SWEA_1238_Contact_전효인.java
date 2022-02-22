
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1238 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//테스트케이스 개수
		int T=10;
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			st=new StringTokenizer(br.readLine());
			//데이터 길이(=간선 개수x2)
			int len=Integer.parseInt(st.nextToken());
			//시작 정점
			int start=Integer.parseInt(st.nextToken());
			
			//간선(연락망) 정보
			int[] input=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//번호 가장 큰 정점
			int maxV=Arrays.stream(input).max().getAsInt();
			
			//인접행렬로 유향그래프 표현(가중치x)
			boolean[][] graph=new boolean[maxV+1][maxV+1];
			for(int i=0;i<len;i++) {
				int from=input[i];
				int to=input[++i];
				
				//from->to 간선 추가
				graph[from][to]=true;
			}
			
			sb.append(bfs(start,graph,maxV)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int bfs(int start,boolean[][] graph,int V) {
		//bfs 탐색 위한 큐(0:정점번호, 1:depth)
		Queue<int[]> q=new LinkedList<>();
		//각 정점의 방문 여부
		boolean[] visited=new boolean[V+1];
		//해당 정점의 depth
		int depth=0;
		//마지막 depth에 연락 받은 사람 중 번호가 가장 큰 사람
		int[] last=new int[] {-1,-1};
		
		//시작 정점 방문 처리, 큐에 추가
		visited[start]=true;
		q.add(new int[]{start,depth});
		
		while(!q.isEmpty()) {
			//큐에서 현재 정점 꺼내고 탐색 처리
			int[] current=q.poll();
			//탐색처리: depth가 더 큰 정점, depth가 같으면 번호가 큰 정점을 last에 저장
			if(current[1]>last[1] || (current[1]==last[1] && current[0]>last[0])) 
				last=current;
			
			for(int i=1;i<=V;i++) {
				//방문 안한 인접정점 방문 처리, 큐에 추가
				if(!visited[i] && graph[current[0]][i]) {
					visited[i]=true;
					//큐에 추가할 때 depth는 현재 정점 current의 depth+1
					q.add(new int[] {i,current[1]+1});
				}
			}
		}
		//마지막 연락 받은 사람 정점 번호 반환
		return last[0];
	}
}
