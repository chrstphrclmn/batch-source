public class Main{

    public static void main(String[] args){

        PrivatePerson x = new PrivatePerson();
        PrivatePerson y = new PrivatePerson("Mike", 22);

        System.out.printf("Name: %s\nAge: %d\n\n", x.name(), x.age());
        System.out.printf("Name: %s\nAge: %d\n\n", y.name(), y.age());
    }
}