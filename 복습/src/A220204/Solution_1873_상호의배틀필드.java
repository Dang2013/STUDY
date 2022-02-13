package A220204;

import java.io.*;
import java.util.*;

public class Solution_1873_상호의배틀필드 {
	//상하좌우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 입력받기
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			// 맵 크기 입력받기
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][W];
			
			// 맵 정보 입력받기
			for (int i = 0; i < H; i++) {
				String input = sc.next();
				for (int j = 0; j < W; j++) {
					char c = input.charAt(j);
					map[i][j] = c;
				}
			}
			
			// 명령어 수 입력받기
			int N = sc.nextInt();
			// 명령어 입력받을 배열
			char[] op = new char[N];
			
			// 명령어 입력받기
			String Operation = sc.next();
			for (int i = 0; i < N; i++) {
				op[i] = Operation.charAt(i);
			}
			
			// 명령 수행
			// 1. 전차 위치 찾기
			// 전차 위치 저장할 좌표 값
			int r = 0;
			int c = 0;
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						r = i;
						c = j;
					}
				}
			}
			
			// 2. 명령어 수행
			for (int i = 0; i < N; i++) {
				// 2-1. 명령어 U인 경우
				if(op[i] == 'U') {
					// 경계값 체크 + 평지인지 체크
					int nr = r + dr[0];
					int nc = c + dc[0];
					
					// 경계를 벗어나지 않고 평지라면 이동
					if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.') {
						map[r][c] = '.';
						r = nr;
						c = nc;
						map[r][c] = '^';
					}else {
						map[r][c] = '^';
					}
				}
				// 2-2. 명령어 D인 경우
				else if(op[i] == 'D') {
					// 경계값 체크 + 평지인지 체크
					int nr = r + dr[1];
					int nc = c + dc[1];
					
					// 경계를 벗어나지 않고 평지라면 이동
					if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.') {
						map[r][c] = '.';
						r = nr;
						c = nc;
						map[r][c] = 'v';
					}else {
						map[r][c] = 'v';
					}
				}
				// 2-3. 명령어 L인 경우
				else if(op[i] == 'L') {
					// 경계값 체크 + 평지인지 체크
					int nr = r + dr[2];
					int nc = c + dc[2];
					
					// 경계를 벗어나지 않고 평지라면 이동
					if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.') {
						map[r][c] = '.';
						r = nr;
						c = nc;
						map[r][c] = '<';
					}else {
						map[r][c] = '<';
					}
				}
				// 2-4. 명령어 R인 경우
				else if(op[i] == 'R') {
					// 경계값 체크 + 평지인지 체크
					int nr = r + dr[3];
					int nc = c + dc[3];
					
					// 경계를 벗어나지 않고 평지라면 이동
					if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.') {
						map[r][c] = '.';
						r = nr;
						c = nc;
						map[r][c] = '>';
					}else {
						map[r][c] = '>';
					}
				}
				// 2-5. 명령어 S인 경우
				else {
					// 포탄의 좌표
					int shr = r;
					int shc = c;
					
					// 포탄이 사라졌는 지 여부
					boolean exist = true;
					
					if(map[r][c] == '^') {
						// 포탄이 사라지지 않았다면
						while(exist) {
							int nr = shr + dr[0];
							int nc = shc + dc[0];
							
							// 포탄 경계값 체크 + 포탄 진행 방향에 평지나 물이 있다면
							if(nr < H && nr >= 0 && nc < W && nc >= 0 && (map[nr][nc] == '.' || map[nr][nc] == '-')) {
								// 포탄이 사라지지 않고 그대로 진행
								shr = nr;
								shc = nc;
								exist = true;
							}
							// 포탄 진행 방향에 벽돌 벽이 있다면
							else if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '*') {
								// 벽돌 벽 -> 평지
								map[nr][nc] = '.';
								// 포탄은 사라짐
								exist = false;
							}
							// 포탄 진행 방향에 강철 벽이 있다면
							else {
								// 포탄은 사라짐
								exist = false;
							}
						}
					}
					else if(map[r][c] == 'v') {
						while(exist) {
							int nr = shr + dr[1];
							int nc = shc + dc[1];
							
							if(nr < H && nr >= 0 && nc < W && nc >= 0 && (map[nr][nc] == '.' || map[nr][nc] == '-')) {
								shr = nr;
								shc = nc;
								exist = true;
							}else if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '*') {
								map[nr][nc] = '.';
								exist = false;
							}else {
								exist = false;
							}
						}
					}
					else if(map[r][c] == '<') {
						while(exist) {
							int nr = shr + dr[2];
							int nc = shc + dc[2];
							
							if(nr < H && nr >= 0 && nc < W && nc >= 0 && (map[nr][nc] == '.' || map[nr][nc] == '-')) {
								shr = nr;
								shc = nc;
								exist = true;
							}else if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '*') {
								map[nr][nc] = '.';
								exist = false;
							}else {
								exist = false;
							}
						}
					}
					else if(map[r][c] == '>') {
						while(exist) {
							int nr = shr + dr[3];
							int nc = shc + dc[3];
							
							if(nr < H && nr >= 0 && nc < W && nc >= 0 && (map[nr][nc] == '.' || map[nr][nc] == '-')) {
								shr = nr;
								shc = nc;
								exist = true;
							}else if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '*') {
								map[nr][nc] = '.';
								exist = false;
							}else {
								exist = false;
							}
						}
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
