package appmultimatri.logica;

public class MultiMatriSecuencial {

    private int[][] A, B;
    private int numFilasA, numColsA, numFilasB, numColsB;

    public MultiMatriSecuencial(int[][] A, int[][] B) {
        this.A = A;
        this.B = B;
        this.numFilasA = A.length;
        this.numColsA = A[0].length;
        this.numFilasB = B.length;
        this.numColsB = B[0].length;
        if (numColsA != numFilasB)
            throw new Error(String.format("Dimensiones no válidas; no se puede multiplicar %dx%d*%dx%d\n", numFilasA, numFilasB,
                    numColsA, numColsB));
    }

    /* returns matrix product C = AB */
    public int[][] calcularProducto() {
        int[][] C = new int[numFilasA][numColsB];
        for (int i = 0; i < numFilasA; i++) {
            for (int k = 0; k < numColsB; k++) {
                int sum = 0;
                for (int j = 0; j < numColsA; j++) {
                    sum += A[i][j] * B[j][k];
                }
                C[i][k] = sum;
            }
        }
        return C;
    }
}