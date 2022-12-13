package Main;

import NN.NeuralNetwork;
import NN.Neuron;

import java.io.IOException;
import java.util.List;

public class MNISTLearn {
    public static List<MNISTDecoder.Digit> digits;
    public static List<MNISTDecoder.Digit> digitsTest;

    public MNISTLearn() {
    }

    public static void main(String[] args) throws IOException {
        digits = MNISTDecoder.loadDataSet("/Users/tobias.schmalhofer/Desktop/MNIST Datenbank/train-images-idx3-ubyte", "/Users/tobias.schmalhofer/Desktop/MNIST Datenbank/train-labels-idx1-ubyte");
        digitsTest = MNISTDecoder.loadDataSet("/Users/tobias.schmalhofer/Desktop/MNIST Datenbank/t10k-images-idx3-ubyte", "/Users/tobias.schmalhofer/Desktop/MNIST Datenbank/t10k-labels-idx1-ubyte");

        NeuralNetwork nn = new NeuralNetwork();

        nn.addInputNeurons(1, new float[]{1.5F});
        nn.addHiddenNeurons(1);
        nn.addOutputNeurons(1);

        nn.connectForwardAll(new float[]{

                2.5F, 0.4F
        });

        int i = 0;

        for (Neuron output : nn.getAllOutputNeurons()) {

            int neuronNumber = i + 1;

            System.out.println(" "+ neuronNumber + ". Neuron: " + output.getOutputValue() + " ");
            System.out.println("----------------------------------");

            i++;

        }
    }

}
