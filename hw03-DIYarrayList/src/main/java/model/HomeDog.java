package model;

public class HomeDog extends Dog {

    private String name;

    public HomeDog( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "; HomeDog: " + this.name;
    }

}
