public class Application{

    public static void main(String[] args){

        Person x = new Person();
        Person y = new Person("Mike", 22);

        System.out.printf("Name: %s\nAge: %d\n\n", x.name(), x.age());
        System.out.printf("Name: %s\nAge: %d\n\n", y.name(), y.age());
    }
}