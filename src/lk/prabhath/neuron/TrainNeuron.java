package lk.prabhath.neuron;

public class TrainNeuron {

    private static final String c_name = "TrainNeuron";

    public static final void trainNeuron(Neuron neuron,
            double error,
            double learningRate,
            int trainCount,
            TraningDataset dataset) {

        TrainNeuron.trainANeuron(
                neuron,
                learningRate,
                trainCount,
                dataset,
                false);
    }

    public static final void trainANeuron(
            Neuron neuron,
            double learningRate,
            int trainCount,
            TraningDataset dataset,
            boolean verbose) {

        int j = 0;

        while (j < trainCount) {
            TrainNeuron.learn(
                neuron,
                learningRate, 
                dataset, 
                verbose);
                
            j++;
        }

        Logging.showState("\n"
                + "Traing is Finish"
                + "\n\tOutput : " + neuron.activate()
                + "\n\tExpected Output : " + neuron.expectedOutput
                + "\n\n\tError : " + neuron.getError()
                + "\n\tBias : " + neuron.getBias()
                + "\n\tWeights : \n" + neuron.getWeightsAsString());

    }

    private static final void learn(
            Neuron neuron,
            double learningRate,
            TraningDataset dataset,
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
    }

}