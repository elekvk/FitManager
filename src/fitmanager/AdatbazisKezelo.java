package fitmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class AdatbazisKezelo {

    private static final String URL = "jdbc:derby:FitManagerDB";

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

    public static void berletMentese(
            int tagId,
            String tipus,
            java.sql.Date kezdoDatum,
            java.sql.Date lejaratiDatum) throws SQLException {

        String sql = "INSERT INTO APP.BERLETEK "
                + "(TAG_ID, TIPUS, KEZDO_DATUM, LEJARATI_DATUM) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql)) {

            utasitas.setInt(1, tagId);
            utasitas.setString(2, tipus);
            utasitas.setDate(3, kezdoDatum);
            utasitas.setDate(4, lejaratiDatum);

            utasitas.executeUpdate();
        }
    }

    public static java.util.List<String> tagokNeveiLekerdezese()
            throws SQLException {

        java.util.List<String> tagok = new java.util.ArrayList<>();

        String sql = "SELECT ID, NEV FROM APP.TAGOK ORDER BY NEV";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas = kapcsolat.prepareStatement(sql);
                ResultSet eredmeny = utasitas.executeQuery()) {

            while (eredmeny.next()) {
                int id = eredmeny.getInt("ID");
                String nev = eredmeny.getString("NEV");

                tagok.add(id + " - " + nev);
            }
        }

        return tagok;
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

    public static DefaultTableModel berletekLekerdezese()
            throws SQLException {

        DefaultTableModel modell = new DefaultTableModel(
                new String[]{
                    "ID", "Tag neve", "Bérlet típusa",
                    "Kezdő dátum", "Lejárati dátum", "Állapot"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int sor, int oszlop) {
                return false;
            }
        };

        String sql = "SELECT B.ID, T.NEV, B.TIPUS, "
                + "B.KEZDO_DATUM, B.LEJARATI_DATUM "
                + "FROM APP.BERLETEK B "
                + "INNER JOIN APP.TAGOK T ON B.TAG_ID = T.ID "
                + "ORDER BY B.ID DESC";

        java.time.LocalDate maiDatum = java.time.LocalDate.now();

        java.time.format.DateTimeFormatter datumFormatum
                = java.time.format.DateTimeFormatter.ofPattern(
                        "yyyy.MM.dd.");

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql);
                ResultSet eredmeny = utasitas.executeQuery()) {

            while (eredmeny.next()) {

                java.time.LocalDate kezdoDatum
                        = eredmeny.getDate("KEZDO_DATUM").toLocalDate();

                java.time.LocalDate lejaratiDatum
                        = eredmeny.getDate("LEJARATI_DATUM").toLocalDate();

                String allapot;

                if (maiDatum.isBefore(kezdoDatum)) {
                    allapot = "Még nem érvényes";
                } else if (maiDatum.isAfter(lejaratiDatum)) {
                    allapot = "Lejárt";
                } else {
                    allapot = "Aktív";
                }

                modell.addRow(new Object[]{
                    eredmeny.getInt("ID"),
                    eredmeny.getString("NEV"),
                    eredmeny.getString("TIPUS"),
                    kezdoDatum.format(datumFormatum),
                    lejaratiDatum.format(datumFormatum),
                    allapot
                });
            }
        }

        return modell;
    }

    public static boolean vanErvenyesBerlet(int tagId)
            throws SQLException {

        String sql = "SELECT COUNT(*) FROM APP.BERLETEK "
                + "WHERE TAG_ID = ? "
                + "AND KEZDO_DATUM <= CURRENT_DATE "
                + "AND LEJARATI_DATUM >= CURRENT_DATE";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql)) {

            utasitas.setInt(1, tagId);

            try (ResultSet eredmeny = utasitas.executeQuery()) {
                if (eredmeny.next()) {
                    return eredmeny.getInt(1) > 0;
                }
            }
        }

        return false;
    }

    public static void belepesMentese(int tagId)
            throws SQLException {

        String sql = "INSERT INTO APP.BELEPESEK (TAG_ID) "
                + "VALUES (?)";

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql)) {

            utasitas.setInt(1, tagId);
            utasitas.executeUpdate();
        }
    }

    public static int osszesDarab(String tablaNev)
            throws SQLException {

        String sql;

        switch (tablaNev) {
            case "TAGOK":
                sql = "SELECT COUNT(*) FROM APP.TAGOK";
                break;
            case "BERLETEK":
                sql = "SELECT COUNT(*) FROM APP.BERLETEK";
                break;
            case "BELEPESEK":
                sql = "SELECT COUNT(*) FROM APP.BELEPESEK";
                break;
            default:
                throw new IllegalArgumentException(
                        "Ismeretlen kimutatási kategória!"
                );
        }

        try (Connection kapcsolat = kapcsolodas();
                PreparedStatement utasitas
                = kapcsolat.prepareStatement(sql);
                ResultSet eredmeny = utasitas.executeQuery()) {

            if (eredmeny.next()) {
                return eredmeny.getInt(1);
            }
        }

        return 0;
    }

}
