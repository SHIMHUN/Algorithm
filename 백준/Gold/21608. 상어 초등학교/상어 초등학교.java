import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] visited;
    static int[][] result;
    static int[][] input;

    // 좌 상 우 하 (인접한 4방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[N][N];  // 방문 여부
        result = new int[N][N];   // 자리 배치 결과
        input = new int[N * N][5]; // 학생 정보

        // 학생 및 해당 학생이 좋아하는 학생 입력받기
        for (int i = 0; i < N * N; i++) {
            int[] line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < 5; j++) {
                input[i][j] = line[j];
            }
        }

        // 학생 순서대로 자리 배치
        for (int i = 0; i < N * N; i++) {
            placeStudent(input[i]);
        }

        // 학생 만족도 계산
        System.out.println(calculateSatisfaction());
    }

    // 학생 자리 배치
    public static void placeStudent(int[] line) {
        int maxLike = -1;
        int maxEmpty = -1;
        int resultX = -1, resultY = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) { // 빈 자리 찾기
                    int likeCount = 0, emptyCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < N && y >= 0 && y < N) {
                            if (result[x][y] == 0) {
                                emptyCount++;  // 비어있는 칸 개수
                            } else {
                                for (int z = 1; z < 5; z++) {
                                    if (result[x][y] == line[z]) {
                                        likeCount++; // 좋아하는 학생 카운트
                                    }
                                }
                            }
                        }
                    }

                    // 좋아하는 학생이 더 많은 칸을 우선
                    if (likeCount > maxLike) {
                        maxLike = likeCount;
                        maxEmpty = emptyCount;
                        resultX = i;
                        resultY = j;
                    }
                    // 좋아하는 학생 수가 같다면, 비어있는 칸이 더 많은 곳 우선
                    else if (likeCount == maxLike) {
                        if (emptyCount > maxEmpty) {
                            maxEmpty = emptyCount;
                            resultX = i;
                            resultY = j;
                        }
                        // 비어있는 칸 수도 같다면, 행 번호가 가장 작은 곳 선택
                        else if (emptyCount == maxEmpty) {
                            if (i < resultX || (i == resultX && j < resultY)) {
                                resultX = i;
                                resultY = j;
                            }
                        }
                    }
                }
            }
        }

        // 학생 자리 배치
        result[resultX][resultY] = line[0];
        visited[resultX][resultY] = 1;
    }

    // 만족도 계산
    public static int calculateSatisfaction() {
        int sum = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        // 학생 정보 맵으로 변환
        for (int[] student : input) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < 5; i++) {
                set.add(student[i]);
            }
            map.put(student[0], set);
        }

        // 만족도 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = result[i][j];
                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        if (map.get(student).contains(result[x][y])) {
                            count++;
                        }
                    }
                }

                // 만족도 점수 변환
                if (count > 0) {
                    sum += (int) Math.pow(10, count - 1);
                }
            }
        }

        return sum;
    }
}
