//Zadanie 5 - Java Eclipse z javac 7

public class Mnozenie {
    public static double pomnoz(double a, double b){
        if(jestCalkowita(b)){
            return pomnoz_calk(a, (long) b);
        }else{
            long q = pomnoz_az_calk(a);
            long w = pomnoz_az_calk(b);
            long e = pomnoz_calk(q, w);
            long r = ile_wielokrotnosci_az_calk(a);
            long t = ile_wielokrotnosci_az_calk(b);
            long y = pomnoz_calk(r, t);
            double u = podz_przezwielokr10(e, y);
            return podz_przezwielokr10(pomnoz_calk(pomnoz_az_calk(a), pomnoz_az_calk(b)), pomnoz_calk(ile_wielokrotnosci_az_calk(a), ile_wielokrotnosci_az_calk(b)));
        }
    }
    private static double pomnoz_calk(double a, long b){
        double wynik = 0;
        for(int i=0; i<b; i++){
            wynik+=a;
        }
        return wynik;
    }
    private static long pomnoz_calk(long a, long b){
        long wynik = 0;
        if(b>0) {
            for (long i = 0; i < b; i++) {
                wynik += a;
            }
        }else if(b<0){
            for (long i = 0; i > b; i--) {
                wynik -= a;
            }
        }
        return wynik;
    }
    private static long pomnoz_az_calk(double a){
        return Long.parseLong(Double.toString(a).replace(".", ""));
    }
    private static long ile_wielokrotnosci_az_calk(double a){
        String s = Double.toString(a);
        if(s.contains(".")){
            int pozycja = s.indexOf('.');
            int iloscmpoprzec = s.length() - pozycja - 1;
            return potega(10, iloscmpoprzec);
        }
        return 0;
    }
    private static long potega(long a, long b){
        long wynik = a;
        for(int i=1; i<b; i++){
            wynik=pomnoz_calk(wynik, a);
        }
        return wynik;
    }
    private static double podz_przezwielokr10(long a, long b){
        long czesc_calkowita=0;
        long czesc_ulamkowa;
        if(a>=0) {
            while (a >= b) {
                czesc_calkowita++;
                a -= b;
            }
        }else{
            while(a<=-b){
                czesc_calkowita--;
                a+=b;
            }
        }
        boolean dodatnie = a >= 0;
        czesc_ulamkowa = wartBezwzgl(a);
        if(czesc_ulamkowa > podz_calkowicieprzez10(b)) {
            return Double.parseDouble(czesc_calkowita + "." + czesc_ulamkowa);
        }else{
            StringBuilder sb = new StringBuilder();
            if(!dodatnie) sb.append("-");
            sb.append(czesc_calkowita).append(".");
            int m = 0;
            for(long i=podz_calkowicieprzez10(b); i>1; i=podz_calkowicieprzez10(i)){
                m++;
                if(czesc_ulamkowa > i){
                    break;
                }
            }
            for(int i=0; i<m; i++){
                sb.append("0");
            }
            sb.append(czesc_ulamkowa);
            return Double.parseDouble(sb.toString());
        }
    }
    private static long podz_calkowicieprzez10(long a){
        if(a > 10){
            int i = 0;
            while(a > 0){
                a=a-10;
                i++;
            }
            return i;
        }else return 1;

    }
    private static long wartBezwzgl(long d){
        if(d>=0) return d;
        else return -d;
    }
    private static boolean jestCalkowita(double d){
        return d == (long) d;
    }
}
