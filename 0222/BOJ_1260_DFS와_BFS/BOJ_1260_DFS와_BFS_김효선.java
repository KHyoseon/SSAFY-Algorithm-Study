package ws0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1260. DFS와 BFS

public class Main1260 {
	
	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		Node adjList[] = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		dfs(adjList, new boolean[N], V-1);
		sb.append("\n");
		bfs(adjList, new boolean[N], V-1);

		bw.write(sb.toString());
		bw.flush();

	}

	private static void dfs(Node[] adjList, boolean visited[], int v) {
		if(!visited[v])
			sb.append((v+1)+" ");
		visited[v] = true;
		
		List<Integer> order = new ArrayList<>();
		for(Node temp=adjList[v]; temp!=null; temp = temp.link) {
			if(!visited[temp.vertex]) {
				order.add(temp.vertex);
			}
		}
		Collections.sort(order);
		
		for(int o: order) {
			dfs(adjList, visited, o);
		}
		
	}

	private static void bfs(Node[] adjList, boolean visited[], int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			List<Integer> order = new ArrayList<>();
			int tmp = queue.poll();
			sb.append((tmp+1)+" ");
			for(Node temp = adjList[tmp]; temp!=null; temp=temp.link) {
				if(!visited[temp.vertex]) {
					order.add(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
			Collections.sort(order);
			for(int o: order) {
				queue.offer(o);				
			}
		}
		
	}

}
