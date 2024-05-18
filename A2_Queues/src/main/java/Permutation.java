import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);
        String[] data = StdIn.readAllStrings();
        StdRandom.shuffle(data);

        for (int i = 0; i < k; i++)
            System.out.println(data[i]);
    }
}
