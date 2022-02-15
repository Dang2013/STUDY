package A220207;

import java.io.*;
import java.util.*;

public class Solution_1208_Flatten {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1208.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			
			// 상자 높이를 입력받을 배열
			int[] boxes = new int[100];
			
			// 상자 높이 입력
			for (int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}
			
			// dump 횟수만큼 반복
			for (int i = 0; i < dump; i++) {
				int max = 0;
				int maxIdx = 0;
				int min = 100;
				int minIdx = 0;
				
				// 최대, 최소 찾기
				for(int j = 0; j < 100; j++) {
					if(boxes[j] > max) {
						max = boxes[j];
						maxIdx = j;
					}
					
					if(boxes[j] < min) {
						min = boxes[j];
						minIdx = j;
					}
				}
				
				// 최대값 -1, 최소값 +1
				boxes[maxIdx]--;
				boxes[minIdx]++;
				
			}
			
			int max = 0;
			int min = 100;
			
			// 평탄화 작업 완료 후 최대, 최소값 출력
			for (int i = 0; i < 100; i++) {
				if(boxes[i] > max) {
					max = boxes[i];
				}
				
				if(boxes[i] < min) {
					min = boxes[i];
				}
			}
			
			sb.append("#"+tc+" "+(max-min)+"\n");
			
		}
		
		System.out.println(sb);

	}

}
