public class Box <T> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    public String toString(){
        return String.format("%s: %s",this.value.getClass().getName(),this.value);
    }
}
