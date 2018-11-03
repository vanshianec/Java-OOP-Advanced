import java.util.Stack;

public class Jar <T> {
    private Stack<T> jar;

    public Jar(){
        this.jar = new Stack<>();
    }

    public void add(T element){
        jar.push(element);
    }

    public T remove(){
        T element = jar.pop();
        return element;
    }


}
