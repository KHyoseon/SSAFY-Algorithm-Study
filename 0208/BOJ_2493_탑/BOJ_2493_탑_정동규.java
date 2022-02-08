package hw0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Tower{
	private int height;
	private int dep;
	
	public Tower(int height) {
		super();
		this.height = height;
		this.dep = 0;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
}

public class Main_2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = 0, height = 0, cur = 0;
		ArrayList<Tower> list;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>(N + 1);
		list.add(new Tower(100000001));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			height = Integer.parseInt(st.nextToken());
			list.add(new Tower(height));
			cur = i - 1;
			while(list.get(cur).getHeight() < list.get(i).getHeight())
				cur = list.get(cur).getDep();
			list.get(i).setDep(cur);
			sb.append(cur + " ");
		}
		sb.deleteCharAt(sb.lastIndexOf(" "));
		System.out.println(sb);
	}
}
