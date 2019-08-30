public class TalkablePerson{

    private String name = "Joe";
    private int age     = 31;

    public TalkablePerson(){}

    public TalkablePerson(String name, int age){

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