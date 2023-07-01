package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴 {
	static int[][] gear;
	static int K;
	static int[] dir;	// 회전 정보 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 톱니바퀴 정보 저장 
		gear = new int[4][8];
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 톱니바퀴 회전
		K = Integer.parseInt(br.readLine());
		
		while(K > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			dir = new int[4];
			
			dir[num] = d;
			// 톱니바퀴 회전 여부 체크 
			checkdir(num);
			// 회전 여부, 방향에 맞게 회전 
			rotate();
			
			K--;
		}
		
		// 회전 후 점수 계산
		int ans = 0;
		if(gear[0][0] == 1) ans += 1;
		if(gear[1][0] == 1) ans += 2;
		if(gear[2][0] == 1) ans += 4;
		if(gear[3][0] == 1) ans += 8;
		
		System.out.println(ans);
		
	}

	private static void checkdir(int num) {
		// 회전 톱니바퀴 기준 왼쪽 방향
		for (int i = num-1; i >= 0; i--) {
			if(gear[i][2] != gear[i+1][6]) {
				dir[i] = -dir[i+1];
			} else {
				break;
			}
		}
		// 회전 톱니바퀴 기준 오른쪽 방향 
		for (int i = num+1; i < 4; i++) {
			if(gear[i][6] != gear[i-1][2]) {
				dir[i] = -dir[i-1];
			} else {
				break;
			}
		}
	}
	
	private static void rotate() {
		for (int i = 0; i < 4; i++) {
			// 1. 회전방향 : 시계방향 
			if(dir[i] == 1) {
				int temp = gear[i][7];
				for (int j = 7; j > 0; j--) {
					gear[i][j] = gear[i][j-1];
				}
				gear[i][0] = temp;
			}
			// 2. 회전방향 : 반시계방향 
			else if(dir[i] == -1) {
				int temp = gear[i][0];
				for (int j = 0; j < 7; j++) {
					gear[i][j] = gear[i][j+1];
				}
				gear[i][7] = temp;
			}
		}
	}

}
