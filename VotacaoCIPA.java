import java.util.ArrayList;
import java.util.Scanner;

public class VotacaoCIPA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Candidatos
        String[] candidatos = { "Ana Paula", "Carlos Eduardo", "Fernanda Oliveira" };

        // Contadores de votos
        int[] votos = { 0, 0, 0 };
        int votosBranco = 0;

        // Lista de quem ja votou
        ArrayList<String> votantes = new ArrayList<>();

        System.out.println("=== VOTACAO CIPA 2025 ===");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n----------------------------");
            System.out.print("Digite seu NOME (ou FIM para encerrar): ");
            String nome = scanner.nextLine().trim().toUpperCase();

            if (nome.equals("FIM")) {
                continuar = false;
                break;
            }

            if (nome.isEmpty()) {
                System.out.println("Nome invalido! Tente novamente.");
                continue;
            }

            if (votantes.contains(nome)) {
                System.out.println("Voce ja votou, " + nome + "!");
                continue;
            }

            // Exibe candidatos
            System.out.println("\nCANDIDATOS:");
            System.out.println("1 - Ana Paula");
            System.out.println("2 - Carlos Eduardo");
            System.out.println("3 - Fernanda Oliveira");
            System.out.println("0 - Voto em Branco");

            // Leitura e validacao do voto
            int voto = -1;
            while (voto < 0 || voto > 3) {
                System.out.print("Digite o numero do seu voto: ");
                try {
                    voto = Integer.parseInt(scanner.nextLine().trim());
                    if (voto < 0 || voto > 3) {
                        System.out.println("Numero invalido! Digite 0, 1, 2 ou 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas numeros!");
                    voto = -1;
                }
            }

            // Registra voto
            votantes.add(nome);

            if (voto == 0) {
                votosBranco++;
                System.out.println("Voto em BRANCO registrado para " + nome + "!");
            } else {
                votos[voto - 1]++;
                System.out.println("Voto registrado para " + candidatos[voto - 1] + "!");
            }

            // Resultado parcial imediato
            System.out.println("\n--- RESULTADO PARCIAL ---");
            System.out.println("1 - James Professo:        " + votos[0] + " voto(s)");
            System.out.println("2 - Carlos Eduardo:   " + votos[1] + " voto(s)");
            System.out.println("3 - Fernanda Oliveira:" + votos[2] + " voto(s)");
            System.out.println("0 - Votos em branco:  " + votosBranco);
            System.out.println("Total de votos: " + votantes.size());
        }

        // Resultado final
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Total de votantes: " + votantes.size());
        System.out.println("1 - Ana Paula:        " + votos[0] + " voto(s)");
        System.out.println("2 - Carlos Eduardo:   " + votos[1] + " voto(s)");
        System.out.println("3 - Fernanda Oliveira:" + votos[2] + " voto(s)");
        System.out.println("0 - Votos em branco:  " + votosBranco);

        // Encontra o vencedor
        int maiorVoto = 0;
        int indiceVencedor = -1;
        for (int i = 0; i < votos.length; i++) {
            if (votos[i] > maiorVoto) {
                maiorVoto = votos[i];
                indiceVencedor = i;
            }
        }

        if (indiceVencedor == -1) {
            System.out.println("\nNenhum candidato recebeu votos.");
        } else {
            System.out.println("\nELEITO(A): " + candidatos[indiceVencedor] + " com " + maiorVoto + " voto(s)!");
        }

        System.out.println("\nFim da votacao. Obrigado!");
        scanner.close();
    }
}