package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class dust{
	int x;
	int y;
	int size;
	
	public dust(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
}

public class BJ_17144_미세먼지안녕 {
	static int R, C, T, ans;
	static dust up, down;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		List<dust> dustlist = new ArrayList<dust>();
		Queue<dust> q = new LinkedList<dust>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				map[i][j] = a;
				
				if(a > 0) {
					dustlist.add(new dust(i, j, a/5));
				}
				
				if(a == -1) {
					q.add(new dust(i, j, 0));
				}
			}
		}
		
		up = q.poll();
		down = q.poll();
		
		ans = 0;
		air_cleaning(0, dustlist);
		
		System.out.println(ans);
		
	}

	private static void air_cleaning(int time, List<dust> list) {
		// T초 지난 후 남은 미세먼지 계산 후 종료
		if(time >= T) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) {
						ans += map[i][j];
					}
				}
			}
			return;
		}
		
		// 미세먼지 확산
		for (int i = 0; i < list.size(); i++) {
			dust cur = list.get(i);
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] >= 0) {
					map[nr][nc] += cur.size;
					map[cur.x][cur.y] -= cur.size;
				}
			}
		}
		
		// 공기청정기 on
		// 위 청정기 -> 우 상 좌 하 / 1 0 3 2 (-1)
		up_moving(up.x, up.y+1);
		// 아래 청정기 -> 우 하 좌 상 / 1 2 3 0 (+1)
		down_moving(down.x, down.y+1);
		
		List<dust> newlist = list_checking();
		
		air_cleaning(time+1, newlist);
	}

	private static List<dust> list_checking() {
		List<dust> list = new ArrayList<dust>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) {
					list.add(new dust(i, j, map[i][j]/5));
				}
			}
		}
		
		return list;
	}

	private static void up_moving(int x, int y) {
		int r = x;
		int c = y;
		int temp = map[r][c];
		int temp2 = 0;
		int dir = 1;
		
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr == x && nc == y - 1) {
				break;
			}
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
				dir = (dir + 3) % 4;
				continue;
			}
			
			temp2 = map[nr][nc];
			map[nr][nc] = temp;
			temp = temp2;
			
			r = nr;
			c = nc;
		}
		
		map[x][y] = 0;
		
		return;
	}
	
	private static void down_moving(int x, int y) {
		int r = x;
		int c = y;
		int temp = map[r][c];
		int temp2 = 0;
		int dir = 1;
		
		while(true) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr == x && nc == y - 1) {
				break;
			}
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
				dir = (dir + 1) % 4;
				continue;
			}
			
			temp2 = map[nr][nc];
			map[nr][nc] = temp;
			temp = temp2;
			
			r = nr;
			c = nc;
		}
		
		map[x][y] = 0;
		
		return;
	}

}
