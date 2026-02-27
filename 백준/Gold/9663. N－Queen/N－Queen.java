import java.io.*;

public class Main {
    static int N;
    static int[] col;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];
        dfs(0); //
        System.out.println(cnt);
    }

    static void dfs(int row){
        //dfs(row+1)이 실행되어야 row == N 조건을 만족
        //여기서 row+1이 되었다는건 해당 열에 놓는게 가능하다는 것을 의미
        //그래서 row+1이 실행되고 나서 다음 루프에서 row==N 검증 로직을 거침
        if(row == N){
            cnt++;
            return;
        }

        //모든 열에 대해서 dfs 시도
        for(int i=0; i<N; i++){
            /*
            * 현재 행에 먼저 값을 넣고 유효한지 체크
            * col[row]를 초기화하지 않아도되는 이유 -> dfs(row+1)이 끝나면 다음 for문에서 col[row] = i로 초기화 됨
            * */
            col[row] = i; //row번째 행 i열에 퀸을 두겠다

            if(isValid(row)){
                dfs(row+1);
            }
        }
    }

    static boolean isValid(int row){ //해당 열에 둘 수 있는지 확인하는 함수
        for(int i=0; i<row; i++){

            if(col[i] == col[row]) return false; //이미 채워진 열
            if(Math.abs(col[i] - col[row]) == Math.abs(i - row)) return false; //열 대각선에 위치
        }

        return true;
    }
}