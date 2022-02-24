
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main15686 {
	static int minTotalLen;
	static List<Pos> house;
	static List<Pos> chicken;
	
	static class Pos{
		int r,c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public int calcLen(Pos o) {
			return Math.abs(this.r-o.r)+Math.abs(this.c-o.c);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//도시 크기 한 변, 남겨둘 치킨집 개수
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		//집, 치킨집 리스트
		house=new ArrayList<>();
		chicken=new ArrayList<>();
		
		//도시 정보(0:빈칸, 1:집, 2:치킨집)
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int cur=Integer.parseInt(st.nextToken());
				if(cur==1)
					house.add(new Pos(i,j));
				else if(cur==2)
					chicken.add(new Pos(i,j));
			}
		}

		//남겨둘 치킨집 정하기->도시의 치킨거리 구하기
		minTotalLen=Integer.MAX_VALUE;
		comb(0,0,M,new int[M]);
		
		System.out.println(minTotalLen);
	}
	
	//남겨둘 치킨집 정하기
	public static void comb(int idx,int start,int M,int[] arr) {
		if(idx==M) {
			//도시의 치킨거리 구하기
			calcTotalLen(arr);
			return;
		}
		for(int i=start;i<chicken.size();i++) {
			arr[idx]=i;
			comb(idx+1,i+1,M,arr);
		}
	}
	
	//도시의 치킨거리 구하기
	public static void calcTotalLen(int[] arr) {
		int totalLen=0;
		for(int i=0;i<house.size();i++) {
			int minLen=Integer.MAX_VALUE;
			for(int j=0;j<arr.length;j++) {
				int len=house.get(i).calcLen(chicken.get(arr[j]));
				if(len<minLen) minLen=len;
			}
			totalLen+=minLen;
		}
		if(totalLen<minTotalLen) minTotalLen=totalLen;
	}
}
