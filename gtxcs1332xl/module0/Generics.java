import java.util.Arrays;

public class Generics<T> {

    private T t;
    private T tt;
    private T[] tArray;
    /**
     * @param <T>
     */
    public Generics(T t) {
        this.t = t;
    }


    public Generics(T t, T tt) {
        this(t);
        this.tt = tt;
    }

    public Generics(T t, T tt, Integer length) {
        this(t,tt);
        this.tArray = (T[])(new Object[length]);
    }



    /**
     * @param args
     */
    public static void main(String[] args) {
        Generics<String> gen = new Generics<>("hi", "there", 3);
        System.out.println(gen.t + "\t" + gen.tt);
        System.out.println(Arrays.toString(gen.tArray));

    }
}
