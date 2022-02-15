/**
 * 백준 10158. 개미
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		//가로길이 세로길이
		int C=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		//개미 현재 좌표
		int c=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		
		//계산할 시간
		int T=Integer.parseInt(br.readLine());
		
		//시간%가로길이*2, 세로길이*2 각각 해서 왕복하는 시간 빼기
		//가로 이동 남은 시간
		int tc=T%(2*C);
		//세로 이동 남은 시간
		int tr=T%(2*R);
		
		//가로 이동
		int dir=1;
		for(int i=0;i<tc;i++) {
			int nc=c+dir;
			if(nc<0 || nc>C) {
				dir=dir==1?-1:1;
			}
			c+=dir;
		}
		//세로 이동
		dir=1;
		for(int i=0;i<tr;i++) {
			int nr=r+dir;
			if(nr<0 || nr>R) {
				dir=dir==1?-1:1;
			}
			r+=dir;
		}
		//결과 출력
		System.out.println(c+" "+r);
	}
}
