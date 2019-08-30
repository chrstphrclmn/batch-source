public class Assignment2{

    public static void main(String[] args){

        String x = "abc";
        String y = "ABC";

        System.out.println(x == y ? "Pass: ==" : "Fail: ==");
        System.out.println(x.equals(y) ? "Pass: .equals()" : "Fail: .equals()");
    }
}