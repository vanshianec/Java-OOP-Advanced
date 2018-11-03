import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable{
    private List<String> collection;
    private int index;

    public ListyIterator(String ... collection){
        this.setCollection(collection);
        this.index = 0;
    }

    public boolean hasNext(){
        if(this.index < collection.size() - 1){
            return true;
        }
        return false;
    }

    public boolean move(){
        if(hasNext()){
            this.index++;
            return true;
        }
        return false;
    }

    private void setCollection(String ... collection){
        if(collection.length == 0){
            this.collection = new ArrayList<>();
        }
        this.collection = Arrays.asList(collection);
    }

    public void print(){
        if(collection.isEmpty()){
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(collection.get(this.index));
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < collection.size();
            }

            @Override
            public String next() {
                return collection.get(count++);
            }
        };
    }

    public void printAll(){
        for (String s : collection) {
            System.out.print(s + " ");
        }
        System.out.println();
    }


}
