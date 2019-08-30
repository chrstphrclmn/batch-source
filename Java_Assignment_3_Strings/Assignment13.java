public class Assignment13{

    public static void main(String[] args){

        String x = "Restful";
        String y = "Fluster";

        for (char c : x.toLowerCase().toCharArray()){

            int idx = y.toLowerCase().indexOf(c);

            if(idx == -1){

                System.out.println("Not an Anagram.");
                return;
            }

            y = y.substring(0, idx) + y.substring(idx + 1);
        }

        if(y.length() == 0){

            System.out.println("Anagrams.");
        }

        else{

            System.out.println("Not an Anagram.");
        }
    }
}