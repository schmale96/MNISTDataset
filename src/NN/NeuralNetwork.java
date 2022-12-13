package NN;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NeuralNetwork {

    private List<Neuron> inputNeurons = new ArrayList<>();
    private List<Neuron> hiddenNeurons = new ArrayList<>();
    private List<Neuron> outputNeurons = new ArrayList<>();


    public void addInputNeurons(int amount, float... values) {

        for(int i = 0; i < amount; i++) {

            this.inputNeurons.add(new Neuron(true, values[i]));

        }

    }

    public void addHiddenNeurons(int amount) {

        for(int i = 0; i < amount; i++) {

            this.hiddenNeurons.add(new Neuron(false));

        }

    }

    public void addOutputNeurons(int amount) {

        for(int i = 0; i < amount; i++) {

            this.outputNeurons.add(new Neuron(false));

        }

    }


    public void connectForwardAll(float... weights) {

        int index = 0;

        for (Neuron input : this.inputNeurons) {

            for(Neuron hidden : this.hiddenNeurons) {

                hidden.addEdge(weights[index++], input);

            }

        }


        for (Neuron hidden : this.hiddenNeurons) {

            for (Neuron output : this.outputNeurons) {

                output.addEdge(weights[index++], hidden);

            }

        }

    }

    public ArrayList<Neuron> getAllOutputNeurons() {

        return (ArrayList<Neuron>) this.outputNeurons;

    }

}
