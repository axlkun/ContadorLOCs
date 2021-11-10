package segundocasoaplicado;

import java.io.File;
import javax.swing.JOptionPane;
import segundocasoaplicado.contadorLOC;

public class AnalizarDirectorio {

    contadorLOC programa;

    public AnalizarDirectorio(contadorLOC programa) {
        this.programa = programa;

    }

    public void analizarRecursivo(File archivo) {
        File listado[];
        listado = archivo.listFiles();
        for (int indice = 0; indice < listado.length; indice++) {
            if (listado[indice].isDirectory()) {
                analizarRecursivo(listado[indice]);
            } else if (listado[indice].toString().endsWith(".java")) {
                programa.actualizar(listado[indice]);
            }
        }
    }

    public void analizar(File archivo) {
        //System.out.println("si entra");
        if (archivo != null) {         
            File listado[];
            boolean entrar = true;
            listado = archivo.listFiles();                   
            
            if (entrar) {              
                for (int indice = 0; indice < listado.length; indice++) {
                    if (listado[indice].isDirectory()) {                     
                            analizarRecursivo(listado[indice]);      
                    } 
                }
            }
        }
    }
}
