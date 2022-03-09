package A0309;

import java.io.*;
import java.util.*;

public class Main_숫자판점프_당현찬 {

	// 처음에 무작정 ArrayList에 문자열을 넣어 중복되는 수를 제거하며 하였더니 시간초과
	// 그래서 중복을 제거해주는 HashSet 자료구조를 써서 다시 구현.
	
	static int[][] map;
	static HashSet<String> list;
	
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		map = new int[5][5];
		list = new HashSet<String>();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		// 숫자판에서 임의의 시작점이므로 모든 칸을 시작점으로 하여 탐색한다.
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 시작점의 숫자를 문자열에 포함
				String select = "";
				select += map[i][j];
				// (시작점, 현재 자릿수, 만들어진 숫자)
				dfs(i, j, 1, select);
			}
		}
		
		// HashSet에 담겨진 문자열의 개수 출력
		System.out.println(list.size());
	}

	private static void dfs(int r, int c, int cnt, String select) {
		// 여섯자리가 모두 채워지면
		if(cnt == 6) {
			// HashSet에 추가 -> 자동으로 중복 제거
			list.add(select);
			return;
		}
		
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 경계값 내에서만 탐색하면 된다.
			if(nr < 5 && nr >= 0 && nc < 5 && nc >= 0) {
				// 숫자 추가, 자릿수 + 1 하여 이동
				dfs(nr, nc, cnt+1, select+map[nr][nc]);
			}
		}
	}
}
