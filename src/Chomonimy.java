import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chomonimy {

    private static List<String> lista = new ArrayList<>();
    private static Map<String, String> slownik = new HashMap<>();

    public static void generate(){
        try {
            File f = new File("resources/slownik.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while(line!=null){
                if(zawieraZnaki(line.toLowerCase())){
                    if(line.contains("ch") && line.contains("h")){
                        System.out.println(line);
                    }
                    lista.add(line);
                }
                line = br.readLine();
            }
            System.out.println(lista.size());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private static boolean zawieraZnaki(String s){
        return  s.contains("u") ||
                s.contains("ó") ||
                s.contains("ż") ||
                s.contains("rz") ||
                s.contains("ch") ||
                s.contains("h") ||
                s.endsWith("e") ||
                s.contains("ę") ||
                s.contains("ą") ||
                s.endsWith("a");
    }
    private static void dodajDoSlownika(String s){
        String[] literki = new String[]{"u", "ó", "ż", "rz", "ę", "e", "ą", "a"};
        for(String l : literki) {
            if (s.contains(l)) {
                slownik.put(l, s);
            }
        }
    }
}
