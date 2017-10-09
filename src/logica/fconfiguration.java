/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
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
            /*File file = new File("conf\\config.txt");
            file.getParentFile().mkdirs();*/
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

}
