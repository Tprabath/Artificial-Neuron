package lk.prabhath.neuron;

enum ActivationFunction {
    Sigmoid,
    ReLU,
    Tanh
}

public final class Neuron {
    private static final String c_name = "Neuron";

    double bias;
    double[] inputs, weights;
    ActivationFunction activationFunction;

    public Neuron(
            double[] inputs,
            double[] weights,
            ActivationFunction activationFunction) {

        this.init(inputs, weights,
                0, // default 0
                activationFunction);

    }

    public Neuron(
            double[] inputs,
            double[] weights,
            double bias,
            ActivationFunction activationFunction) {

        this.init(inputs, weights, bias, activationFunction);
    }

    private final void init(double[] inputs,
            double[] weights,
            double bias,
            ActivationFunction activationFunction) {

        this.inputs = Neuron.checkpoint(inputs);
        this.weights = Neuron.checkpoint(weights);
        this.bias = bias;
        this.activationFunction = activationFunction;
    }

    public final double activate() {
        double final_value = 0.00;
        int values_length;

        // calculate sigma(wi*xi)
        if (inputs.length != weights.length) {
            Logging
                    .getInstance()
                    .log(Neuron.c_name,
                            "inputs length must equal to weights length",
                            Logging.Status.ERROR);
        }

        values_length = (inputs.length + weights.length) / 2;

        for (int i = 0; i < values_length; i++) {
            final_value += inputs[i] * weights[i];
        }

        return Neuron.activationFunction(
                (final_value + this.bias), // add bias inline
                activationFunction);
    }

    private static final double activationFunction(
            double value,
            ActivationFunction func) {

        switch (func) {
            case ActivationFunction.Sigmoid:
                return 1 / (1 + Math.exp(-value));

            default:
                System.err.println("Not impliment");
                return 0;
        }

    }

    // check all values lass that 1 and more than 0
    private static final double[] checkpoint(double[] d) {
        for (double v : d) {
            if (v < 0 && 1 < v) {
                Logging
                        .getInstance()
                        .log(Neuron.c_name,
                                "inputs or weights less than 1 and more than 0",
                                Logging.Status.ERROR);
            }
        }

        return d;
    }

    public final void setBias(double bias) {
        this.bias = bias;
    }

    public final double[] getInputs() {
        return this.inputs;
    }

    public final double[] getweights() {
        return this.weights;
    }

    public final double getBias(){
        return this.bias;
    }

}
