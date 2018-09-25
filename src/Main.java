
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Barbara Luisa
 * @author Matheus Patrick
 */
public class Main {

    public static void init() throws IOException {
        System.out.println("------------------------------------------------------");
        System.out.println("Seja bem vindo ao Nexus! O que deseja fazer?");
        System.out.println("------------------------------------------------------");
        System.out.println("1 - Escolher a quantidade de registros a ser gerada");
        System.out.println("2 - Gerar arquivo");
        System.out.println("3 - Ler Arquivo");
        System.out.println("0 - Sair do Programa");
        System.out.println("------------------------------------------------------");

        int opcao = getInt(0);
        LapManager SN = new LapManager();
        double startTime = -1;

        switch (opcao) {
            case 1:
                System.out.println("Quantos registros devem ser criados? (Valor inteiro)");
                int quantity = getInt(0);
                System.out.println("Gostaria de visualizar as informacoes das maratonas na tela? (1- Sim, 2- Nao)");
                int verbose = getInt(0);
                startTime = System.nanoTime();
                SN.generateFiles(quantity, verbose);
                break;
            case 2:
                startTime = System.nanoTime();
                System.out.println("Gostaria de visualizar as informacoes da criacao do registro na tela? (1- Sim, 2- Nao)");
                int verbose2 = getInt(0);
                System.out.println("Qual o tamanho do arquiv (em MB)?  (exemplo: 100 = 100MB)");
                double fileSize = getInt(0);
                SN.generateBigFile(verbose2, fileSize);
                break;
            case 3:
                startTime = System.nanoTime();
                System.out.println("Qual o tipo de organizacao que voce deseja utilizar? (1 - Codigo, 2 - Nome, 3 - Tempo de corrida, 4 - Data da Corrida)");
                int indexType = getInt(1);
                SN.readBigFileIndexedObjects(indexType);
                break;
            case 4:
                SN.readBigFile();
            case 0:
                System.out.println("------------------------------------------------------");
                System.out.println("Obrigado por utilizar o Nexus, tenha um otimo dia!");
                System.out.println("------------------------------------------------------");
                System.exit(0);
                return;
            default:
                System.out.println("Por favor, digite uma opcao valida!");
                break;
        }
        if (startTime != -1) {
            double endTime = System.nanoTime();
            double totalTime = (endTime - startTime) / 1e9;
            System.out.printf("Tempo de processamento: %.2f segundos. \n", totalTime);
        }
        if (opcao != 0) {
            init();
        }
    }

    public static void main(String[] args) throws IOException {
        init();
    }

    public static int getInt(int type) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int returned = scanner.nextInt();
            if (type == 1 && (returned < 1 || returned > 4)) {
                System.out.println("Valor invalido! Tente novamente.. ");
                return getInt(0);
            } else {
                return returned;
            }
        } else {
            System.out.println("Valor invalido! Tente novamente.. ");
            return getInt(0);
        }
    }
}
