import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = reader.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        // 기차 배열 초기화
        int[][] arr = new int[N + 1][21];

        // 명령 처리
        for (int i = 0; i < M; i++) {
            String[] line = reader.readLine().split(" ");
            int train = Integer.parseInt(line[1]);

            switch (line[0]) {
                case "1": // 승차
                    int seatToBoard = Integer.parseInt(line[2]);
                    arr[train][seatToBoard] = 1;
                    break;
                case "2": // 하차
                    int seatToLeave = Integer.parseInt(line[2]);
                    arr[train][seatToLeave] = 0;
                    break;
                case "3": // 뒤로 이동
                    for (int j = 20; j > 1; j--) { // 20번 칸까지 뒤로 이동
                        arr[train][j] = arr[train][j - 1];
                    }
                    arr[train][1] = 0; // 1번 좌석은 빈 상태
                    break;
                case "4": // 앞으로 이동
                    for (int j = 1; j < 20; j++) { // 1번 칸부터 앞으로 이동
                        arr[train][j] = arr[train][j + 1];
                    }
                    arr[train][20] = 0; // 20번 좌석은 빈 상태
                    break;
                default:
                    // 잘못된 명령어는 무시
                    break;
            }
        }

        // 중복된 상태 제거
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) { // 좌석 상태만 문자열로 변환
                sb.append(arr[i][j]);
            }
            set.add(sb.toString()); // 중복된 배열 상태 제거
        }

        // 결과 출력
        writer.write(set.size() + "\n");
        writer.flush();
        writer.close();
    }
}
