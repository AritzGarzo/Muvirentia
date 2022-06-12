package usart;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import pantallas.PanelPrincipal;

public class Uart {
	static String estado;
	static String datosEnt;
	SerialPort puerto;

	public Uart() {
		// this.preset=preset;

		SerialPort puertos[] = SerialPort.getCommPorts();
		System.out.println("Select a port:");
		int i = 1;
		for (SerialPort puerto : puertos) {
			System.out.println(i++ + ". " + puerto.getSystemPortName());
		}
		Scanner s = new Scanner(System.in);
		int chosenPort = s.nextInt();

		// open and configure the port
		puerto = puertos[chosenPort - 1];
		if (puerto.openPort()) {
			System.out.println("Successfully opened the port.");
		} else {
			System.out.println("Unable to open the port.");
			return;
		}
		puerto.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

		// ver la velocidad de transmision
		System.out.println("Baud rate: " + puerto.getBaudRate());
	}

	public void start(Uart uart, String oraingoa) {
		Uart.estado = oraingoa;
		Thread hilo = new Thread(new Runnable() {
			@Override

			public void run() {
				int i = 0;
				try {

					System.out.println("inicio");
					while (true) {
						// preset=getPreset();

						uart.enviar(estado);
						System.out.println("hascodeuart: " + estado.hashCode());
						System.out.println("hascode Uart.preset: " + Uart.estado.hashCode());
						// printea la clase preset
						System.out.println(i++ + " " + estado);
						uart.leer();
						// Thread.sleep(1000);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		hilo.start();

	}

	public void enviar(String[] datos) {
		// determine which serial port to use

		byte bD[] = new byte[4];

		datos = preset.getTemperatura();

		// Convert Integer number to byte value
		for (int i = 0; i < datos.length; i++)
			bD[i] = datos[i].byteValue();

		puerto.writeBytes(bD, datos.length);

	}

	public void leer() {

		byte bD[] = new byte[1];
		int dato;

		puerto.readBytes(bD, 1);

		dato = (bD[0] - 48);

		if (dato == 1) {
			preset.setPersiana(0);
		}

	}


}
