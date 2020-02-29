public class Main {
    public static void main(String[] args){
        //Widoki.wygeneruj();
        //Niepowtarzalne.niepowtarzalny("123231");
        /*Random rand = new Random();
        for(int i=0; i<1000; i++) {
            double one = -50 + (50 - -50) * rand.nextDouble();
            double two = -50 + (50 - -50) * rand.nextDouble();
            DecimalFormat df = new DecimalFormat("##.####");
            one = Double.parseDouble(df.format(one).replace(",", "."));
            two = Double.parseDouble(df.format(two).replace(",", "."));
            System.out.println(one + " " + two);
            System.out.println(Mnozenie.pomnoz(one, two));
        }*/
        System.out.println(Mnozenie.pomnoz(2.456, 6.423));
        //System.out.println(Mnozenie.pomnoz(0.1, -0.2));
        //Chomonimy.chomonimy();
        //Chomonimy.chomonimy("michał stanowski");
        //System.out.println(Mendelejew.convert("cabbage"));
        //System.out.println(Mendelejew.szyfrMendelejewa("SobOta rANO"));
    }
}
