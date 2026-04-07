package lk.prabhath.neuron;

public class TrainNeuron {

    private static final String c_name = "TrainNeuron";

    public static final void trainNeuron(Neuron neuron,
            double error,
            double learningRate,
            int trainCount) {

        TrainNeuron.trainANeuron(
                neuron,
                learningRate,
                false,
                trainCount);
    }

    public static final void trainANeuron(
            Neuron neuron,
            double learningRate,
            boolean verbose,
            int trainCount) {

        int j = 0;

        while (j < trainCount) {
            TrainNeuron.learn(neuron, learningRate, verbose);
            j++;
        }

    }

    private static final void learn(
            Neuron neuron,
            double learningRate,
            boolean verbose) {

        int l = (neuron.getInputs().length + neuron.getweights().length) / 2;
        double[] u_w = new double[l];

        double error = neuron.getError();

        for (int i = 0; i < l; i++) {
            u_w[i] = neuron.getweights()[i]
                    + (learningRate
                            * error
                            * neuron.getInputs()[i]);

         Logging.showState(c_name, verbose, "Weight [" + i + "] is now : " + u_w[i]);

        }

        neuron.setWeights(u_w);
        neuron.setBias(neuron.getBias() + (learningRate * error));

        Logging.showState("\n"
            +"Traing is Finish\n"
            + "\tBias : " + neuron.getBias()
        );
    }

   
}