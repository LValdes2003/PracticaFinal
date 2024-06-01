import java.io.*;

public class GestorArchivos {
    public void guardarExperimento(Experimento experimento, String nombreArchivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(experimento);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Experimento cargarExperimento(String nombreArchivo) {
        Experimento experimento = null;
        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            experimento = (Experimento) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Clase Experimento no encontrada");
            c.printStackTrace();

        }
        return experimento;
    }
}
