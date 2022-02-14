import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo3_구미_5반_전효인 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//관리자 패스워드 최대값(0~1000)
		int N=Integer.parseInt(br.readLine());
		//해커가 사용한 패스워드 개수(1~1000)
		int M=Integer.parseInt(br.readLine());
		//해커가 사용한 M개의 패스워드(0~N)
		int[] hpw=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		//최대 보안성
		int maxCount=0;

		//M개의 해커 패스워드와 0~N을 비교해서 보안성 높은 패스워드 찾기 
		for(int i=0;i<N;i++) {
			//현재 관리자 패스워드에서 최저 보안척도
			int minCount=Integer.MAX_VALUE;
			for(int j=0;j<M;j++) {
				//현재 관리자 패스워드
				int pw=i;
				//현재 해커 패스워드
				int h=hpw[j];
				
				//pw와 h의 보안척도
				int count=0;
				//이진수로 변환해서 보안척도 찾기
				while(pw>0) {
					//pw와 h를 2로 나눈 나머지가 다르면 보안척도 증가
					if(pw%2 != h%2) {
						count++;
					}
					//다음 이진수 자리 보기 위해 2로 나누기
					pw/=2;
					h/=2;
				}
				//최저 보안척도 갱신
				if(count<minCount) {
					minCount=count;
				}
			}
			//최대 보안성 갱신
			if(minCount>maxCount) {
				maxCount=minCount;
			}
		}
		//결과(최대 보안성) 출력
		System.out.println(maxCount);
	}
}
