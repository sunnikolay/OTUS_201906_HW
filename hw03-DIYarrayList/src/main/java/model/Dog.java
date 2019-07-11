package model;

public class Dog extends Animal {

    private int gender;

    public void setGender( int gender ) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return super.toString() + "; Dog Gender: " + this.gender;
    }

}
