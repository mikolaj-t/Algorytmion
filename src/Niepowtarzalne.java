public class Niepowtarzalne {
    public static boolean niepowtarzalny(String s){
        for(int i = 1; i<=s.length()/2; i++){
            String compare;
            String compareTo;
            for(int j=0; j<=s.length()-(2*i); j++){
                compare=s.substring(j, (j+i));
                compareTo=s.substring(j+i, j+2*i);
                //System.out.println("i " + i + " j " + j + " compare "+ compare + " compareTo " + compareTo);
                if(compare.equals(compareTo)){
                    //System.out.println("false");
                    return false;
                }
            }
        }
        System.out.println("true");
        return true;
    }

}
