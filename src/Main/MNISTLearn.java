package Main;

import NN.NeuralNetwork;
import NN.Neuron;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MNISTLearn {
    public static List<MNISTDecoder.Digit> digits;
    public static List<MNISTDecoder.Digit> digitsTest;

    public MNISTLearn() {
    }

    public static void main(String[] args) throws IOException {

        //Datensatz einlesen
        digits = MNISTDecoder.loadDataSet("/Users/tobias.schmalhofer/Desktop/MNIST Datenbank/train-images-idx3-ubyte", "/Users/tobias.schmalhofer/Desktop/MNIST Datenbank/train-labels-idx1-ubyte");

        //Neuronales Netz erstellen
        NeuralNetwork nn = new NeuralNetwork();

        //Input Neuronen erzeugen und mit Werten befüllen
        for (int x = 0; x < 28; x++) {

            for(int y = 0; y < 28; y++) {

                nn.addInputNeurons(1, new float[]{MNISTDecoder.toUnsignedByte(digits.get(50000).data[x][y]) / 255F});
            }

        }

        //Output Neuronen erzeugen
        nn.addOutputNeurons(10);

        //Zufällige Initialgewichte
        Random rand = new Random();
        float[] weights = new float[28*28*10];

        for(int i = 0; i < weights.length; i++ ){

            weights[i] = rand.nextFloat();
        }

        //Verbinde alle Inputs mit allen Outputs
        nn.connectForwardAll(weights);

        System.out.println("");
        System.out.println("Sollziffer: " + digits.get(50000).label);
        System.out.println("");


        System.out.println("");
        System.out.println("Vor dem Lernen:");
        System.out.println("");

        int i = 0;

        for (Neuron output : nn.getAllOutputNeurons()) {

            int neuronNumber = i + 1;

            System.out.println(" "+ neuronNumber + ". Neuron: " + output.getOutputValue() + " ");
            System.out.println("----------------------------------");

            i++;

        }

        float learningRate = 0.01F;

        //In Java ist bei Initialisierung alles 0
        float shoulds[] = new float[10];
        shoulds[digits.get(50000).label] = 1;

        int counter = 0;

        /*while(counter < 500) {

            nn.calculateSmallDelta(shoulds, learningRate);
            counter ++;
        }*/

        System.out.println("");
        System.out.println("Nach dem Lernen");
        System.out.println("");

        int k = 0;

        for (Neuron output : nn.getAllOutputNeurons()) {

            int neuronNumber = k + 1;

            System.out.println(" "+ neuronNumber + ". Neuron: " + output.getOutputValue() + " ");
            System.out.println("----------------------------------");

            k++;

        }

    }

}
