package GUI;

import Compress_Decompress.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

//    CONSTRUCTOR.
    AppFrame() {
        this.setTitle("Compressor and Decompressor");
        this.setLayout(null);
        this.setSize(800, 500);
        this.getContentPane().setBackground(Color.darkGray);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(110, 200, 200, 50);
        compressButton.setBackground(Color.black);
        compressButton.setForeground(Color.white);
        compressButton.addActionListener(this);

        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(470, 200, 200, 50);
        decompressButton.setBackground(Color.black);
        decompressButton.setForeground(Color.white);
        decompressButton.addActionListener(this);

        this.add(compressButton);
        this.add(decompressButton);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == compressButton) {

            JFileChooser fileChooser = new JFileChooser("C:");
            int chosenOption = fileChooser.showSaveDialog(null);

            if(chosenOption == JFileChooser.APPROVE_OPTION) {
                File inputFile = fileChooser.getSelectedFile();
                File compressedFile = new File(inputFile.getAbsolutePath() + ".gz");
                try {
                    Compressor.method(inputFile, compressedFile);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }

        if(actionEvent.getSource() == decompressButton) {

            JFileChooser fileChooser = new JFileChooser("C:");
            int chosenOption = fileChooser.showSaveDialog(null);

            if(chosenOption == JFileChooser.APPROVE_OPTION) {
                File compressedFile = fileChooser.getSelectedFile();
                File decompressedFile = new File(compressedFile.getAbsolutePath().replace(".gz", ""));

                try {
                    Decompressor.method(compressedFile, decompressedFile);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
}
