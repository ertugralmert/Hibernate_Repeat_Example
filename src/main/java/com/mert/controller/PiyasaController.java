package com.mert.controller;

import com.mert.entity.Maas;
import com.mert.entity.Unvan;
import com.mert.service.MaasService;
import com.mert.service.UnvanService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PiyasaController {

    private Scanner scanner = new Scanner(System.in);

    private final UnvanService unvanService;
    private final MaasService maasService;

    public PiyasaController(){
        unvanService = new UnvanService();
        maasService = new MaasService();
    }

    public void gui(){
        System.out.println("""
                **** GUI ***
                1- Unvan Ekleme & Maaş Ekleme
                2- Listeleme
                0 - Ç I K I Ş 
                """);
    }

    public void unvanMaasEkle(){
        System.out.println("Program Dilini Giriniz: ");
        String programDili = scanner.nextLine();
        System.out.println("Unvan: ");
        String unvan = scanner.nextLine();
        System.out.println("Tecrübe: ");
        String tecrube = scanner.nextLine();
        System.out.println("Eğitim Bilgisi: ");
        String egitim = scanner.nextLine();
       Unvan unvanSaved = unvanService.save(Unvan.builder()
                        .programlamaDili(programDili)
                        .unvan(unvan)
                        .tecrube(tecrube)
                        .egitim(egitim)
                .build());

        System.out.println("Maaş: ");
        Integer maas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Para Birimi: ");
        String paraBirimi = scanner.nextLine();
        maasService.save(Maas.builder()
                        .unvanId(unvanSaved.getId())
                        .tarih(System.currentTimeMillis())
                        .maas(maas)
                        .paraBirimi(paraBirimi)
                .build());
    }

    public void listeleme(){
        List<Unvan> unvanList = unvanService.listeleme();
        List<Maas> maasList = maasService.listeleme();
       Map<Long,Integer> mapMaasList = maasList.stream().collect(Collectors.toMap(Maas::getUnvanId,Maas::getMaas));

        unvanList.forEach(u ->{
           // Optional<Maas> optionalMaas = maasList.stream().filter(m->m.getUnvanId().equals(u.getId())).findFirst();
            System.out.println("Unvan Programlama Dili: "+ u.getProgramlamaDili());
            System.out.println("Unvan: "+ u.getUnvan());
            System.out.println("Maaş: " + mapMaasList.get(u.getId()));

        });
    }
}
