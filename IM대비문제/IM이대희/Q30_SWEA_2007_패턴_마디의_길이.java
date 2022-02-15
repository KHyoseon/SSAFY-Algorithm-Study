import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30_SWEA_2007_패턴_마디의_길이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tNum = 1; tNum <= t; tNum++) {
			sb.append("#").append(tNum).append(" ");
			String str = br.readLine();
			for(int i=1;i<=10;i++) {
				String temp = str.substring(0,i);				//첫문자부터 시작해서 길이가 i인 부분문자열을 생성해서
				boolean trigger = true;
				for(int j=0;j<30/i&&trigger;j++) {				//전체 문자열에 해당 문자열이 반복해서 나타나는지를 파악.
					if(!temp.equals(str.substring(j*i,j*i+i)))
					{
						trigger = false;
						break;
					}
				}
				if(trigger) {									//패턴 마디를 찾은 경우 결과 출력 후 break
					sb.append(i).append("\n");
					break;
				}
			}
		}
		System.out.print(sb.toString());
	}
}
