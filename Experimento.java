import java.util.ArrayList;

public class Experimento implements java.io.Serializable {
    public ArrayList<Poblacion> poblaciones;

    public Experimento(ArrayList<Poblacion> poblaciones) {
        this.poblaciones = poblaciones;
    }
}