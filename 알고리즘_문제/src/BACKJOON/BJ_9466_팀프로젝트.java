package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9466_팀프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트케이스 수 
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			// 학생의 수 
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] map = new int[n+1];
			
			for (int j = 1; j <= n; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}
		}
	}

}
