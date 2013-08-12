package com.winterland.plantzam;


import java.net.*;
import java.io.IOException;
/**
 * Created by winterland on 13-8-12.
 */
public class UDSend  implements Runnable{
    private String destAddressStr = "192.168.1.102";
    private int destPortInt = 1337;
    private DatagramSocket dSocket = null;
    private InetAddress destAddress = null;
    public void run() {
        try{
            destAddress = InetAddress.getByName(destAddressStr);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
        try{
            dSocket =new DatagramSocket ();
        }catch(SocketException e){
            e.printStackTrace();
        }
            byte[] sendMSG = "Hello world!".getBytes();
            DatagramPacket dp = new DatagramPacket(sendMSG, sendMSG.length, destAddress , destPortInt);
        try{
            dSocket.send(dp);
        }catch(IOException   e){
            e.printStackTrace();
        }

    }

}
