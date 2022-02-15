/**
 * 백준 2491. 수열
 * 
 * 220210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2491 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//수열 길이
		int N=Integer.parseInt(br.readLine());
		//수열
		int[] arr=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//현재 인덱스에서 몇칸째 증가하는 중인지
		int[] incLen=new int[N];
		incLen[0]=1;
		//감소하는 중인지
		int[] decLen=new int[N];
		decLen[0]=1;
		
		for(int i=1;i<N;i++) {
			//현재 인덱스에서 증가하는 중이면 길이 하나 증가 후 저장
			if(arr[i-1]<=arr[i]) {
				incLen[i]=incLen[i-1]+1;
			}else {
				//증가 끊어지면 길이 초기화
				incLen[i]=1;
			}
			
			//감소도 똑같이
			if(arr[i-1]>=arr[i]) {
				decLen[i]=decLen[i-1]+1;
			}else {
				decLen[i]=1;
			}
		}
		
		//각 배열에서 최대값 구해서
		int incMax=Arrays.stream(incLen).max().getAsInt();
		int decMax=Arrays.stream(decLen).max().getAsInt();
		//전체 최대값 구하기
		int max=0;
		if(incMax>decMax) {
			max=incMax;
		}else {
			max=decMax;
		}
		
		//결과 출력
		System.out.println(max);
	}
}
