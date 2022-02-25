package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_경비원 {
	
	static int[] map;
	static int M, N;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 가로 길이
		M = sc.nextInt();
		// 세로 길이
		N = sc.nextInt();
		
		int T = sc.nextInt();
		
		map = new int[2*(N+M)];
		int[][] store = new int[T][2];
		int[] dk = new int[2];
		
		for (int i = 0; i < T; i++) {
			store[i][0] = sc.nextInt();
			store[i][0] = sc.nextInt();
		}
		
		dk[0] = sc.nextInt();
		dk[1] = sc.nextInt();
		
		set1(dk, T+1);
		
		int ans = 0;
		System.out.println(ans);
	}

	private static void set1(int[] inf, int idx) {
		int dir = inf[0];
		int distance = inf[1];
		// 북쪽
		if(dir == 1) {
			map[distance] = idx;
		}
		// 남쪽
		else if(dir == 2) {
			map[M+N+(M-distance)] = idx;
		}
		// 서쪽
		else if(dir == 3) {
			map[(2*M)+N] = idx;
		}
		//동쪽
		else if(dir == 4) {
			map[M+distance] = idx;
		}
	}
}
