package usart;

import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import pantallas.PanelPrincipal;

public class Uart {
	static String estado;
	static String datosEnt;
	SerialPort puerto;
	String s;

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
						
						String estado =(PanelPrincipal.isValvula())?"1":"0";
						System.out.println(estado);
						uart.enviar(estado);
						
						
						uart.enviar("r");
						String infos=uart.leer();
						//System.out.print(infos);
						 Thread.sleep(100);

					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});

		hilo.start();

	}

	public void enviar(String datos) {

		puerto.writeBytes(datos.getBytes(java.nio.charset.StandardCharsets.UTF_8), datos.getBytes().length);

	}

	public String leer() {
		byte bD[] = new byte[13];
		
		
//		int dato;

		puerto.readBytes(bD, 13);
		
		//recoge valor humedad,temperatura,luz
		String str = new String(bD, java.nio.charset.StandardCharsets.UTF_8);
		//System.out.println(str);
		
		if(s == null) {
			s = str;
		}else if(str.contains(".")) {
			str = str.replace(".", "");
			System.out.println(str);
			if(str.charAt(0)=='t') PanelPrincipal.setValores(str);
			s = null;
		}else {
			
			s = s.concat(str);
		}
		
		return str;
		
		/*
		dato = (bD[0] - 48);

		if (dato == 1) {
			preset.setPersiana(0);
		}
		*/
	}


}
