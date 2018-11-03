import java.util.List;

public class Box <T> {
    private T value;

    public Box(T value){
        this.value = value;
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
}
