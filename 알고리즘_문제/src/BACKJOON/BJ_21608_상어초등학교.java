package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class site {
	int r;
	int c;
	
	public site(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BJ_21608_상어초등학교 {
	static int N, score;
	static int[][] map, likeStudent;
	static Queue<Integer> turn;
	static List<site> candidate;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];	// 자리 배치도
		likeStudent = new int[N*N+1][4];	// 좋아하는 학생 리스트
		turn = new LinkedList<Integer>();	// 자리 배치 순서
		
		for (int i = 1; i <= N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			turn.offer(cur);
			for (int j = 0; j < 4; j++) {
				likeStudent[cur][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		placing();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		score = 0;
		scoring();
		
//		System.out.println(score);
	}

	private static void scoring() {
		for (int idx = 1; idx <= N*N; idx++) {
			
			a : for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == idx) {
						int cnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
								for (int k = 0; k < d; k++) {
									if(map[nr][nc] == likeStudent[idx][k]) {
										cnt += 1;
									}
								}
							}
						}
						score += Math.pow(10, cnt);
						break a;
					}
				}
			}
			
			
			
		}
	}

	private static void placing() {
		while(!turn.isEmpty()) {
			int cur = turn.poll();
			System.out.println(cur);
			// 1. 좋아하는 학생이 근접한 자리에 가장 많이 있는 빈 자리
			candidate = new ArrayList<site>();
			checkLike(cur);
			if(candidate.size() == 1) {
				map[candidate.get(0).r][candidate.get(0).c] = cur;
				continue;
			} else if(candidate.size() > 1){
				// 2-1. 1번 조건을 만족하는 자리가 여러 개일 경우 - 후보군 중 근접 빈칸이 가장 많은 자리 선정
				checkBlank(candidate, cur);
			} else {
				// 2-2. 1번 조건을 만족하는 자리가 없을 경우 - 전체 빈 자리 중 근접 빈칸이 가장 많은 자리 선정
				checkBlank(cur);
			}
		}
	}

	private static void checkBlank(int cur) {
		int[][] cntBlank = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if(map[nr][nc] == 0) {
							cntBlank[i][j] += 1;
						}
					}
				}
			}
		}
		
		// 근접 빈칸 최대값 찾기
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && cntBlank[i][j] > max) {
					max = cntBlank[i][j];
				}
			}
		}
		
		// 근접 빈칸이 최대값이면서 빈 자리 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0 && cntBlank[i][j] == max) {
					map[i][j] = cur;
				}
			}
		}
	}

	private static void checkBlank(List<site> list, int cur) {
		int max = 0;
		
		int r = 0;
		int c = 0;
		
		for (int i = 0; i < list.size(); i++) {
			site s = list.get(i);
			
			int cnt = 0;
			
			for (int d = 0; d < 4; d++) {
				int nr = s.r + dr[d];
				int nc = s.c + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] == 0) {
						cnt += 1;
					}
				}
			}
			
			if(cnt > max) {
				max = cnt;
				r = s.r;
				c = s.c;
			}
		}
		
		map[r][c] = cur;
		
	}

	private static void checkLike(int cur) {
		int[][] cntLike = new int[N][N];
		
		// 좋아하는 학생 근접 포인트 체크
		for (int idx = 0; idx < 4; idx++) {
			int likeNum = likeStudent[cur][idx];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == likeNum) {
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							
							if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
								cntLike[nr][nc] += 1;
							}
						}
					}
				}
			}
		}
		
		// 근접된 곳에 좋아하는 학생 수가 가장 많으면서 현재 빈 자리를 후보에 ++
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cntLike[i][j] > max) {
					max = cntLike[i][j];
				}
			}
		}
		
		if(max == 0) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cntLike[i][j] == max && map[i][j] == 0) {
					candidate.add(new site(i, j));
				}
			}
		}
		
	}

}
