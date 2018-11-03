public class Tuple <T, S> {

    private T item1;
    private S item2;

    public Tuple(T item1,S item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public S getItem2() {
        return item2;
    }

   public String toString(){
        String result = this.getItem1() + " -> " + this.getItem2();
        return result;
   }
}
