package BACKJOON;

import java.io.*;
import java.util.*;

public class Main_직사각형_미완성 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < 4; tc++) {
			// 1번 직사각형
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			// 2번 직사각형
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();
			
			// 선분만 겹치는 경우 : b
			if((x1 != x4 && y1 == y4) || (x1 == x4 && y2 != y3) || (x2 == x3 && y1 != y4) || (x2 != x3 && y2 == y3)) {
				sb.append("b\n");
			}
			// 점만 겹치는 경우 : c
			else if((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) || (x2 == x3 && y1 == y4) || (x2 == x3 && y2 == y3)) {
				sb.append("c\n");
			}
			// 안 겹치는 경우 : d
			else if(x1 > x4 || x2 < x3 || y1 > y4 || y2 < y3) {
				sb.append("d\n");
			}
			// 직사각형으로 겹치는 경우
			else {
				sb.append("a\n");
			}
		}
		
		System.out.println(sb);
	}

}
