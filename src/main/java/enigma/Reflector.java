package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends Rotor {

	int[] reflection;
	
	public static Reflector reflectorFactory(String str){
		char[] s = str.trim().replace(" ", "").toCharArray();  //We remove all things which are not letters
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){											  //Permiss to work with ints between 0 and 26
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);											  //Creation of the object
	}
	
	Reflector(int[] r){   // constructor of the reflector
		super(r,0);
		reflection = r;
	}
        
    public int convertForward(int p) {						// We need to refactor this
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }

    @Override
    public int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void advance() {
    }

}
