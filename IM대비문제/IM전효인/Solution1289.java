/**
 * SWEA 1289. 원재의 메모리 복구하기
 * 
 * 220203
 */
import java.util.Scanner;

public class Solution1289 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 개수
		int T;
		T = sc.nextInt();
		//결과를 담을 배열
		int[] result=new int[T];
		
		for(int i=0;i<T;i++) {
			//원래 메모리 상태 char[]
			char[] str=sc.next().toCharArray();
			//전부 0으로 초기화 된 상태에서 시작하므로 현재 위치는 0
			char now='0';
			//왼쪽부터 읽으면서 다음 애가 지금 애랑 같은지 확인
			for(char c:str) {
				//다음 애가 지금 애랑 다르면 변경해야함
				if(now!=c) {
					now=c;
					result[i]++;
				}
			}
		}
		sc.close();
		
		//출력
		for(int i=0;i<T;i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
	}
}
/*
2
0011
100
*/
/*
10
01010101010101010101010101010101010101010101010101
01
1000110010011111010110000100100000000001001
10011010001110111010111010001100101101
00110101100001010000110010111
101111110101010100111100101111001
01110011110001110
1010101001010101010101010100111111
01010100010100101100111010100010111111011001011000
1111100101101110000
*/
