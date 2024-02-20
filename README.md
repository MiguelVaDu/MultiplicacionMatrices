<h1>PROYECTO DE PROGRAMACIÓN PARALELA</h1>

<h2>MULTIPLICACIÓN DE MATRICES</h2>

Este proyecto es una implementación en Java para la multiplicación de matrices utilizando diferentes técnicas y estrategias para optimizar el rendimiento.

<h3>Puntos tratados:</h3>
- Calculo de multiplicación de matrices de manera secuencial.
- Calculo de multiplicación de matrices de manera paralela.
- Interfaz grafica que compara el promedio de los resultados en n ejecuciones.

<h4>Java M.M.Secuencial</h4>

```java
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
```
<h4>Java M.M.Paralela</h4>

```java
public class MultiMatriParalela {

    private int[][] A, B;
    private int numFilasA, numColsA, numFilasB, numColsB;

    public MultiMatriParalela(int[][] A, int[][] B) {
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

    public int[][] calcularProducto() {
    	// crear grupo de subprocesos
        int numTrab = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numTrab);

        //enviar tareas para calcular resultados parciales
        int subseccion = (int) Math.ceil((double) numFilasA / numTrab);
        Future<int[][]>[] futures = new Future[numTrab];
        for (int w = 0; w < numTrab; w++) {
            int start = Math.min(w * subseccion, numFilasA);
            int end = Math.min((w + 1) * subseccion, numFilasA);
            futures[w] = pool.submit(new TrabajadorParalelo(start, end));
        }

        //unir resultados parciales
        int[][] C = new int[numFilasA][numColsB];
        try {
            for (int w = 0; w < numTrab; w++) {
            	// recuperar valor del futuro
                int[][] parteC = futures[w].get();
                for (int i = 0; i < parteC.length; i++)
                    for (int j = 0; j < numColsB; j++)
                        C[i + (w * subseccion)][j] = parteC[i][j];
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        return C;
    }

    /*El trabajador calcula el resultado para el subconjunto de filas en C */
    private class TrabajadorParalelo implements Callable {

        private int filaInicialC, filaFinalC;

        public TrabajadorParalelo(int filaInicialC, int filaFinalC) {
            this.filaInicialC = filaInicialC;
            this.filaFinalC = filaFinalC;
        }

        public int[][] call(){
            int[][] parteC = new int[filaFinalC - filaInicialC][numColsB];
            for (int i = 0; i < filaFinalC - filaInicialC; i++) {
                for (int k = 0; k < numColsB; k++) {
                    int sum = 0;
                    for (int j = 0; j < numColsA; j++) {
                        sum += A[i + filaInicialC][j] * B[j][k];
                    }
                    parteC[i][k] = sum;
                }
            }
            return parteC;
        }
    }
}
```
