package KWIC;

import KWIC.Capa;

import java.util.ArrayList;
import java.util.Iterator;

public class Out extends Capa {

    private void impresion(ArrayList<String> strings){
        Iterator<String> iteradorpalabras = strings.iterator();
        while(iteradorpalabras.hasNext()){
            System.out.println(iteradorpalabras.next());
        }
    }

    @Override
    public Object doit(Object param) {
        impresion((ArrayList<String>)param);
        return null;
    }

}