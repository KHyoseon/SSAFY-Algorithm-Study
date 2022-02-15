package BOJ.웹엑스수업;

import java.util.Scanner;

public class BOJ_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int three = n/3;        // 3kg로 최대 수
        int five = n/5;         // 5kg로 최대 수
        int result = Integer.MAX_VALUE;

        for(int i=0; i<=three; i++){
            for(int j=0; j<=five; j++){
                if(3*i+5*j == n){
                    result = Math.min(result, i+j);
                }
            }
        }
        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }
}