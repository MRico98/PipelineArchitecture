package KWIC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Combinaciones extends Capa {

    private ArrayList<String[]> hacercombinaciones(String[] tokens){
        ArrayList<String[]> contenedorcombinaciones = new ArrayList<>();
        int pivote = (int)Math.ceil((double)tokens.length/2);
        try {
            StopWords stopWords = new StopWords();
            for (int contador = 0; contador < tokens.length; contador++) {
                if (!stopWords.getStopwords().contains(tokens[pivote])) {
                    contenedorcombinaciones.add(tokens);
                }
                tokens = rotar(tokens).clone();
            }
        }
        catch(IOException e){
            System.out.println(e);
            return contenedorcombinaciones;
        }
        return contenedorcombinaciones;
    }

    private String[] rotar(String[] cadena){
        String contenedoraux = cadena[0];
        String contenedoraux2;
        for(int contador=0;contador<cadena.length;contador++){
            contenedoraux2 = cadena[(contador + 1) % cadena.length];
            cadena[(contador + 1) % cadena.length] = contenedoraux;
            contenedoraux = contenedoraux2;
        }
        return cadena;
    }

    @Override
    public Object doit(Object param) {
        return hacercombinaciones((String[])param);
    }

    public class StopWords{

        private ArrayList<String> stopwords;

        StopWords()throws IOException{
            stopwords = makeStopWords("stopwords.txt");
        }

        private ArrayList<String> makeStopWords(String rute) throws IOException {
            ArrayList<String> stopwords = new ArrayList<>();
            FileReader lectordearchivo = new FileReader(rute);
            BufferedReader streaminformacion = new BufferedReader(lectordearchivo);
            String cadenaleida;
            while((cadenaleida = streaminformacion.readLine())!=null){
                stopwords.add(cadenaleida);
            }
            return stopwords;
        }

        ArrayList<String> getStopwords() {
            return stopwords;
        }

        public void setStopwords(ArrayList<String> stopwords) {
            this.stopwords = stopwords;
        }

    }

}