import java.io.*;

public class Main {
    static int[][] square;
    static int white=0, blue=0;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];

        // 초기 2차원 배열 세팅
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(s[j]);
                square[i][j] = num;
            }
        }

        check(0, 0, N);
        System.out.println(white + "\n" + blue);
    }

    public static void check(int x, int y, int n){

        boolean isSame = true;
        int color = square[x][y]; // 시작 원소를 기준점으로 잡는다
        
        loop:
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(square[i][j] != color){
                    isSame=false;
                    break loop;
                }
            }
        }

        if(isSame == true){
            if(color == 1){
                blue++;
            }else{
                white++;
            }
            return;
        }

        n /= 2;

        check(x, y, n);
        check(x+n, y, n);
        check(x, y+n, n);
        check(x+n, y+n, n);
    }
}