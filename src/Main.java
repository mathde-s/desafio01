import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSorteado = random.nextInt(10);
        System.out.println("bem vindo ao jogo de adivinhação! para continuar escolha um palpite.");
        int numeroEscolhido = scanner.nextInt();

        while (!verificaNumero(numeroEscolhido))
            numeroEscolhido = scanner.nextInt();

        int pontuacao = pontuador(numeroEscolhido, numeroSorteado);

    }
    static boolean verificaNumero(int esolhido){
        if (esolhido < 0 | esolhido > 10){
            System.out.println("número inválido, escolha um número entre 0 a 10");
            return false;
        }
        return true;
    }
    static int pontuador(int escolhido, int sorteado){
        int pontos = 0;

        if(escolhido == sorteado)
        {
            System.out.println("parabéns você acertou o número");
            pontos += 10;
        }
        else if(escolhido + 1 == sorteado | escolhido - 1 == sorteado) {
            System.out.println("você quase acertou ");
            System.out.println("o número sorteado era: "+sorteado);
            pontos += 5;
        }
        else {
            System.out.println("infelizmente você não acertou");
            System.out.println("o número sorteado era: "+sorteado);
        }
        System.out.println("sua pontuação total é: "+pontos);

        return pontos;
    }
}