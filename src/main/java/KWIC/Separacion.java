package KWIC;

import KWIC.Capa;

public class Separacion extends Capa {

    private String[] separacion(String entrada){
        String[] palabras = entrada.split(" ");
        return palabras;
    }

    @Override
    public Object doit(Object param) {
        return separacion((String)param);
    }

}