import java.util.*;

public class MinHash<T> {
    private int numHashes;
    private int[] hashValues;
    private Random rand;

    public MinHash(int numHashes) {
        this.numHashes = numHashes;
        this.hashValues = new int[numHashes];
        this.rand = new Random();
        for (int i = 0; i < numHashes; i++) {
            this.hashValues[i] = rand.nextInt();
        }
    }

    public double similarity(Set<T> set1, Set<T> set2) {
        int[][] signatures = new int[2][numHashes];
        Arrays.fill(signatures[0], Integer.MAX_VALUE);
        Arrays.fill(signatures[1], Integer.MAX_VALUE);

        int i = 0;
        for (T item : set1) {
            for (int j = 0; j < numHashes; j++) {
                int h = hash(item, hashValues[j]);
                if (h < signatures[0][j]) {
                    signatures[0][j] = h;
                }
            }
            i++;
        }

        i = 0;
        for (T item : set2) {
            for (int j = 0; j < numHashes; j++) {
                int h = hash(item, hashValues[j]);
                if (h < signatures[1][j]) {
                    signatures[1][j] = h;
                }
            }
            i++;
        }

        int count = 0;
        for (i = 0; i < numHashes; i++) {
            if (signatures[0][i] == signatures[1][i]) {
                count++;
            }
        }

        return (double) count / (double) numHashes;
    }

    private int hash(T item, int hashValue) {
        int hash = item.hashCode();
        hash = hashValue * hash + 1;
        hash = hash ^ (hash >>> 16);
        return hash;
    }
}
