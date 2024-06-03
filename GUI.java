import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class GUI implements ActionListener {
    private JFrame frame;
    private JButton nuevoExperimento;
    private JButton cargarExperimento;
    private JButton guardarExperimento;
    private JPanel panelNuevoExperimento;
    private JPanel panelCargarExperimento;
    private Poblacion poblacion;
    private String nombreExperimento = "";



    public GUI() {
        frame = new JFrame("Experimentos de bacterias");
        JPanel panel = new JPanel();

        nuevoExperimento = new JButton("Nuevo experimento");
        cargarExperimento = new JButton("Cargar experimento");
//        guardarExperimento = new JButton("Guardar experimento");

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);

        panel.add(nuevoExperimento);
        panel.add(cargarExperimento);
//        panel.add(guardarExperimento);

        nuevoExperimento.addActionListener(this);
        cargarExperimento.addActionListener(this);
//        guardarExperimento.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevoExperimento) {
            nuevoExperimentoPanel();
        } else if (e.getSource() == cargarExperimento) {
            cargarExperimentoPanel();
            }
/*        } else if (e.getSource() == guardarExperimento) {
            System.out.println("Guardar experimento");
        }*/
    }

    private void nuevoExperimentoPanel() {
        panelNuevoExperimento = new JPanel();
        panelNuevoExperimento.setLayout(new GridLayout(0, 1, 10, 10));
        panelNuevoExperimento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField nombreField = new JTextField();
        panelNuevoExperimento.add(new JLabel("Nombre del experimento:"));
        panelNuevoExperimento.add(nombreField);
        
        nombreField.addActionListener(e -> nombreExperimento = nombreField.getText());

        JButton nuevaPoblacionButton = new JButton("Nueva población");
        nuevaPoblacionButton.addActionListener(e -> datosExperimento());

        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> {
            GestorArchivos gestorArchivos = new GestorArchivos();
            Experimento experimento = new Experimento(new Poblacion[]{poblacion});
            gestorArchivos.guardarExperimento(experimento, nombreExperimento + ".ser");
            JOptionPane.showMessageDialog(frame, "Experimento guardado", " ", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            new GUI();
        });

        panelNuevoExperimento.add(nuevaPoblacionButton);
        panelNuevoExperimento.add(botonGuardar);
        panelNuevoExperimento.add(botonVolver);

        frame.getContentPane().removeAll();
        frame.add(panelNuevoExperimento);
        frame.repaint();
        frame.revalidate();
    }

    private void cargarExperimentoPanel() {
        panelCargarExperimento = new JPanel();
        panelCargarExperimento.setLayout(new GridLayout(0, 1, 10, 10));
        panelCargarExperimento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelCargarExperimento.add(new JLabel("Introduce nombre de archivo:"));
        JTextField nombreArchivoField = new JTextField();
        panelCargarExperimento.add(nombreArchivoField);

        JButton botonCargar = getjButton(nombreArchivoField);

        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            new GUI();
        });

        panelCargarExperimento.add(botonCargar);
        panelCargarExperimento.add(botonVolver);

        frame.getContentPane().removeAll();
        frame.add(panelCargarExperimento);
        frame.repaint();
        frame.revalidate();
    }

    private JButton getjButton(JTextField nombreArchivoField) {
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(e -> {
            GestorArchivos gestorArchivos = new GestorArchivos();
            Experimento experimento = gestorArchivos.cargarExperimento(nombreArchivoField.getText());
            if (experimento != null) {
                JOptionPane.showMessageDialog(frame, "Experimento cargado", " ", JOptionPane.INFORMATION_MESSAGE);
                for(Poblacion poblacion : experimento.poblaciones) {
                    JButton nombrePoblacion = new JButton(poblacion.nombre);
                    panelCargarExperimento.add(nombrePoblacion);

                    nombrePoblacion.addActionListener(e1 -> panelPoblacion());
                }
                /*nombrePoblacion.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panelPoblacion();
                    }
                });*/

            } else {
                JOptionPane.showMessageDialog(frame, "Error al cargar experimento", " ", JOptionPane.ERROR_MESSAGE);
            }
        });
        return botonCargar;
    }

    private void datosExperimento() {
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(0, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelDatos.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panelDatos.add(nombreField);

        panelDatos.add(new JLabel("Fecha de inicio (formato yyyy-mm-dd):"));
        JTextField inicioField = new JTextField();
        panelDatos.add(inicioField);

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

        panelDatos.add(new JLabel("Cantidad de comida en día máximo:"));
        JTextField comidaMaximaField = new JTextField();
        panelDatos.add(comidaMaximaField);

        panelDatos.add(new JLabel("Cantidad final de comida:"));
        JTextField comidaFinalField = new JTextField();
        panelDatos.add(comidaFinalField);

        panelDatos.add(new JLabel("Día máximo de comida:"));
        JTextField diaMaximoField = new JTextField();
        panelDatos.add(diaMaximoField);

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            nuevoExperimentoPanel();
        });

        JButton botonSubmit = new JButton("Submit");
        botonSubmit.addActionListener(e -> {
            String nombre = nombreField.getText();
            Date inicio = Date.valueOf(inicioField.getText());
            int numeroInicial = Integer.parseInt(numeroInicialField.getText());
            int temperatura = Integer.parseInt(temperaturaField.getText());
            Poblacion.Luminosidad luminosidad = Poblacion.Luminosidad.valueOf(((String) luminosidadComboBox.getSelectedItem()).toUpperCase());
            Comida comida = new Comida(Integer.parseInt(comidaInicialField.getText()),
                    Integer.parseInt(comidaMaximaField.getText()), Integer.parseInt(comidaFinalField.getText()),
                    Integer.parseInt(diaMaximoField.getText()));

            poblacion = new Poblacion(nombre, inicio, numeroInicial, temperatura, luminosidad, comida);

            JOptionPane.showMessageDialog(frame, "Confirmado", " ", JOptionPane.INFORMATION_MESSAGE);
            JButton nombrePoblacion = new JButton(nombre);
            nombrePoblacion.addActionListener(e1 -> panelPoblacion());

            panelNuevoExperimento.add(nombrePoblacion);
            frame.getContentPane().removeAll();
            frame.add(panelNuevoExperimento);
            frame.repaint();
            frame.revalidate();
        });

        panelDatos.add(botonSubmit);
        panelDatos.add(backButton);

        frame.getContentPane().removeAll();
        frame.add(panelDatos);
        frame.repaint();
        frame.revalidate();
    }

    private void panelPoblacion() {
        JPanel panelPoblacion = new JPanel();
        panelPoblacion.setLayout(new GridLayout(0, 1, 10, 10));
        panelPoblacion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (String s : poblacion.toStringArray()) {
            panelPoblacion.add(new JLabel(s));
        }

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            frame.repaint();
            frame.revalidate();
            nuevoExperimentoPanel();
        });

        panelPoblacion.add(backButton);

        frame.getContentPane().removeAll();
        frame.add(panelPoblacion);
        frame.repaint();
        frame.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
