package com.moodaye.utils.algorithms.search;

public class BinarySearchTrees {
	public static TreeNode createTree(int[] v) {
		if (v.length == 0) {
			return null;
		}
		TreeNode root = null;
		for (int next : v) {
			addNode(next, root);
		}
		return root;
	}

	static void addNode(int v, TreeNode root) {
		if (root == null) {
			root = new TreeNode(v);
			return;
		}
		if (v <= root.val) {
			addNode(v, root.left);
		} else {
			addNode(v, root.right);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
