import java.io.*;

public class Main {
    static boolean[] visited;
    static String input;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = br.readLine();

        visited = new boolean[input.length()]; // 방문 여부

        solve(0, input.length() - 1);

        bw.flush();
        bw.close();
    }

    public static void solve(int start, int end) throws IOException {

        int minCharIndex = -1; // 가장 작은 문자의 인덱스
        char minChar = 'Z' + 1; // 가장 작은 문자

        //구간 내 가장 작은 문자 탐색
        for (int i = start; i <= end; i++) {
            char c = input.charAt(i);
            if (!visited[i] && c < minChar) {
                minChar = c;
                minCharIndex = i;
            }
        }

        if (minCharIndex == -1) return; //구간 내 가장 작은 문자가 더이상 없으면 종료

        // 가장 작은 문자를 방문 처리
        visited[minCharIndex] = true;
        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) {
                bw.write(input.charAt(i)); //방문한 문자 전부 출력
            }
        }
        bw.write("\n");

        // 오른쪽, 왼쪽 부분으로 재귀 호출
        solve(minCharIndex + 1, end); // 오른쪽 부분 처리
        solve(start, minCharIndex - 1); // 왼쪽 부분 처리
    }
}
