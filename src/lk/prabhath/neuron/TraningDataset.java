package lk.prabhath.neuron;
public class TraningDataset {
    private double[] 
        inputs,
        expectedOutput;

    public TraningDataset(
        double[] inputs,
        double[] expectedOutput){

            this.inputs = inputs;
            this.expectedOutput = expectedOutput;
    }

    public final double[] getInputs(){
        return this.inputs;
    }


    public final double[] getExpectedOutput(){
        return this.expectedOutput;
    }

    public final boolean haveData(){
        return (this.inputs.length == 0)
            && (this.expectedOutput.length == 0) ? false : true; 

    }
}
