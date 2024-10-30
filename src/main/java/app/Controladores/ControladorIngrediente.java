package app.Controladores;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import app.Modelo.GestionBasicaFicheros;
import app.Modelo.Ingrediente;

public class ControladorIngrediente {

    public void exportarIngredientes(List<Ingrediente> listaAlumnos, String nombre) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, FileNotFoundException {
       
        GestionBasicaFicheros.exportarIngredientesCsv(listaAlumnos, nombre);

    }

    public List<Ingrediente> importatIngredientes(String nombreArchivo) throws FileNotFoundException, IOException {
        
        return GestionBasicaFicheros.importatIngredientesCsv(nombreArchivo);
    }

}
