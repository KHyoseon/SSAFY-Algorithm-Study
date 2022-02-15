

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//https://www.acmicpc.net/problem/2635
public class Q12_IMBJ_2635_수_이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		for(int i=T;i>0;i--) {
			int temp;
			if(cnt == 0) {
				list.add(T);
				cnt++;
				list.add(i);
				cnt++;
			}
			while(true) {
				if(list.get(cnt-2)-list.get(cnt-1)>=0) {
					list.add(list.get(cnt-2)-list.get(cnt-1));
					cnt++;
				}
				else
					break;
			}
			if(cnt>maxList.size()) {
				maxList.clear();
				for(int j=0;j<cnt;j++) {
					maxList.add(list.get(j));
				}
			}
			list.clear();
			cnt = 0;
			
		}
		System.out.println(maxList.size());
		for(int i=0;i<maxList.size();i++)
			System.out.print(maxList.get(i)+" ");
	}
}
