package BOJ0325;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 문제
 * 출발은 상근이네 집, 맥주 한 박스를 들고 출발한다. 20개들이. 50미터에 한 병씩 마신다.
 * 길을 가던 중 편의점에 들러 빈 병은 버리고 새 맥주를 살 수 있는데 20병을 넘을 수 없다.
 * 편의점, 상근이네 집, 락페 좌표가 주어질 때, 상근이와 친구들이 도착할 수 있는지 구하라.
 * 
 * 입력
 * T
 * 편의점 개수 N
 * 다음 N+2개의 줄에는 집, 편의점, 락페 좌표
 * 두 좌표 사이의 거리는 x끼리 뺀 수 + y끼리 뺀 수 이다.
 * 
 * 출력
 * 갈 수 있으면 happy, 맥주가 바닥나면 sad 출력
 */ 
public class Main_S1_9205_맥주마시면서걸어가기 {
    static int N;    
    static int matrix[][];
    static ArrayList<Point> arrList;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        final int MAX = Integer.MAX_VALUE>>1;
        for(int t=0; t<T; t++) {
            N = Integer.parseInt(in.readLine());
            
            arrList = new ArrayList<>();
            matrix = new int[N+2][N+2];
        
            for(int i=0; i<N+2; i++)
                for(int j=0; j<N+2; j++)
                    matrix[i][j]=MAX;
            
            StringTokenizer st;
            
            for(int i=0; i<N+2; i++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                arrList.add(new Point(x,y));
            }
            
            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(i==j)
                        continue;
                    
                    Point current = arrList.get(i);
                    Point next = arrList.get(j);
                    
                    int dist = Math.abs(current.x-next.x)+Math.abs(current.y-next.y);
                    if(dist<=1000)
                        matrix[i][j] = 1;
                }
            }
            //Floyd-Warshall
            for(int k=0; k<N+2; k++) {
                for(int i=0; i<N+2; i++) {
                    for(int j=0; j<N+2; j++) {
                        if(matrix[i][j] > matrix[i][k] + matrix[k][j])
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
            if(0<matrix[0][N+1] && matrix[0][N+1]<MAX)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
}