public class NullCheck {

    public static void main(String[] args) {
        String nullObject = null;
        String normalObject = "normal";
        
        System.out.println(nullObject == null);
        System.out.println(normalObject == null);


        System.out.println(normalObject.equals(null));
        System.out.println(normalObject.equals(nullObject));
        
        nullObject.equals(normalObject); // throw null pointer exception
        nullObject.equals(null); // throw null pointer exception

    }
    
}
