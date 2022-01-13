package Model;

public class GameService {
    private  GameField gameField;

    public GameService() {
        gameField = new GameField(size 4)
    }

    public void moveLeft() {
        int[][] matrix = gameField.getMatrix();
        shift(matrix);
        merge(matrix);
        shift(matrix);
    }

    public void  moveRight() {
        int[][] matrix = gameField.getMatrix();
        reverse(matrix);
        shift(matrix);
        merge(matrix);
        shift(matrix);
        reverse(matrix);
    }

    public void moveUp() {
        int[][] matrix = gameField.getMatrix();
        transpose(matrix);
        reverse(matrix);
        shift(matrix);
        merge(matrix);
        shift(matrix);
        reverse(matrix);
        transpose(matrix);
    }

    public void moveDown() {
        int[][] matrix = gameField.getMatrix();
        transpose(matrix);
        reverse(matrix);
        shift(matrix);
        merge(matrix);
        shift(matrix);
        reverse(matrix);
        transpose(matrix);
    }

    private void merge(int[][] mateix) {
        for (int row = 0; row < mateix.length; row++) {
            for (int col = 0; col + 1 < mateix[row].length; col++) {
                if (mateix[row][col] > 0 && mateix[row][col + 1] == mateix[row][col]) {
                    mateix[row][col] *= 2;
                    mateix[row][col + 1] = 0;

                }

            }

        }
    }

    private void shift(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int emptyCall = -1;

            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0 && emptyCall == -1) {
                    emptyCall = col;
                }
                if(emptyCall != -1 && matrix[row][col] != 0 ) {
                    matrix[row][emptyCall] = matrix[row][col];
                    matrix[row][col] = 0;
                    col = emptyCall;
                    emptyCall = -1;
                }

            }

        }
    }

    private void transpose(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[row].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;

            }

        }
    }

    private void  reverse(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length / 2; col++) {
                int lastIndex = matrix[col].length - 1;

                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][lastIndex - col];
                matrix[row][lastIndex - col] = temp;

            }

        }
    }

    public void print() {
        for (int[] innerArray : gameField.getMatrix()) {
            for (int element : innerArray) {
                System.out.print(element + " ");

            }
            System.out.println();
        }
    }
}

