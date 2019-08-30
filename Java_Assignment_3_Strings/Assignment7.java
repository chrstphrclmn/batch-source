public class Assignment7{

    public static void main(String[] args){

        String token = "http://example.com?access_token=EFEc8328h29jndjd02h12$3829&ds98d";

        System.out.println(token.substring(token.indexOf('=') + 1));
    }
}