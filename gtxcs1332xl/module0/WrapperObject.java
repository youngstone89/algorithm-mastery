public class WrapperObject {
    public static void main(String[] args) {
        Integer primitive = 1;
        Integer object = new Integer(primitive);
        Integer unequal = 2;

        System.out.println(primitive == object);
        System.out.println(primitive == 1);
        System.out.println(object == 1); // true for auto unboxing
        System.out.println(object == new Integer(1)); // false for difference reference

        System.out.println(primitive.equals(object));
        System.out.println(object.equals(primitive));
        System.out.println(primitive.equals(1));
        System.out.println(object.equals(1));
        System.out.println((new Integer(1).equals(1)));
        System.out.println((new Integer(1)).equals((new Integer(1))));

        System.out.println(primitive == unequal);
        System.out.println(object == unequal);
        System.out.println(primitive.equals(unequal));
        System.out.println(object.equals(unequal));

        1.equals(primitive) // compile error
        1.equals(1) // compile error because 1 is considered a primitive without autoboxing
    }
}
