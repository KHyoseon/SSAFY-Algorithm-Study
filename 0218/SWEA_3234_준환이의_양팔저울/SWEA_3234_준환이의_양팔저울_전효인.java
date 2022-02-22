import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution3234_2 {
	static int[] factorial;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 개수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		//팩토리얼 미리 계산하기(N:1~9)
		factorial=new int[10];
		factorial[0]=1;
		for(int i=1;i<10;i++) {
			factorial[i]=factorial[i-1]*i;
		}
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			//무게추 개수(사용 안함)
//			int N=Integer.parseInt(br.readLine());
			br.readLine();
			//각 무게추 무게
			int[] weight=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			sb.append(find(0,0,weight,0,0,Arrays.stream(weight).sum())).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int find(int idx,int flag,int[] weight,int leftSum,int rightSum,int totalSum) {
		//순열 완료하면 성공
		if(idx==weight.length) 
			return 1;
		//왼쪽 합이 오른쪽 합보다 무조건 커지면 종료(다른 분들 코드 참고해서 추가했어요)
		if(leftSum-rightSum>=totalSum) 
			return (1<<(weight.length-idx))*factorial[weight.length-idx];
		
		int count=0;
		for(int i=0;i<weight.length;i++) {
			if((flag&1<<i)!=0) continue;
			
			//이번 무게추 왼쪽에 추가
			 count+=find(idx+1,flag|1<<i,weight,leftSum+weight[i],rightSum,totalSum-weight[i]);
			//이번 무게추 오른쪽에 추가할 수 있으면 추가
			if(leftSum>=rightSum+weight[i])
				count+=find(idx+1,flag|1<<i,weight,leftSum,rightSum+weight[i],totalSum-weight[i]);
		}
		return count;
	}
}