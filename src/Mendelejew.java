//Zadanie 3 - Java Eclipse z javac 7

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mendelejew {

    private static Map<String, Integer> pierwiastki = wygeneruj();

    public static String szyfrMendelejewa(String s) {
        StringBuilder sb = new StringBuilder();
        String[] splitted = s.split("\\s+");
        for(int i = 0; i < splitted.length; i++){
            List<String> szyfr = szyfruj(splitted[i]);
            if(szyfr.isEmpty()){
                return "Nie mozna zaszyfrowac!";
            }else{
                for(int j=0; j<szyfr.size(); j++){
                    sb.append(pierwiastki.get(szyfr.get(j)));
                    if(j!=szyfr.size()-1) {
                        sb.append("*");
                    }
                }
            }
            if(i!=splitted.length-1){
                sb.append("**");
            }
        }
        return sb.toString();
    }


    private static List<String> szyfruj(String b){
        String s = b.toLowerCase();
        List<String> znalezione = new ArrayList<>();
        for(int ilosc=0; ilosc<=s.length()/2; ilosc++){
            List<Integer> pos = new ArrayList<>();
            for(int i=0; i<ilosc; i++){
               pos.add(i);
            }
            int max = s.length()-ilosc-1;
            int razy = (silnia(max+1))/(silnia(ilosc)*silnia(max-ilosc+1));
            for(int j=0; j<razy; j++){
                for(int k=0; k<=s.length()-ilosc-1; k++){
                    String pierwiastek;
                    if(pos.contains(k)){
                        pierwiastek = s.substring(k + odIluWieksze(k, pos), k + odIluWieksze(k, pos) + 2);
                    }else{
                        pierwiastek = String.valueOf(s.charAt(k + odIluWieksze(k, pos)));
                    }
                    if(pierwiastki.containsKey(pierwiastek)){
                        znalezione.add(pierwiastek);
                    }else{
                        znalezione.clear();
                        break;
                    }
                }
                if(znalezione.size() != 0){
                    return znalezione;
                }
                pos = nastepnaKombinacja(pos, max, pos.size() -1);
            }
        }
        return znalezione;
    }


    public static List<Integer> nastepnaKombinacja(List<Integer> list, int max, int pos){
        if(pos < 0){
            return list;
        }
        if(list.get(pos) == max){
            return nastepnaKombinacja(list, max, pos-1);
        }else {
            List<Integer> result = new ArrayList<>();
            if((list.size() - 1 - pos) > (max-list.get(pos)-1)){
                return nastepnaKombinacja(list, max, pos-1);
            }
            if (pos < list.size() - 1) {
                for(int i = 0; i < pos; i++){
                    result.add(list.get(i));
                }
                for(int i = pos; i < list.size(); i++){
                    result.add(list.get(pos) + 1 + (i-pos));
                }
            }else if(pos == list.size() - 1){
                for(int i = 0; i < list.size() - 1; i++){
                    result.add(list.get(i));
                }
                result.add(list.get(pos) + 1);
            }
            return result;
        }
    }

    public static int odIluWieksze(int x, List<Integer> list){
        int ilosc = 0;
        for(Integer i : list){
            if(x>i) ilosc++;
        }
        return ilosc;
    }

    public static int silnia(int x){
        if(x == 0) return 1;
        if(x < 0) return -silnia(-x);
        int wynik = 1;
        for(int i=2; i<=x; i++){
            wynik*=i;
        }
        return wynik;
    }

    private static Map<String, Integer> wygeneruj(){
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("h", 1);
        mapa.put("he", 2);
        mapa.put("li", 3);
        mapa.put("be", 4);
        mapa.put("b", 5);
        mapa.put("c", 6);
        mapa.put("n", 7);
        mapa.put("o", 8);
        mapa.put("f", 9);
        mapa.put("ne", 10);
        mapa.put("na", 11);
        mapa.put("mg", 12);
        mapa.put("al", 13);
        mapa.put("si", 14);
        mapa.put("p", 15);
        mapa.put("s", 16);
        mapa.put("cl", 17);
        mapa.put("ar", 18);
        mapa.put("k", 19);
        mapa.put("ca", 20);
        mapa.put("sc", 21);
        mapa.put("ti", 22);
        mapa.put("v", 23);
        mapa.put("cr", 24);
        mapa.put("mn", 25);
        mapa.put("fe", 26);
        mapa.put("co", 27);
        mapa.put("ni", 28);
        mapa.put("cu", 29);
        mapa.put("zn", 30);
        mapa.put("ga", 31);
        mapa.put("ge", 32);
        mapa.put("as", 33);
        mapa.put("se", 34);
        mapa.put("br", 35);
        mapa.put("kr", 36);
        mapa.put("rb", 37);
        mapa.put("sr", 38);
        mapa.put("y", 39);
        mapa.put("zr", 40);
        mapa.put("nb", 41);
        mapa.put("mo", 42);
        mapa.put("tc", 43);
        mapa.put("ru", 44);
        mapa.put("rh", 45);
        mapa.put("pd", 46);
        mapa.put("ag", 47);
        mapa.put("cd", 48);
        mapa.put("in", 49);
        mapa.put("sn", 50);
        mapa.put("sb", 51);
        mapa.put("te", 52);
        mapa.put("i", 53);
        mapa.put("xe", 54);
        mapa.put("cs", 55);
        mapa.put("ba", 56);
        mapa.put("la", 57);
        mapa.put("ce", 58);
        mapa.put("pr", 59);
        mapa.put("nd", 60);
        mapa.put("pm", 61);
        mapa.put("sm", 62);
        mapa.put("eu", 63);
        mapa.put("gd", 64);
        mapa.put("tb", 65);
        mapa.put("dy", 66);
        mapa.put("ho", 67);
        mapa.put("er", 68);
        mapa.put("tm", 69);
        mapa.put("yb", 70);
        mapa.put("lu", 71);
        mapa.put("hf", 72);
        mapa.put("ta", 73);
        mapa.put("w", 74);
        mapa.put("re", 75);
        mapa.put("os", 76);
        mapa.put("ir", 77);
        mapa.put("pt", 78);
        mapa.put("au", 79);
        mapa.put("hg", 80);
        mapa.put("tl", 81);
        mapa.put("pb", 82);
        mapa.put("bi", 83);
        mapa.put("po", 84);
        mapa.put("at", 85);
        mapa.put("rn", 86);
        mapa.put("fr", 87);
        mapa.put("ra", 88);
        mapa.put("ac", 89);
        mapa.put("th", 90);
        mapa.put("pa", 91);
        mapa.put("u", 92);
        mapa.put("np", 93);
        mapa.put("pu", 94);
        mapa.put("am", 95);
        mapa.put("cm", 96);
        mapa.put("bk", 97);
        mapa.put("cf", 98);
        mapa.put("es", 99);
        mapa.put("fm", 100);
        mapa.put("md", 101);
        mapa.put("no", 102);
        mapa.put("lr", 103);
        mapa.put("rf", 104);
        mapa.put("db", 105);
        mapa.put("sg", 106);
        mapa.put("bh", 107);
        mapa.put("hs", 108);
        mapa.put("mt", 109);
        mapa.put("ds", 110);
        mapa.put("rg", 111);
        mapa.put("cn", 112);
        mapa.put("nh", 113);
        mapa.put("fl", 114);
        mapa.put("mc", 115);
        mapa.put("lv", 116);
        mapa.put("ts", 117);
        mapa.put("og", 118);
        return mapa;
    }


}
