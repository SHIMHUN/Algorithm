import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 격자의 크기 입력
        scanner.close();

        // 격자를 저장할 배열 생성
        char[][] grid = new char[4*n-3][4*n-3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' '; // 공백 문자로 초기화
            }
        }

        // 격자 채우기
        fillGrid(grid, n, 0);

        // 결과 출력
        for (char[] row : grid) {
            for (char ch : row) {
                System.out.print(ch);
            }
            System.out.println();
        }
        // 결과 출력
//        printGrid(grid);
    }

    // 격자를 채우는 재귀 함수
    public static void fillGrid(char[][] grid, int n, int offset) {
        // 종료 조건: n이 1인 경우, 중심을 별로 채운다
        if (n == 1) {
            grid[offset][offset] = '*';
            return;
        }

        int size = n * 4 - 3; // 현재 격자의 크기

        // 테두리를 별로 채우기
        for (int i = 0; i < size; i++) {
            grid[offset][offset + i] = '*'; // 위쪽
            grid[offset + i][offset] = '*'; // 왼쪽
            grid[offset + size - 1][offset + i] = '*'; // 아래쪽
            grid[offset + i][offset + size - 1] = '*'; // 오른쪽
        }


        // 내부에 대해 재귀적으로 처리
        fillGrid(grid, n - 1, offset + 2);
    }

    public static void drawSquare(char[][] grid, int offset, int size) {
        for (int i = 0; i < size; i++) {
            grid[offset][offset + i] = '*'; // 위쪽
            grid[offset + i][offset] = '*'; // 왼쪽
            grid[offset + size - 1][offset + i] = '*'; // 아래쪽
            grid[offset + i][offset + size - 1] = '*'; // 오른쪽
        }
    }
}
