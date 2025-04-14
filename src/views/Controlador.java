package views;

import data.Persistencia;
import domain.*;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

public class Controlador {
    public static TipoAlimentacion[] getTiposAlimentacion(){
        return  TipoAlimentacion.values();
    }
    public static ArrayList<Especie> getEspecies(){
        return Persistencia.getEspecies();
    }
    public static ArrayList<Sector> getSectores(){
        return Persistencia.getSectores();
    }
    
    public static ArrayList<AnimalViewModel> getAnimales(){
        ArrayList<AnimalViewModel> animales = new ArrayList<>();
        for(Mamifero animal : Persistencia.getAnimales()){
            animales.add(new AnimalViewModel(animal));
        }
        return animales;
    }
    
    public static ComidaViewModel  calcularComida(){
        double totalCarnivoros = Persistencia.getTotalComida(TipoAlimentacion.CARNIVORO);
        double totalHerbivoros = Persistencia.getTotalComida(TipoAlimentacion.HERBIVORO);
        return new ComidaViewModel(totalCarnivoros, totalHerbivoros);
    }

    public static void AgregarAnimal(AgregarAnimalView vistaAnimal) throws InvalidPropertiesFormatException{
        
        int edad = Integer.parseInt(vistaAnimal.getTfEdad().getText());
        double peso = Double.parseDouble(vistaAnimal.getTfPeso().getText());
        String nombreEspecie = vistaAnimal.getTfEspecie().getText();
        String tipoDeAlimentacion = vistaAnimal.getCbTipoDeAlimentacion();
        double porcentajeDeAlimentacion = (Double.parseDouble(vistaAnimal.getTfPorcentajeAlimentacion().getText()))/100;
        double alimentacionFija = Double.parseDouble(vistaAnimal.getTfAlimentacionExtra().getText());
        int numeroSector = Integer.parseInt(vistaAnimal.getTfSector().getText());
        double latitud = Double.parseDouble(vistaAnimal.getTfLatitud().getText());
        double longitud = Double.parseDouble(vistaAnimal.getTfLongitud().getText());
        int limite = Integer.parseInt(vistaAnimal.getTfLimite().getText());
        String empleado = vistaAnimal.getCbEmpleado();
        String pais = vistaAnimal.getTfPais().getText();
        String codigoIso = vistaAnimal.getTfCodigo().getText();
        
        Persistencia.cargarAnimal(edad, peso, nombreEspecie, tipoDeAlimentacion,
                                    porcentajeDeAlimentacion, alimentacionFija, numeroSector, latitud,
                                    longitud, limite, empleado, pais, codigoIso);
        
        vistaAnimal.getTfEdad().setText("");
        vistaAnimal.getTfPeso().setText("");
        vistaAnimal.getTfEspecie().setText("");
        vistaAnimal.setCbTipoDeAlimentacion(0);
        vistaAnimal.getTfPorcentajeAlimentacion().setText("0");
        vistaAnimal.getTfAlimentacionExtra().setText("0");
        vistaAnimal.getTfSector().setText("");
        vistaAnimal.getTfLatitud().setText("");
        vistaAnimal.getTfLongitud().setText("");
        vistaAnimal.getTfLimite().setText("");
        vistaAnimal.setCbEmpleado(0);
        vistaAnimal.getTfPais().setText("");
        vistaAnimal.getTfCodigo().setText("");
    }
}
  
