import java.sql.Date;

public class Poblacion implements java.io.Serializable{
    public enum Luminosidad {ALTA, MEDIA, BAJA}
    public enum SuministroComida {INCREMENTO_DECREMENTO, CONSTANTE, INCREMENTO, CADA_2_DIAS}

    public String nombre;
    public Date fechaComienzo;
    public Date fechaFin;
    public int bacteriaInicial;
    public int temperatura;
    public Comida comida;
    public int duracion;
    public Luminosidad luminosidad;
    public SuministroComida suministroComida;

    public Poblacion(String nombre, Date fechaComienzo, int bacteriaInicial,
                     int temperatura, Comida comida, int duracion, Luminosidad luminosidad, SuministroComida suministroComida) {
        this.nombre = nombre;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = Date.valueOf(fechaComienzo.toLocalDate().plusDays(duracion));
        this.bacteriaInicial = bacteriaInicial;
        this.temperatura = temperatura;
        this.comida = comida;
        this.duracion = duracion;
        this.luminosidad = luminosidad;
        this.suministroComida = suministroComida;
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
                "Día máximo de comida: " + comida.getDiaMaximo(),
                "Duración: " + duracion + " días"
        };
    }

    public int getDosis(Date fecha) {
        if (fecha.before(fechaComienzo) || fecha.after(fechaFin)) {
            throw new IllegalArgumentException("Fecha fuera de rango");
        }
        int dia = (int) (fecha.toLocalDate().toEpochDay() - fechaComienzo.toLocalDate().toEpochDay()) + 1;

        if (suministroComida == SuministroComida.CONSTANTE) {
            return comida.dosisInicial;
        } else if (suministroComida == SuministroComida.INCREMENTO) {
            return comida.dosisInicial + (comida.dosisFinal - comida.dosisInicial) / (duracion - 1) * (dia - 1);
        } else if (suministroComida == SuministroComida.INCREMENTO_DECREMENTO) {
            if (fecha.before(Date.valueOf(fechaComienzo.toLocalDate().plusDays(comida.diaMaximo)))) {
                return comida.dosisInicial + (comida.dosisMaxima - comida.dosisInicial) / (comida.diaMaximo - 1) * (dia - 1);
            } else {
                return comida.dosisMaxima + (comida.dosisFinal - comida.dosisMaxima) / (30 - comida.diaMaximo) * (dia - comida.diaMaximo);
            }
        } else if (suministroComida == SuministroComida.CADA_2_DIAS) {
            return dia % 2 == 0 ? 0 : comida.dosisInicial;
        } else {
            throw new IllegalArgumentException("Tipo de suministro de comida no reconocido");
        }
    }
}
