package br.unesp.petruspradella.maquinanorma.registrador;

public class Recorder implements Comparable<Recorder>{

    public final String name;
    public int value = 0;
    public int signal = 0;

    public Recorder(String name, int value, int signal) {
        this.name = name;
        this.value = value;
        this.signal = signal;
    }

    public void fixSignal(){
        if (value == 0 ) {
            signal = 0;
        }else if (value < 0){
            invertSignal();
            value = Math.abs(value);
        }
    }


    public void addOne(){
        if (this.signal == 1){
            this.value--;
        }else {
            this.value++;
        }
        fixSignal();
    }

    public void removeOne(){
        if (this.signal == 1){
            this.value++;
        }else {
            this.value--;
        }
        fixSignal();
    }

    public void invertSignal(){
        this.signal = (this.signal == 0 ? 1 : 0);
    }

    @Override
    public int compareTo(Recorder o) {
        return Integer.compare(this.value,o.value);
    }
}
