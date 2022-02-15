/**
 * 백준 2477. 참외밭
 * 
 * 220212
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2477 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//참외 수 
		int K=Integer.parseInt(br.readLine());
		
		//여섯개 변 0:방향, 1:길이
		int[][] data=new int[6][2];
		//두번 나오는 변 방향 두개 합, 둘 중 하나
		int twiceDir=0;
		int dir=0;
		//방향 별 변 길이(두번 나오는 변 길이는 1로 처리)
		int[] onceLen=new int[5];
		
		//참외밭 육각형 변의 방향, 길이(1~500) 입력받기
		//동1 서2 남3 북4
		StringTokenizer st;
		for(int i=0;i<6;i++) {
			st=new StringTokenizer(br.readLine());
			//각 변의 방향, 길이
			data[i][0]=Integer.parseInt(st.nextToken());
			data[i][1]=Integer.parseInt(st.nextToken());
			
			//한번 나온 방향만 길이 저장
			if(onceLen[data[i][0]]==0) {
				onceLen[data[i][0]]=data[i][1];
			}else {
				//두번 나온 방향은 길이 저장 안하고, 방향만 저장
				onceLen[data[i][0]]=1;
				twiceDir+=data[i][0];
				dir=data[i][0];
			}
		}
		
		//참외밭 넓이에 일단 큰 직사각형 넓이 저장
		int result=1;
		for(int i=1;i<=4;i++) {
			result*=onceLen[i];
		}

		//작은 직사각형 넓이 구해서 빼기
		switch(twiceDir) {
		case 4:	//1->3 ┌
			result-=findSmallArea(1, 3, data);
			break;
		case 5:	//4->1, 3->2
			if(dir==4 || dir==1)	//4->1 └
				result-=findSmallArea(4, 1, data);
			else	//3->2 ┐
				result-=findSmallArea(3, 2, data);
			break;
		case 6:	//2->4 ┘
			result-=findSmallArea(2, 4, data);
			break;
		}
		
		//면적 당 참외 개수 곱해서 결과 출력
		System.out.println(result*K);
	}
	
	//각 육각형 모양마다 작은 직사각형 구성하는 변 순서 정해져 있음
	//그 순서에 맞는 애들 찾아서 작은 직사각형 영역 구하기
	public static int findSmallArea(int first,int second,int[][] data) {
		for(int i=0;i<5;i++) {
			if(data[i][0]==first && data[i+1][0]==second) {
				return data[i][1]*data[i+1][1];
			}
		}
		
		return data[5][1]*data[0][1];
	}
}
