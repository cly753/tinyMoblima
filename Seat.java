package Moblima;

class Seat {
    private Integer row;
    private Integer no;
    private boolean assign;
    //private Integer moviegoerId;
    
    public Seat() {

    }

    public boolean setRow(Integer row) {
        this.row = row;
        return true;
    }
    public Integer getRow() {
        return row;
    }

    public boolean setNo(Integer no) {
        this.no = no;
        return true;
    }
    public Integer getNo() {
        return no;
    }

    public boolean setAssign(boolean assign) {
        this.assign = assign;
        return true;
    }
    public boolean getAssign() {
        return assign;
    }

    // public boolean setMoviegoerId(boolean id) {
    //     this.moviegoerId = id;
    //     return true;
    // }
    // public Integer getMoviegoerId() {
    //     return moviegoerId;
    // }
}
