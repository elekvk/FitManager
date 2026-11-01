package fitmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdatbazisKezelo {

    // A FitManager adatbázisának elérési útja
    private static final String URL =
            "jdbc:derby:C:/Users/User/AppData/Roaming/NetBeans/8.2/derby/FitManagerDB";

    // Kapcsolódás az adatbázishoz
    public static Connection kapcsolodas() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Új tag adatainak mentése
    public static void tagMentese(String nev, String telefon,
                                  String email, String azonosito)
            throws SQLException {

        String sql = "INSERT INTO APP.TAGOK "
                + "(NEV, TELEFON, EMAIL, TAG_AZONOSITO) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection kapcsolat = kapcsolodas();
             PreparedStatement utasitas =
                     kapcsolat.prepareStatement(sql)) {

            utasitas.setString(1, nev);
            utasitas.setString(2, telefon);
            utasitas.setString(3, email);
            utasitas.setString(4, azonosito);

            utasitas.executeUpdate();
        }
    }

    // Az adatbázis-kapcsolat tesztelése
    public static void main(String[] args) {

        try (Connection kapcsolat = kapcsolodas()) {

            System.out.println("Sikeres adatbázis-kapcsolat!");

        } catch (SQLException ex) {

            System.out.println("Adatbázis-kapcsolati hiba!");
            ex.printStackTrace();
        }
    }
}
