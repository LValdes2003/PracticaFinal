import java.io.Serializable;

public class Experimento implements Serializable {
    public Poblacion[] poblaciones = {};

    public Experimento(Poblacion[] poblaciones) {
        this.poblaciones = poblaciones;
    }
}