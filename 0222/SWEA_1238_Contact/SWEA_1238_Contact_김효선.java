package hw0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA 1238. [S/W 문제해결 기본] 10일차 - Contact

public class Solution1238 {
	
	static class Node {
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = 10;

		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			Node adjLink[] = new Node[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjLink[from] = new Node(to, adjLink[from]);
			}
			
			bfs(adjLink, new boolean[N], V);
			sb.append(MAX+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();

	}
	
	static int MAX=-1;

	public static void bfs(Node adjLink[], boolean visited[], int start) {
		Queue<Integer> queue1 = new LinkedList<>();
		visited[start] = true;
		queue1.offer(start);
		
		while(!queue1.isEmpty()) {
			Queue<Integer> queue2 = new LinkedList<>();
			int m =-1;
			
			// 부모 노드들의 자식들을 모두 담음
			while(!queue1.isEmpty()) {
				int current = queue1.poll();
				m = Math.max(m, current);
				for(Node temp=adjLink[current]; temp!=null; temp=temp.link) {
					if(!visited[temp.vertex]) {
						queue2.offer(temp.vertex);
						visited[temp.vertex] = true;
					}
				}
			}
			
			if(queue2.isEmpty()) {
				MAX = m;	return;
			}
			queue1 = queue2;
			m=-1;
		}
	}
}
