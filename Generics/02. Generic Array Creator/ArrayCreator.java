import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayCreator <T> {




   public static <T> T[] create(int lenght,T item){
      T[] array = (T[])new Object[lenght];
        for (int i=0;i<array.length;i++){
            array[i] = item;
        }
        return array;
    }

    public static <T> T[] create(Class <T> c1,int length,T item){
      T[] array = (T[]) Array.newInstance(c1,length);
      for (int i=0;i<array.length;i++){
          array[i] = item;
      }
      return array;
    }


}
