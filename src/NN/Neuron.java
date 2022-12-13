package NN;

import java.util.ArrayList;


public class Neuron {

    private float value;
    private ArrayList<Edge> edges = new ArrayList<>();
    private boolean isInput;

    public Neuron(boolean isInput) {

        this.isInput = isInput;
    }

    public Neuron(boolean isInput, float value) {

        this.isInput = isInput;
        this.value = value;
    }

    public float getOutputValue(){

        if (this.isInput) {

            return this.value;

        } else {

            float sum = 0.0F;

            for (Edge e : this.edges) {

                sum += e.getValue();

            }

            return sum;
        }

    }

    public float activation(float input) {

        return (float)(1f / (1f + Math.pow(Math.E, -input)));

    }


    public void addEdge(float weight, Neuron neuron) {

        this.edges.add(new Edge(weight, neuron));

    }

    public void deltaLearning(float learningRate, float smallDelta) {

        for(int i = 0; i < this.edges.size(); i++) {

            float bigDelta = learningRate * smallDelta * edges.get(i).getNeuron().getOutputValue();
            edges.get(i).addWeight(bigDelta);
        }

    }
}
