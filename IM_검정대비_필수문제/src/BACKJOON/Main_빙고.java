package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_빙고 {

	static int[][] map = new int[5][5];
	static int ans = 0;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 사회자가 번호 부르기
		for (int i = 0; i < 25; i++) {
			int num = sc.nextInt();
			// 횟수 카운트
			ans++;
			
			// 부른 번호 빙고판에 체크
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if(map[r][c] == num) {
						map[r][c] = -1;
						
						// 가로 세로 대각선 체크 후 빙고Count가 3 이상이면
						if (check(r, c) >= 3) {
							// 횟수 출력 후 반복 종료
							System.out.println(ans);
							return;
						}
					}
				}
			}
		}
	}
	
	// 가로 세로 대각선 체크
	static int check(int r, int c) {
		// 빙고 줄 개수
		int cnt = 0;
		
		// 가로 체크
		for (int i = 0; i < 5; i++) {
			int cntR = 0;
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == -1) {
					cntR++;
				}
			}
			if(cntR == 5) {
					cnt++;
			}
		}
		
		// 세로 체크
		for (int i = 0; i < 5; i++) {
			int cntC = 0;
			for (int j = 0; j < 5; j++) {
				if(map[j][i] == -1) {
					cntC++;
				}
			}
			if(cntC == 5) {
					cnt++;
			}
		}
		
		// 대각선 체크
		int cntD = 0;
		for (int i = 0; i < 5; i++) {
			if(map[i][i] == -1) {
				cntD++;
			}
		}
		if(cntD == 5) {
			cnt++;
		}
		
		cntD = 0;
		for (int i = 0; i < 5; i++) {
			if(map[4-i][i] == -1) {
				cntD++;
			}
		}
		if(cntD == 5) {
			cnt++;
		}
		
		return cnt;
	}
}
