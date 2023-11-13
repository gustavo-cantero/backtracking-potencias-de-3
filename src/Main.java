import java.util.ArrayList;

public class Main {
    private static final String SET_BOLD_TEXT = "\033[0;1m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {
        ArrayList<Integer> nroPares = new ArrayList<Integer>();
        nroPares.add(2);
        nroPares.add(6);
        nroPares.add(8);
        ArrayList<Integer> nroImpares = new ArrayList<Integer>();
        nroImpares.add(5);
        //nroImpares.add(7);
        nroImpares.add(9);

        System.out.println(ANSI_GREEN + "\nCalculando...");

        EncontrarPotenciaDeTresImplementacion potenciaTres = new EncontrarPotenciaDeTresImplementacion();
        ArrayList<Integer> resultado = potenciaTres.obtenerPotencia(nroPares, nroImpares);

        System.out.println(SET_BOLD_TEXT + ANSI_BLACK + "\nEl resultado es el siguiente:" + ANSI_BLUE);
        for (int i = 0; i < resultado.size(); i++) {
            if (i != 0)
                System.out.print(", ");
            System.out.print(resultado.get(i).toString());
        }

        System.out.println('\n');
    }

}
