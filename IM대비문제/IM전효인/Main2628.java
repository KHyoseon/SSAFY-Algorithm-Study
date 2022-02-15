/**
 * 백준 2628. 종이자르기
 * 
 * 220206
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2628 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		//너비 높이
		int W=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		//자르는 횟수
		int N=Integer.parseInt(br.readLine());
		//가로로 자르는 점선 번호 배열
		List<Integer> h=new ArrayList<>();
		h.add(0);
		h.add(H);
		//세로로 자르는 점선 번호 배열
		List<Integer> w=new ArrayList<>();
		w.add(0);
		w.add(W);
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			//0: 가로로 자르기, 1: 세로로 자르기
			int dir=Integer.parseInt(st.nextToken());
			int num=Integer.parseInt(st.nextToken());
			if(dir==0) {
				h.add(num);
			}else {
				w.add(num);
			}
		}
		
		//점선 번호 순서대로 정렬
		Collections.sort(h);
		Collections.sort(w);
		
		//가로 세로 각각 젤 긴 길이 구하기
		int hMax=0;
		int wMax=0;
		for(int i=0;i<h.size()-1;i++) {
			if(h.get(i+1)-h.get(i)>hMax) {
				hMax=h.get(i+1)-h.get(i);
			}
		}
		for(int i=0;i<w.size()-1;i++) {
			if(w.get(i+1)-w.get(i)>wMax) {
				wMax=w.get(i+1)-w.get(i);
			}
		}
		
		//결과 출력
		System.out.println(hMax*wMax);
	}
}
