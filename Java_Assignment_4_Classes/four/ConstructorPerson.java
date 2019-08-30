public class ConstructorPerson{

    private String name;
    private int age;

    public ConstructorPerson(){

        this.name   = "Joe";
        this.age    = 31;
    }

    public ConstructorPerson(String name, int age){

        this.name   = name;
        this.age    = age;
    }

    public String name(){

        return this.name;
    }

    public int age(){
        return this.age;
    }

    public void talk(){

        System.out.printf("Hello, my name is: %s\n", this.name);
    }
}