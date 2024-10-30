package app.Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class GestionBasicaFicheros {

    public GestionBasicaFicheros() {
    }

    public static List<Cliente> importarClientes(String nombre) throws  Exception {

        List<Cliente> listaClientes = new ArrayList<>();


        try (Stream<String> lineas = Files.lines(Path.of(nombre))) {

            lineas.forEach(valores -> {

                String nuevaValor = valores.replaceAll("[|,;]", ",");

                String valoresClientes[] = nuevaValor.split(",");

                listaClientes.add(new Cliente(Integer.parseInt(valoresClientes[0].trim()), valoresClientes[1].trim(),
                        valoresClientes[2].trim(), valoresClientes[3].trim(), valoresClientes[4].trim(), valoresClientes[5].trim(),
                        valoresClientes[6].trim(), null, true));

            });

        }

        return listaClientes;
    }

    public static void exportarClientesXML(List<Cliente> listaClientes, String nombreFile) throws JAXBException {

        JAXBContext contexto = JAXBContext.newInstance(ClientesWrap.class);
        Marshaller marshaller = contexto.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        ClientesWrap listaClientesFormato = new ClientesWrap(listaClientes);
        marshaller.marshal(listaClientesFormato, new File(nombreFile));

    }

    public static List<Cliente> importarClientesXML(String nombre) throws JAXBException {

        JAXBContext contexto = JAXBContext.newInstance(ClientesWrap.class);
        Unmarshaller unmarshaller = contexto.createUnmarshaller();
        ClientesWrap cliente1 = (ClientesWrap) unmarshaller.unmarshal(new File(nombre));

        return cliente1.getClientes();
    }

    public static void exportarIngredientesCsv(List<Ingrediente> listaIngrediente, String nombre)throws FileNotFoundException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        try (PrintWriter pw = new PrintWriter(nombre)) {
            StatefulBeanToCsv<Ingrediente> beanToCsv = new StatefulBeanToCsvBuilder<Ingrediente>(pw).withSeparator(';').build();
            beanToCsv.write(listaIngrediente);
        } 

    }

    public static List<Ingrediente> importatIngredientesCsv(String nombreArchivo) throws FileNotFoundException, IOException {

        List<Ingrediente> listaIngredientes = null;

        try (FileReader fileReader = new FileReader(nombreArchivo)) {

            CsvToBean<Ingrediente> csvToBean = new CsvToBeanBuilder<Ingrediente>(fileReader)
                    .withType(Ingrediente.class)
                    .withSeparator(';')
                    .build();

                    listaIngredientes = (List<Ingrediente>) csvToBean.parse();
        } 

        return listaIngredientes;
    }

}
