package NN;

public class Edge {

    private float weight;
    private Neuron neuron;


    public Edge(float weight, Neuron neuron){

        this.weight = weight;
        this.neuron = neuron;
    }

    public float getValue() {

        return this.neuron.getOutputValue() * this.weight;

    }

    public void addWeight(float delta) {

        this.weight += delta;
    }

    public Neuron getNeuron() {

        return this.neuron;
    }

}
