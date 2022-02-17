package hw0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Comp implements Comparator<Substance>{

	@Override
	public int compare(Substance o1, Substance o2) {
		if(o1.max < o2.max) {
			return -1;
		}else if(o1.max > o2.max) {
			return 1;
		}else {
			if(o1.min < o2.min) {
				return -1;
			}else {
				return 1;
			}
		}
	}
}

class Substance{
	int min;
	int max;
	
	public Substance(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

public class JUNGOL_1828_냉장고 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, min = 0, max = 0, count = 1;
		Comp comp = new Comp();
		Substance[] substance;
		
		N = Integer.parseInt(br.readLine());
		substance = new Substance[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			min = Integer.parseInt(st.nextToken());
			max = Integer.parseInt(st.nextToken());
			substance[i] = new Substance(min, max);
		}
		Arrays.sort(substance, comp);
		
		min = substance[0].min;
		max = substance[0].max;
		for(int i = 1; i < substance.length; i++) {
			if(max < substance[i].min) {
				count++;
				min = substance[i].min;
				max = substance[i].max;
			}
		}
		sb.append(count);
		System.out.println(sb);
	}
}
