package fitmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class AdatbazisKezelo {

    private static final String URL
            = "jdbc:derby:C:/Users/User/AppData/Roaming/NetBeans/8.2/derby/FitManagerDB";

    public static Connection kapcsolodas() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void tagMentese(String nev, String telefon,
            String email, String azonosito)
            throws SQLException {

        String sql = "INSERT INTO APP.TAGOK "
                + "(NEV, TELEFON, EMAIL, TAG_AZONOSITO) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql)) {

            utasitas.setString(1, nev);
            utasitas.setString(2, telefon);
            utasitas.setString(3, email);
            utasitas.setString(4, azonosito);

            utasitas.executeUpdate();
        }
    }

    public static void tagModositasa(int id, String nev, String telefon,
            String email, String azonosito)
            throws SQLException {

        String sql = "UPDATE APP.TAGOK "
                + "SET NEV = ?, TELEFON = ?, EMAIL = ?, TAG_AZONOSITO = ? "
                + "WHERE ID = ?";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql)) {

            utasitas.setString(1, nev);
            utasitas.setString(2, telefon);
            utasitas.setString(3, email);
            utasitas.setString(4, azonosito);
            utasitas.setInt(5, id);

            int modositottSorok = utasitas.executeUpdate();

            if (modositottSorok != 1) {
                throw new SQLException("A kiválasztott tag nem található.");
            }
        }
    }

    public static void tagTorlese(int id) throws SQLException {
        String sql = "DELETE FROM APP.TAGOK WHERE ID = ?";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas = kapcsolat.prepareStatement(sql)) {

            utasitas.setInt(1, id);

            int toroltSorok = utasitas.executeUpdate();

            if (toroltSorok != 1) {
                throw new SQLException("A kiválasztott tag nem található.");
            }
        }
    }

    public static DefaultTableModel tagokLekerdezese()
            throws SQLException {

        String[] oszlopok = {
            "ID", "Név", "Telefonszám",
            "E-mail-cím", "Tagsági azonosító"
        };

        DefaultTableModel modell
                = new DefaultTableModel(oszlopok, 0) {
            @Override
            public boolean isCellEditable(int sor, int oszlop) {
                return false;
            }
        };

        String sql = "SELECT ID, NEV, TELEFON, EMAIL, "
                + "TAG_AZONOSITO FROM APP.TAGOK ORDER BY ID";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql);
                ResultSet eredmeny = utasitas.executeQuery()) {

            while (eredmeny.next()) {
                Object[] sor = {
                    eredmeny.getInt("ID"),
                    eredmeny.getString("NEV"),
                    eredmeny.getString("TELEFON"),
                    eredmeny.getString("EMAIL"),
                    eredmeny.getString("TAG_AZONOSITO")
                };

                modell.addRow(sor);
            }
        }

        return modell;
    }

    public static void main(String[] args) {
        try (Connection kapcsolat = kapcsolodas()) {
            System.out.println("Sikeres adatbázis-kapcsolat!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
