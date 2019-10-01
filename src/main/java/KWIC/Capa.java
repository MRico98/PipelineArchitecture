package KWIC;

public abstract class Capa{

    private Capa siguienteCapa;

    public abstract Object doit(Object param);

    public Object callDoIt(Object param){
        Object returnDoit = doit(param);
        if(siguienteCapa != null) {
            siguienteCapa.callDoIt(returnDoit);
        }
        return returnDoit;
    }

    public void setSiguienteCapa(Capa siguienteCapa){
        this.siguienteCapa = siguienteCapa;
    }

    public Capa getSiguienteCapa(){
        return this.siguienteCapa;
    }

}