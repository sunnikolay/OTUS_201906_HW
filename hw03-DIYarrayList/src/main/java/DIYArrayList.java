import java.util.*;

public class DIYArrayList<T> implements List<T> {

    private final int INIT_SIZE = 100;
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
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public boolean containsAll( Collection<?> collection ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public boolean addAll( Collection<? extends T> collection ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public boolean addAll( int i, Collection<? extends T> collection ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public boolean removeAll( Collection<?> collection ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public boolean retainAll( Collection<?> collection ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public T get( int i ) {
        return (T) objects[ i ];
    }

    @Override
    public T set( int index, T type ) {
        T old = (T) objects[ index ];
        Object newObject = type;
        this.objects[ index ] = newObject;

        return old;
    }

    @Override
    public void add( int i, T t ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public T remove( int i ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public int indexOf( Object o ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public int lastIndexOf( Object o ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<>() {
            @Override
            public boolean hasNext() {
                return pointer < objects.length;
            }

            @Override
            public T next() {
                return (T) objects[ pointer++ ];
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public T previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set( T t ) {

            }

            @Override
            public void add( T t ) {

            }
        };
    }

    @Override
    public ListIterator<T> listIterator( int i ) {
        throw new UnsupportedOperationException( "listIterator" );
    }

    @Override
    public List<T> subList( int i, int i1 ) {
        throw new UnsupportedOperationException( "oooPs..." );
    }

    @Override
    public String toString() {
        String str = "";
        for ( int i = 0; i < pointer; i++ ) {
            str += this.objects[i] + ", ";
        }
        return str;
    }
}
