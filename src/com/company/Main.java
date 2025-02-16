package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {


        File b = new File("airbnb.txt");
        Scanner sk = new Scanner(b);
        sk.nextLine();
        ArrayList<Accommodation> list = new ArrayList<>();
        HashMap<String, ArrayList<Accommodation>> mapa1 = new HashMap<>();
        ArrayList<Accommodation> lista2 = new ArrayList<>();
        while (sk.hasNextLine()){

            String []parts = sk.nextLine().split("\t");

            int brojac = 0;
            for (String s:parts) {
                brojac++;
            }
            if (brojac==10){
                Accommodation a = new Accommodation(parts[0],parts[1],parts[2],parts[3],parts[4],parts[5],parts[6],parts[7],parts[8],parts[9]);
                if (a.name.contains("London") && a.minimum_nights<=7)list.add(a);
                if (a.distance<=10 && a.minimum_nights<=7)lista2.add(a);
                if (!mapa1.containsKey(a.room_type))
                    mapa1.put(a.room_type,new ArrayList<>());
                if(a.minimum_nights<=7)
                mapa1.get(a.room_type).add(a);
            }

        }

        for (String s:mapa1.keySet()) {
            System.out.println(s + " " + mapa1.get(s).size());
            Collections.sort(mapa1.get(s));
        }

        File fajlRjesenja = new File("output.txt");
        FileWriter writer1 = new FileWriter(fajlRjesenja);
        writer1.write(mapa1.get("Shared room").get(0).toString() + "\n");
        Collections.sort(list);

        writer1.write(list.get(list.size()/2).toString() + "\n");
        Collections.sort(lista2);

        writer1.write(lista2.get(lista2.size()-1).toString() + "\n");

        System.out.println(lista2.size());
        writer1.close();




    }
}
