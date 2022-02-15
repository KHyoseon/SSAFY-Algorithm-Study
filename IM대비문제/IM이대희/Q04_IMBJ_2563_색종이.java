

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2563	색종이
public class Q04_IMBJ_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] arr = new boolean[101][101];				//도화지 생성
		int result = 0;
		
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {											//색종이 영역을 순서대로 칠하면서, 겹치는 부분은 더하지 않도록 for문 돌리기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int xpos = Integer.parseInt(st.nextToken());				//시작 x값
			int ypos = Integer.parseInt(st.nextToken());				//시작 y값
			
			for(int y=ypos;y<ypos+10;y++) {								//영역을 칠하는과정
				for(int x=xpos;x<xpos+10;x++) {
					if(arr[y][x] == false) {							//영역이 칠해져있지 않았다면, 결과값을 더하고 영역이 칠해져있다는 표시를 해준다.
						result ++;
						arr[y][x] = true;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
