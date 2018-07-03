package algorithm.sort;

public class DivideAndConquer {

    private int[][] board;
    private int specialRow;
    private int specialCol;
    private int leftRow;
    private int leftCol;
    private int size;
    private int type = 0;

    public DivideAndConquer(int specialRow, int specialCol, int size) {
        this.specialCol = specialCol;
        this.specialRow = specialRow;
        this.size = size;
        board = new int[size][size];
    }

    private void Chessboard(int specialCol, int specialRow, int leftCol, int leftRow, int size) {
        if (size == 1) {
            return;
        }
        int subSize = size / 2;
        type = type % 4 + 1;
        int n = type;
        //左上
        if (specialRow < leftRow + subSize && specialCol < leftCol + subSize) {
            Chessboard(specialCol, specialRow, leftCol, leftRow, subSize);
        }else {
            board[leftRow + subSize - 1][leftCol + subSize - 1] = n;
            Chessboard(leftCol + subSize - 1, leftRow + subSize - 1,leftCol,leftRow,subSize);
        }
        //右上
        if (specialRow < leftRow + subSize && specialCol >= leftCol + subSize) {
            Chessboard(specialCol,specialRow,leftCol + subSize,leftRow,subSize);
        }else {
            board[leftRow + subSize - 1][leftCol + subSize] = n;
            Chessboard(leftCol + subSize,leftRow + subSize - 1, leftCol + subSize,leftRow,subSize);
        }
        //左下
        if (specialRow >= leftRow + subSize && specialCol < leftCol + subSize) {
            Chessboard(specialCol, specialRow, leftCol, leftRow + subSize, subSize);
        }else {
            board[leftRow + subSize][leftCol + subSize - 1] = n;
            Chessboard(leftCol + subSize - 1,leftRow + subSize,leftCol,leftRow + subSize,subSize);
        }
        //右下
        if (specialRow >= leftRow + subSize && specialCol >= leftCol + subSize) {
            Chessboard(specialCol, specialRow, leftCol + subSize, leftRow + subSize, subSize);
        }else {
            board[leftRow + subSize][leftCol + subSize] = n;
            Chessboard(leftCol + subSize, leftRow + subSize, leftCol + subSize, leftRow + subSize, subSize);
        }
    }
        public void printBoard(int specialRow, int specialCol,int size){
            Chessboard(specialCol, specialRow, leftCol, leftRow, size);
            printResult();
        }

        private void printResult(){
            for (int i = 0; i < size; i++)  {
                for (int j = 0 ;j < size; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

    public static void main(String[] args){
        int N = 2;
        int specialRow = 0;
        int specialCol = 1;
        DivideAndConquer divideAndConquer = new DivideAndConquer(specialRow, specialCol, N);
        divideAndConquer.printBoard(specialRow, specialCol, N);
    }
}
