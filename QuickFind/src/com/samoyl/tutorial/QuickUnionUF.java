package com.samoyl.tutorial;

public class QuickUnionUF {

	public int[] id;
	public int[] sz;

	/***
	 * set id of each object to itself (N array accesses)
	 **/
	public QuickUnionUF(int n) {
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	/***
	 * Chase parent pointers until reach root (depth of i array accesses)
	 **/
	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	/***
	 * Check if p and q have same root (depth of p and q array accesses)
	 **/
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}

	/***
	 * Change root of p to point to root of q (depth of p and q array accesses)
	 **/
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) {
			return;
		}
		if (sz[i] == sz[j]) {
			if (id[i] < id[j]) {
				id[i] = j;
				sz[j] += sz[i];
			} else {
				id[j] = i;
				sz[i] += sz[j];
			}
			return;
		}

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}
