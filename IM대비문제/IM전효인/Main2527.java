/**
 * 백준 2527. 직사각형
 * 
 * 220214
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2527 {
	static class Rectangle{
		int x;
		int y;
		int p;
		int q;
		
		public Rectangle(int x, int y, int p, int q) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트 케이스 개수
		int T=4;
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		//네 줄의 입력 받고, 두 직사각형 공통부분 조사
		for(int t=0;t<T;t++) {
			int[] input=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//첫번째 사각형, 두번째 사각형
			Rectangle r1=new Rectangle(input[0], input[1], input[2], input[3]);
			Rectangle r2=new Rectangle(input[4], input[5], input[6], input[7]);
			
			//각각의 경우 나눠서 두 직사각형의 공통부분 조사
			if(checkD(r1,r2)) {
				//d: 공통 부분 없음
				sb.append("d\n");
			}else if(checkC(r1,r2)) {
				//c: 공통 부분 점
				sb.append("c\n");
			}else if(checkB(r1,r2)) {
				//b: 공통 부분 선분
				sb.append("b\n");
			}else {
				//a: 그 외에는 공통 부분 직사각형
				sb.append("a\n");
			}
		}
		//결과 출력
		System.out.println(sb.toString());
	}
	
	//d: 공통 부분 없음
	public static boolean checkD(Rectangle r1,Rectangle r2) {
		//x축 방향이 안만날때
		if(r1.p<r2.x || r2.p<r1.x) 
			return true;
		//y축 방향이 안만날때
		if(r1.q<r2.y || r2.q<r1.y) 
			return true;
		return false;
	}
	
	//c: 공통 부분 점
	public static boolean checkC(Rectangle r1,Rectangle r2) {
		//두 사각형이 / 방향으로 만날때
		if(r1.p==r2.x && r1.q==r2.y || r2.p==r1.x && r2.q==r1.y) 
			return true;
		//두 사각형이 \ 방향으로 만날때
		if(r1.p==r2.x && r1.y==r2.q || r2.p==r1.x && r2.y==r1.q) 
			return true;
		return false;
	}
	
	//b: 공통 부분 선분
	public static boolean checkB(Rectangle r1,Rectangle r2) {
		//두 사각형이 | 방향으로 만날때
		//y축 방향 체크는 앞에서 checkD, checkC 먼저 호출해서 처리했다고 생각
		if(r1.p==r2.x || r2.p==r1.x) 
			return true;
		//두 사각형이 ㅡ 방향으로 만날때
		//x축 방향 체크는 앞에서 checkD, checkC 먼저 호출해서 처리했다고 생각
		if(r1.q==r2.y || r2.q==r1.y) 
			return true;
		return false;
	}
}
