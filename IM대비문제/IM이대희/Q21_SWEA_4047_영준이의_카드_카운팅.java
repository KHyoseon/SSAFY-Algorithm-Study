import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q21_SWEA_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			int[][] arr = new int[4][13];				//0 = S, 1 = D, 2 = H, 3 = C
			String str = br.readLine();
			boolean error = false;
			for(int i=0;i<str.length()/3&&!error;i++) {
				error = false;
				String temp="";
				int var;
				switch(str.charAt(i*3)) {
				case 'S':
					temp = temp+str.charAt((i*3)+1)+str.charAt((i*3)+2);	//카드 뒤의 숫자부분을 가져와서
					var = Integer.parseInt(temp)-1;							//숫자로 변환
					if(arr[0][var] > 0) 									//같은 카드가 2장이상이면
						error = true;										//error를 출력하게끔 한다.
					else
						arr[0][var]++;
					break;
				case 'D':
					temp = temp+str.charAt((i*3)+1)+str.charAt((i*3)+2);
					var = Integer.parseInt(temp)-1;
					if(arr[1][var] > 0) 
						error = true;
					else
						arr[1][var]++;
					break;
				case 'H':
					temp = temp+str.charAt((i*3)+1)+str.charAt((i*3)+2);
					var = Integer.parseInt(temp)-1;
					if(arr[2][var] > 0) 
						error = true;
					else
						arr[2][var]++;
					break;
				case 'C':
					temp = temp+str.charAt((i*3)+1)+str.charAt((i*3)+2);
					var = Integer.parseInt(temp)-1;
					if(arr[3][var] > 0) 
						error = true;
					else
						arr[3][var]++;
					break;
				}
				
			}
			if(error) {								//error인 경우, ERROR출력
				sb.append("ERROR\n");
			}
			else {									//그렇지 않은 경우 각 문자열별로 얼마나 모자란지 출력
				for(int i=0;i<4;i++) {
					int cnt = 0;
					for(int j=0;j<13;j++) {			//카드 없는 경우에 cnt값을 증가시켜준다.
						if(arr[i][j] == 0)
							cnt++;
					}
					sb.append(cnt).append(" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}
