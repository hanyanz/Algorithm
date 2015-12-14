package com.yanzi.ccf;

import java.util.*;

public class Game {
	public static void main(String[] args) {
	     new Game().run();
	}
	
	public void run() {
		Scanner fin = new Scanner(System.in);
		int R = fin.nextInt();
		int C = fin.nextInt();
		fin.nextLine();
		int[][] board = new int[R + 2][C + 2];
		int rowStart = 0, colStart = 0, rowEnd = 0, colEnd = 0;
		for (int i = 1; i <= R; ++i) {
		    String line = fin.nextLine();
		for (int j = 1; j <= C; ++j) {
		   char c = line.charAt(j - 1);
			switch (c) {
				case '#': break;
				case '-': board[i][j] = 5; break;
				case '|': board[i][j] = 0xA; break;
				case '+':
				case 'S':
				case 'T': board[i][j] = 0xF; break;
				case '.': board[i][j] = 0x8; break;
				default: break;
			}
			if (c == 'S') {
			rowStart = i;
			colStart = j;
			} else if (c == 'T') {
			rowEnd = i;
			colEnd = j;
			}
	      }
	}
	  int[] dr = new int[] {0, -1, 0, 1};
	  int[] dc = new int[] {1, 0, -1, 0};
	// Scan 1: find all cells which can reach T
		boolean[][] visited = new boolean[R + 2][C + 2];
		boolean[][] canReachT = new boolean[R + 2][C + 2];
		initVisited(visited);
		canReachT[rowEnd][colEnd] = true;
		visited[rowEnd][colEnd] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(rowEnd);
		queue.add(colEnd);
		while (!queue.isEmpty()) {
			int r = queue.remove();
			int c = queue.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (visited[nr][nc]) continue;
				if ((board[nr][nc] & (1 << ((i + 2) % 4))) != 0) {
				canReachT[nr][nc] = true;
				queue.add(nr);
				queue.add(nc);
				visited[nr][nc] = true;
				}
			}
		}
		
		if (!canReachT[rowStart][colStart]) {
		System.out.println("I'm stuck!");
		return;
		}
	// Scan 2: get result
	boolean[][] rCanReach = new boolean[R + 2][C + 2];
	initVisited(visited);
	queue.clear();
	visited[rowStart][colStart] = true;
	rCanReach[rowStart][colStart] = true;
	queue.add(rowStart);
	queue.add(colStart);
	while (!queue.isEmpty()) {
		int r = queue.remove();
		int c = queue.remove();
		for (int i = 0; i < 4; ++i) {
			if ((board[r][c] & (1 << i)) == 0) continue;
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (visited[nr][nc]) continue;
			if (board[nr][nc] == 0) continue;
			rCanReach[nr][nc] = true;
			queue.add(nr);
			queue.add(nc);
			visited[nr][nc] = true;
		}
	}
	
	int result = 0;
	for (int i = 1; i <= R; ++i) {
		for (int j = 1; j <= C; ++j) {
		
		if (rCanReach[i][j] && (!canReachT[i][j])) 
			++result;
		}
	}
	System.out.println(result);
 } //endrun()
	
	
	private void initVisited(boolean[][] visited) {
		int R = visited.length - 2;
		int C = visited[0].length - 2;
		for (int i = 0; i <= R + 1; ++i) {
			visited[i][0] = true;
			visited[i][C + 1] = true;
		}
		for (int j = 0; j <= C + 1; ++j) {
			visited[0][j] = true;
			visited[R + 1][j] = true;
		}
		for (int i = 1; i <= R; ++i) {
			for (int j = 1; j <= C; ++j) {
				visited[i][j] = false;
			}
		}
	}
}

