public class Threeuple<T, S, V> {

    private T item1;
    private S item2;
    private V item3;

    public Threeuple(T item1, S item2, V item3){
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public S getItem2() {
        return item2;
    }

    public V getItem3(){
        return item3;
    }

   public String toString(){
        String result = this.getItem1() + " -> " + this.getItem2() + " -> " + this.getItem3();
        return result;
   }
}
