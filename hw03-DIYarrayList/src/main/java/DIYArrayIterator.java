import java.util.Iterator;

public class DIYArrayIterator implements Iterator {

    private int index = 0;

    private Object[] objects;

    public DIYArrayIterator( Object[] objects ) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public Object next() {
        return objects[ index++ ];
    }

}
