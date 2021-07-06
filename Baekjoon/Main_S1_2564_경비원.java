package IMPrepare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 문제
 * 직사각형 모양의 블록으로 블록을 가로질러 차가 통과할 수 없다. = 블록의 둘레를 따라 움직일 수 있다.
 * 이 때, 무인 경비를 의뢰한 상점까지의 최단 거리들을 모두 합한 값을 구하는 프로그램을 만들어라.
 * 
 * 입력
 * 첫째 줄에는 블록의 가로,세로의 길이가 주어진다. (가로+세로)*2 = 둘레의 길이
 * 
 * 둘째 줄에는 상점의 개수 N (1~100)
 * 
 * 셋째 줄부터 한 줄에 하나씩 상점의 위치 = 두 개의 자연수
 * 첫번째 수는 방향 북1,남2,서3,동4
 * 두번째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리 = x좌표,
 * 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리 = y
 * 
 * 마지막 줄에는 동근이의 위치가 상점의 위치와 동일한 방식으로 주어짐
 * 이때, 상점이나 동근이는 블록의 꼭짓점이 될 수 없다.
 * 
 * 출력 : 동근이와 각 상점 사이의 최단 거리들의 합
 * 
 * 풀이
 * 동근이와 상점 사이의 거리를 구하기 위한 코드 구현
 * 만약 동근이와 상점 사이의 거리를 구했을 때 그 값이 둘레의 절반과 같거나 작으면 최단거리로 인정,
 * 아닐 경우 둘레에서 빼주면 그 값이 최단거리가 된다.
 *
 */ 
public class Main_S1_2564_경비원 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int width = Integer.parseInt(st.nextToken());//가로
        int height = Integer.parseInt(st.nextToken());//세로
        int store = Integer.parseInt(br.readLine());//상점의 수
        int[] point = new int[store + 1];//상점의수+1 크기 만큼의 배열 생성
        
        for (int i = 0; i <= store; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken()); //상점의 방향
            int value = Integer.parseInt(st.nextToken()); //상점의 거리
            switch (direction) {
            case 1://방향이 북쪽이면
                point[i] = value;
                break;
            case 2://방향이 남쪽이면
                point[i] = 2 * width + height - value;
                break;
            case 3://방향이 서쪽이면
                point[i] = 2 * (width + height) - value;
                break;
            case 4://방향이 동쪽이면
                point[i] = width + value;
                break;
            }
        }
 
        int sum = 0;
        for (int i = 0; i < store; i++) {
            int temp = Math.abs(point[store] - point[i]);
            sum += (temp > (width + height)) ? 2 * (width + height) - temp : temp;
        }
        System.out.println(sum);
    }
}