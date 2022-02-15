import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_구미_5반_이대희 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//값을 입력받기 위헤 bufferedreader 선언
		int tc = Integer.parseInt(br.readLine());						//테스트케이스 수를 입력받는다.
		
		for(int i=1;i<=tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	//stringtokenizer를 이용해 한문장으로 입력된 종이컵의 수,간식이 들어있는 종이컵의 위치, 맞바꾸는 횟수를 입력받는다.
			int size = Integer.parseInt(st.nextToken());		//종이컵의 수를 입력받는다.
			int place = Integer.parseInt(st.nextToken());		//간식이 들어있는 종이컵의 위치를 입력받는다.
			int cnt = Integer.parseInt(st.nextToken());			//컵의 위치를 맞바꾸는 횟수를 입력받는다.
			for(int j=0;j<cnt;j++) {							//컵의 위치를 맞바꾸는 횟수만큼 돌아간다.
				st = new StringTokenizer(br.readLine());		//stringtokenizer를 이용해 맞바꾸는 종이컵의 위치를 한문장으로 입력받는다.
				int var1 = Integer.parseInt(st.nextToken());	//맞바꾸는 종이컵의 위치 1
				int var2 = Integer.parseInt(st.nextToken());	//맞바꾸는 종이컵의 위치 2
				if(var1 == place)								//처음 입력받은 위치가 간식이 들어있는 종이컵이었을 경우
					place = var2;								//뒤에 입력받은 위치로 간식이 들어있는 위치를 변경해준다.
				else if(var2 == place)							//뒤에 입력받은 위치가 간식이 들어있는 종이컵이었을 경우
					place = var1;								//처음 입력받은 위치로 간식이 들어있는 위치를 변경해준다.
			}
			System.out.println("#"+i+" "+place);				//컵의 위치를 다바꾸고 난 뒤에 간식이 있는 위치를 출력해준다.
		}
	}
}
