public class DiscreteDistribution {
    public static void main(String[] args) {

        // number of random indices
        int m = Integer.parseInt(args[0]);

        // read in frequency of occurrence of n values
        int n = args.length;
        int[] freq = new int[n];
        for (int i = 1; i < n; i++) {
            freq[i] = Integer.parseInt(args[i]);
        }

        // compute total count of all frequencies
        int total = 0;
        for (int i = 1; i < n; i++) {
            total += freq[i];
        }
        double[] summedProbabilities = new double[n];
        for (int i = 1; i < summedProbabilities.length; i++) {
            final double probability = freq[i] / (double) total;
            summedProbabilities[i] = summedProbabilities[i - 1] + probability;

        }
        for (int j = 0; j < m; j++) {
            // generate random integer with probability proportional to frequency
            double randomProbability = Math.random();
            int i = 1;
            while (randomProbability > summedProbabilities[i]) {
                i++;
            }
            System.out.print(i + " ");
            if (j % 25 == 0) {
                System.out.println();
            }
        }
    }
}
