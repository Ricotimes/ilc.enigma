package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {



	@Test
	public void aRotor1convertBackward1(){
		Rotor rotor = Rotor.rotorFactory("E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
		rotor.setPosition(25);
		int data = rotor.convertBackward(2);
		int expected =23;
		assertEquals(expected,data);
	}

	@Test
	public void aRotor1convertForward1(){
		Rotor rotor = Rotor.rotorFactory("E K M F L G D Q V Z N T O W Y H X U S P A I B R C J", "Q");
		rotor.setPosition(25);
		int data = rotor.convertForward(2);
		int expected =11;
		assertEquals(expected,data);
	}

}
