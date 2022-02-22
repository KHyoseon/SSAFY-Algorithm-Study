package ws0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_List_이대희 {
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link +"]";
		}
	}
	static int N;
	static int M;
	static int V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(adjList[from] == null)							//값없으면 바로 넣어줘도 된다.
				adjList[from]=new Node(to,adjList[from]);
			else {
				Node insNode = new Node(to, null);				//
				Node cur = adjList[from];				//커서
				if(adjList[from].link == null) {				//노드배열에 값이 하나만 있는경우.
					if(insNode.vertex<adjList[from].vertex) {
						Node temp=new Node(adjList[from].vertex, adjList[from].link);
						insNode.link = temp;
						adjList[from] = insNode;
					}
					else {
						adjList[from].link=insNode;
					}
				}else {											//노드배열에 값이 2개 이상 있는 경우.
					if(insNode.vertex<adjList[from].vertex) {
						Node temp=new Node(adjList[from].vertex, adjList[from].link);
						insNode.link = temp;
						adjList[from] = insNode;
					}
					else {
						while (cur.link != null && cur.link.vertex < insNode.vertex)			//while문 돌아가면서 넣고자 하는 인덱스까지 계속 cur가 이동
							cur = cur.link;
						
						insNode.link = cur.link;
						cur.link = insNode;

					}
				}
			}
			//----------------------------------------------------------------------------------
			if(adjList[to] == null)
				adjList[to] = new Node(from,adjList[to]);
			else {
				Node insNode = new Node(from, null);
				Node cur = adjList[to];
				if(adjList[to].link == null) {
					if(insNode.vertex<adjList[to].vertex) {
						Node temp=new Node(adjList[to].vertex, adjList[to].link);
						insNode.link = temp;
						adjList[to] = insNode;
					}
					else {
						adjList[to].link=insNode;
					}
				}else {
					if(insNode.vertex<adjList[to].vertex) {
						Node temp=new Node(adjList[to].vertex, adjList[to].link);
						insNode.link = temp;
						adjList[to] = insNode;
					}
					else {
						while (cur.link != null && cur.link.vertex < insNode.vertex)
							cur = cur.link;
						
						insNode.link = cur.link;
						cur.link = insNode;
					}
				}
			}
		}
		dfs(adjList,new boolean[N], V);
		System.out.println();
		bfs(adjList, V);
	}
	public static void bfs(Node[] adjList, int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");

			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (Node temp=adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
	public static void dfs(Node[] adjList, boolean[] visited, int current) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(Node temp=adjList[current]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				dfs(adjList,visited,temp.vertex);
			}
		}
	}
}
