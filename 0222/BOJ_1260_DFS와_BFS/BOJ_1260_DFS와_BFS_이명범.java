package com.ssafy.ws0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_2 {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int data;
        Node link;

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        M = Integer.parseInt(st.nextToken());
        // 시작 정점 번호
        int V = Integer.parseInt(st.nextToken());

        Node[] head = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 만약에 현재 헤드가 아무것도 가리키지 않는다면 헤드가 새로 만든 노드를 가리킨다.
            if (head[from] == null) {
                head[from] = new Node(to, head[from]);
            } else {
                for (Node temp = head[from]; temp != null; temp = temp.link) {
                    // 만약 새로운 데이터가 현재 노드의 헤드의 데이터보다 작다면 제일 앞에 삽입
                    if (to < head[from].data) {
                        head[from] = new Node(to, head[from]);
                        break;
                    }
                    if (temp.link == null) {
                        temp.link = new Node(to, null);
                        break;
                    }
                    if (to < temp.link.data) {
                        temp.link = new Node(to, temp.link);
                        break;
                    }
                }
            }

            if (head[to] == null) {
                head[to] = new Node(from, head[to]);
            } else {
                for (Node temp = head[to]; temp != null; temp = temp.link) {
                    // 만약 새로운 데이터가 현재 노드의 헤드의 데이터보다 작다면 제일 앞에 삽입
                    if (from < head[to].data) {
                        head[to] = new Node(from, head[to]);
                        break;
                    }
                    if (temp.link == null) {
                        temp.link = new Node(from, null);
                        break;
                    }
                    if (from < temp.link.data) {
                        temp.link = new Node(from, temp.link);
                        break;
                    }
                }
            }
        }
        // 입력 완료
        dfs(head, V, new boolean[N + 1]);
        sb.append("\n");
        bfs(head, V);

        System.out.println(sb);
    }

    private static void dfs(Node[] head, int cur, boolean[] visit) {
        visit[cur] = true;
        sb.append(cur).append(" ");

        for (Node temp = head[cur]; temp != null; temp = temp.link) {
            if (!visit[temp.data]) {
                dfs(head, temp.data, visit);
            }
        }
    }

    private static void bfs(Node[] head, int start) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visit = new boolean[N + 1];

        queue.offer(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (Node temp = head[cur]; temp != null; temp = temp.link) {
                if (!visit[temp.data]) {
                    queue.offer(temp.data);
                    visit[temp.data] = true;
                }
            }
        }
    }
}
