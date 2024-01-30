package BACKJOON.A231025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class block {
	int r;
	int c;
	
	public block(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}

public class Main_21609_상어중학교 {
	private static int N, M, maxGroupSize, maxGroupRainbow;
	private static int[][] map;
	private static List<block> maxGroup;
	private static boolean[][] blockChecked;
	private static int score;
	//4방
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		score = 0;
		
		while(true) {
			
			maxGroupSize = Integer.MIN_VALUE;
			maxGroupRainbow = Integer.MIN_VALUE;
			maxGroup = new ArrayList<block>();
			blockChecked = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > 0 && !blockChecked[i][j]) {
						getGroup(i,j);
					}
				}
			}
			
			if(maxGroupSize < 2) {
				break;
			}
			
			removeMaxGroup();
			for (int i = N-2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] >= 0) {
						gravity(i,j);
					}
				}
			}
			showMap();
			
			rotate();
			for (int i = N-2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] >= 0) {
						gravity(i,j);
					}
				}
			}
		}
	}

	private static void showMap() {
		System.out.println("=======================================");
		for(int[] a : map) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void rotate() {
		int[][] newmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newmap[i][j] = map[j][N-1-i];
			}
		}
		map = newmap;
	}

	private static void gravity(int r, int c) {
		int color = map[r][c];
		Queue<block> q = new LinkedList<>();
		q.offer(new block(r,c));
		
		while(!q.isEmpty()) {
			block cur = q.poll();
			
			int nr = cur.r + dr[2];
			int nc = cur.c + dc[2];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == -2) {
				q.offer(new block(nr,nc));
				map[cur.r][cur.c] = -2;
				map[nr][nc] = color;
			}
		}
	}

	private static void removeMaxGroup() {
		for (int i = 0; i < maxGroupSize; i++) {
			block cur = maxGroup.get(i);
			
			map[cur.r][cur.c] = -2;
		}
		
		score += maxGroupSize * maxGroupSize;
		
		System.out.println(score);
	}

	private static void getGroup(int i, int j) {
		int color = map[i][j];
		int rainbowCnt = 0;
		Queue<block> q = new LinkedList<block>();
		List<block> group = new ArrayList<block>();
		boolean[][] checked = new boolean[N][N];
		
		q.offer(new block(i,j));
		group.add(new block(i,j));
		checked[i][j] = true;
		
		while(!q.isEmpty()) {
			block cur = q.poll();
			blockChecked[cur.r][cur.c] = true;
			
			for (int k = 0; k < 4; k++) {
				int nr = cur.r + dr[k];
				int nc = cur.c + dc[k];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !checked[nr][nc]) {
					if(map[nr][nc] == color) {
						q.offer(new block(nr,nc));
						group.add(new block(nr,nc));
						checked[nr][nc] = true;
					} else if(map[nr][nc] == 0) {
						q.offer(new block(nr,nc));
						group.add(new block(nr,nc));
						checked[nr][nc] = true;
						rainbowCnt++;
					}
				}
			}
		}
		
		if(group.size() > 1) {
			if(group.size() > maxGroupSize) {
				maxGroupSize = group.size();
				maxGroup = group;
				maxGroupRainbow = rainbowCnt;
			} else if(group.size() == maxGroupSize) {
				if(rainbowCnt >= maxGroupRainbow) {
					maxGroup = group;
				}
			}
		}
	}
}
