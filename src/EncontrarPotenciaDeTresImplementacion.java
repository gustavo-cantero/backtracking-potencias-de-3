import java.util.ArrayList;

public class EncontrarPotenciaDeTresImplementacion implements EncontrarPotenciaDeTres {

    @Override
    public ArrayList<Integer> obtenerPotencia(ArrayList<Integer> nroPares, ArrayList<Integer> nroImpares) {
        int valActual = 0; //Valor actual formado por los dígitos recorridos
        ArrayList<Integer> res = new ArrayList<Integer>(); //Lista para guardar los valores resultantes
        int[] usos = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //Acá guardamos cuantas veces se utilizó cada dígito
        int[] cantPI = {0, 0}; //Cant. de números pares (posición cero) e impares (posición uno) que se utilizaron

        BuscarPot3(nroPares, nroImpares, valActual, cantPI, usos, res);

        return res;
    }

    private void BuscarPot3(ArrayList<Integer> p, ArrayList<Integer> i, long valActual, int[] cantPI, int[] usos, ArrayList<Integer> res) {
        ArrayList<Integer> t = p; //Referencia temporal para cambiar entre pares e impares.  Comenzamos con los pares.
        int pi = 0; //Guardamos si estamos utilizando los pares o impares.
        while (pi <= 1) {
            if (cantPI[pi] < Math.min(p.size(), i.size()) * 2) {
                cantPI[pi]++;
                t.forEach(v -> {
                    if (usos[v] < 2 && (v != 0 || valActual != 0)) {
                        usos[v]++;
                        long valTemp = valActual * 10 + v;
                        if (cantPI[0] == cantPI[1] && esPotencia(valTemp) && valTemp <= Integer.MAX_VALUE)
                            res.add((int)valTemp);
                        BuscarPot3(p, i, valTemp, cantPI, usos, res);
                        usos[v]--;
                    }
                });
                cantPI[pi]--;
            }
            pi++;
            t = i; //Cambio la referencia para utilizar los valores impares
        }
    }

    private boolean esPotencia(long valor) {
        double r = Math.cbrt(valor);
        return r == Math.floor(r) && !Double.isInfinite(r);
    }
}
