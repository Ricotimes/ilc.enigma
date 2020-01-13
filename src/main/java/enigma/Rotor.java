package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    public int getPosition() {
        return position;
    }

    public void setPosition(int posn) {
        position = posn;
    }
    
    public static Rotor rotorFactory(String str, String notches){
            char[] s = str.trim().replace(" ", "").toCharArray();           //On retire les espaces et caract�res sp�ciaux de formattage
            int[] cipher = new int[26];
            for (int i = 0; i< 26; i++){                                    //On r�cup�re un tableau avec les index des lettres dans l'alphabet
                    cipher[i] = toIndex(s[i]);                              //A l'indice i, on a l'index de la i-i�me lettre
            }                                                               
            s = notches.trim().replace(" and ", "").toCharArray();          //On r�cup�re juste les lettres dans un tableau
            if (s.length == 2){
                    return new Rotor(cipher, toIndex(s[0]), toIndex(s[1])); //On cr�e un rotor avec 2 notches 
            } else {
                    return new Rotor(cipher, toIndex(s[0]));                //Idem avec une seule notche
            }

    }

    Rotor(int[] c, int notch1, int notch2) {
            this.notch1 = notch1;
            this.notch2 = notch2;
            cipher = c;
            createBCipher();
    }

    Rotor(int[] c, int notch1) {
            this.notch1 = notch1;
            cipher = c;
            createBCipher();
    }

    public int convertForward(int p) {
        return ((cipher[((p + position) % 26 + 26) % 26] - position) %26 + 26) % 26;           
    }

    public int convertBackward(int e) {
        return ((bcipher[((e + position) % 26 + 26) % 26] - position) %26 + 26) % 26;
    }
    
    public void advance() {
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
