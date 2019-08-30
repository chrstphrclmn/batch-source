public class Assignment6{

    public static void main(String[] args){

        float x = 2.5f;
        String msg;

        if(x == 3){
            msg = "Equal to 3";
        }

        else if(x > 5){
            msg = "Greater than 5";
        }

        else if(x <= 0){
            msg = "Less than or equal to 0";
        }
        else{
            msg = "None";
        }

        System.out.println(msg);
    }
}