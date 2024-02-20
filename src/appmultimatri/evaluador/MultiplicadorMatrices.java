package appmultimatri.evaluador;


import java.util.Arrays;
import appmultimatri.logica.MultiMatriSecuencial;
import appmultimatri.logica.MultiMatriParalela;
import appmultimatri.logica.GeneradorMatrices;

public class MultiplicadorMatrices {

    /* evaluar el rendimiento de implementaciones secuenciales y paralelas */
    public static void main(String args[]) {
        final int numEval = 5;
        final int[][] A = GeneradorMatrices.generarMatrizAleatoria(1000, 1000);
        final int[][] B = GeneradorMatrices.generarMatrizAleatoria(1000, 1000);

        System.out.println("Evaluando Implementación Secuencial...");
        MultiMatriSecuencial mms = new MultiMatriSecuencial(A, B);
        int[][] resultadoSecuencial = mms.calcularProducto();
        double tiempoSecuencial = 0;
        for (int i = 0; i < numEval; i++) {
            long inicio = System.currentTimeMillis();
            mms.calcularProducto();
            tiempoSecuencial += System.currentTimeMillis() - inicio;
        }
        tiempoSecuencial /= numEval;

        System.out.println("Evaluando Implementación Paralela...");
        MultiMatriParalela mmp = new MultiMatriParalela(A, B);
        int[][] resultadoParalelo = mmp.calcularProducto();
        double tiempoParalelo = 0;
        for (int i = 0; i < numEval; i++) {
            long inicio = System.currentTimeMillis();
            mmp.calcularProducto();
            tiempoParalelo += System.currentTimeMillis() - inicio;
        }
        tiempoParalelo /= numEval;

        // Mostrar resultados secuenciales y paralelos para comparar
        if (!Arrays.deepEquals(resultadoSecuencial, resultadoParalelo))
            throw new Error("ERROR: ¡El resultado secuencial y paralelo no coinciden!");
        System.out.format("Tiempo secuencial promedio: %.1f ms\n", tiempoSecuencial);
        System.out.format("Tiempo paralelo promedio: %.1f ms\n", tiempoParalelo);
        System.out.format("Speedup: %.2f \n", tiempoSecuencial / tiempoParalelo);
        System.out.format("Eficiencia: %.2f%%\n",
                100 * (tiempoSecuencial / tiempoParalelo) / Runtime.getRuntime().availableProcessors());
    }
}