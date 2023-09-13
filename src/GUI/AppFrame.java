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

//    CONSTRUCTOR FOR THE APPLICATION FRAME.
    AppFrame() {
//        SET THE TITLE OF THE FRAME.
        this.setTitle("Compressor and Decompressor");
//        SET THE LAYOUT TO NULL TO USE ABSOLUTE POSITIONING OF COMPONENTS.
        this.setLayout(null);
//        SET THE SIZE OF THE FRAME.
        this.setSize(800, 500);
//        SET THE BACKGROUND COLOR OF THE CONTENT PANE.
        this.getContentPane().setBackground(Color.darkGray);
//        DISABLE FRAME RESIZING.
        this.setResizable(false);
//        EXIT THE APPLICATION WHEN FRAME IS CLOSED.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        CREATE A "Select File to Compress" BUTTON.
        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(110, 200, 200, 50);
        compressButton.setBackground(Color.black);
        compressButton.setForeground(Color.white);
        compressButton.addActionListener(this);

//        CREATE A "Select File to Decompress" BUTTON.
        decompressButton = new JButton("Select File to Decompress");
        decompressButton.setBounds(470, 200, 200, 50);
        decompressButton.setBackground(Color.black);
        decompressButton.setForeground(Color.white);
        decompressButton.addActionListener(this);

//        ADD THE BUTTONS TO THE FRAME.
        this.add(compressButton);
        this.add(decompressButton);
    }


    @Override
//    HANDLE THE BUTTON CLICKS.
    public void actionPerformed(ActionEvent actionEvent) {
//        IF THE COMPRESS BUTTON IS CLICKED.
        if(actionEvent.getSource() == compressButton) {

//            CREATE A FILE CHOOSER DIALOG FOR SELECTING A FILE TO COMPRESS.
            JFileChooser fileChooser = new JFileChooser("C:");
            int chosenOption = fileChooser.showSaveDialog(null);

            if(chosenOption == JFileChooser.APPROVE_OPTION) {
//                GET THE SELECTED INPUT FILE.
                File inputFile = fileChooser.getSelectedFile();
//                CREATE A COMPRESSED FILE WITH A ".gz" EXTENSION.
                File compressedFile = new File(inputFile.getAbsolutePath() + ".gz");
                try {
//                    CALL THE COMPRESSOR CLASS'S METHOD TO COMPRESS FILE.
                    Compressor.method(inputFile, compressedFile);
                }catch (Exception e) {
//                    DISPLAY AN ERROR MESSAGE IS AN EXCEPTION OCCURS DURING COMPRESSION.
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }

//        IF DECOMPRESS BUTTON IS CLICKED.
        if(actionEvent.getSource() == decompressButton) {

//            CREATE A FILE CHOOSER DIALOG FOR SELECTING A FILE TO DECOMPRESS.
            JFileChooser fileChooser = new JFileChooser("C:");
            int chosenOption = fileChooser.showSaveDialog(null);

            if(chosenOption == JFileChooser.APPROVE_OPTION) {
//                GET THE SELECTED COMPRESSED FILE.
                File compressedFile = fileChooser.getSelectedFile();
//                GET FILE PATH AND MODIFY FILENAME, SO IN DIRECTORY DECOMPRESSED FILE WILL BE DISTINCT FROM ORIGINAL.
                String fileName = compressedFile.getAbsolutePath();
                fileName = getFileName(fileName);
                System.out.println(fileName);
//                CREATE A DECOMPRESSED FILE.
                File decompressedFile = new File(fileName.replace(".gz", ""));

                try {
//                    CALL DECOMPRESSOR CLASS'S METHOD TO DECOMPRESS FILE.
                    Decompressor.method(compressedFile, decompressedFile);
                } catch (Exception e) {
//                    DISPLAY AN ERROR MESSAGE IS AN EXCEPTION OCCURS DURING COMPRESSION.
                    JOptionPane.showMessageDialog(null, e.toString());
                }
            }
        }
    }
//    UTILITY METHOD TO MODIFY DECOMPRESSED FILE NAME.
    public static String getFileName(String fileName ) {
        StringBuilder sb = new StringBuilder(fileName);
        int dotCount = 0;
        for(int i=sb.length()-1; i>=0; i--) {
            if(dotCount == 2) {
                sb.insert(i+1, "(decompressed)");
                break;
            }
            if(sb.charAt(i) == '.') {
                dotCount++;
            }
        }
        return sb.toString();
    }
}
