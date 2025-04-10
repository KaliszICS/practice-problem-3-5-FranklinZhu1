public class PracticeProblem {

	public static int dfs(String[][] arr, int r, int c, int moves) {
		if (r < 0 || c > arr[r].length - 1) return 999999; // reached out of array
		if (arr[r][c].equals("F")) return moves; // reached finish
		return Math.min(dfs(arr, r - 1, c, moves + 1), dfs(arr, r, c + 1, moves + 1));
	}

	public static int searchMazeMoves(String[][] arr) {
		/* non dfs way
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				if (arr[i][j].equals("F")) {
					return (arr.length - 1 - i) + j;
				}
			}
		}
		return -1;
		*/

		return dfs(arr, arr.length - 1, 0, 0); // searchMazeMoves could be replaced by dfs if given the same arguments
	}

	public static int nCr(int n, int r) { // for non dfs noOfPaths
		if (r == 0) return 1;
		int num = 1;
		for (int i = 0; i < r; ++i) num *= n - i;
		for (int i = 1; i <= r; ++i) num /= i;
		return num;
	}

	public static int dfsPathCount(String[][] arr, int r, int c) {
		if (r < 0 || c > arr[r].length - 1) return 0; // reached out of array
		if (arr[r][c].equals("F")) return 1; // reached finish
		return dfsPathCount(arr, r - 1, c) + dfsPathCount(arr, r, c + 1);
	}

	public static int noOfPaths(String[][] arr) {
		/* non dfs way
		for (int i = 0; i < arr.length; ++i) {
			for (int j = 0; j < arr[i].length; ++j) {
				if (arr[i][j].equals("F")) {
					return nCr((arr.length - 1 - i) + j, Math.min(arr.length - 1 - i, j));
				}
			}
		}
		return -1;
		*/

		return dfsPathCount(arr, arr.length - 1, 0);
	}
}
