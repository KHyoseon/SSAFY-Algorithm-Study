import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algo2_구미_5반_전효인 {
	public static void main(String[] args)throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] temp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		//신청한 동아리 수(1~500,000)
		int N=temp[0];
		//팀원 3명 능력 합 가입조건(0~12,000)
		int S=temp[1];
		//개인 능력치 가입조건(0~4,000)
		int M=temp[2];
		
		//가입 가능한 동아리 수
		int count=0;
		//가입한 팀원의 능력치
		List<Integer> result=new ArrayList<>();
		
		//신청한 동아리 팀원 3명의 능력치 입력받기
		for(int i=0;i<N;i++) {
			int[] data=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			//팀원 능력 합
			int sum=Arrays.stream(data).sum();
			//팀원 중 최저 능력치
			int min=Arrays.stream(data).min().getAsInt();
			
			//가입 조건 만족하면...
			if(sum>=S && min>=M) {
				//동아리 수 추가
				count++;
				//가입한 학생들 능력치 추가
				for(int j=0;j<3;j++) {
					result.add(data[j]);
				}
			}
		}
		
		//결과 출력: 가입 가능한 동아리 수 / 가입된 학생들의 능력치
		StringBuilder sb=new StringBuilder();
		sb.append(count).append("\n");
		for(int i=0;i<result.size();i++) {
			sb.append(result.get(i)).append(" ");
		}
		System.out.println(sb.toString());
	}
}
