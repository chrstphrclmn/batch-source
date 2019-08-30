public class Autoboxing{

    public static void main(String[] args){

        // Explicit boxing
        int n1 = 7;
        Integer n2 = new Integer(n1);

        // Unboxing
        Integer n3 = new Integer(8);
        int n4 = n3.intValue();

        int n5 = 6;
        Integer n6 = n5;
    }
}