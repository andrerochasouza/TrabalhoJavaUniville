import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scan = new Scanner(System.in);

        ArrayList<Frame> frames = new ArrayList<>();
        frames.add(new Frame(1, 12, 10, 20, 1, 1)); 
        frames.add(new Frame(2, 10, 1, 12, 0, 0)); 
        frames.add(new Frame(3, 11, 2, 21, 1, 0)); 

        System.out.println("Qual algoritmo de substituição você quer?");
        System.out.println("(1) FIFO");
        System.out.println("(2) LFU");
        System.out.println("(3) LRU");
        System.out.println("(4) NRU");

        while(true){

            int number = scan.nextInt();

            if(number == 1){
                System.out.println(Frame.fifo(frames));
                return;
            } else if(number == 2) {
                System.out.println(Frame.lfu(frames));
                return;
            } else if(number == 3) {
                System.out.println(Frame.lru(frames));
                return;
            } else if(number == 4) {
                System.out.println(Frame.nru(frames));
                return;
            } else if(number > 4 || number < 1){
                System.out.println("Digite um número valido");
            }
        }
    }
}
