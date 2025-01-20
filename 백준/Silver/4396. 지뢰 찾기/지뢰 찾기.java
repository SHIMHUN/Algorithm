import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 입력받기
        char[][] originalGrid = new char[n][n]; // 지뢰 위치
        char[][] transformedGrid = new char[n][n]; // 플레이어가 연 칸
        char[][] resultGrid = new char[n][n]; // 최종 출력 결과

        // 지뢰 위치 입력
        for (int i = 0; i < n; i++) {
            originalGrid[i] = scanner.nextLine().toCharArray();
        }

        // 플레이어가 연 칸 입력
        for (int i = 0; i < n; i++) {
            transformedGrid[i] = scanner.nextLine().toCharArray();
        }

        // 결과 배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultGrid[i][j] = '.'; // 기본 값으로 초기화
            }
        }

        boolean isGameOver = false;

        // 변환된 grid 처리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (transformedGrid[i][j] == 'x') { // 클릭한 칸
                    if (originalGrid[i][j] == '*') { // 지뢰를 클릭한 경우
                        isGameOver = true; // 게임 종료 조건
                    } else {
                        // 주변 지뢰 개수를 계산하여 표시
                        resultGrid[i][j] = (char) (countMines(i, j, n, originalGrid) + '0');
                    }
                }
            }
        }

        // 게임 종료 시 모든 지뢰 표시
        if (isGameOver) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (originalGrid[i][j] == '*') {
                        resultGrid[i][j] = '*';
                    }
                }
            }
        }

        // 결과 출력
        for (char[] row : resultGrid) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }

        scanner.close();
    }

    // 주변 8칸의 지뢰 개수를 세는 함수
    public static int countMines(int x, int y, int n, char[][] grid) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }
}
