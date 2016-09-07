package com.samoyl.tutorial;

public class QuickFindUF {

	private int[] id;

	/***
	 * set id of each object to itself
	 * (N array accesses)
	 **/
	public QuickFindUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}

	/***
	 * Check whether p and q are in the same component
	 * (2 array accesses)
	 **/
	public boolean connected(int p, int q) {
		boolean answer = id[p] == id[q];
		return answer;
	}

	/***
	 * Change all entries with id[p] to id[q]
	 * (at most 2n + 2 array accesses)
	 **/
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}

	}

}
