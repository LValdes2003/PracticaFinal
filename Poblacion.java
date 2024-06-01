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
}
