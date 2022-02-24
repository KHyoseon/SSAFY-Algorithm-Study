
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1753 {
	static class Node{
		int to;
		int weight;
		Node next;
		public Node(int to, int weight, Node next) {
			super();
			this.to = to;
			this.weight = weight;
			this.next = next;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//정점 수, 간선 수
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		//시작 정점 번호
		int start=Integer.parseInt(br.readLine());
		
		//간선 정보 입력받기
		Node[] adjList=new Node[V+1];
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			//from->to, 가중치가 weight인 간선
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			
			adjList[from]=new Node(to,weight,adjList[from]);
		}

		//시작 정점에서 해당 정점까지 경로의 최소 비용
		int[] distance=new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start]=0;
		
		//최소 비용 확정 여부
		boolean[] visited=new boolean[V+1];
		
		for(int i=1;i<=V;i++) {
			//1. 최소 비용이 확정 안된 정점 중 최소 비용 정점 선택
			int min=Integer.MAX_VALUE;
			int current=1;
			for(int j=1;j<=V;j++) {
				if(!visited[j] && distance[j]<min) {
					min=distance[j];
					current=j;
				}
			}
			visited[current]=true;
			
			//2. 선택한 최소 비용 정점의 인접 정점 중 아직 최소 비용 확정 안된 정점의 최소 비용 갱신
			Node cursor=adjList[current];
			while(cursor!=null) {
				if(!visited[cursor.to] && distance[cursor.to]>distance[current]+cursor.weight)
					distance[cursor.to]=distance[current]+cursor.weight;
				cursor=cursor.next;
			}
		}
		
		//결과 출력
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=V;i++) {
			if(distance[i]==Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(distance[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
