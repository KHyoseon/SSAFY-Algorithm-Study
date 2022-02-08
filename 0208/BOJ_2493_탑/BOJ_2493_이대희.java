package algo0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_이대희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];
		Stack<int[]> s = new Stack<int[]>();		//배열로 idx값과 key값을 저장해주는 Stack 생성.
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<T;i++) {					//입력받은 값은 그 앞에 있는 idx의 값이랑만 비교해주면 된다. 그래서 입력받으면서 바로 계산
			int var = Integer.parseInt(st.nextToken());
			
			while(!s.empty()) {					//스택에 값이 존재하는동안
				if(s.peek()[0]>var) {			//stack 맨 위의 값(현재 탑 바로 왼쪽부터 시작된다)이 현재 탑 높이보다 높은 경우
					result[i] = (s.peek()[1])+1;	//result에 탑 위치 기록후 while문을 탈출
					break;
				}
				else							//현재 탑의 높이가 더 높기 때문에 스택에서 pop해서 왼쪽 top을 찾으러 간다.
					s.pop();
			}
			s.push(new int[]{var,i});			//탐색이 끝난 후에 현재 탑위치를 스택에 push
		}
		
		for(int i=0;i<T;i++) {
			System.out.print((result[i])+" ");
		}
	}
}
