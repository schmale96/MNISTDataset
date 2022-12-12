package Main;

import java.io.IOException;
import java.util.List;

public class MNISTLearn {
    public static List<MNISTDecoder.Digit> digits;
    public static List<MNISTDecoder.Digit> digitsTest;

    public MNISTLearn() {
    }

    public static void main(String[] args) throws IOException {
        digits = MNISTDecoder.loadDataSet("C:/temp/train-images.idx3-ubyte", "C:/temp/train-labels.idx1-ubyte");
        digitsTest = MNISTDecoder.loadDataSet("C:/temp/t10k-images.idx3-ubyte", "C:/temp/t10k-labels.idx1-ubyte");


        System.out.println(((MNISTDecoder.Digit)digits.get(3)).label);

    }

}
