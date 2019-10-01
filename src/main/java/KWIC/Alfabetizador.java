package KWIC;

import java.util.ArrayList;

public class Alfabetizador extends Capa {

    private ArrayList<String> alfabetizar(ArrayList<String[]> tokens) {
        quickSort(tokens,0,tokens.size()-1);
        ArrayList<String> oraciones = new ArrayList<>();
        String contenedorstring = "";
        for(int contador=0;contador<tokens.size();contador++){
            for(int contador2=0;contador2<tokens.get(contador).length;contador2++){
                contenedorstring = contenedorstring + tokens.get(contador)[contador2] + " ";
            }
            oraciones.add(contenedorstring);
            contenedorstring = "";
        }
        return oraciones;
    }

    private void quickSort(ArrayList<String[]> tokens, int begin, int end) {
        if (begin < end) {
            int pivote = (int)Math.ceil((double)tokens.get(0).length/2);
            int partitionIndex = partition(tokens, begin, end,pivote);
            quickSort(tokens, begin, partitionIndex-1);
            quickSort(tokens, partitionIndex+1, end);
        }
    }

    private int partition(ArrayList<String[]> tokens, int begin, int end,int pivote) {
        String[] pivot = tokens.get(end);
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (tokens.get(j)[pivote].compareTo(pivot[pivote]) < 0) {
                i++;
                cambiostring(tokens.get(i),tokens.get(j));
            }
        }
        cambiostring(tokens.get(i+1),tokens.get(end));
        return i+1;
    }

    private void cambiostring(String[] array1,String[] array2){
        String[] contenedorauxiliar = new String[array1.length];
        for(int contador=0;contador<array1.length;contador++){
            contenedorauxiliar[contador] = array1[contador];
        }
        for(int contador=0;contador<array1.length;contador++){
            array1[contador] = array2[contador];
        }
        for(int contador=0;contador<array1.length;contador++){
            array2[contador] = contenedorauxiliar[contador];
        }
    }

    @Override
    public Object doit(Object param) {
        return alfabetizar((ArrayList<String[]>)param);
    }

}