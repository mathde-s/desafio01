import java.util.*;

public class Main {

        static List<Integer> acertos = new ArrayList<>();
        static List<Integer> erros = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int continua;
        int pontuacao = 0;

        while (true) {
            int numeroSorteado = 5 ;//random.nextInt(10);
            System.out.println("bem vindo ao jogo de adivinhação! para continuar escolha um palpite.");
            int numeroEscolhido = scanner.nextInt();

            while (!validaNumero(numeroEscolhido))
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
    static boolean validaNumero(int escolhido){
        if (escolhido < 0 || escolhido > 10){
            System.out.println("número inválido, escolha um número entre 0 a 10");
            return false;
        }
        return true;
    }
    static int pontuador(int escolhido, int sorteado){
        int pontos = 0;

        if(escolhido == sorteado)
        {
            System.out.println("parabéns você acertou o número e ganhou 10 pontos");
            pontos += 10;
            acertos.add(escolhido);
        }
        else if(escolhido + 1 == sorteado || escolhido - 1 == sorteado) {
            System.out.println("você quase acertou, ganhou 5 pontos");
            System.out.println("o número sorteado era: "+sorteado);
            pontos += 5;
        }
        else {
            System.out.println("infelizmente você não acertou");
            System.out.println("o número sorteado era: "+sorteado);
            erros.add(escolhido);
        }
        return pontos;
    }
}