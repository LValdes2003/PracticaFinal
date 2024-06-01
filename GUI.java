import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JButton nuevoExperimento;
    private JButton cargarExperimento;
    private JButton guardarExperimento;

    public GUI() {
        frame = new JFrame("Experimentos de bacterias");
        JPanel panel = new JPanel();

        nuevoExperimento = new JButton("Nuevo experimento");
        cargarExperimento = new JButton("Cargar experimento");
        guardarExperimento = new JButton("Guardar experimento");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        panel.add(nuevoExperimento);
        panel.add(cargarExperimento);
        panel.add(guardarExperimento);

        nuevoExperimento.addActionListener(this);
        cargarExperimento.addActionListener(this);
        guardarExperimento.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevoExperimento) {
            nuevoExperimentoPanel();
        } else if (e.getSource() == cargarExperimento) {
            System.out.println("Cargar experimento");
        } else if (e.getSource() == guardarExperimento) {
            System.out.println("Guardar experimento");
        }
    }

    private void nuevoExperimentoPanel() {
        JPanel panelNuevoExperimento = new JPanel();
        panelNuevoExperimento.setLayout(new GridLayout(0, 1, 10, 10));
        panelNuevoExperimento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton nuevaPoblacionButton = new JButton("Nueva población");
        nuevaPoblacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datosExperimento();
            }
        });

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.revalidate();
                new GUI();
            }
        });

        panelNuevoExperimento.add(nuevaPoblacionButton);
        panelNuevoExperimento.add(backButton);

        frame.getContentPane().removeAll();
        frame.add(panelNuevoExperimento);
        frame.repaint();
        frame.revalidate();
    }

    private void datosExperimento() {
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(0, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelDatos.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panelDatos.add(nombreField);

        panelDatos.add(new JLabel("Fecha de inicio:"));
        JTextField inicioField = new JTextField();
        panelDatos.add(inicioField);

        panelDatos.add(new JLabel("Fecha de fin:"));
        JTextField finField = new JTextField();
        panelDatos.add(finField);

        panelDatos.add(new JLabel("Número inicial de bacterias:"));
        JTextField numeroInicialField = new JTextField();
        panelDatos.add(numeroInicialField);

        panelDatos.add(new JLabel("Temperatura:"));
        JTextField temperaturaField = new JTextField();
        panelDatos.add(temperaturaField);

        panelDatos.add(new JLabel("Condiciones de luminosidad:"));
        JComboBox<String> luminosidadComboBox = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});
        panelDatos.add(luminosidadComboBox);

        panelDatos.add(new JLabel("Cantidad inicial de comida:"));
        JTextField comidaInicialField = new JTextField();
        panelDatos.add(comidaInicialField);

        panelDatos.add(new JLabel("Día de incremento de comida:"));
        JTextField diaIncrementoField = new JTextField();
        panelDatos.add(diaIncrementoField);

        panelDatos.add(new JLabel("Cantidad de comida en día de incremento:"));
        JTextField comidaIncrementoField = new JTextField();
        panelDatos.add(comidaIncrementoField);

        panelDatos.add(new JLabel("Cantidad final de comida:"));
        JTextField comidaFinalField = new JTextField();
        panelDatos.add(comidaFinalField);

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.revalidate();
                new GUI();
            }
        });

        JButton submitButton = new JButton("Guardar datos del experimento");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Here, you can handle the input data
                String nombre = nombreField.getText();
                String inicio = inicioField.getText();
                String fin = finField.getText();
                int numeroInicial = Integer.parseInt(numeroInicialField.getText());
                double temperatura = Double.parseDouble(temperaturaField.getText());
                String luminosidad = (String) luminosidadComboBox.getSelectedItem();
                int comidaInicial = Integer.parseInt(comidaInicialField.getText());
                int diaIncremento = Integer.parseInt(diaIncrementoField.getText());
                int comidaIncremento = Integer.parseInt(comidaIncrementoField.getText());
                int comidaFinal = Integer.parseInt(comidaFinalField.getText());

                // Print data to the console for now (replace this with your actual save logic)
                System.out.println("Nombre: " + nombre);
                System.out.println("Fecha de inicio: " + inicio);
                System.out.println("Fecha de fin: " + fin);
                System.out.println("Número inicial de bacterias: " + numeroInicial);
                System.out.println("Temperatura: " + temperatura);
                System.out.println("Condiciones de luminosidad: " + luminosidad);
                System.out.println("Cantidad inicial de comida: " + comidaInicial);
                System.out.println("Día de incremento de comida: " + diaIncremento);
                System.out.println("Cantidad de comida en día de incremento: " + comidaIncremento);
                System.out.println("Cantidad final de comida: " + comidaFinal);
            }
        });

        panelDatos.add(submitButton);
        panelDatos.add(backButton);

        frame.getContentPane().removeAll();
        frame.add(panelDatos);
        frame.repaint();
        frame.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
