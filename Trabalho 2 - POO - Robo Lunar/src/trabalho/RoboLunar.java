
import trabalho.DirecaoEnum;

public class RoboLunar {

    String nome;
    int bateria;
    int velocidade;
    DirecaoEnum direcaoLunar;
    int memoria;
    int fotos;
    boolean lanterna;

    public RoboLunar(String nome, int bateria, int velocidade, DirecaoEnum direcaoLunar, int memoria, int fotos, boolean lanterna) {
        this.nome = nome;
        this.bateria = bateria;
        this.velocidade = velocidade;
        this.direcaoLunar = direcaoLunar;
        this.memoria = memoria;
        this.fotos = fotos;
        this.lanterna = lanterna;
    }

    public void acelerar() {
        if (bateriaSuficiente()) {
            if (this.velocidade >= 100) {
                System.out.println("Velocidade máxima atingida");
            } else {
                System.out.println("Acelerando...");
                this.velocidade += 1;
                this.bateria -= 1;
            }

        }
    }

    public void frear() {
        if (bateriaSuficiente()) {
            if (this.velocidade <= 0) {
                System.out.println("Robo Lunar já está parado");
            } else {
                System.out.println("Freando...");
                this.velocidade -= 1;
                this.bateria -= 1;
            }
        }
    }

    public void switchLuz() {
        if (this.lanterna) {
            System.out.println("Lanterna desligada");
            this.lanterna = false;
        } else {
            if(bateriaSuficiente()) {
                System.out.println("Lanterna ligada");
                this.lanterna = true;
                this.bateria -= 1;
            }
        }
    }

    public void fotografar() {
        if (bateriaSuficiente()) {
            if (this.lanterna && memoriaSuficiente()) {
                System.out.println("Fotografando...");
                this.bateria -= 1;
                this.fotos += 1;
                this.memoria += 1;
            } else if (memoriaSuficiente()) {
                System.out.println("Lanterna desligada para fotografar");
            } else {
                System.out.println("Memoria insuficiente para fotografar");
            }
        }
    }

    public void informaçoesRobo() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Bateria: " + this.bateria + " %");
        System.out.println("Velocidade: " + this.velocidade + " km/h");
        System.out.println("Memoria: " + this.memoria + " MB");
        System.out.println("Lanterna: " + (this.lanterna ? "Ligada" : "Desligada"));
        System.out.println("Fotos: " + this.fotos);
    }

    public void rotacionarRobo() {
        if (bateriaSuficiente()) {
            if (this.rotacao >= 360 || this.rotacao < 0) {
                this.rotacao = 0;
            } else {
                System.out.println("Rotacionando 90 graus...");
                direcaoNova();
                System.out.println("Direção Robo Lunar: " + this.direcaoLunar);
                this.bateria -= 1;
            }
        }
    }

    public void recarregarBateria() {
        if (this.bateria >= 100) {
            System.out.println("Bateria já está carregada");
        } else {
            System.out.println("Recarregando bateria...");
            this.bateria += 10;
        }
    }

    private boolean bateriaSuficiente() {
        if (this.bateria > 10) {
            return true;
        } else {
            System.out.println("Bateria insuficiente, está em carregamento");
            this.bateria += 10;
            return false;
        }
    }

    private boolean memoriaSuficiente() {
        if (this.memoria < 100) {
            return true;
        } else {
            System.out.println("Memória insuficiente, está em uso total");
            return false;
        }
    }

    private DirecaoEnum direcaoNova() {
        switch (this.direcaoLunar) {
            case NORTE:
                return DirecaoEnum.LESTE;
            case LESTE:
                return DirecaoEnum.SUL;
            case SUL:
                return DirecaoEnum.OESTE;
            case OESTE:
                return DirecaoEnum.NORTE;
            default:
                return DirecaoEnum.NORTE;
        }
    }
}
