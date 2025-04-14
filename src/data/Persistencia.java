package data;

import domain.*;

import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;

public class Persistencia {
    private static ArrayList<Mamifero> animales = new ArrayList<>();
    private static ArrayList<Sector> sectores = new ArrayList<>();
    private static ArrayList<Especie> especies = new ArrayList<>();
    private static ArrayList<Pais> paises = new ArrayList<>();
    private static ArrayList<Empleado> empleados = new ArrayList<>();

    public static ArrayList<Mamifero> getAnimales() {
        return animales;
    }

    public static ArrayList<Sector> getSectores() {
        return sectores;
    }

    public static ArrayList<Especie> getEspecies() {
        return especies;
    }

    public static double getTotalComida(TipoAlimentacion tipoAlimentacion) {
        double total = 0;
        for(Mamifero animal : animales){
            total += animal.TieneAlimentacion(tipoAlimentacion) ? animal.calcularCantidadDeComida() : 0;
        }
        return total;
    }
    public static void cargarAnimal(int edad,double peso,String nombreEspecie,String tipoDeAlimentacion,
                                    double porcentajeDeAlimentacion, double alimentacionFija, int numeroSector,double latitud,
                                    double longitud,int limite, String empleado,String pais,String codigoIso) throws InvalidPropertiesFormatException{

        Empleado empleadoSeleccionado = seleccionarEmpleado(empleado);

        Pais paisOrigen = new Pais(pais,codigoIso);

        if(tipoDeAlimentacion.equals("CARNIVORO")){
            Especie especie = new Especie(nombreEspecie,TipoAlimentacion.CARNIVORO,porcentajeDeAlimentacion);
            Sector sector = new Sector(numeroSector, latitud, longitud, limite,TipoAlimentacion.CARNIVORO, empleadoSeleccionado);

            animales.add(new Carnivoro(edad, peso, especie, sector, paisOrigen));
        }else{
            Especie especie = new Especie(nombreEspecie,TipoAlimentacion.HERBIVORO,porcentajeDeAlimentacion);
            Sector sector = new Sector(numeroSector, latitud, longitud, limite,TipoAlimentacion.HERBIVORO, empleadoSeleccionado);

            animales.add(new Herbivoro(edad, peso, especie, sector, alimentacionFija, paisOrigen));
        }

    }

private static Empleado seleccionarEmpleado(String empleadoABuscar){

        empleados.add(new Empleado("Raul A", "20111222", "Tucumán" ));
        empleados.add(new Empleado("Maria B", "30111222", "Tucumán" ));

        Empleado empleadoSeleccionado = new Empleado();

        for(Empleado empleado : empleados){
            if(empleado.getNombre().contains(empleadoABuscar)){
                empleadoSeleccionado = empleado;
            }
        }
        return empleadoSeleccionado;
    }
}
