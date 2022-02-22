package com.ssafy.w0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int num;
	Node link;
	
	public Node() {
		
	}
	
	public Node(int num, Node link) {
		this.num = num;
		this.link = link;
	}
}

public class BOJ_1260_DFS와_BFS {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, M = 0, V = 0, from = 0, to = 0, front = 0;
		Node cur, next;
		boolean[] visited;
		Node[] adj;
		Queue<Integer> que = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		adj = new Node[N];
		for(int i = 0; i < adj.length; i++)
			adj[i] = new Node();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			cur = adj[from - 1];
			while(cur != null) {
				if(cur.link == null)
					break;
				else if(cur.link.num > to - 1)
					break;
				cur = cur.link;
			}
			cur.link = new Node(to - 1, cur.link);
			
			cur = adj[to - 1];
			while(cur != null) {
				if(cur.link == null)
					break;
				else if(cur.link.num > from - 1)
					break;
				cur = cur.link;
			}
			cur.link = new Node(from - 1, cur.link);
		}
		
		dfs(adj, visited, V - 1, sb);
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		visited = new boolean[N];
		
		que.offer(V - 1);
		visited[V - 1] = true;
		while(!que.isEmpty()) {
			front = que.poll();
			sb.append(front + 1).append(" ");
			
			for(Node i = adj[front]; i.link != null; i = i.link) {
				next = i.link;
				if(visited[next.num] == false) {
					visited[next.num] = true;
					que.offer(next.num);
				}
			}
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		System.out.println(sb);
		
	}
	
	private static void dfs(Node[] adj, boolean[] visited, int num, StringBuilder sb) {
		Node next;
		
		visited[num] = true;
		sb.append(num + 1).append(" ");
		
		for(Node i = adj[num]; i.link != null; i = i.link) {
			next = i.link;
			
			if(visited[next.num] == false) {
				visited[next.num] = true;
				dfs(adj, visited, next.num, sb);
			}
		}
		
	}
}

/*
public class BOJ_1260_DFS와_BFS {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, M = 0, V = 0, from = 0, to = 0, front = 0, next = 0;
		boolean[] visited;
		List<List<Integer>> adj;
		Queue<Integer> que = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		adj = new LinkedList<List<Integer>>();
		for(int i = 0; i < N; i++)
			adj.add(new LinkedList<Integer>());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			adj.get(from - 1).add(to - 1);
			adj.get(to - 1).add(from - 1);
		}
		for(int i = 0; i < adj.size(); i++)
			Collections.sort(adj.get(i));
		
		dfs(adj, visited, V - 1, sb);
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		visited = new boolean[N];
		
		que.offer(V - 1);
		visited[V - 1] = true;
		while(!que.isEmpty()) {
			front = que.poll();
			sb.append(front + 1).append(" ");
			
			for(int i = 0; i < adj.get(front).size(); i++) {
				next = adj.get(front).get(i);
				if(visited[next] == false) {
					visited[next] = true;
					que.offer(next);
				}
			}
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		
		System.out.println(sb);
	}
	
	private static void dfs(List<List<Integer>> adj, boolean[] visited, int num, StringBuilder sb) {
		int next = 0;
		
		visited[num] = true;
		sb.append(num + 1).append(" ");
		
		for(int i = 0; i < adj.get(num).size(); i++) {
			next = adj.get(num).get(i);
			if(visited[next] == false) {
				visited[next] = true;
				dfs(adj, visited, next, sb);
			}
		}
	}
}
*/
