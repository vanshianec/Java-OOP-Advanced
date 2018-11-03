import java.util.ArrayList;
import java.util.List;

public class CustomList <T extends Comparable<T>> {

    private List<T> list;

    public CustomList(){
        this.list = new ArrayList<>();
    }

    public void add(T element){
        list.add(element);
    }

    public T remove(int index){
        return list.remove(index);
    }

    public boolean contains(T element){
        return list.contains(element);
    }

    public void swap(int index1,int index2){
        T oldFirst = list.get(index1);
        list.set(index1,list.get(index2));
        list.set(index2,oldFirst);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for (T t : list) {
            if(t.compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax(){
        return list.stream().max((t1,t2) -> t1.compareTo(t2)).get();
    }

    public T getMin(){
        return list.stream().min((t1,t2) -> t1.compareTo(t2)).get();
    }

    public void Print(){
        for (T t : list) {
            System.out.println(t);
        }
    }





}
