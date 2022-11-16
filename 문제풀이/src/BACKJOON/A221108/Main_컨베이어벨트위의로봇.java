package BACKJOON.A221108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_컨베이어벨트위의로봇 {

	static int N, K, length;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		length = 2 * N;
		
		belt = new int[length];
		robot = new boolean[length];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 1;
		
		while(true) {
			// 1-1. 벨트 롤링
			int temp = belt[length - 1];
			for (int i = length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;
			// 1-2. 로봇 롤링
			for (int i = N-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			// 1-3. 로봇 내리기
			if(robot[N - 1]) {
				robot[N - 1] = false;
			}
			
			// 2-1. 로봇 이동
			for (int i = N-2; i >= 0; i--) {
				if(robot[i] && !robot[i+1] && belt[i+1] > 0) {
					belt[i+1]--;
					robot[i] = false;
					robot[i+1] = true;
				}
			}
			// 2-2. 로봇 내리기
			if(robot[N - 1]) {
				robot[N - 1] = false;
			}
			
			// 3. 올리는 위치에 내구도가 0이 아니면 로봇 올리기
			if(belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			// 4. 내구도 체크
			int brokenCount = 0;
			for (int i = 0; i < length; i++) {
				if(belt[i] == 0) {
					brokenCount++;
				}
				if(brokenCount >= K) {
					System.out.println(count);
					return;
				}
			}			
			count++;
		}
	}
}
