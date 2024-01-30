package BACKJOON.A231101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int z;
	
	public Tree(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public int compareTo(Tree o) {
		if (o.z > z) {
			return -1;
		} else if (o.z < z) {
			return 1;
		}
		return 0;
	}
}

public class Main_16235_나무재테크 {
	private static int N, M, K;
	private static int[][] map, A;
	
	private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	private static ArrayList<Tree> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		A = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		list = new ArrayList<Tree>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); 
			
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			
			list.add(new Tree(x, y, z));
		}
		
		for (int k = 0; k < K; k++) {
			Collections.sort(list);
			
			ArrayList<Tree> newList = new ArrayList<Tree>();
			ArrayList<Tree> dieList = new ArrayList<Tree>();
			
			for (int i = 0; i < list.size(); i++) {
				Tree cur = list.get(i);
				
				int x = cur.x;
				int y = cur.y;
				int age = cur.z;
				
				if(map[x][y] >= age) {
					map[x][y] = map[x][y] - age;
					newList.add(new Tree(x, y, (age + 1)));
				} else {
					dieList.add(new Tree(x, y, (age / 2)));
				}
			}
			
			for (int i = 0; i < dieList.size(); i++) {
				Tree cur = dieList.get(i);
				
				int x = cur.x;
				int y = cur.y;
				int age = cur.z;
				
				map[x][y] = map[x][y] + age;
			}
			
			for (int i = 0; i < newList.size(); i++) {
				Tree cur = newList.get(i);
				
				int x = cur.x;
				int y = cur.y;
				int age = cur.z;
				
				if (age % 5 == 0) {
					for (int d = 0; d < 8; d++) {
						int nr = x + dr[d];
						int nc = y + dc[d];
						
						if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
							newList.add(new Tree(nr, nc, 1));
						}
					}
				}
			}
			
			list = (ArrayList<Tree>) newList.clone();
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = map[i][j] + A[i][j];
				}
			}
		}
		
		System.out.println(list.size());
	}
}
