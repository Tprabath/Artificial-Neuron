package lk.prabhath.neuron.util;

public final class Logging {

    public static enum Status {
        LOG,
        ERROR
    }

    private static Logging l;
    private static String prefix = " : \n - ";
    private static String c_name_prefix = "\n Class - ";

    public final static Logging getInstance() {
        if (Logging.l == null) {
            Logging.l = new Logging();
        }

        return Logging.l;
    }

    public final void log(String class_name,
            String message,
            Status status) {

                String c_name = "";

                if(class_name != null){
                    c_name = c_name_prefix + class_name + prefix;
                }

        switch (status) {
            case Status.LOG:
                System.out.println(c_name + message);
                break;

            case Status.ERROR:
                System.err.println(c_name + message);
                System.exit(-1);
        }

    }

    public static final void showState(String c_name, boolean v, String message) {
        if (v) {
            Logging.showState(c_name, message);
        }
    }

    public static final void showState(String c_name, String message) {
        Logging.show(c_name, message, Logging.Status.LOG);
    }

    public static final void showState(String message) {
        Logging.show(null, message, Logging.Status.LOG);
    }

    public static final void showError(String c_name, String message) {
        Logging.show(c_name, message, Logging.Status.ERROR);
    }

    public static final void show(String c_name, String message, Logging.Status state) {
        Logging
                .getInstance()
                .log(c_name,
                        message,
                        state);
    }
}