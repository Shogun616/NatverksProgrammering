package weatherreport;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WeatherReportTransmitter {
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException, InterruptedException{
        
        String temperature = "";
        String dataTosend = "";
        Scanner sc = new Scanner(System.in);
        String City = JOptionPane.showInputDialog(null, "ange ett Stad");
        if (City == null || City.length() == 0){
            System.exit(0);
        }
        
        InetAddress toAdr = InetAddress.getLocalHost();
        int toPort = 55555;
        DatagramSocket socket = new DatagramSocket();
        while(sc.hasNext()){
            temperature = sc.next();
            dataTosend = City+", "+temperature;
            byte[] data = dataTosend.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            
            
           
        }
    }
    
}
