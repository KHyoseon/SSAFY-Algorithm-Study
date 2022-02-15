

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2628 종이자르기
public class Q14_IMBJ_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int max = 0;
		List<Integer> xlist = new ArrayList<Integer>();
		List<Integer> ylist = new ArrayList<Integer>();
		xlist.add(0);
		xlist.add(x);
		ylist.add(0);
		ylist.add(y);
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());
			int var = Integer.parseInt(st.nextToken());
			if(mode == 0) {
				ylist.add(var);
			}
			if(mode == 1) {
				xlist.add(var);
			}
		}
		
		Collections.sort(xlist);
		Collections.sort(ylist);
		
		int[] xarr = new int[xlist.size()-1];
		int[] yarr = new int[ylist.size()-1];
		for(int i=0;i<xlist.size()-1;i++) 
			xarr[i] = xlist.get(i+1)-xlist.get(i);
		for(int i=0;i<ylist.size()-1;i++)
			yarr[i] = ylist.get(i+1)-ylist.get(i);
		for(int i=0;i<xarr.length;i++) {
			for(int j=0;j<yarr.length;j++) {
				int temp = xarr[i]*yarr[j];
				if(temp > max)
					max = temp;
			}
		}
		System.out.println(max);
	}
}
