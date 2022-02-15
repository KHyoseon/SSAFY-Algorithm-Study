import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1074 {
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//2차원 배열 크기: 2^N*2^N (N:1~15)
		int N=Integer.parseInt(st.nextToken());
		//방문 순서 찾아야 하는 (r,c) (r,c:0~2^N)
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		count=0;
		
		//2^N*2^N 배열의 (r,c)의 방문 순서 찾기
		findGroup(r,c,N);
		System.out.println(count);
	}
	
	//2^N*2^N 이차원 배열을 네 그룹으로 나눴을 때, (r,c)의 해당 그룹 찾기
	public static void findGroup(int r,int c,int N) {
		//2x2 크기 그룹 번호까지 정한 후 종료 
		if(N==0) {
			return;
		}
		//2^(N-1)x2^(N-1) 크기의 0~3 네 그룹 중 몇번 그룹인지
		int n=(int)Math.pow(2, N-1);
		int group= r/n*2+c/n;
		
		//그룹번호*2^(N-1)*2^(N-1) 합하기
		count+=group*n*n;
		
		//(r,c)를 그룹 내의 좌표로 바꾸고 한단계 작은 그룹에서 반복
		findGroup(r%n, c%n, N-1);
	}
}
