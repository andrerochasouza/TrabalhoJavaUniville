import java.util.ArrayList;

public class Frame {
    private int id;
    private int tempoDeCarga;
    private int qtdRef;
    private int tempoUltRef;
    private int br;
    private int bm;

    public Frame(){ }

    public Frame(int id, int tempoDeCarga, int qtdRef, int tempoUltRef, int br, int bm) {
        this.id = id;
        this.tempoDeCarga = tempoDeCarga;
        this.qtdRef = qtdRef;
        this.tempoUltRef = tempoUltRef;
        this.br = br;
        this.bm = bm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTempoDeCarga() {
        return tempoDeCarga;
    }

    public void setTempoDeCarga(int tempoDeCarga) {
        this.tempoDeCarga = tempoDeCarga;
    }

    public int getQtdRef() {
        return qtdRef;
    }

    public void setQtdRef(int qtdRef) {
        this.qtdRef = qtdRef;
    }

    public int getTempoUltRef() {
        return tempoUltRef;
    }

    public void setTempoUltRef(int tempoUltRef) {
        this.tempoUltRef = tempoUltRef;
    }

    public int getBr() {
        return br;
    }

    public void setBr(int br) {
        this.br = br;
    }

    public int getBm() {
        return bm;
    }

    public void setBm(int bm) {
        this.bm = bm;
    }

    @Override
    public String toString() {
        return "Frame [bm=" + bm + ", br=" + br + ", id=" + id + ", qtdRef=" + qtdRef + ", tempoDeCarga=" + tempoDeCarga
                + ", tempoUltRef=" + tempoUltRef + "]";
    }

    public static int fifo(ArrayList<Frame> frames){
        int aux = frames.get(0).getTempoDeCarga();
        int auxId = 0;

        for (Frame frame : frames) {
            if(aux >= frame.getTempoDeCarga()){
                aux = frame.getTempoDeCarga();
                auxId = frame.getId();
            }
        }

        return auxId;
    }   

    public static int lfu(ArrayList<Frame> frames){
        int aux = frames.get(0).getQtdRef();
        int auxId = 0;

        for (Frame frame : frames) {
            if(aux >= frame.getQtdRef()){
                aux = frame.getQtdRef();
                auxId = frame.getId();
            }
        }

        return auxId;
    }

    public static int lru(ArrayList<Frame> frames){
        int aux = frames.get(0).getTempoUltRef();
        int auxId = 0;

        for (Frame frame : frames) {
            if(aux <= frame.getTempoUltRef()){
                aux = frame.getTempoUltRef();
                auxId = frame.getId();
            }
        }

        return auxId;
    }

    public static int nru(ArrayList<Frame> frames){
        int aux = frames.get(0).getQtdRef();
        for (Frame frame : frames) {
            if(frame.getBm() == 0 && frame.getBr() == 0){
                return frame.getId();
            }
        }

        for (Frame frame : frames) {
            if(frame.getBm() == 0 && frame.getBr() == 1){
                return frame.getId();
            }
        }

        return frames.get(0).getId();
    }

}
