package BOJ.웹엑스수업;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1074{

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long r = sc.nextInt();
        long c = sc.nextInt();
        long sideLength = (long)Math.pow(2,n);        // 사각형의 한 변의 길이
        long result = 0;                             // 제 x 사분면일 때 앞에 사각형의 수 : 한 변의 길이^2 X (x-1)/4

        while(sideLength >= 2){
            // (r,c)가 사각형에서 몇 사분면인지 구하기
            if(r < sideLength/2 && c >= sideLength/2){     // 제 1 사분면
                result += sideLength*sideLength/4;
                c -= sideLength/2;
            }
            else if(r < sideLength/2 && c < sideLength/2){     // 제 2 사분면
                result += 0;
            }
            else if(r >= sideLength/2 && c < sideLength/2){     // 제 3 사분면
                result += sideLength*sideLength/2;
                r -= sideLength/2;
            }
            else if(r >= sideLength/2 && c >= sideLength/2){     // 제 4 사분면
                result += sideLength*sideLength*3/4;
                r -= sideLength/2;
                c -= sideLength/2;
            }
            // 다음 사각형(제 x 사분면)의 변의 길이
            sideLength /= 2;
        }
        System.out.println(result);
    }
}