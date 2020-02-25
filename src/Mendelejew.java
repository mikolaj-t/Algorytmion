public class Mendelejew {

    private static String[] pierwiastki = new String[]{"0", "H", "He",
    "Li", "Be", "B", "C", "N", "O", "F", "Ne",
    "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar",
    "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
    "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe",
    "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu",
    "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn",
    "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr",
    "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"};

    //TODO pewnie mozna zrobic dzielac na rozna ilosc podciagow 1 elementowych i 2 elementowych
    //TODO lekkie poprawki stylistyczne z *
    //TODO problemy z tym jeśli w dwuliterowcu jest pierwsza litera - np Ca, He,

    public static String convert(String s) {
        boolean poprzednie = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(poprzednie){
                poprzednie = false;
                continue;
            }
            if(s.charAt(i) == ' ') {
                sb.append("**");
                continue;
            }
            boolean znaleziono = false;
            for (int j = 1; j <= 118; j++) {
                if(pierwiastki[j].length() == 1){
                    if(pierwiastki[j].equalsIgnoreCase(s.charAt(i) + "")){
                        sb.append(j).append("*");
                        znaleziono = true;
                        break;
                    }
                }else if(pierwiastki[j].length() == 2){
                    if((i+1 < s.length()) && pierwiastki[j].equalsIgnoreCase(s.charAt(i) + "" +  s.charAt(i+1))){
                        sb.append(j).append("*");
                        znaleziono = true;
                        poprzednie = true;
                        break;
                    }
                }
            }
            if(!znaleziono) return "Nie można zaszyfrować!";
        }
        return sb.toString();
    }


}
