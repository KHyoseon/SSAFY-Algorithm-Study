package hw0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_1238_Contact {
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
	static int S;
	static int max, maxDepth;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= 10; tNum++) {
			sb.append("#").append(tNum).append(" ");
			max = -1;													//최대값 초기화
			maxDepth = -1;												//최대깊이값 초기화
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			Node[] adjList = new Node[101];								//1~100 사이의 값이 들어올 수 있기 때문에 배열의 크기를 101로 선언해준다.
			for(int i=0;i<N/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from]=new Node(to,adjList[from]);
			}
			
			bfs(adjList, S);
			sb.append(max).append("\n");								//bfs를 하고 나서 최대값을 출력
		}
		System.out.print(sb.toString());
	}
	
	public static void bfs(Node[] adjList, int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> depthCnt = new LinkedList<Integer>();			//현재 들어가는 값에 대한 높이 정보를 큐로 하나 더 생성
		boolean[] visited = new boolean[N];

		queue.offer(start);
		depthCnt.offer(0);												//제일 처음 들어가는 값의 depth는 0으로 설정
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();									//노드의 값
			int depth = depthCnt.poll();								//해당 노드의 깊이
			if(depth > maxDepth) {										//기존의 최대깊이보다 더 깊이 들어간 경우, 최댓값을 강제로 해당 깊이의 첫값으로 바꾸고, 최대깊이값도 변경해준다.
				max = current;
				maxDepth = depth;
			}else if(depth == maxDepth) {								//같은 깊이의 노드끼리는 값을 비교해주어야 한다. 가장 큰 값이 max에 들어감.
				max = max<current?current:max;
			}
			// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
			for (Node temp=adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					depthCnt.offer(depth+1);							//인접노드의 depth는 원래 depth보다 1만큼 크다.
					visited[temp.vertex] = true;
				}
			}
		}
	}
}
