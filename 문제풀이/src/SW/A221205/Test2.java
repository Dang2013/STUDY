package SW.A221205;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
	
	public static class home {
		int r, c, distance;

		public home() {
			super();
		}

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		public int getDistance() {
			return distance;
		}

		public void setDistance(int distance) {
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			ArrayList<home> homelist = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				int r, c, distance;
				
				r = sc.nextInt();
				c= sc.nextInt();
				distance = sc.nextInt();
				
				home h = new home();
				
				h.setR(r);
				h.setC(c);
				h.setDistance(distance);
				
				homelist.add(h);
			}
			
		}
	}

}
