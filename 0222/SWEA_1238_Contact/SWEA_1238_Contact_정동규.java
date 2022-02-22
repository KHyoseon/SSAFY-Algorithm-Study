package com.ssafy.w0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int num;
	int depth;
	Node link;
	
	public Node() {
		
	}

	public Node(int num, Node link) {
		this.num = num;
		this.link = link;
	}
}

public class SWEA_1238_Contact {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 1, size = 0, V = 0, from = 0, to = 0, count = 0, max = 0, depth = 0;
		Node next, front;
		Map<Integer, Integer> indexs;
		List<Boolean> visited;
		List<Node> adj;
		Queue<Node> que;
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			count = 0;
			max = 0;
			depth = 0;
			indexs = new HashMap<Integer, Integer>();
			visited = new ArrayList<>();
			adj = new ArrayList<>();
			que = new LinkedList<Node>();
			
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < size / 2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				if(!indexs.containsKey(from)) {
					indexs.put(from, count++);
					adj.add(new Node(from, null));
					visited.add(false);
				}
				if(!indexs.containsKey(to)) {
					indexs.put(to, count++);
					adj.add(new Node(to, null));
					visited.add(false);
				}
				adj.get(indexs.get(from)).link = new Node(to, adj.get(indexs.get(from)).link);
			}
			
			adj.get(indexs.get(V)).depth = 0;
			que.offer(adj.get(indexs.get(V)));
			visited.set(indexs.get(V), true);
			while(!que.isEmpty()) {
				front = que.poll();
				if(depth < front.depth) {
					depth = front.depth;
					max = front.num;
				}else {
					if(max < front.num)
						max = front.num;
				}
				
				for(Node i = adj.get(indexs.get(front.num)); i.link != null; i = i.link) {
					next = i.link;
					if(!visited.get(indexs.get(next.num))) {
						visited.set(indexs.get(next.num), true);
						next.depth = front.depth + 1;
						que.offer(next);
					}
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
