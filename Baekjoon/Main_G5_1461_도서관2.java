package BOJ0511;

import java.util.*;
import java.io.*;

public class Main_G5_1461_도서관2{
    static int n, m;
    static int ans = 0;
    static LinkedList<Integer> x = new LinkedList<>(); // 양수 좌표 저장
    static LinkedList<Integer> y = new LinkedList<>(); // 음수 좌표 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > 0)
                x.add(tmp); 
            else
                y.add(-tmp); // 음수인 경우 (-)를 붙여 양수 형식으로 저장
        }

        Collections.sort(x, Collections.reverseOrder()); //내림차순으로 정렬
        Collections.sort(y, Collections.reverseOrder());

        if (!x.isEmpty() && !y.isEmpty()) { // x와 y 모두 한 개 이상의 값이 있는 경우
            if (x.peek() > y.peek()) { // x의 0번째 인덱스 값이 y의 0번째 인덱스 값보다 큰 경우
                ans += x.poll(); // 가장 먼 거리는 다시 원점에 올 필요가 없으므로 편도 거리만 
                for (int i = 0; i < m - 1; i++)
                    x.poll();
            }
            else {
                ans += y.poll();
                for (int i = 0; i < m - 1; i++)
                    y.poll();
            }
        }
        else {
            if (x.isEmpty() && !y.isEmpty()) { // x에는 값이 없고 y에만 값이 있는 경우
                ans += y.poll();
                for (int i = 0; i < m - 1;i++)
                    y.poll();
            }
            else if (!x.isEmpty() && y.isEmpty()) { // x에는 값이 있고 y에는 값이 없는 경우
                ans += x.poll();
                for (int i = 0; i < m - 1;i++)
                    x.poll();
            }
        }

        while (x.size() > 0) { // x가 모두 비워질 때까지
            ans += (x.poll() * 2); //  원점부터 좌표까지의 왕복 거리 계산
            for (int i = 0; i < m - 1; i++) // 이 책들은 위에서 poll()한 좌표에 가면서 가져다 놓을 책들. 따라서 거리 계산에 포함하지 않음
                x.poll();
        }
        while (y.size() > 0) { // y가 모두 비워질 때까지
            ans += (y.poll() * 2); // 왕복 거리 계산
            for (int i = 0; i < m - 1; i++)
                y.poll();
        }

        System.out.println(ans);
    }
}