package model;

public class HomeCat extends Cat {

    private String name;

    public HomeCat( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
