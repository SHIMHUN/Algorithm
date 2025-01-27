import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        int length = s.length();

        boolean[] visited = new boolean[length]; //모든 루프에서 방문 여부를 체크하여 건너뛸지를 결정
        int result = 0;

        for (int i = 0; i < length; i++) {
            if (!visited[i] && s.charAt(i) == 'q') { // 아직 처리되지 않은 q
                if (!findQuack(i, s, visited)) { // 입력순서 잘못됐으면 -1 리턴
                    result = -1;
                    break;
                }
                result++;
            }
        }
        
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                result = -1;
                break;
            }
        }

        writer.write(result + "\n");
        writer.flush();
        writer.close();
    }

    public static boolean findQuack(int idx, String s, boolean[] visited) {
        String quack = "quack";
        int quack_idx = 0;

        for (int i = idx; i < s.length(); i++) {
            if (visited[i]) continue; // 이미 처리된 문자는 건너뜀

            if (s.charAt(i) == quack.charAt(quack_idx)) { // 현재 단계와 일치하는 문자
                visited[i] = true; // 해당 문자를 처리 완료로 표시
                quack_idx++;

                if (quack_idx == 5) { // "quack"을 완성하면 초기화
                    quack_idx = 0;
                }
            }
        }
        
        return quack_idx == 0; //단어가 완성되지 못하여 idx가 1 이상일때 실패
    }
}
