package com.codewage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;

public class CheckPortAccessibilityOnServer {

	public static void main(String[] args) {

		//Specifying the host and port to connect
		boolean connectionStatus = isSocketAlive("1.1.1.1", 5511);
		if (connectionStatus) {

			System.out.println("Connection Succeeded");

		}else {

			System.out.println("Connection Failed");

		}

	}

	public static boolean isSocketAlive(String host, int port) {

		boolean isAlive = false;
		SocketAddress socketAddress = new InetSocketAddress(host, port);
		Socket socket = new Socket();
		int timeout = 1500;
		System.out.println("Trying to connect "+host + " on  port " + port);

		try {
			socket.connect(socketAddress, timeout);
			socket.close();
			isAlive = true;
		} catch (SocketTimeoutException e) {
			System.out.println("Socket Connection Timed Out");
		} catch (IOException e) {
			System.out.println("Unable to connect host on the specified port");
		}
		return isAlive;
	}

}
