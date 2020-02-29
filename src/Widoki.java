//Zadanie 1 - Java Eclipse z javac 7

import java.util.Random;

public class Widoki {

    private static Random random = new Random();

    public static void wygeneruj(){
      int[][] tablica = new int[7][7];

      for(int i=1; i<6; i++){
          for(int j=1; j<6; j++){
              tablica[i][j] = random.nextInt(5) + 1;
          }
      }
      oblicz(tablica);
      for(int i=0; i<7; i++){
          for(int j=0; j<7; j++){
              if (tablica[i][j] == 0) {
                  System.out.print("  ");
              }else {
                  System.out.print(tablica[i][j] + " ");
              }
          }
          System.out.print(System.lineSeparator());
      }
    }

    private static void oblicz(int[][] t){
        for(int i=1; i<6; i++){
            int lastbig = t[i][1];
            int countbig = 1;
            int lastsmall = t[i][1];
            int countsmall = 1;
            for(int j=2; j<6; j++){
                if(t[i][j] < lastsmall){
                    lastsmall = t[i][j];
                    countsmall++;
                }
                if(t[i][j] > lastsmall){
                    lastsmall = t[i][j];
                    if(t[i][j] >= lastbig){
                        countsmall = 1;
                    }
                    if(t[i][j] < lastbig){
                        countsmall = 2;
                    }
                }

                if(t[i][j] > lastbig){
                    countbig++;
                    lastbig = t[i][j];
                }
            }
            t[i][0] = countbig;
            t[i][6] = countsmall;
        }
        for(int j=1; j<6; j++){
            int lastbig = t[1][j];
            int countbig = 1;
            int lastsmall = t[1][j];
            int countsmall = 1;
            for(int i=2; i<6; i++){
                if(t[i][j] < lastsmall){
                    lastsmall = t[i][j];
                    countsmall++;
                }
                if(t[i][j] > lastsmall){
                    lastsmall = t[i][j];
                    if(t[i][j] >= lastbig){
                        countsmall = 1;
                    }
                    if(t[i][j] < lastbig){
                        countsmall = 2;
                    }
                }

                if(t[i][j] > lastbig){
                    countbig++;
                    lastbig = t[i][j];
                }
            }
            t[0][j] = countbig;
            t[6][j] = countsmall;
        }
    }
}
