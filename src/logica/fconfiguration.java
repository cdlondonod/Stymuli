/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author crist
 */
public class fconfiguration {

    public static Properties prop = new Properties();

    String valueencr;

    public void SaveProp(String title, String value) {

        try {

            String valuec = value;
            String valueencrip = encrypt(valuec);

            prop.setProperty(title, valueencrip);

            prop.store(new FileOutputStream("conf\\config.txt"), null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public String GetProp(String title) {
        String value = "";
        String valuedecr = "";
        try {

            prop.load(new FileInputStream("conf\\config.txt"));
            value = prop.getProperty(title);

            valuedecr = decrypt(value);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        return valuedecr;

    }

    private static final String ALGO = "AES";
    private static final byte[] keyValue
            = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
                'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};

    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

    public String numberFormatDisplay(Double value) {

        Locale fmtLocale = Locale.getDefault(Locale.Category.FORMAT);
        NumberFormat formated = NumberFormat.getInstance(fmtLocale);
        formated.setMaximumFractionDigits(2);
        String local_number = formated.format(value);

        return local_number;
    }

    public Double DBnumberFormatInput(String value) {
        Double local_number = 0.0;
        try {
            Locale fmtLocale = Locale.getDefault(Locale.Category.FORMAT);
            NumberFormat formated = NumberFormat.getInstance(fmtLocale);
            formated.setMaximumFractionDigits(2);
            String numericalv = value.replaceAll("[^0-9,.-]", "");
            local_number = formated.parse(numericalv).doubleValue();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "No es Posible Identificar el Número" + e);
            return null;
        }

        return local_number;
    }

    JDialog loadingsc;

    public void loadingscreen() {
        loadingsc = new JDialog();
        loadingsc.setLayout(new GridBagLayout());
        ImageIcon icon = new ImageIcon(fconfiguration.class.getResource("/img/loadinggif.gif"));
        JLabel label = new JLabel(icon);
        loadingsc.add(label);
        //loadingsc.setSize(Toolkit.getDefaultToolkit().getScreenSize());      
        loadingsc.setSize(INICIO.escritorio.getSize());
        loadingsc.setResizable(false);
        loadingsc.setModal(false);
        loadingsc.setUndecorated(true);
        loadingsc.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        loadingsc.setLocationRelativeTo(INICIO.escritorio);
        loadingsc.setVisible(true);
        loadingsc.setBackground(new Color(30, 30, 30, 50));
        //loadingsc.setBackground(new Color(75, 16, 160, 50));
        loadingsc.validate();
        loadingsc.repaint();
        

    }

    public void hideloading() {
        loadingsc.dispose();
    }

}
