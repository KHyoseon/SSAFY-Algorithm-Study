package ws0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1074
public class BJ_1074_Z_이대희 {
	static int cnt = 0;
	static int r;
	static int c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		search((int)Math.pow(2, N),0,0);								//size와 시작r,c값을 보낸다.
	}
	
	private static void search(int size, int startr, int startc) {
		
		if(startr == r && startc == c) {								//divide하다가 r,c값을 찾은 경우
			System.out.println(cnt);									//cnt값을 출력해주고 종료
			return;
		}
		if(r>=startr+size/2) {											//r행 c열이 전체 배열중 어느 위치에 있는지를 파악
			if(c>=startc+size/2) {										//r행 c열이 전체 배열을 4분할한 것 중에서 오른쪽 아래에 있을 경우
				cnt += (size/2)*(size/2)*3;								//나머지 3부분을 다 탐색하고 오기 때문에 해당 size만큼 cnt에 더해준다.
				search(size/2, startr+size/2, startc+size/2);			//오른쪽 아랫부분 부분배열에서 탐색 시작
			}
			else {														//r행 c열이 전체 배열을 4분할한 것 중에서 왼쪽 아래에 있을 경우
				cnt += (size/2)*(size/2)*2;								//왼쪽 위, 오른쪽 위 부분을 탐색하고 오기 때문에 해당 size만큼 cnt에 더해준다.
				search(size/2, startr+size/2, startc);					//왼쪽 아랫부분 부분배열에서 탐색 시작
			}
		}
		else {
			if(c>=startc+size/2) {										//r행 c열이 전체 배열을 4분할한 것 중에서 오른쪽 위에 있을 경우
				cnt += (size/2)*(size/2);								//왼쪽 윗부분을 탐색하고 오기 때문에 해당 size만큼 cnt에 더해준다.
				search(size/2, startr, startc+size/2);					//오른쪽 윗부분 부분배열에서 탐색 시작.
			}
			else {														//r행 c열이 전체 배열을 4분할한 것 중에서 왼쪽 위에 있을 경우
				search(size/2,startr,startc);							//왼쪽 윗부분 부분배열에서 탐색 시작
			}
		}
	}
}
