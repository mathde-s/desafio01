import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class teste {

    static List<Integer> acertos = new ArrayList<>();
    static List<Integer> erros = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int continua;
        int pontuacao = 0;

        while (true) {
            System.out.println("bem vindo ao jogo de adivinhação!");
            System.out.println("escolha um nivel de dificuldade: 1- fácil | 2- médio | 3- dificil");
            int dificuldade = scanner.nextInt();
            int numeroSorteado = sorteiaNumeroAleatorio(dificuldade);
            validaDificuldade(dificuldade);
            System.out.println("digite um palpite");
            int numeroEscolhido = scanner.nextInt();

            while (!validaDificuldade(dificuldade))
                dificuldade = scanner.nextInt();

            while (!validaNumero(numeroEscolhido, dificuldade))
                numeroEscolhido = scanner.nextInt();
            pontuacao += pontuador(numeroEscolhido,numeroSorteado);
            System.out.println("sua pontuação total é: "+pontuacao);

            System.out.println("uma nova rodada irá iniciar, para sair aperte 0 e para continuar aperte outro número");
            continua = scanner.nextInt();
            if (continua == 0) {
                System.out.println("números certos: "+ acertos);
                System.out.println("números errados: "+ erros);
                return;
            }
        }
    }
    static boolean validaNumero(int escolhido,int dificuldade){
        switch (dificuldade){
            case 1:
                if (escolhido < 0 || escolhido > 10) {
                    System.out.println("número inválido, escolha um número entre 0 a 10");
                    return false;
                }
            case 2:
                if (escolhido < 0 || escolhido > 50) {
                    System.out.println("número inválido, escolha um número entre 0 a 50");
                    return false;
                }
            case 3:
                if (escolhido < 0 || escolhido > 100) {
                    System.out.println("número inválido, escolha um número entre 0 a 100");
                    return false;
                }
        }

        return true;
    }

    static boolean validaDificuldade(int dificuldade){
        if (dificuldade != 1 && dificuldade != 2 && dificuldade != 3){
            System.out.println("dificuldade inválida, escolha um número entre 1 a 3");
            return false;
        }
        return true;
    }
    static int pontuador(int escolhido, int sorteado){
        int pontos = 0;


        if (escolhido == sorteado) {
            System.out.println("parabéns você acertou o número e ganhou 10 pontos");
            pontos += 10;
            acertos.add(escolhido);
        } else if (escolhido + 1 == sorteado || escolhido - 1 == sorteado) {
            System.out.println("você quase acertou, ganhou 5 pontos");
            System.out.println("o número sorteado era: " + sorteado);
            pontos += 5;
        } else {
            System.out.println("infelizmente você não acertou");
            System.out.println("o número sorteado era: " + sorteado);
            erros.add(escolhido);
        }

        return pontos;
    }
    static int sorteiaNumeroAleatorio(int dificuldade){
        Random random = new Random();

        if (dificuldade == 1) {
            return random.nextInt(10);
        } else if (dificuldade == 2) {
            return random.nextInt(50);
        } else if (dificuldade == 3) {
            return random.nextInt(100);
        }
        return 0;
    }
}