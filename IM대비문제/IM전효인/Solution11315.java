/**
 * SWEA 11315. 오목 판정
 * 
 * 220211
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution11315 {
	static int N;
	static boolean[][] board;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//테스트케이스 수
		int T=Integer.parseInt(br.readLine());
		//결과 저장할 문자열
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			sb.append("#").append(t).append(" ");
			
			//오목판 한변 길이(5~20)
			N=Integer.parseInt(br.readLine());
			//오목판 이차원 배열: 돌 있으면 true
			board=new boolean[N][N];
			
			//오목판 입력받기
			for(int i=0;i<N;i++) {
				String[] line=br.readLine().split("");
				for(int j=0;j<N;j++) {
					if(line[j].equals("o")) {
						board[i][j]=true;
					}
				}
			}
			
			String result="";
			//모든 칸에서...
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					//현재 칸에 돌이 있으면
					if(board[r][c]) {
						//모든 방향 체크 후 오목이면 YES
						if(checkRow(r,c) || checkCol(r,c) || checkX1(r,c) || checkX2(r,c)) {
							result="YES\n";
						}
					}
				}
			}
			//오목 없으면 NO
			if(result.equals("")) {
				result="NO\n";
			}
			//결과 저장
			sb.append(result);
		}
		//결과 출력
		System.out.println(sb.toString());
	}
	
	//현재 위치 (r,c)에서...
	//가로로 5개 (이상) 있나 체크
	public static boolean checkRow(int r,int c) {
		for(int i=1;i<5;i++) {
			int nr=r+i;
			if(nr>=N) 
				return false;
			if(!board[nr][c])
				return false;
		}
		
		return true;
	}
	
	//세로로 5개 (이상) 있나 체크
	public static boolean checkCol(int r,int c) {
		for(int i=1;i<5;i++) {
			int nc=c+i;
			if(nc>=N)
				return false;
			if(!board[r][nc])
				return false;
		}
		
		return true;
	}
	
	//왼쪽 시작 대각선으로 5개 (이상) 있나 체크
	public static boolean checkX1(int r,int c) {
		for(int i=1;i<5;i++) {
			int nr=r+i;
			int nc=c+i;
			if(nr>=N || nc>=N)
				return false;
			if(!board[nr][nc])
				return false;
		}
		
		return true;
	}
	
	//오른쪽 시작 대각선으로 5개 (이상) 있나 체크
	public static boolean checkX2(int r,int c) {
		for(int i=1;i<5;i++) {
			int nr=r+i;
			int nc=c-i;
			if(nr>=N || nc<0)
				return false;
			if(!board[nr][nc])
				return false;
		}
		
		return true;
	}
	
}
