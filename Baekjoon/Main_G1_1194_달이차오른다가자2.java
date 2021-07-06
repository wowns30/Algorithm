package BOJ0421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main_G1_1194_달이차오른다가자2 {
 
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] dirX = new int[] { 0, 0, -1, 1 };
    public static int[] dirY = new int[] { 1, -1, 0, 0 };
    public static char[][] map;
    public static boolean[][][] visited;
    public static Nodess start;
    public static int N, M;
 
    public static void main(String[] args) throws Exception {
 
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[64][N][M];
 
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0')
                    start = new Nodess(i, j, 0, 0);
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
 
        Queue<Nodess> q = new LinkedList<Nodess>();
        q.offer(new Nodess(start.row, start.col, 0, 0));
        visited[0][start.row][start.col] = true;
 
        while (!q.isEmpty()) {
 
            Nodess node = q.poll();
            int row = node.row;
            int col = node.col;
            int cnt = node.cnt;
            int key = node.key;
 
            if (map[row][col] == '1') {
                return cnt;
            }
            for (int i = 0; i < 4; i++) {
 
                int nr = row + dirX[i];
                int nc = col + dirY[i];
 
                if (isBoundary(nr, nc) && map[nr][nc] != '#' && !visited[key][nr][nc]) {
                    if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
                        visited[key][nr][nc] = true;
                        q.offer(new Nodess(nr, nc, cnt + 1, key));
 
                    } else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
                        int newKey = 1 << (map[nr][nc] - 'a');
                        newKey = newKey | key;
                        if (!visited[newKey][nr][nc]) {
                            visited[key][nr][nc] = true;
                            visited[newKey][nr][nc] = true;
                            q.offer(new Nodess(nr, nc, cnt + 1, newKey));
                        }
 
                    } else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
 
                        int door = 1 << (map[nr][nc] - 'A');
                        if ((key & door) > 0) {
                            visited[key][nr][nc] = true;
                            q.offer(new Nodess(nr, nc, cnt + 1, key));
                        }
                    }
                }
            }
 
        }
        return -1;
    }
    public static boolean isBoundary(int row, int col) {
        return (row >= 0 && row < N) && (col >= 0 && col < M);
    }
}
class Nodess {
 
    int row;
    int col;
    int cnt;
    int key;
 
    public Nodess(int row, int col, int cnt, int key) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
        this.key = key;
    }
 
}