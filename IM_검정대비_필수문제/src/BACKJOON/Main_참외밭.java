package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_참외밭 {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int[][] map = new int[6][2];
		
		int N = sc.nextInt();
		
		for (int i = 0; i < 6; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
		}
		
		// 전체 너비
		int width = 0;
		// 전체 너비 정보를 가진 인덱스
		int widthIdx = 0;
		
		// 전체 높이
		int height = 0;
		// 전체 높이 정보를 가진 인덱스
		int heightIdx = 0;
		
		for (int i = 0; i < 6; i++) {
			// 전체 너비 구하기
			if(map[i][0] == 1 || map[i][0] == 2) {
				if(map[i][1] >= width) {
					width = map[i][1];
					widthIdx = i;
				}
			}
			// 전체 높이 구하기
			else if(map[i][0] == 3 || map[i][0] == 4) {
				if(map[i][1] >= height) {
					height = map[i][1];
					heightIdx = i;
				}
			}
		}
		
		// 빠질 공간의 너비
		int mWidth = 0;
		// 빠질 공간의 높이
		int mHeight = 0;
		
		// 빠질 공간의 너비는 {전체 너비 - (전체 높이를 가지는 가로의 양 옆 중 작은 수)}
		mWidth = width - (Math.min(map[(heightIdx+1)%6][1], map[heightIdx == 0? 5 : (heightIdx - 1)][1]));
		// 빠질 공간의 높이는 {전체 높이 - (전체 너비를 가지는 세로의 양 옆 중 작은 수)}
		mHeight = height - (Math.min(map[(widthIdx+1)%6][1], map[widthIdx == 0? 5 : (widthIdx - 1)][1]));
		
		// (전체 넓이 - 빠진 넓이 빼기) * 면적 당 참외 수
		int result = ((width * height) - (mWidth * mHeight)) * N;
		
		System.out.println(result);
	}

}
