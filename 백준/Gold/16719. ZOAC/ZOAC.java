import java.io.*;

public class Main {
    static boolean[] visited; // 방문 여부 체크
    static String input; // 입력 문자열
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input = br.readLine();
        visited = new boolean[input.length()]; // 방문 여부 배열 초기화

        // 처음 전체 문자열 영역에 대해 재귀 호출
        solve(0, input.length() - 1);

        bw.flush();
        bw.close();
//        br.close();
    }

    // start부터 end까지의 범위에서 처리
    public static void solve(int start, int end) throws IOException {
//        if (start > end) return; // 재귀 종료 조건

        int minCharIndex = -1; // 가장 작은 문자의 인덱스
        char minChar = 'Z' + 1; // 가장 작은 문자

        // 현재 범위에서 가장 작은 문자 탐색
        for (int i = start; i <= end; i++) {
            if (!visited[i] && input.charAt(i) < minChar) {
                minChar = input.charAt(i);
                minCharIndex = i;
            }
        }

        if (minCharIndex == -1) return; // 탐색 실패 시 종료

        // 가장 작은 문자를 방문 처리하고 출력
        visited[minCharIndex] = true;
        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) {
                bw.write(input.charAt(i));
            }
        }
        bw.write("\n");

        // 오른쪽, 왼쪽 부분으로 재귀 호출
        solve(minCharIndex + 1, end); // 오른쪽 부분 처리
        solve(start, minCharIndex - 1); // 왼쪽 부분 처리
    }
}
