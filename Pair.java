public class Pair<T1 extends Comparable<T1>> implements Comparable<Pair<T1>>{
    private int index;
    private T1 value;

    //Class constructor
    public Pair(int index, T1 value) {
        this.index = index;
        this.value = value;
    }
    //Setters and getters of variables
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public T1 getValue() {
        return value;
    }
    public void setValue(T1 value) {
        this.value = value;
    }
    //Setting of comparison function
    @Override
    public int compareTo(Pair<T1> other){
        if(this.value instanceof String) return value.compareTo(other.value);
        else return ((Integer)value).compareTo((Integer)other.value);
    }
}
