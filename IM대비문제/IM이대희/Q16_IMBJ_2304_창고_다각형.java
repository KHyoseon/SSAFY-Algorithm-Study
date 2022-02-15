

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2304 창고 다각형
public class Q16_IMBJ_2304_창고_다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;
		int maxx = 0;
		int maxy = 0;
		for(int i=0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(maxy < arr[i][1]) {
				maxx = arr[i][0];
				maxy = arr[i][1];
			}
		}
		Arrays.sort(arr, Comparator.comparingInt(o1->o1[0]));
		
		for(int i=0;i<N;i++) {
			if(arr[i][1] == maxy) {
				if(stack.empty())
					break;
				else {
					result += (arr[i][0]-stack.peek()[0])*stack.peek()[1];
					break;
				}
			}
			else {
				if(stack.empty()) {
					stack.push(arr[i]);
				}
				else {
					if(stack.peek()[1]<arr[i][1]) {
						result += (arr[i][0]-stack.peek()[0])*stack.peek()[1];
						stack.clear();
						stack.push(arr[i]);
					}
				}
			}
		}
		stack.clear();
		
		for(int i=N-1;i>=0;i--) {
			if(arr[i][1] == maxy) {
				if(stack.empty())
					break;
				else {
					result += (stack.peek()[0]-arr[i][0])*stack.peek()[1];
					break;
				}
			}
			else {
				if(stack.empty()) {
					stack.push(arr[i]);
				}
				else {
					if(stack.peek()[1]<arr[i][1]) {
						result += (stack.peek()[0]-arr[i][0])*stack.peek()[1];
						stack.clear();
						stack.push(arr[i]);
					}
				}
			}
		}
		int startPos = -1;
		int endPos = -1;
		for(int i=0;i<N;i++) {

			if(arr[i][1] == maxy) {
				if(startPos == -1) {
					startPos = arr[i][0];
				}
				endPos = arr[i][0];
			}
		}
		result += (endPos-startPos+1)*maxy;
		System.out.println(result);
	}
}
