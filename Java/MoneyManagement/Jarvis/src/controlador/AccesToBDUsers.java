package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BD.ConexionBD;
import modelo.User;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author marco
 */
public class AccesToBDUsers {

    private final Connection con = ConexionBD.getConnection();
    String secretKey = "Kakaroto";

    public String ecnode(String secretKey, String cadena) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ex) {
            return "Error al encriptar la cadena. Más informacion: " + ex.getMessage();
        }
        return encriptacion;
    }

    public String deecnode(String secretKey, String cadenaEncriptada) {
        String desencriptacion = "";
        try {
            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            desencriptacion = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            System.out.println("Error al desencriptar la cadena. Más informacion: " + ex.getMessage());
        }
        return desencriptacion;
    }

    public int addUser(User user) {
        String sql = "insert into users values(?,?,?);";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, user.getCode());
            pst.setString(2, user.getName());
            pst.setString(3, this.ecnode(secretKey, user.getPassword()));

            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }

    }

    public int deleteUser(User user) {

        String sql = "delete from users where code = ?";
        PreparedStatement pst;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, user.getCode());
            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return 0;
        }

    }

    public int modify(User user) {
        String sql = "update users set user_name = ?, pasword = ? where code = ?";
        PreparedStatement pst;

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setInt(3, user.getCode());

            int rowAffected = pst.executeUpdate();
            pst.close();
            return rowAffected;

        } catch (SQLException error) {
            error.getMessage();
            return 0;
        }
    }

    public int Login(String name, String password) {
        String sql = "select user_name, pasword from users where user_name = ? and pasword = ?";
        PreparedStatement pst;
        ResultSet rs;
        Integer contador = 0;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                contador = 1;
            }

            return contador;

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return -1;
        }

    }

    public User searchByName(String name) {
        String sql = "select * from users where user_name=?";
        String password;
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, name);
            rs = pst.executeQuery();
            if (rs.next()) {
                name = rs.getString("user_name");
                password = rs.getString("pasword");

                return new User(name, password);
            } else {
                return null;
            }

        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public ArrayList<User> searchAll() {
        String sql = "select name, password from users";
        String name, password;
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<User> users = new ArrayList();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                name = rs.getString("user_name");
                password = rs.getString("password");

                users.add(new User(name, password));

            }
            return users;
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            return null;
        }

    }

}
