import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chomonimy {

    //TODO zrobic ta druga czesc

    private static List<String> lista = new ArrayList<>();

    public static void generate(){
        try {
            File f = new File("resources/slownik.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
            String line = br.readLine();
            while(line!=null){
                if(zawieraZnaki(line.toLowerCase())){
                    lista.add(line);
                }
                line = br.readLine().toLowerCase();
            }
            System.out.println("Całość: " + lista.size());
            for(String slowo : lista){
                List<String> chomonimy = chomonimy(slowo);
                if(chomonimy != null && !chomonimy.isEmpty()) {
                    for (String chomonim : chomonimy) {
                        if(lista.contains(chomonim)){
                            System.out.println(slowo + " @ " + chomonim);
                        }
                    }
                }
            }
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
                s.contains("e") ||
                s.contains("ę") ||
                s.contains("ą") ||
                s.contains("a");
    }

    //TODO rozpoznawanie H/CH

    private static List<String> zawiera(String s){
        String[] literki = new String[]{"u", "ó", "ż", "rz", "ę", "e", "ą", "a"};
        List<String> output = new ArrayList<>();
        for(String l : literki) {
            if (s.contains(l)) {
                output.add(l);
            }
        }
        return output;
    }

    private static String przecwinaLiterka(char c){
        if(c=='h') return "ch";
        if(c=='c') return "h";
        if(c=='ż') return "rz";
        if(c=='r') return "ż";
        if(c=='u') return "ó";
        if(c=='ó') return "u";
        if(c=='e') return "ę";
        if(c=='ę') return "e";
        if(c=='a') return "ą";
        if(c=='ą') return "a";
        return "";
    }

    public static List<String> chomonimy(String s){
        List<String> litery = zawiera(s);
        if(litery.isEmpty()) return null;
        List<String> homonimy = new ArrayList<>();
        boolean[] szukaneZnaki = new boolean[s.length()];
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c!='h' && c!= 'r' && c!='z'){
                if(litery.contains(c+"")){
                    szukaneZnaki[i] = true;
                    count++;
                }
            }else if(c=='h'){
                if(i>0 && s.charAt(i-1) == 'c'){
                    szukaneZnaki[i-1] = true;
                    count++;
                }else if(i>0 && s.charAt(i-1) != 'c'){
                    szukaneZnaki[i] = true;
                    count++;
                }
            }else if(c=='z'){
                if(i>0 && s.charAt(i-1) == 'r'){
                    szukaneZnaki[i-1] = true;
                    count++;
                }
            }
        }
        //System.out.println("count " + count + " " + (Math.pow(2, count)));
        for(int i=((int)Math.pow(2, count)-1); i>0; i--){
            StringBuilder sb = new StringBuilder();
            int c=-1;
            String binary = zeraNaPocz(Integer.toBinaryString(i), count);
            //System.out.println(binary);
            for(int j=0; j<s.length(); j++) {
                if (szukaneZnaki[j]) {
                    c+=1;
                    if(c<binary.length() && binary.charAt(c) == '1'){
                        sb.append(przecwinaLiterka(s.charAt(j)));
                    }else{
                        sb.append(s.charAt(j));
                    }
                }else{
                    if((s.charAt(j) == 'z' || s.charAt(j) == 'h') && (c>=0 && (c>=binary.length() || binary.charAt(c)!='0'))){
                        continue;
                    }else{
                        sb.append(s.charAt(j));
                    }
                }
            }
            homonimy.add(sb.toString());
            //System.out.println(sb.toString());
        }
        return homonimy;
    }

    private static String zeraNaPocz(String s, int c){
        if(s.length() < c){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<=(c-s.length()); i++){
                sb.append("0");
            }
            sb.append(s);
            return sb.toString();
        }
        return s;
    }

}
