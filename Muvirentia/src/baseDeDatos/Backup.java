package baseDeDatos;

import java.io.*;

public class Backup {
    // backup de sql
    public void backupSql() throws IOException {
        String ruta = "F:\\001UNI\\2.maila\\2.Semestre\\Base de datos\\pbl\\Muvirentia\\";

        Process p = Runtime.getRuntime().exec("mysqldump -u root -p12345678aA@ -B -t muvirentia");

        InputStream is = p.getInputStream();// Pedimos la entrada
        FileOutputStream fos = new FileOutputStream(ruta+"backup_muvirentia.sql"); // creamos el archivo para le respaldo
        byte[] buffer = new byte[1000]; // Creamos una variable de tipo byte para el buffer

        int leido = is.read(buffer); // Devuelve el n�mero de bytes le�dos o -1 si se alcanz� el final del stream.
        while (leido > 0) {
            fos.write(buffer, 0, leido);// Buffer de caracteres, Desplazamiento de partida para empezar a escribir
                                        // caracteres, N�mero de caracteres para escribir
            leido = is.read(buffer);
        }

        fos.close();
    }

}
