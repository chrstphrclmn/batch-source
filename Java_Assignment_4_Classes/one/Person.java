public class Person{

    private String name = "Joe";
    private int age     = 31;

    public Person(){}

    public Person(String name, int age){

        this.name   = name;
        this.age    = age;
    }

    public String name(){

        return this.name;
    }

    public int age(){
        return this.age;
    }
}