package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_개미_미완성 {

	// 우, 좌
	static int[] dc = {1, -1};
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		int[] stick = new int[L];
		int[][] ants = new int[N][2];
		
		for (int i = 1; i <= N; i++) {
			int lotation = sc.nextInt();
			
			if(lotation > 0) {
				ants[i][0] = 0;
				ants[i][1] = Math.abs(lotation);
			}else {
				ants[i][0] = 1;
				ants[i][1] = Math.abs(lotation);
			}
			
			stick[ants[i][1]-1] = i;
		}
		
		while(true) {
			
		}
		
		
	}

}
