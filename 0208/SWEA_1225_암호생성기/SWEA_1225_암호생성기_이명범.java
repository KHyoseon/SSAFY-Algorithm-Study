import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
#1 6 2 2 9 4 1 3 0
#2 9 7 9 5 4 3 8 0
#3 8 7 1 6 4 3 5 0
#4 7 5 8 4 8 1 3 0
#5 3 8 7 4 4 7 4 0
#6 6 7 5 9 6 8 5 0
#7 7 6 8 3 2 5 6 0
#8 9 2 1 7 3 6 3 0
#9 4 7 8 1 2 8 4 0
#10 6 8 9 5 8 5 2 0
*/
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> que = new LinkedList<>();

        int T = 10;

        for (int i = 0; i < T; i++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int min = Integer.MAX_VALUE;
            int minIdx;
            int[] arr = new int[8];
            // 배열에 수 입력
            for (int j = 0; j < 8; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (min > num) {
                    min = num;
                }
                arr[j] = num;
            }

            // 최솟값에서 15를 나눈 값
            int n = min / 15;

            // 15로 나누어 떨어지면 n에 1을 뺴줌(0이 되어서는 안됨)
            if (min % 15 == 0) {
                n--;
            }

            // 그 값에서 15를 곱한 값
            int m = n * 15;

            for (int j = 0; j < 8; j++) {
                arr[j] -= m;
                que.offer(arr[j]);
            }

            // 처음 숫자를 큐로부터 가져옴
            int index = 1;
            while (true) {
                int temp = que.poll() - index++;
                if (temp <= 0) {
                    que.offer(0);
                    break;
                } else {
                    que.offer(temp);
                }

                if (index > 5) {
                    index = 1;
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(tc).append(" ");

            while (!que.isEmpty()) {
                sb.append(que.poll()).append(" ");
            }

            System.out.println(sb);
        }


    }
}
