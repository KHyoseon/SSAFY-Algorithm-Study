/**
 * 백준 13300. 방 배정
 * 
 * 220209
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13300 {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//총 학생수
		int N=Integer.parseInt(st.nextToken());
		//한 방 최대 인원수
		int K=Integer.parseInt(st.nextToken());
		//학생 정보 입력받기(행:성별, 열:학년) >> 12개 그룹
		int[][] student=new int[2][6];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int gender=Integer.parseInt(st.nextToken());
			int grade=Integer.parseInt(st.nextToken());
			
			//학년은 1~6이므로 -1 해서 인덱스랑 맞춰주기
			student[gender][--grade]++;
		}
		
		//최소 방 개수 구하기
		int count=0;
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				if(student[i][j]==0)
					continue;
				count+=student[i][j]/K;
				if(student[i][j]%K!=0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
