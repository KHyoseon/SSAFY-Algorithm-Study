

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2527	직사각형
public class Q08_IMBJ_2527_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseNum;
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][]rect1 = new int[2][2];
			int[][]rect2 = new int[2][2];

			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++)
					rect1[j][k] = Integer.parseInt(st.nextToken());
			}
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++)
					rect2[j][k] = Integer.parseInt(st.nextToken());
			}
			int xcnt=0;
			int ycnt=0;
			for(int j=rect1[0][0];j<=rect1[1][0];j++) {
				if(j>=rect2[0][0]&&j<=rect2[1][0])
					xcnt++;
			}
			for(int j=rect1[0][1];j<=rect1[1][1];j++) {
				if(j>=rect2[0][1]&&j<=rect2[1][1])
					ycnt++;
			}
			if(xcnt==0||ycnt==0)
				caseNum = 4;
			else if(xcnt==1&&ycnt==1)
				caseNum = 3;
			else if(xcnt>1&&ycnt>1)
				caseNum = 1;
			else
				caseNum = 2;
				
			
			switch(caseNum) {
			case 1:
				System.out.println("a");
				break;
			case 2:
				System.out.println("b");
				break;
			case 3:
				System.out.println("c");
				break;
			case 4:
				System.out.println("d");
				break;
			}
		}
		
	}
}
