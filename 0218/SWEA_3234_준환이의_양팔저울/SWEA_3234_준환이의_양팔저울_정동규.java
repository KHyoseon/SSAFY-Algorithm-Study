package com.ssafy.w0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class SWEA_3234_준환이의_양팔저울 {
     
    static int res;
    static int[] factorial = new int[10];
     
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = 0, N = 0, sum = 0;
        boolean[] used;
        Integer[] weights;
         
        initFactorial();
         
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
             
            res = 0;
            sum = 0;
             
            N = Integer.parseInt(br.readLine());
            used = new boolean[N];
            weights = new Integer[N];
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                weights[i] = Integer.parseInt(st.nextToken());
                sum += weights[i];
            }
             
            weighing(weights, used, 0, 0, sum, 0);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
     
    private static void weighing(Integer[] weights, boolean[] used, int left, int right, int sum, int count) {
         
        if(count == weights.length) {
            res++;
            return;
        }

        if(left-right>=sum) {
            int temp = 1;
            for(int i=1;i<=weights.length-count;i++)
               temp*=2;
            for(int i=2;i<=weights.length-count;i++)
               temp*=i;
            res += temp;
            return;
         }
        
        /*
        if(left - right >= sum) {
            // Math.pow는 시간을 많이 잡아먹으니 사용에 주의(정확한 이유는 모르겠음...)
            res += factorial[weights.length - count] * Math.pow(2, weights.length - count);
            return;
        }
        */
        
        for(int i = 0; i < weights.length; i++) {
            if(used[i] == false) {
                used[i] = true;
                weighing(weights, used, left + weights[i], right, sum - weights[i], count + 1);
                 
                if(right + weights[i] <= left)
                    weighing(weights, used, left, right + weights[i], sum - weights[i], count + 1);
                used[i] = false;
            }
        }
    }
     
    private static void  initFactorial() {
        int num = 1;
         
        factorial[0] = 1;
        for(int i = 1; i <= 9; i++) {
            num *= i;
            factorial[i] = num;
        }
    }
}
