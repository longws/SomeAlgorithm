import java.util.Arrays;

public class SmoothRobinWithWeight {
    private int[] weights;
    private int[] currentWeights;

    public SmoothRobinWithWeight(int[] weights) {
        this.weights = weights;
        currentWeights = Arrays.copyOf(weights, weights.length);
    }

    public int next() {
        int index = 0, sum = 0, maxWeight = currentWeights[index];
        for (int i = 0; i < currentWeights.length; i++) {
            if(currentWeights[i] > maxWeight){
                index = i;
                maxWeight = currentWeights[index];
            }
            sum += currentWeights[i];
            currentWeights[i] += weights[i];
        }
        currentWeights[index] = weights[index] - (sum - maxWeight);
        return index;
    }

    public static void main(String[] args) {
        int[] weights = {5,1,1};
        SmoothRobinWithWeight smoothRobinWithWeight = new SmoothRobinWithWeight(weights);
        while(true) {
            System.out.println(smoothRobinWithWeight.next());
        }
    }
}
