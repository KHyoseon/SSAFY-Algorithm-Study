

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2477	참외밭
public class Q07_IMBJ_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[6][2];
		int x = 0; 
		int y = 0;
		int minx = 0;
		int miny = 0;
		int maxx = 0;
		int maxy = 0;
		boolean[] param = new boolean[4];
		for(int i=0;i<6;i++)
		{
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int move = Integer.parseInt(st.nextToken());
			switch(direction) {
			case 1:
				x += move;
				arr[i][0] = x;
				arr[i][1] = y;
				break;
			case 2:
				x -= move;
				arr[i][0] = x;
				arr[i][1] = y;
				break;
			case 3:
				y -= move;
				arr[i][0] = x;
				arr[i][1] = y;
				break;
			case 4:
				y += move;
				arr[i][0] = x; 
				arr[i][1] = y;
				break;
			}
			if(arr[i][0] < minx)
				minx = arr[i][0];
			if(arr[i][1] < miny)
				miny = arr[i][1];
			
		}
		for(int i=0;i<6;i++) {
			arr[i][0] += -minx;
			arr[i][1] += -miny;
			if(arr[i][0] > maxx)
				maxx = arr[i][0];
			if(arr[i][1] > maxy)
				maxy = arr[i][1];
		}
		
		Arrays.sort(arr, (o1,o2)->{
			if(o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i=0;i<6;i++) {
			if(arr[i][0] == 0 && arr[i][1] == 0)
				param[0] = true;
			if(arr[i][0] == maxx && arr[i][1] == 0)
				param[1] = true;
			if(arr[i][0] == 0 && arr[i][1] == maxy)
				param[2] = true;
			if(arr[i][0] == maxx && arr[i][1] == maxy)
				param[3] = true;
		}
		int caseint = -1;
		for(int i=0;i<4;i++) {
			if(param[i] == false)
				caseint = i;
		}
		int result;
		switch(caseint) {
		case 0:
			result = ((maxx * maxy)-(arr[2][0]*arr[0][1]))*t;
			System.out.println(result);
			break;
		case 1:
			result = ((maxx * maxy)-(maxx-arr[2][0])*arr[3][1])*t;
			System.out.println(result);
			break;
		case 2:
			result = ((maxx * maxy)-(arr[2][0]*(maxy-arr[2][1])))*t;
			System.out.println(result);
			break;
		case 3:
			result = ((maxx * maxy)-(maxx-arr[2][0])*(maxy-arr[2][1]))*t;
			System.out.println(result);
			break;
		default:
			System.out.println("error");
			break;
		}
		
	}
}
