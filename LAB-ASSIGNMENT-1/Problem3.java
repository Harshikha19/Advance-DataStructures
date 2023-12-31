public class RatMaze {

	// Size of the maze
	static int N;
	void printSolution(int sol[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(
					" " + sol[i][j] + " ");
			System.out.println();
		}
	}
	boolean isSafe(
		int maze[][], int x, int y)
	{
		// if (x, y outside maze) return false
		return (x >= 0 && x < N && y >= 0
				&& y < N && maze[x][y] == 1);
	}

//If path exist return true else return false
	function prints one of the feasible solutions.*/
	boolean solveMaze(int maze[][])
	{
		int sol[][] = new int[N][N];

        System.out.println("---------- Intermediate Stage---------- ");
		if (solveMazeUtil(maze, 0, 0, sol) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}

        System.out.println("---------- Final Stage----------");
		printSolution(sol);
		return true;
	}

	boolean solveMazeUtil(int maze[][], int x, int y,
						int sol[][])
	{
        printSolution(sol);
        System.out.println("");
		if (x == N - 1 && y == N - 1
			&& maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

		// if maze[x][y] is valid move
		if (isSafe(maze, x, y) == true) {	
			if (sol[x][y] == 1)
				return false;
			
			sol[x][y] = 1;

			if (solveMazeUtil(maze, x + 1, y, sol))
				return true;

			if (solveMazeUtil(maze, x, y + 1, sol))
				return true;
			sol[x][y] = 0;
			return false;
		}

		return false;
	}

	public static void main(String args[])
	{
		RatMaze rat = new RatMaze();
		int maze[][] = { { 1, 0, 0, 0 },
						{ 1, 1, 0, 1 },
						{ 0, 1, 0, 0 },
						{ 1, 1, 1, 1 } };

		N = maze.length;
        System.out.println("---------- Initial Stage----------");
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(
					" " + maze[i][j] + " ");
			System.out.println();
		}
		rat.solveMaze(maze);
	}
}
