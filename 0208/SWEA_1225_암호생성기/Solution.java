/*
SW Academy 풀이 용
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static void pw(Queue<Integer> q){
        int num = 1;
        while(true){
            int target = q.poll() - num;
            if(target<=0) {
                q.offer(0);
                return;
            }
            q.offer(target);
            num++;
            if(num>5){
                num=1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        for(int i=1; i<=t; i++){
            int testNum = Integer.parseInt(in.readLine());
            int[] arr = new int[8];
            int min = 2147483647;
            StringTokenizer st = new StringTokenizer(in.readLine());
            Queue<Integer> q = new LinkedList<>();

            for(int j=0; j<8; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j]<min){
                    min = arr[j];
                }
            }
            for(int j=0; j<8; j++){
                arr[j] -= ((min/15)-1)*15;
                q.offer(arr[j]);
            }

            pw(q);
            System.out.print("#"+testNum+" ");
            for(int p=0; p<8; p++){
                System.out.print(q.poll()+" ");
            }
            System.out.println();
        }
    }
}