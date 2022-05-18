import java.util.Scanner;
import trabalho.DirecaoEnum;
import trabalho.RoboLunar;

public class Trabalho {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        RoboLunar robo = new RoboLunar("Robo teste", 100, 0, DirecaoEnum.NORTE, 0, 0, false);

        robo.acelerar();
        robo.frear();
        robo.fotografar();
        robo.informaçoesRobo();

        scanner.close();
    }
}
