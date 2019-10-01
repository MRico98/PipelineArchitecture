package KWIC;

import java.util.ArrayList;
import java.util.Scanner;

public class Entrada extends Capa {

    private String ingresardatos() {
        System.out.println("Escriba la oriacion: ");
       return new Scanner(System.in).nextLine();
    }

    @Override
    public Object doit(Object param) {
        return ingresardatos();
    }

}