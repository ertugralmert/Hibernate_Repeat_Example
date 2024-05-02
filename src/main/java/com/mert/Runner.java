package com.mert;

import com.mert.controller.PiyasaController;

import java.util.Scanner;

public class Runner {
    private static PiyasaController controller;



    public static void main(String[] args) {
        int secim;
        controller = new PiyasaController();

        do{
            controller.gui();

            System.out.println("Secim: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim){
                case 1 : controller.unvanMaasEkle(); break;
                case 2 : controller.listeleme(); break;
                default:
                    System.out.println("Çıkış Yapıldı"); break;
            }
        }while (secim !=0);

    }

}
