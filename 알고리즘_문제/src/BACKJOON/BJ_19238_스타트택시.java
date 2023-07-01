package BACKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Taxi {
	int x;
	int y;
	int move;
	
	public Taxi(int x, int y, int move) {
		super();
		this.x = x;
		this.y = y;
		this.move = move;
	}
}

class Passenger {
	int id;
	int sx;
	int sy;
	int ax;
	int ay;
	
	public Passenger(int id, int sx, int sy, int ax, int ay) {
		super();
		this.id = id;
		this.sx = sx;
		this.sy = sy;
		this.ax = ax;
		this.ay = ay;
	}
}

public class BJ_19238_스타트택시 {
	static int N, M, R;
	static Taxi taxi;
	static int[][] map;
	static Passenger taken;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static HashMap<Integer, Passenger> passengers = new HashMap<Integer, Passenger>(); 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		taxi = new Taxi(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int id = i + 2;
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ax = Integer.parseInt(st.nextToken()) - 1;
			int ay = Integer.parseInt(st.nextToken()) - 1;
			
			Passenger p = new Passenger(id, sx, sy, ax, ay);
			
			passengers.put(id, p);
			
			map[sx][sy] = id;
		}
		
		taxing();
	}

	private static void taxing() {
		while(!passengers.isEmpty()) {
			int Fuel = GoToPassenger();
			
			R -= Fuel;
			
			if(R < 0) {
				break;
			}
			
			Fuel = GoToArrival();
			
			R -= Fuel;
			
			if(R < 0) {
				break;
			}
			
			R += Fuel * 2;
			
		}
		
		if(R < 0) {
			System.out.println(-1);
		} else {
			System.out.println(R);
		}
	}

	private static int GoToArrival() {
		Queue<Taxi> q = new LinkedList<Taxi>();
		boolean[][] visited = new boolean[N][N];
		q.add(taxi);
		visited[taxi.x][taxi.y] = true;
		
		Passenger p = passengers.get(taken.id);
		
		int preMove = taxi.move;
		
		while(!q.isEmpty()) {
			Taxi cur = q.poll();
			
			if(R - cur.move < 0) {
				return Integer.MAX_VALUE;
			}
			
			preMove = cur.move;
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					if(nr == p.ax && nc == p.ay) {
						passengers.remove(taken.id);
						taken = null;
						taxi = new Taxi(nr, nc, 0);
						return preMove + 1;
					}
					
					if(map[nr][nc] != 1) {
						q.add(new Taxi(nr, nc, cur.move+1));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}

	private static int GoToPassenger() {
		Queue<Taxi> q = new LinkedList<Taxi>();
		Queue<Passenger> candidates = new LinkedList<Passenger>();
		boolean[][] visited = new boolean[N][N];
		q.add(taxi);
		visited[taxi.x][taxi.y] = true;
		int preMove = taxi.move;
		
		while(!q.isEmpty()) {
			Taxi cur = q.poll();
			
			if(R - cur.move < 0) {
				return Integer.MAX_VALUE;
			}
			
			if(preMove != cur.move && !candidates.isEmpty()) {
				break;
			}
			
			preMove = cur.move;
			
			if(map[cur.x][cur.y] > 1) {
				Passenger p = passengers.get(map[cur.x][cur.y]);
				candidates.add(p);
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cur.x + dr[d];
				int nc = cur.y + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] != 1 && !visited[nr][nc]) {
						q.add(new Taxi(nr, nc, cur.move+1));
						visited[nr][nc] = true;
					}
				}
			}
			
		}
		
		if(candidates.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		
		taken = GetNearest(candidates);
		taxi = new Taxi(taken.sx, taken.sy, 0);
		map[taken.sx][taken.sy] = 0;
		
		return preMove;
	}

	private static Passenger GetNearest(Queue<Passenger> candidates) {
		Passenger target = candidates.poll();
		
		while(!candidates.isEmpty()) {
			Passenger cur = candidates.poll();
			
			if(target.sx > cur.sx) {
				target = cur;
			} else if (target.sx == cur.sx && target.sy > cur.sy) {
				target = cur;
			}
		}
		
		return target;
	}

}
