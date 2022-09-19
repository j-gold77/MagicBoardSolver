public class Position {

    private int row;
    private int column;

    public Position(){
        row = 0;
        column =0;
    }

    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
