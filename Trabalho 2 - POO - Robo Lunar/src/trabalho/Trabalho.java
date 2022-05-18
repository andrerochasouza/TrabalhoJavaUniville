import java.util.Scanner;
import trabalho.DirecaoEnum;
import trabalho.RoboLunar;

public class Trabalho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RoboLunar robo = new RoboLunar("Robo teste", 100, 0, DirecaoEnum.NORTE, 0, 0, false);

        System.out.println("------------------------------------------------------");
        System.out.println("Bem vindo ao Robo Lunar!");
        System.out.println("Você pode acelerar ou frear o robo, ou ligar/desligar a lanterna");
        System.out.println("também podemos tirar fotos e guardar novas fotos na memória do robo");
        System.out.println("e por fim, mudar a direçao do robo");
        System.out.println("-----------------------------------------------------");
        System.out.println("Para acelerar digite 'a'");
        System.out.println("Para frear digite 'f'");
        System.out.println("Para ligar/desligar a lanterna digite 'l'");
        System.out.println("Para tirar fotos digite 't'");
        System.out.println("Para mudar a direção do robo digite 'd'");
        System.out.println("Para mostrar o status do robo digite 'i'");
        System.out.println("Para recarrear a bateria do robo digite 'r'");
        System.out.println("Para sair digite 's'");
        System.out.println("-----------------------------------------------------");

        while (true) {
            System.out.print("Digite uma opçao: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("a")) {
                robo.acelerar();
            } else if (opcao.equals("f")) {
                robo.frear();
            } else if (opcao.equals("l")) {
                robo.switchLuz();
            } else if (opcao.equals("t")) {
                robo.fotografar();
            } else if (opcao.equals("d")) {
                robo.rotacionarRobo();
            } else if (opcao.equals("i")) {
                robo.informaçoesRobo();
            } else if (opcao.equals("r")) {
                robo.recarregarBateria();
            } else if (opcao.equals("s")) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida");
            }
            System.out.println("-----------------------------------------------------");
        }

        scanner.close();
    }
}
