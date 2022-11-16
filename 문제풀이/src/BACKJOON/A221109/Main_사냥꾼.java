package BACKJOON.A221109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class dot implements Comparable<dot>{
	int x;
	int y;
	
	public dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(dot o) {
		return x - o.x;
	}
}

public class Main_사냥꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		List<dot> shootingSite = new ArrayList<>();
		List<dot> animal = new ArrayList<>();
		boolean isHunted[] = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			shootingSite.add(new dot(Integer.parseInt(st.nextToken()), 0));
		}
		
		Collections.sort(shootingSite);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			animal.add(new dot(x, y));
		}
		
		Collections.sort(animal);
		
		int count = 0;
		
		// 사냥
		for (int i = 0; i < shootingSite.size(); i++) {
			dot cur = shootingSite.get(i);
			
			for (int j = 0; j < animal.size(); j++) {
				if(!isHunted[j]) {
					dot curAnimal = animal.get(j);
					
					double width = Math.abs(cur.x - curAnimal.x);
					double deepth = Math.abs(cur.y - curAnimal.y);
					
					double length = Math.sqrt((width * width) + (deepth * deepth));
					
					if(length <= L) {
						isHunted[j] = true;
						count++;
					}					
				}
			}
		}
		
		System.out.println(count);
		
	}

}
