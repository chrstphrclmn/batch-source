public class PrivatePerson{

    private String name = "Joe";
    private int age     = 31;

    public PrivatePerson(){}

    public PrivatePerson(String name, int age){

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