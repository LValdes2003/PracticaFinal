import java.util.Date;

public class Poblacion {
    public enum Luminosidad { ALTA, MEDIA, BAJA }
    public String nombre;
    public Date fechaComienzo;
    public Date fechaFin;
    public int bacteriaInicial;
    public int temperatura;
    public Luminosidad luminosidad;
    public Comida comida;

    public Poblacion(String nombre, Date fechaComienzo, Date fechaFin, int bacteriaInicial,
                     int temperatura, Luminosidad luminosidad, Comida comida) {
        this.nombre = nombre;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.bacteriaInicial = bacteriaInicial;
        this.temperatura = temperatura;
        this.luminosidad = luminosidad;
        this.comida = comida;
    }
}
