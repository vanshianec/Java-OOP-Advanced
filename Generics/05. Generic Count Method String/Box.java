import java.util.List;

public class Box <T> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public String toString(){
        return String.format("%s: %s",this.value.getClass().getName(),this.value);
    }

    public static <T> void swap(List<T> list,int firstIndex,int secondIndex){
        T oldFirst = list.get(firstIndex);
        T oldSecond = list.get(secondIndex);
        list.remove(secondIndex);
        list.add(secondIndex,oldFirst);
        list.remove(firstIndex);
        list.add(firstIndex,oldSecond);

    }

    public static <T extends Comparable<T>> int compareValues(List<Box<T>> list,Box<T> element){
        int count = 0;
        for (Box<T> box : list) {
            if(box.getValue().compareTo(element.getValue())> 0){
            count++;
            }
        }
        return count;
    }
}
