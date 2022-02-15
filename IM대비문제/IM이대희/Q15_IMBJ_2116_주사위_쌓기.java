

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2116 주사위쌓기
public class Q15_IMBJ_2116_주사위_쌓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int maxResult = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=0;j<6;j++) 
				temp.add(Integer.parseInt(st.nextToken()));
			list.add(temp);
		}
		for(int i=1;i<=6;i++) {
			int tempResult = 0;
			int bottom = 0;
			int top = 0;
			for(int j=0;j<T;j++) {
				if(j == 0)
					bottom = i;
				else
					bottom = top;
				switch(list.get(j).indexOf(bottom)) {
				case 0:
					top = list.get(j).get(5);
					break;
				case 1:
					top = list.get(j).get(3);
					break;
				case 2:
					top = list.get(j).get(4);
					break;
				case 3:
					top = list.get(j).get(1);
					break;
				case 4:
					top = list.get(j).get(2);
					break;
				case 5:
					top = list.get(j).get(0);
					break;
				}
				int tempMax = 0;
				for(int k=0;k<list.get(j).size();k++) {
					if((tempMax < list.get(j).get(k)) && (list.get(j).get(k) != top && list.get(j).get(k) != bottom))
						tempMax = list.get(j).get(k);
				}
				tempResult += tempMax;
			}
			if(tempResult > maxResult)
				maxResult = tempResult;
			
		}
		System.out.println(maxResult);
		
	}
}
