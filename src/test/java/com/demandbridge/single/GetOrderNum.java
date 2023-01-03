package com.demandbridge.single;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import java.net.MalformedURLException;

public class GetOrderNum {

    public static void main(String[] args) throws MalformedURLException, JSchException, SftpException, InterruptedException {

        String printOrderNumber = LoginPageGeneric.chiliGenericLogin_Test();
        System.out.println("\nThe Order Number from ChiliApprovalsEdit.java is: " + printOrderNumber);
    }
}
