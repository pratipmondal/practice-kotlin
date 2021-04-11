import java.util.ArrayList;
import java.util.List;

public class CovContra {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Object> objs = new ArrayList<>();
        //List<Object> objs = list;//A compile time exception to prevent a runtime exception
        //list.addAll(objs);//addAll(Collection<? extends E> c) not possible since Object doesn't extends String
        objs.addAll(list);//addAll(Collection<? extends E> c)// This is clled Covariant

        //Contravariant is just the opposite List<? super String>
    }
}
