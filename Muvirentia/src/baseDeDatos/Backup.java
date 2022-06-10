package baseDeDatos;

import java.io.*;

public class Backup {
    // backup de sql
    public void backupSql() throws IOException {
        String ruta = "F:\\001UNI\\2.maila\\2.Semestre\\Base de datos\\pbl\\Muvirentia\\";

        Process p = Runtime.getRuntime().exec("mysqldump -u root -p12345678aA@ -d muvirentia");

        InputStream is = p.getInputStream();
        FileOutputStream fos = new FileOutputStream(ruta + "backup_muvirentia_estructura.sql");
        byte[] buffer = new byte[1000];

        int leido = is.read(buffer);
        while (leido > 0) {
            fos.write(buffer, 0, leido);

            leido = is.read(buffer);
        }
        fos.close();
        p = Runtime.getRuntime().exec("mysqldump -u root -p12345678aA@ -t muvirentia");

        is = p.getInputStream();
        fos = new FileOutputStream(ruta + "backup_muvirentia_datos.sql");
        buffer = new byte[1000];

        leido = is.read(buffer);
        while (leido > 0) {
            fos.write(buffer, 0, leido);

            leido = is.read(buffer);
        }

        fos.close();
    }

}
