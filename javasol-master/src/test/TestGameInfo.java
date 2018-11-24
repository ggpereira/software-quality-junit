package test;

import static org.junit.Assert.*;


import org.junit.Test;
import com.fbergeron.solitaire.*;

//@Author: Gabriel Gomes

public class TestGameInfo {
	@Test
	public void testGameInfoType() {
		//testa valores ao instanciar GameInfo
		GameInfo ginf = new GameInfo("asdhhc", 4689);
		assertEquals("asdhhc", ginf.getType());
	}
	
	@Test
	public void testTypeMethods() {
		//Testa get e set de type
		GameInfo ginf = new GameInfo();
		ginf.setType("Random");
		assertEquals("Random", ginf.getType());
	}
	
	@Test
	public void testSeedMethods() {
		//Testa get e set de semente
		GameInfo ginf = new GameInfo();
		ginf.setSeed(5);
		assertEquals(5, ginf.getSeed());
	}
	
	@Test
	public void testEqualsTrue() {
		//Testa equals quando deve retornar verdadeiro
		GameInfo ginf = new GameInfo();
		ginf.setSeed(10);
		ginf.setType("teste");
		
		GameInfo ginf2 = new GameInfo();
		ginf2.setSeed(10);
		ginf2.setType("teste");
		
		
		assertEquals(true, ginf.equals(ginf2));
	}
	
	@Test
	public void testEqualsFalse() {
		//Testa equals quando deve retornar falso
		GameInfo ginf = new GameInfo();
		ginf.setSeed(10);
		ginf.setType("normal");
		
		GameInfo ginf2 = new GameInfo();
		ginf2.setSeed(10);
		ginf2.setType("random");
		
		assertEquals(false, ginf.equals(ginf2));
	}
	
	@Test
	public void testDefaultObjectState() {
		//Testa quais são os valores "padrão" quando o objeto é instância
		GameInfo ginf = new GameInfo();
		
		assertEquals(-1, ginf.getSeed());
		assertEquals("Random", ginf.getType());
	}
	
}
