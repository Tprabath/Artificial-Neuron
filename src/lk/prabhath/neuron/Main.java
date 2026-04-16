package lk.prabhath.neuron;

public class Main {

    static double threshold = 0.5;
    static Neuron[] neurons = {
            new Neuron(
                    // new double[] {
                    // Normalization.min_max_normalize(
                    // 30,
                    // 100,
                    // 0), // exam
                    // Normalization.min_max_normalize(
                    // 3,
                    // 10,
                    // 0) // attendence
                    // },

                    new double[] {
                            0.2,
                            0.3
                    },
                    new double[] {
                            0.1, // exam weigth
                            0.1 // attendence weight
                    },

                    -0.7,
                    1,
                    ActivationFunction.Sigmoid,
                    true),

    };

    public static void main(String[] args) {

        // for (int i = 0; i < Main.neurons.length; i++) {
        // Neuron n = neurons[i];
        // // double output = n.activate();

        // TrainNeuron.trainANeuron(
        // n,
        // 0.001,
        // true,
        // 20000);

        // // double n_output = n.activate();

        // // System.out.println("Neuron [" + i + "] Output : " + n_output);
        // // System.out.println("\n====================");

        // // StringBuilder sb = new StringBuilder();
        // // sb.append("\nNeuron [" + i + "] is activating...");
        // // sb.append("\n\t - input");
        // // sb.append(Main.concat(n.getInputs()));
        // // sb.append("\n\t - weights");
        // // sb.append(Main.concat(n.getweights()));
        // // sb.append("\n\t - bias : " + n.getBias());
        // // sb.append("\n\t - output : " + output);
        // // sb.append("\n\t - fire : " + (output >= threshold));

        // // System.out.println(sb.toString());
        // }

        TrainNeuron.trainANeuron(
                new Neuron(
                        new double[]{},
                        new double[]{},
                        -1, //bias
                        1,
                        ActivationFunction.Sigmoid,
                        true),

                0.0001,
                100000,

                new TraningDataset(
                        null,
                        null),

                true);

        // System.out.println(
        // new Neuron().activate()
        // );
    }

    private static final String concat(double[] valus) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (double d : valus) {
            sb.append("\n\t    [" + (++i) + "] " + d);
        }

        return sb.toString();
    }
}
