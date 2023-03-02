package cs.udp;
import java.io.*;
import java.net.*;

public class UDPClient {
  public static void main(String args[]) throws Exception {
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket clientSocket = new DatagramSocket();
    InetAddress IPAddress = InetAddress.getByName("localhost");
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];

    while (true) {
      System.out.print("Messaggio da inviare: ");
      String message = inFromUser.readLine();
      sendData = message.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 5000);
      clientSocket.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String response = new String(receivePacket.getData());
      System.out.println("Risposta dal server: " + response);
    }
  }
}