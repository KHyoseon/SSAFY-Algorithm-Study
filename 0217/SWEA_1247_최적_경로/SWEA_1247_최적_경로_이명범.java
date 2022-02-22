package com.ssafy.ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution_최적경로 {
    static int N, min;
    static int numbers[];
    static Location com, home, customer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            com = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customer = new Location[N];
            numbers = new int[N];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                customer[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            permutation(0, 0, 0, com);

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(tc).append(" ").append(min);
            System.out.println(sb);
        }
    }

    private static void permutation(int cnt, int flag, int total, Location cur) {
        if (cnt == N) {
            total += Math.abs(cur.x - home.x) + Math.abs(cur.y - home.y);
            min = Math.min(min, total);
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((flag & 1 << i) != 0) continue;

            // total이 min을 넘어서면 더 이상 연산을 할 필요가 없음
            if (total >= min) return;

            int temp = total;

            numbers[cnt] = i;

            temp += Math.abs(cur.x - customer[i].x) + Math.abs(cur.y - customer[i].y);

            permutation(cnt + 1, flag | 1 << i, temp, customer[i]);
        }
    }
}
