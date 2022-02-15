import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo2_구미_5반_이대희 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//입력값을 받아들이기 위한 BufferedReader 선언
		StringTokenizer st = new StringTokenizer(br.readLine());		//신청한 동아리의 수, 팀원3명의 능력합 조건, 개인의 능력 조건을 한줄에 입력받아 처리하는 StringTokenizer 선언
		int size = Integer.parseInt(st.nextToken());					//신청한 동아리의 수를 입력받는다.
		int team = Integer.parseInt(st.nextToken());					//팀원3명의 능력합에 대한 가입조건을 입력받는다.
		int indi = Integer.parseInt(st.nextToken());					//개인의 능력 조건을 입력받는다.
		int[][]result = new int[size][3];								//조건을 만족하는 팀을 저장하기 위한 2차원 배열 선언. 최대 신청한 동아리의 수만큼 들어올 수 있으며, 팀원 3명의 능력치를 담는다.
		int[] tempArr=new int[3];										//임시로 팀원의 능력치를 받는 배열. 
		int cnt = 0;													//조건을 만족하는 팀의 숫자를 저장하기 위한 변수 선언.
		for(int i=0;i<size;i++) {										//신청한 동아리의 수만큼 반복문을 돈다.
			boolean isGood = true;										//팀원 개개인이 개인 조건을 만족하는지를 검사하기 위한 boolean변수 선언. 초기상태는 true이다.
			st = new StringTokenizer(br.readLine());					//팀원에 대한 정보를 한줄에 입력받아서 처리해주는 StringTokenizer선언.
			int tempSum = 0;											//팀원의 능력치 합을 구하기 위한 변수 선언. 초기상태는 0이다.
			for(int j=0;j<3&&isGood;j++) {								//팀원 개개인의 능력치를 받아오기 위한 반복문. 입력받는동안 기준미달인 팀원이 있을 경우 반복문을 탈출한다.
				tempArr[j] = Integer.parseInt(st.nextToken());			//개인의 능력치 정보를 가져온다.
				if(tempArr[j]<indi)										//개인의 능력치가 기준미만일경우
					isGood = false;										//더이상 합을 구하지 않고 isGood을 false로 변경한다.
				else													//개인의 능력치가 기준을 만족하는 경우
					tempSum += tempArr[j];								//팀원 능력치 합에 개인의 능력치를 더한다.
			}
			if(isGood && tempSum >=team) {								//개개인의 능력이 기준 이상이면서 팀원 능력치 합도 기준을 만족하는 경우
				for(int j=0;j<3;j++)									//반복문을 통해 팀원의 능력치 정보를 결과에 더해준다.
					result[cnt][j] = tempArr[j];
				cnt++;													//조건을 만족하는 팀원 수를 1 증가 시켜준다.
			}
		}
		System.out.println(cnt);										//조건을 만족하는 팀 수 출력
		for(int i=0;i<cnt;i++) 											//반복문을 통해 조건을 만족하는 팀의 능력치를 순서대로 출력해준다.
			System.out.print(result[i][0]+" "+result[i][1]+" "+result[i][2]+" ");
	}
}
