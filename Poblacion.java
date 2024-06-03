import java.sql.Date;

public class Poblacion implements java.io.Serializable{
    public enum Luminosidad {ALTA, MEDIA, BAJA}

    public String nombre;
    public Date fechaComienzo;
    public Date fechaFin;
    public int bacteriaInicial;
    public int temperatura;
    public Luminosidad luminosidad;
    public Comida comida;

    public Poblacion(String nombre, Date fechaComienzo, int bacteriaInicial,
                     int temperatura, Luminosidad luminosidad, Comida comida) {
        this.nombre = nombre;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = Date.valueOf(fechaComienzo.toLocalDate().plusDays(30));
        this.bacteriaInicial = bacteriaInicial;
        this.temperatura = temperatura;
        this.luminosidad = luminosidad;
        this.comida = comida;
    }

    public String[] toStringArray() {
        return new String[]{
                "Población: " + nombre,
                "Fecha de comienzo: " + fechaComienzo,
                "Fecha de fin: " + fechaFin,
                "Bacteria inicial: " + bacteriaInicial,
                "Temperatura: " + temperatura,
                "Luminosidad: " + luminosidad,
                "Comida inicial: " + comida.getDosisInicial(),
                "Comida máxima: " + comida.getDosisMaxima(),
                "Comida final: " + comida.getDosisFinal(),
                "Día máximo de comida: " + comida.getDiaMaximo()
        };
    }
}
