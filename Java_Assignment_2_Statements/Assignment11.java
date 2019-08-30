public class Assignment11{

    public static void main(String[] args){

        int[] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for(int i : x){

            for(int j : x){

                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
    }
}