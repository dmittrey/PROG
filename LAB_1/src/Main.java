public class Main {

    public static void main(String[] args) {
        long[] f = new long[14];
        for (int i = 6; i < 20; i++) {
            f[i - 6] = i;
        }
        float[] x = new float[11];
        for (int i = 0; i < 11; i++) {
            x[i] = ((float) (Math.random() * 14 - 5));
        }
        double[][] e = new double[14][11];
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 11; j++) {
                if (f[i] == 16) e[i][j] = Math.log(Math.sqrt(Math.pow(Math.sin(x[j]), 2)));

                else if (f[i] > 9 && f[i] < 20 && f[i] != 12 && f[i] != 16 && f[i] != 18) {
                    e[i][j] = Math.pow((Math.pow(x[j],3) / (Math.pow(Math.E, x[j])+1/2)), 2 / 3);
                }
                else {
                    e[i][j] = Math.asin(Math.pow(Math.E, Math.pow(Math.pow((-1*Math.E),(Math.pow(x[j],x[j])/(2+2*x[j]))), 1/3)));
                }
            }
        }
        for (int i = 0; i < 14; i++) {
            System.out.println("");
            for (int j = 0; j < 11; j++) {
                System.out.printf("%.3f ", e[i][j]);
                }
            }

        }
    }
