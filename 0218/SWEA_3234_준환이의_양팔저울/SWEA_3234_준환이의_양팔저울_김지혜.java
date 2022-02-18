package SWEA.웹엑스수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3234 {
    static int N;
    static int[] weight;
    static int[] weightPerm;
    static boolean[] isSelected;
    static int result;

    private static void balance(int left, int right, int order){
        if(order == N){     // 모든 추가 올라감
            result++;
            return;
        }
        balance(left+weightPerm[order], right, order+1);    //  왼쪽 선택
        if(order > 0 && left >= right+weightPerm[order]) {         // 첫번째는 항상 왼쪽(왼쪽이 항상 무거워야 하므로)
            balance(left, right + weightPerm[order], order + 1);    //  오른쪽 선택
        }
    }

    public static void permutation(int cnt) {               // 추 순서 리턴

        if(cnt == N) {
            balance(0,0,0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            weightPerm[cnt] = weight[i];
            isSelected[i] = true;

            permutation(cnt+1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        for(int tc=1; tc<=t; tc++){
            N = Integer.parseInt(in.readLine());
            result = 0;
            weight = new int[N];
            weightPerm = new int[N];
            isSelected = new boolean[N];
            String str = in.readLine();
            StringTokenizer st = new StringTokenizer(str);

            for(int i=0; i<N; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }

            permutation(0);
            System.out.println("#"+tc+" "+result);
        }
    }
}
