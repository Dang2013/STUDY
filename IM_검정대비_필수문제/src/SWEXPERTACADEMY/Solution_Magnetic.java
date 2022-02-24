package SWEXPERTACADEMY;

import java.io.*;
import java.util.*;

public class Solution_Magnetic {

	static int N, ans;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			
			// 좌우 (열) 기준으로 다음 상하(행) 처리
			for (int c = 0; c < N; c++) {
				int r = 0;
				while(r < N) {
					boolean isN = false;
					boolean isS = false;
					// N극을 만났을 경우
					if(map[r][c] == 1) {
						// N극을 만났다고 체크
						isN = true;
						// N극을 만난 위치 저장
						int nr = r;
						while(true) {
							// S극 찾기
							if(map[nr][c] == 2) {
								// 찾았다고 체크 후, 종료
								isS = true;
								break;
							}
							// 다음 위치로
							nr++;
							// 경계값 벗어나면 종료
							if(nr >= N) {
								break;
							}
						}
						// N극과 S극을 만나 교착상태임을 확인하면 답 + 1
						if(isS) {
							ans++;
							// 다음 탐색 시작 위치를 S극을 찾은 위치로
							r = nr;
						}
					}
					r++;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
