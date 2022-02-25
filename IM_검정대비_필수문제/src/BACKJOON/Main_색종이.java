package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_색종이 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 색종이가 붙을 도화지
		boolean[][] paper = new boolean[100][100];
		// 넓이
		int area = 0;
		
		// 색종이의 수
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			// 색종이가 붙은 곳 체크
			for (int x = c; x < c+10; x++) {
				for (int y = r; y < r+10; y++) {
					paper[x][y] = true;
				}
			}
		}
		
		// 색종이가 붙어있다면 Count
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(paper[i][j] == true) {
					area++;
				}
			}
		}
		
		System.out.println(area);
	}

}
