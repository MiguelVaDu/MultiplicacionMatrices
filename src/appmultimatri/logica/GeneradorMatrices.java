package appmultimatri.logica;

import java.util.Random;

public class GeneradorMatrices {
	/* función para generar matriz MxN de enteros aleatorios */
	public static int[][] generarMatrizAleatoria(int M, int N) {
		System.out.format("Generando matrix random de %d x %d ...\n", M, N);
		Random rand = new Random();
		int[][] output = new int[M][N];
		for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                output[i][j] = rand.nextInt(100);
        return output;
    }
}
