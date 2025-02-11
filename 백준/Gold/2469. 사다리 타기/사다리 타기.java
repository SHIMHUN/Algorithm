import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int K,N;
    static char[][] ladder;
    static int blankLine;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        
        char [] origin = new char[K];
        for (int i = 0; i < K; i++) {
            origin[i] = (char)('A' + i);
        }
        
        char [] result = br.readLine().toCharArray(); //string으로 받고 for문으로 char배열에 넣었는데 toCharArray() 사용하면 한번에..

        ladder = new char[N][K - 1];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            //?로 채워진 blank 찾아두기
            if (input.charAt(0) == '?') {
                blankLine = i;
                continue;
            }
            ladder[i] = input.toCharArray();
        }


        // 위에서 아래로
        for (int i = 0; i < blankLine; i++) {
            for (int j = 0; j < K - 1; j++) {
                // 가로 막대를 만났을 때 swap
                if (ladder[i][j] == '-') {
                    char tmpChar = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = tmpChar;
                }
            }
        }

        //아래에서 위로
        for (int i = N - 1; i > blankLine; i--) {
            for (int j = 0; j < K - 1; j++) {
                if (ladder[i][j] == '-') {
                    char tmpChar = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = tmpChar;
                }
            }
        }

        //최종 두 결과를 비교
        for (int i = 0; i < K - 1; i++) {
            // 서로 같으면  *
            if (origin[i] == result[i]) {
                sb.append("*");
            }
            // 인덱스 하나 차이라면 가로막대를 놔야하므로 -
            else if (origin[i] == result[i + 1]) {
                sb.append("-");
                // 그대로 진행하면 다음 반복에서 또 가로막대를 놓기 때문에 swap
                char tmpChar = origin[i];
                origin[i] = origin[i + 1];
                origin[i + 1] = tmpChar;
            }
            //2칸 이상 차이나서 swap이 안되는 경우 x로 채우고 리턴
            else {
                sb = new StringBuilder(); //기존 sb 버퍼를 공유하므로 새로운 객체 만들어 초기화 후 출력
                sb.append("x".repeat(K - 1)); //반복하여 채울때 for루프 대신 repeat으로 
                break;
            }
        }
        System.out.print(sb);
    }

}