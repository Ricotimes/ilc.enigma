package enigma;

public class Rotor {

    private static int ALPHABET_SIZE = 26;
    
    private int position;
    private int[] cipher = new int[ALPHABET_SIZE];
    private int[] bcipher = new int[ALPHABET_SIZE];
    private int notch1 = -1;
    private int notch2 = -1;

    public int getPosition() {
        return position;
    }

    public void setPosition(int posn) {
        position = posn;
    }
    
    public static Rotor rotorFactory(String str, String notches){
            char[] s = str.trim().replace(" ", "").toCharArray();           //On retire les espaces et caractères spéciaux de formattage
            int[] cipher = new int[ALPHABET_SIZE];
            for (int i = 0; i< ALPHABET_SIZE; i++){                                    //On récupère un tableau avec les index des lettres dans l'alphabet
                    cipher[i] = toIndex(s[i]);                              //A l'indice i, on a l'index de la i-ième lettre
            }                                                               
            s = notches.trim().replace(" and ", "").toCharArray();          //On récupère juste les lettres dans un tableau
            if (s.length == 2){
                    return new Rotor(cipher, toIndex(s[0]), toIndex(s[1])); //On crée un rotor avec 2 notches 
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
        return (cipher[(p + position) % ALPHABET_SIZE] - position) %ALPHABET_SIZE;           
    }

    public int convertBackward(int e) {
        return (bcipher[(e + position) % ALPHABET_SIZE] - position) %ALPHABET_SIZE;
    }
    
    public void advance() {
        position = (position+1) % ALPHABET_SIZE;
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
		for(int i =0; i<ALPHABET_SIZE; i++)
			bcipher[cipher[i]] = i;
	}



}
