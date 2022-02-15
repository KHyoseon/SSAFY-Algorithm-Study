

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2564	경비원
public class Q05_IMBJ_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] arr;
		int result = 0;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for(int i=0;i<N;i++) {
			int pos, distance;
			st = new StringTokenizer(br.readLine());
			pos = Integer.parseInt(st.nextToken());
			distance = Integer.parseInt(st.nextToken());
			switch(pos) {
			case 1:
				arr[i][0] = distance;
				arr[i][1] = Y;
				break;
			case 2:
				arr[i][0] = distance;
				arr[i][1] = 0;
				break;
			case 3:
				arr[i][0] = 0;
				arr[i][1] = Y-distance;
				break;
			case 4:
				arr[i][0] = X;
				arr[i][1] = Y-distance;
				break;
			}
		}
		st = new StringTokenizer(br.readLine());
		int pos = Integer.parseInt(st.nextToken());
		int distance = Integer.parseInt(st.nextToken());
		int[] cur = new int[2];
		switch(pos) {
		case 1:
			cur[0] = distance;
			cur[1] = Y;
			break;
		case 2:
			cur[0] = distance;
			cur[1] = 0;
			break;
		case 3:
			cur[0] = 0;
			cur[1] = Y-distance;
			break;
		case 4:
			cur[0] = X;
			cur[1] = Y-distance;
			break;
		}
		for(int i=0;i<N;i++) {
			if(arr[i][1] == cur[1])
				result += arr[i][0]-cur[0] > 0?arr[i][0]-cur[0]:cur[0]-arr[i][0];
			else
				result += arr[i][0]+cur[0] < (X-arr[i][0])+(X-cur[0])?arr[i][0]+cur[0]:(X-arr[i][0])+(X-cur[0]);
			if(arr[i][0] == cur[0])
				result += arr[i][1]-cur[1] > 0?arr[i][1]-cur[1]:cur[1]-arr[i][1];
			else
				result += arr[i][1]+cur[1] < (Y-arr[i][1])+(Y-cur[1])?arr[i][1]+cur[1]:(Y-arr[i][1])+(Y-cur[1]);
		}
		System.out.println(result);
	}
}
