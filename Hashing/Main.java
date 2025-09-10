import java.util.*;

public class Main {
    public static void main(String[] args) {
        // create two sets of strings
        Set<String> set1 = new HashSet<>();
        set1.add("apple");
        set1.add("banana");
        set1.add("orange");

        Set<String> set3 = new HashSet<>();
        set3.add("apple");
        set3.add("banana");
        set3.add("orange");

        Set<String> set2 = new HashSet<>();
        set2.add("banana");
        set2.add("orange");
        set2.add("grape");

        // create a MinHash object with 100 hash functions
        MinHash<String> minHash = new MinHash<>(100);

        // compute the similarity between the sets
        double similarity = minHash.similarity(set1, set3);

        // print the similarity
        System.out.println("Similarity between set1 and set2: " + similarity);
    }
}
