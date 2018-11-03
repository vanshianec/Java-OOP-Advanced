import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator {
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
}
