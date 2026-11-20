package fitmanager;

public class FitManager {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Foablak ablak = new Foablak();
                ablak.setLocationRelativeTo(null);
                ablak.setVisible(true);
            }
        });
    }
}