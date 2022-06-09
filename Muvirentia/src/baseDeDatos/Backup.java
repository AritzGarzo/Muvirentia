package baseDeDatos;

import java.io.*;

public class Backup {
    // backup de sql
    public void backupSql() throws IOException {
        String ruta = "F:\\001UNI\\2.maila\\2.Semestre\\Base de datos\\pbl\\Muvirentia\\";

        Process p = Runtime.getRuntime().exec("mysqldump -u root -p12345678aA@ -d -t muvirentia");

        InputStream is = p.getInputStream();
        FileOutputStream fos = new FileOutputStream(ruta+"backup_muvirentia.sql"); 
        byte[] buffer = new byte[1000];

        int leido = is.read(buffer);
        while (leido > 0) {
            fos.write(buffer, 0, leido);
                                        
            leido = is.read(buffer);
        }

        fos.close();
    }

}
