package BACKJOON.A231025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

public class Main_21608_상어초등학교 {
	private static int[][] map, satisTable;
	private static HashMap<Integer, ArrayList<Integer>> satisMap;
	private static int N;
	//4방 탐색
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		satisTable = new int[N*N][5];
		satisMap = new HashMap<>();
		int cntStu = N * N;
		
		for (int i = 0; i < cntStu; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				satisTable[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < cntStu; i++) {
			int stuNum = satisTable[i][0];
			ArrayList<Integer> stuLike = new ArrayList<Integer>();
			stuLike.add(satisTable[i][1]);
			stuLike.add(satisTable[i][2]);
			stuLike.add(satisTable[i][3]);
			stuLike.add(satisTable[i][4]);
			satisMap.put(stuNum, stuLike);
		}
		
		for (int i = 0; i < cntStu; i++) {
			int curStu = satisTable[i][0];
			checkLike(i);
		}
		
		System.out.println(carculateSatis());
	}

	private static int carculateSatis() {
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int curNum = map[i][j];
				
				int cnt = 0;
				
				ArrayList<Integer> stuLike = satisMap.get(curNum);
				
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					
					if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if(stuLike.contains(map[nr][nc])) {
							cnt++;
						}
					}
				}
				
				if(cnt == 1) {
					result += 1;
				} else if(cnt == 2) {
					result += 10;
				} else if(cnt == 3) {
					result += 100;
				} else if(cnt ==4) {
					result += 1000;
				}
			}
		}
		
		return result;
		
	}

	private static void checkLike(int idx) {
		ArrayList<Integer> likeList = new ArrayList<Integer>();
		likeList.add(satisTable[idx][1]);
		likeList.add(satisTable[idx][2]);
		likeList.add(satisTable[idx][3]);
		likeList.add(satisTable[idx][4]);
		
		int[][] cntLike = new int[N][N];
		int[][] emptyMap = new int[N][N];
		int max = Integer.MIN_VALUE;
		
		// 좋아하는 학생이 인접칸에 얼마나 있는지 체크
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							// 인접 칸 중 좋아하는 학생 카운트
							if (likeList.contains(map[nr][nc])) {
								cntLike[i][j] += 1;
								// 인접 칸 중 빈 칸 카운트
							} else if (map[nr][nc] == 0) {
								emptyMap[i][j] += 1;
							}
						}
					}
				}
				
				if(cntLike[i][j] > max) {
					max = cntLike[i][j];
				}
			}
		}
		
		// 인접 선호 칸이 가장 많은 자리들
		ArrayList<site> maxList = new ArrayList<site>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(max == cntLike[i][j] && map[i][j] == 0) {
					maxList.add(new site(i,j));
				}
			}
		}
		
		if(maxList.size() > 1) {
			ArrayList<site> maxEmptyList = new ArrayList<site>();
			
			int maxEmpty = Integer.MIN_VALUE;
			
			for (int i = 0; i < maxList.size(); i++) {
				site cur = maxList.get(i);
				
				if(emptyMap[cur.r][cur.c] > maxEmpty) {
					maxEmpty = emptyMap[cur.r][cur.c];
				}
			}
			
			for (int i = 0; i < maxList.size(); i++) {
				site cur = maxList.get(i);
				
				if(emptyMap[cur.r][cur.c] == maxEmpty) {
					map[cur.r][cur.c] = satisTable[idx][0];
					return;
				}
			}
		} else {
			site cur = maxList.get(0);
			
			map[cur.r][cur.c] = satisTable[idx][0];
			return;
		}
		
	}
}
