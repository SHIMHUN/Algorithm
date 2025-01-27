import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        int length = s.length();

        boolean[] visited = new boolean[length]; // 문자의 처리 여부를 기록
        int result = 0;

        for (int i = 0; i < length; i++) {
            if (!visited[i] && s.charAt(i) == 'q') { // 아직 처리되지 않은 'q'를 만났을 때
                if (!findQuack(i, s, visited)) { // 잘못된 입력이면 -1
                    result = -1;
                    break;
                }
                result++; // 한 마리의 오리를 처리
            }
        }

        // 모든 문자가 처리되었는지 확인
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
        int quackIdx = 0;

        for (int i = idx; i < s.length(); i++) {
            if (visited[i]) continue; // 이미 처리된 문자는 건너뜀

            if (s.charAt(i) == quack.charAt(quackIdx)) { // 현재 단계와 일치하는 문자
                visited[i] = true; // 해당 문자를 처리 완료로 표시
                quackIdx++;

                if (quackIdx == 5) { // "quack"을 완성하면 초기화
                    quackIdx = 0;
                }
            }
        }

        // "quack"이 완전히 매칭되지 못한 경우
        return quackIdx == 0;
    }
}
