package cs.udp;
import java.net.*;

public class UDPServer {
  public static void main(String args[]) throws Exception {
    DatagramSocket serverSocket = new DatagramSocket(5000);
    byte[] receiveData = new byte[1024];
    byte[] sendData = new byte[1024];

    while (true) {
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      serverSocket.receive(receivePacket);
      String message = new String(receivePacket.getData());
      InetAddress IPAddress = receivePacket.getAddress();
      int port = receivePacket.getPort();
      System.out.println("Ricevuto da " + IPAddress + ":" + port + " - " + message);
      String response = "Ricevuto: " + message;
      sendData = response.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
      serverSocket.send(sendPacket);
    }
  }
}