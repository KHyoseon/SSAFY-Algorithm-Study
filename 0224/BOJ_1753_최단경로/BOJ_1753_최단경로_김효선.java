package ws0224;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1753 {
	
	static class Node {
		int to, weight;
		Node link;
		public Node(int to, int weight, Node link) {
			super();
			this.to = to;
			this.weight = weight;
			this.link = link;
		}
	}
	
	static Node nodes[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());	// 노드 개수
		int E = Integer.parseInt(st.nextToken());	// 간선 개수
		
		int K = Integer.parseInt(br.readLine())-1;	// 시작 정점

		nodes = new Node[V];
		int s, t, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()) - 1;
			t = Integer.parseInt(st.nextToken()) - 1;
			w = Integer.parseInt(st.nextToken());
			nodes[s] = new Node(t, w, nodes[s]);
		}
		
		boolean visited[] = new boolean[V];
		int dist[] = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// dist 구성
		dist[K] = 0;
		visited[K] = true;
		Node temp = nodes[K];
		while(temp != null) {
			dist[temp.to] = Math.min(temp.weight, dist[temp.to]);
			temp = temp.link;
		}
		
		for(int v=0; v<V; v++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for(int i=0; i<V; i++) {
				if(!visited[i] && min>dist[i]) {
					min = dist[i];
					minVertex = i;
				}
			}
			
			visited[minVertex] = true;
			temp = nodes[minVertex];
			while(temp != null) {
				if(!visited[temp.to] && dist[temp.to]>dist[minVertex]+temp.weight) {
					dist[temp.to] = dist[minVertex] + temp.weight;
				}
				temp = temp.link;
			}
		}
		
		for(int d: dist)
			sb.append(d==Integer.MAX_VALUE? "INF\n": d+"\n");
		
		bw.write(sb.toString());
		bw.flush();

	}

}
/*
[입력]
5 7
1
1 2 3
1 3 6
1 4 7
2 3 1
3 4 4
3 5 2
4 5 3

[출력]
0
3
4
7
6

[입력]
5 5
1
1 2 10
1 3 5
1 4 3
2 4 2
2 5 6

[출력]
0
10
5
3
16
*/
