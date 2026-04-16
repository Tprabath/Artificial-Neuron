package lk.prabhath.neuron;

import lk.prabhath.neuron.util.Logging;

public final class Normalization {
    private static final String c_name = "Normalization";

    public static final double min_max_normalize(double input, double max_value, double min_value) {
        if (input > max_value) {
            Normalization.log_error(
                    "Value must lass than max_value"
                            + "\n\t - input " + input
                            + "\n\t - max_value " + max_value);
        }

        if (input < min_value) {
            Normalization.log_error(
                    "Value must more than min_value"
                            + "\n\t - input " + input
                            + "\n\t - min_value " + min_value);
        }

        return (input - min_value) / (max_value - min_value);
    }

    private static final void log_error(String message) {
        Logging
                .getInstance()
                .log(Normalization.c_name,
                        message,
                        Logging.Status.ERROR);
    }
}
