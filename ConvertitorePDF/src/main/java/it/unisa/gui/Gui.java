package it.unisa.gui;


import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import it.unisa.app.Converter;
import it.unisa.app.FileFilterRecognize;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.InputStream;

public class Gui extends JFrame {
    private JButton convertiButton;
    private JPanel mainPanel;
    private JLabel topLabel;
    private JButton scegliFileButton;
    private JComboBox file;
    private JFileChooser fileChooser;
    private JOptionPane success;

    public Gui() {
        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilterRecognize());
        fileChooser.setAcceptAllFileFilterUsed(false);
        setContentPane(mainPanel);
        setTitle("Converti da Word in PDF");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        scegliFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setApproveButtonText("Scegli");
                if (fileChooser.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    file.addItem(path);
                    convertiButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Converter cvt = new Converter();
                            if (cvt.converter(path)) {
                                JOptionPane.showMessageDialog(null, "Il file è stato convertito in PDF");
                                System.exit(0);

                            } else {
                                JOptionPane.showMessageDialog(null, "Il file non è stato convertito per un errore");
                                System.exit(0);
                            }
                        }
                    });

                }


            }
        });
    }


}
