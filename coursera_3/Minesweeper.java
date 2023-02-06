import java.util.Random;

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        String[][] grid = new String[m][n];
        Random random = new Random();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = "0";
            }
        }


        int minesPlaced = 0;
        while (minesPlaced < k) {
            int row = random.nextInt(m);
            int column = random.nextInt(n);
            if (grid[row][column].equals("0")) {
                grid[row][column] = "*";
                minesPlaced++;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!grid[i][j].equals("*")) {
                    int mineCount = 0;
                    for (int ii = -1; ii <= 1; ii++) {
                        for (int jj = -1; jj <= 1; jj++) {
                            if (ii != 0 || jj != 0) {
                                int rowIndex = i + ii;
                                int columnIndex = j + jj;
                                if (rowIndex >= 0 && rowIndex < m && columnIndex >= 0 && columnIndex < n) {
                                    if (grid[rowIndex][columnIndex].equals("*")) {
                                        mineCount++;
                                    }
                                }
                            }
                        }
                    }
                    grid[i][j] = Integer.toString(mineCount);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
