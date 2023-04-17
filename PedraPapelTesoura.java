import java.util.Scanner;

public class PedraPapelTesoura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jogo Pedra, Papel e Tesoura");

        int escolhaJogador;
        int escolhaComputador;
        int resultado;

        do {
            System.out.println("Escolha: 1 - Pedra, 2 - Papel, 3 - Tesoura");

            escolhaJogador = scanner.nextInt();
            escolhaComputador = (int) (Math.random() * 3) + 1;

            System.out.println("Jogador escolheu: " + jogadaToString(escolhaJogador));
            System.out.println("Computador escolheu: " + jogadaToString(escolhaComputador));

            resultado = verificarResultado(escolhaJogador, escolhaComputador);

            if (resultado == 0) {
                System.out.println("Empate! Vamos jogar novamente.");
            } else if (resultado == 1) {
                System.out.println("Jogador venceu!");
                System.out.println("Deseja jogar novamente? (s/n)");

                String jogarNovamente = scanner.next();

                if (jogarNovamente.equals("s")) {
                    resultado = 0; // jogar novamente
                }
            } else {
                System.out.println("Computador venceu!");
                System.out.println("Deseja jogar novamente? (s/n)");

                String jogarNovamente = scanner.next();

                if (jogarNovamente.equals("s")) {
                    resultado = 0; // jogar novamente
                }
            }

        } while (resultado == 0);
    }

    public static String jogadaToString(int jogada) {
        switch (jogada) {
            case 1:
                return "Pedra";
            case 2:
                return "Papel";
            case 3:
                return "Tesoura";
            default:
                return "";
        }
    }

    public static int verificarResultado(int jogadaJogador, int jogadaComputador) {
        if (jogadaJogador == jogadaComputador) {
            return 0; // empate
        } else if ((jogadaJogador == 1 && jogadaComputador == 3)
                || (jogadaJogador == 2 && jogadaComputador == 1)
                || (jogadaJogador == 3 && jogadaComputador == 2)) {
            return 1; // jogador vence
        } else {
            return -1; // computador vence
        }
    }
}
