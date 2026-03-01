class Solution {

    int currX, currY, cnt;
    boolean[][][] visited;

    // d: 0=U, 1=D, 2=R, 3=L
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[] rev = {1, 0, 3, 2}; // 반대방향 매핑

    public int solution(String dirs) {
        currX = 5;
        currY = 5;
        cnt = 0;
        visited = new boolean[11][11][4];

        for (int i = 0; i < dirs.length(); i++) {
            move(dirs.charAt(i));
        }
        return cnt;
    }

    void move(char dir) {
        int d = 0;
        switch (dir) {
            case 'U': d = 0; break;
            case 'D': d = 1; break;
            case 'R': d = 2; break;
            case 'L': d = 3; break;
        }

        int nextX = currX + dx[d];
        int nextY = currY + dy[d];

        if (nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10) return;

        // "출발점에서 d방향으로 간 길"을 체크
        if (!visited[currX][currY][d]) {
            cnt++;
            visited[currX][currY][d] = true;
            visited[nextX][nextY][rev[d]] = true; // 반대방향도 같은 길
        }

        currX = nextX;
        currY = nextY;
    }
}