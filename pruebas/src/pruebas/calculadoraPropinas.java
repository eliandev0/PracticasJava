//Coded by: eliandev0
//El programa se desarrolló de forma accesible para una interfaz formato; TPV, tablet o touch de cualquier tipo.

package pruebas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class calculadoraPropinas {

    private JFrame frmCalculadoraDePropinas;
    private JTextField importeFactura;
    private JTextField importePropina;
    private JTextField facturaTotal;
    private JComboBox<String> porcentajePropina;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    calculadoraPropinas window = new calculadoraPropinas();
                    window.frmCalculadoraDePropinas.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public calculadoraPropinas() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCalculadoraDePropinas = new JFrame();
        frmCalculadoraDePropinas.setTitle("Calculadora de propinas");
        frmCalculadoraDePropinas.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Elian\\Documents\\Recursos\\Eclipse\\1355772349a91d6fd6ea7ee29c9c5f50-icono-de-dinero-de-moneda-de-signo-de-da-lar.png"));
        frmCalculadoraDePropinas.setBounds(100, 100, 370, 647);
        frmCalculadoraDePropinas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCalculadoraDePropinas.getContentPane().setLayout(null);

        JLabel importeFacturatxt = new JLabel("Importe factura");
        importeFacturatxt.setFont(new Font("Gadugi", Font.BOLD, 12));
        importeFacturatxt.setBounds(35, 130, 97, 14);
        frmCalculadoraDePropinas.getContentPane().add(importeFacturatxt);

        importeFactura = new JTextField();
        importeFactura.setFont(new Font("Gadugi", Font.PLAIN, 17));
        importeFactura.setBounds(35, 146, 168, 38);
        frmCalculadoraDePropinas.getContentPane().add(importeFactura);
        importeFactura.setColumns(10);

        JLabel porcentajePropinatxt = new JLabel("Porcentaje propina (%)");
        porcentajePropinatxt.setFont(new Font("Gadugi", Font.BOLD, 12));
        porcentajePropinatxt.setBounds(35, 219, 126, 14);
        frmCalculadoraDePropinas.getContentPane().add(porcentajePropinatxt);

        porcentajePropina = new JComboBox<>();
        porcentajePropina.setFont(new Font("Gadugi", Font.PLAIN, 17));
        porcentajePropina.setModel(new DefaultComboBoxModel<>(new String[] {"", "5", "10", "15", "20", "25", "30", "40", "50"}));
        porcentajePropina.setBounds(35, 235, 72, 31);
        frmCalculadoraDePropinas.getContentPane().add(porcentajePropina);

        JLabel importePropinatxt = new JLabel("Importe propina");
        importePropinatxt.setFont(new Font("Gadugi", Font.BOLD, 12));
        importePropinatxt.setBounds(35, 310, 97, 14);
        frmCalculadoraDePropinas.getContentPane().add(importePropinatxt);

        importePropina = new JTextField();
        importePropina.setFont(new Font("Gadugi", Font.PLAIN, 17));
        importePropina.setEditable(false);
        importePropina.setBounds(35, 326, 168, 38);
        frmCalculadoraDePropinas.getContentPane().add(importePropina);
        importePropina.setColumns(10);

        JLabel facturaTotaltxt = new JLabel("Factura total");
        facturaTotaltxt.setFont(new Font("Gadugi", Font.BOLD, 12));
        facturaTotaltxt.setBounds(35, 410, 84, 14);
        frmCalculadoraDePropinas.getContentPane().add(facturaTotaltxt);

        facturaTotal = new JTextField();
        facturaTotal.setFont(new Font("Gadugi", Font.BOLD, 17));
        facturaTotal.setEditable(false);
        facturaTotal.setBounds(35, 426, 168, 38);
        frmCalculadoraDePropinas.getContentPane().add(facturaTotal);
        facturaTotal.setColumns(10);

        // Listener para el importe de la factura
        importeFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPropinaYTotal();
            }
        });

        // Listener para el JComboBox porcentajePropina
        porcentajePropina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPropinaYTotal();
            }
        });

        // Listener para el botón nueva factura
        JButton nuevaFactura = new JButton("NUEVA FACTURA");
        nuevaFactura.setBackground(new Color(234, 183, 28));
        nuevaFactura.setFont(new Font("Gadugi", Font.BOLD, 14));
        nuevaFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        nuevaFactura.setBounds(35, 515, 291, 38);
        frmCalculadoraDePropinas.getContentPane().add(nuevaFactura);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Elian\\Documents\\Recursos\\Eclipse\\po.png"));
        lblNewLabel.setBounds(35, 36, 51, 63);
        frmCalculadoraDePropinas.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Calculadora de propinas");
        lblNewLabel_1.setFont(new Font("Gadugi", Font.BOLD, 15));
        lblNewLabel_1.setBounds(109, 46, 180, 21);
        frmCalculadoraDePropinas.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Introduce el importe de una factura");
        lblNewLabel_2.setFont(new Font("Gadugi", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(109, 69, 217, 14);
        frmCalculadoraDePropinas.getContentPane().add(lblNewLabel_2);
    }

    // Método para calcular la propina y el total
    private void calcularPropinaYTotal() {
        try {
            double eurosFactura = Double.parseDouble(importeFactura.getText());

            if (porcentajePropina.getSelectedIndex() > 0) {
                String porcentajeStr = (String) porcentajePropina.getSelectedItem();
                int porcentaje = Integer.parseInt(porcentajeStr);

                double eurosPropina = eurosFactura * porcentaje / 100.0;
                double eurosTotal = eurosFactura + eurosPropina;

                importePropina.setText(String.format("%.2f", eurosPropina));
                facturaTotal.setText(String.format("%.2f", eurosTotal));
            } else {
                // Caso en que no hay un porcentaje seleccionado
                importePropina.setText("");
                facturaTotal.setText("");
            }

        } catch (NumberFormatException ex) {
            // Manejar el caso donde el usuario no introduce un número válido
            importePropina.setText("");
            facturaTotal.setText("");
        }
    }

    // Método para limpiar los campos
    private void limpiarCampos() {
        importeFactura.setText("");
        porcentajePropina.setSelectedIndex(0); // Seleccionar el primer índice del JComboBox
        importePropina.setText("");
        facturaTotal.setText("");
    }
}
