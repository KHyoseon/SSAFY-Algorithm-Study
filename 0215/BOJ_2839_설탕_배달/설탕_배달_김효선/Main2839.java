package ws0215;
import java.util.Scanner;

public class Main2839{
    public static int three[] = new int[5001];
    public static int five[] = new int[5001];

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        buildUP(N);
        System.out.println(P(N));
    }

    public static void buildUP(int N){
        three[3]=1; five[3]=0;
        three[4]=-1; five[4]=-1;
        three[5]=0; five[5]=1;

        for(int i=5; i<N; i++){
            if(three[i]==-1){
                three[i+1] = three[i-1] -1;
                five[i+1] = five[i-1] + 1;
            }
            else if(three[i]>=3){
                three[i+1] = three[i] -3;
                five[i+1] = five[i] + 2;
            }
            else if (five[i] >= 1){
                five[i+1] = five[i] - 1;
                three[i+1] = three[i] + 2;
            }
            else{
                three[i+1] = -1;
                five[i+1] = -1;
            }
        }
    }

    public static int P(int N){
        if(three[N]==-1)
            return -1;
        else
            return five[N] + three[N];
    }
}