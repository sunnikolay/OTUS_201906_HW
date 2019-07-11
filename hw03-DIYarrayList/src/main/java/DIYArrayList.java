import java.util.*;

public class DIYArrayList<T> extends AbstractList<T> implements List<T> {

    private final int INIT_SIZE = 15;
    private Object[] objects = new Object[ INIT_SIZE ];
    private int pointer = 0;

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return ( pointer == 0 ) ? true : false;
    }

    @Override
    public boolean contains( Object o ) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[ 0 ];
    }

    @Override
    public <T1> T1[] toArray( T1[] t1s ) {
        return null;
    }

    @Override
    public boolean add( T t ) {
        if ( this.pointer == objects.length-1 ) {
            resize( objects.length + INIT_SIZE );
        }

        objects[ pointer++ ] = t;

        return true;
    }

    private void resize( int nLen ) {
        Object[] newObjects = new Object[ nLen ];
        System.arraycopy( objects, 0, newObjects, 0, pointer );
        objects = newObjects;
    }

    @Override
    public boolean remove( Object o ) {
        return false;
    }

    @Override
    public boolean containsAll( Collection<?> collection ) {
        return false;
    }

    public boolean addAll( Collection<? super T> collection, T... elements ) {
        boolean   result = false;
        System.out.println( collection.size() );
        System.out.println( elements.length );
        Object[] objects = elements;
        int       length = elements.length;

        for ( int i = 0; i < length; ++i ) {
            T element = (T) objects[i];
            result |= collection.add( element );
        }

        return result;
    }

    @Override
    public boolean addAll( Collection<? extends T> collection ) {
        return false;
    }

    @Override
    public boolean addAll( int i, Collection<? extends T> collection ) {
        return false;
    }

    @Override
    public boolean removeAll( Collection<?> collection ) {
        return false;
    }

    @Override
    public boolean retainAll( Collection<?> collection ) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals( Object o ) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public T get( int i ) {
        return (T) objects[ i ];
    }

    @Override
    public T set( int i, T t ) {
        return null;
    }

    @Override
    public void add( int i, T t ) {
        super.add( i, t );
    }

    @Override
    public T remove( int i ) {
        return null;
    }

    @Override
    public int indexOf( Object o ) {
        return 0;
    }

    @Override
    public int lastIndexOf( Object o ) {
        return super.lastIndexOf( o );
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator( int i ) {
        return null;
    }

    @Override
    public List<T> subList( int i, int i1 ) {
        return null;
    }

}
