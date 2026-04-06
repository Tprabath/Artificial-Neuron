package lk.prabhath.neuron;

public class TrainNeuron {

    public static void trainNeuron(
            Neuron neuron,
            double error,
            double learningRate) {


        int l = (neuron.getInputs().length + neuron.getweights().length) / 2;
        double[] u_w = new double[l];

        for (int i = 0; i < l; i++) {
            u_w[i] = 
                neuron.getweights()[i] 
                + (
                    learningRate 
                    * error 
                    * neuron.getInputs()[i]
                );

        }

        neuron.setWeights(u_w);
        neuron.setBias(neuron.getBias() + (learningRate * error));

    }

}