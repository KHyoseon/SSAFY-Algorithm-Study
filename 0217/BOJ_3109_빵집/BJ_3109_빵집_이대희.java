package ws0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집_이대희 {
	static int result = 0;
	static int r;
	static int c;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r][c];
		for(int i=0;i<r;i++) {
			String temp = br.readLine();
			for(int j=0;j<c;j++) {
				arr[i][j] = temp.charAt(j);
			}
		}
		for(int i=0;i<r;i++) {
			Search(arr,i,0);
		}
		System.out.println(result);
	}
	public static void Search(char[][] arr, int startr, int startc) {
		if(startc == c-1) {												//반대쪽 끝까지 가는데 성공한경우
			result++;													//결과값을 증가
			arr[startr][startc] = 'x';									//여러번 파이프가 오는것을 막기 위해 x를 찍는다.
			return;
		}
		int temp = result;												//여러 길을 다 가지 않도록 현재 result값을 저장한다.
		arr[startr][startc] = 'x';										//현재 위치를 x로 바꿔준다.
		if(startr-1>=0&&arr[startr-1][startc+1] == '.')					//윗길로 갈수 있다면 윗길로 간다.
			Search(arr, startr-1, startc+1);
		if(arr[startr][startc+1] == '.'&&temp == result)				//가운데길로 갈수있다면 가운데로 간다. 단 윗길로 탐색이 완료됐다면 result값에 변동이 생겼기 때문에 가지 않는다.
			Search(arr, startr, startc+1);
		if(startr+1<r && arr[startr+1][startc+1] == '.'&&temp == result)//아랫길로 갈수 있다면 아랫길로 간다. 단 위/가운데 길로 탐색이 완료됐다면 result값에 변동이 생겼기 때문에 가지 않는다.
			Search(arr, startr+1, startc+1);
		
	}
}
