package br.com.finalcraft.unesp.tc.maquinanorma.registrador;

public class Recorder implements Comparable<Recorder>{

    public final String name;
    public int value = 0;
    public int signal = 0;

    public Recorder(String name, int value, int signal) {
        this.name = name;
        this.value = value;
        this.signal = signal;
    }

    public void addOne(){
        if (this.signal == 0){
            this.value++;
        }else {
            this.value--;
            if (this.value == 0){
                this.signal--;
            }
        }
    }

    public void removeOne(){
        if (this.signal == 0){
            if (this.value == 0){
                this.signal++;
                this.value++;
            }else {
                this.value--;
            }
        }else {
            this.value++;
        }
    }

    public void invertSignal(){
        this.signal = (this.signal == 0 ? 1 : 0);
    }

    @Override
    public int compareTo(Recorder o) {
        return Integer.compare(this.value,o.value);
    }
}
