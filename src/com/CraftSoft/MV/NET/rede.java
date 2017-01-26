package com.CraftSoft.MV.NET;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by nig on 25/01/17.
 */
public class rede {

    public int porta = 12345;
    public String str_ip;
    public String str_user;


    public rede(){

        try {
            Enumeration e = NetworkInterface.getNetworkInterfaces();
            while(e.hasMoreElements()){
                NetworkInterface i = (NetworkInterface) e.nextElement();
                Enumeration ds  = i.getInetAddresses();
                InetAddress ttt = InetAddress.getLocalHost();
                str_user = ttt.getHostName();

                while (ds.hasMoreElements()){
                    InetAddress yo = (InetAddress) ds.nextElement();
                    System.out.println("HostName > " + yo.getHostName() + "IP > " + yo.getHostAddress());
                    if(!yo.isLoopbackAddress() && yo.isSiteLocalAddress()){
                        str_ip = yo.getHostAddress();
                    }
                }

            }
        } catch (SocketException e1) {
            e1.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }




}
