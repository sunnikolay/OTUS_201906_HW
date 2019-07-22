package calc;

public class Calculator {

    public int add( int x, int y ) {
        return x + y;
    }

    public int sub( int x, int y ) {
        return x - y;
    }

    public void err() throws Exception {
        throw new Exception( "Method err generate exception...." );
    }

}
