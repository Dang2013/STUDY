package A0309;

import java.io.*;
import java.util.*;

public class Main_숫자판점프_당현찬_미완성 {

	static int[][] map;
	static int[] select = new int[6];
	static ArrayList<int[]> list = new ArrayList<>();
	
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		map = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				select = new int[6];
				dfs(i, j, 0);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println();
			for (int a : list.get(i)) {
				System.out.print(a);
			}
		}
	}

	private static void dfs(int r, int c, int cnt) {
		if(cnt == 6) {
			// 같지 않은 배열의 수
			int arrCnt = 0;
			for (int i = 0; i < list.size(); i++) {
				// 같지 않은 요소의 수
				int elementCnt = 0;
				for (int j = 0; j < 6; j++) {
					if(list.get(i)[j] != select[j]) {
						elementCnt++;
					}
				}
				// 같지 않은 것이 하나라도 있다면h
				if(elementCnt > 0) {
					// 같지 않은 배열임
					arrCnt++;
				}
			}
			
			// 전체 배열 모두와 다른 배열이라면
			if(arrCnt == list.size()) {
				list.add(select);
			}
			
			return;
		}
		
		select[cnt] = map[r][c];
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 5 && nr >= 0 && nc < 5 && nc >= 0) {
				dfs(nr, nc, cnt+1);
			}
		}
	}

}
