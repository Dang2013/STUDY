package P2605;

import java.io.*;
import java.util.*;

public class Main_줄세우기 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		List<Integer> student = new ArrayList<>();
		student.add(-1);
		for (int i = 1; i <= N; i++) {
			int num = sc.nextInt();
			
			student.add(i-num, i);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(student.get(i)+" ");
		}
	}
}
