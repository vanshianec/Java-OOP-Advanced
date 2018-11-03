import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private List<T> numbers;

    Lake(List<T> numbers){
        setNumbers(numbers);
    }

    private void setNumbers(List<T> numbers){
        this.numbers = numbers;
    }

    public Iterator<T> iterator(){
           return new Froggy();
    }

    private class Froggy implements Iterator<T>{

        int oddCounter = 1;
        int evenCounter = 0;
        @Override
        public boolean hasNext() {
            if(numbers.size()==1){
                return evenCounter < numbers.size();
            }
           return oddCounter < numbers.size();
        }

        @Override
        public T next() {
              if(evenCounter < numbers.size()){
                   T element = numbers.get(evenCounter);
                   evenCounter += 2;
                   return element;
              }
            T element = numbers.get(oddCounter);
            oddCounter += 2;
            return element;
        }
    }

}
