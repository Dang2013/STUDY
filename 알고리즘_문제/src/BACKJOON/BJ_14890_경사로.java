package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14890_경사로 {
	static int N, L;
	static int[][] map;
	static boolean isOk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			if(check(i, 0)) {
				ans++;
			}
			
			if(check(i, 1)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean check(int idx, int rc) {
		boolean[] visited = new boolean[N];
		int[] height = new int[N];
		
		for (int i = 0; i < N; i++) {
			if(rc == 0) {
				height[i] = map[idx][i];
			} else {
				height[i] = map[i][idx];
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			if(height[i] == height[i+1]) {
				continue;
			}
			
			if(Math.abs(height[i] - height[i+1]) > 1) {
				return false;
			}
			
			if(height[i] - height[i+1] == 1) {
				for (int j = i+1; j <= i+L; j++) {
					if(j >= N || height[i+1] != height[j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			} else if(height[i] - height[i+1] == -1) {
				for(int j = i; j > i-L; j--) {
					if(j < 0 || height[i] != height[j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			}
		}
		
		return true;
	}

}
