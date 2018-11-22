package test;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;

import org.junit.Test;
import com.fbergeron.card.*;

public class TestCard {
	
	@Test
	public void testIsFaceDownTrue() {
		//Testa o valor do atributo facedown retornado pelo método isFaceDown quando a carta está virada para baixo 
		ClassicCard card = new ClassicCard(Value.V_1, Suit.HEART);
		card.turnFaceDown();
		assertEquals(true, card.isFaceDown());
	}
	
	@Test
	public void testIsFaceDownFalse() {
		//Testa o valor do atributo facedown retornado pelo método turnFaceUp quando a carta está virada para cima
		ClassicCard card = new ClassicCard(Value.V_1, Suit.HEART);
		card.turnFaceUp();
		assertEquals(false, card.isFaceDown());
		
	}
	
	@Test
	public void testFlipIsFaceDownTrue() {
		//Testa o valor do atributo facedown quando é chamado flip e facedown = true
		ClassicCard card = new ClassicCard(Value.V_2, Suit.DIAMOND); 
		card.turnFaceDown();
		card.flip();
		assertEquals(false, card.isFaceDown());
	}
	
	@Test
	public void testFlipIsDownFalse() {
		//Testa o valor do atributo facedown quando é chamado flip e facedown = false
		ClassicCard card = new ClassicCard(Value.V_10, Suit.SPADE);
		card.turnFaceUp();
		card.flip();
		assertEquals(true, card.isFaceDown());
	}
	
	@Test
	public void testSizeHeight() {
		//Testa o valor padrão retornado por getsize para height default 129
		ClassicCard card = new ClassicCard(Value.V_2, Suit.CLUB); 
		Dimension size = card.getSize();
		assertEquals(129, size.getHeight(), 0);
	}
	
	@Test
	public void testSizeWidth() {
		//testa o valor padrão retornado por getsize para width default 86
		ClassicCard card = new ClassicCard(Value.V_1, Suit.SPADE);
		Dimension size = card.getSize();
		assertEquals(86, size.getWidth(), 0);
	}
	
	@Test
	public void testSize() {
		//testa o valor de getsize é igual ao último inserido
		ClassicCard card = new ClassicCard(Value.V_1, Suit.SPADE);
		card.setSize(100, 200);
		card.setSize(100, 300);
		Dimension size = card.getSize();
		assertEquals(100, size.getWidth(), 0);
		assertEquals(size.getHeight(), 300, 0 );
	}
	
	@Test
	public void testLocation() {
		//testa um location inserido e retornado
		ClassicCard card = new ClassicCard(Value.V_1, Suit.SPADE);
		Point p = new Point(3, 5);
		card.setLocation(p);
		Point res = card.getLocation();
		assertEquals(3, res.getX(), 0);
		assertEquals(5, res.getY(), 0);
	}
	
	@Test 
	public void testSuit() {
		//Cria uma série de cards e testa se a inserção dos naipes foi correta
		ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
		ClassicCard card2 = new ClassicCard(Value.V_11, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_5, Suit.DIAMOND);
		ClassicCard card4 = new ClassicCard(Value.V_4, Suit.HEART);
		ClassicCard card5 = new ClassicCard(Value.V_7, Suit.SPADE);
		ClassicCard card6 = new ClassicCard(Value.V_7, Suit.DIAMOND);
		Suit[] actual = {card.getSuit(), card2.getSuit(), card3.getSuit(), card4.getSuit(), card5.getSuit(), card6.getSuit()};
		Suit[] expected = {Suit.CLUB, Suit.SPADE, Suit.DIAMOND, Suit.HEART, Suit.SPADE, Suit.DIAMOND};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test() {
		ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
		ClassicCard card1  = new ClassicCard(Value.V_2, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_3, Suit.CLUB);
		ClassicCard card3 = new ClassicCard(Value.V_4, Suit.DIAMOND);
		ClassicCard card4 = new ClassicCard(Value.V_5, Suit.DIAMOND);
		ClassicCard card5 = new ClassicCard(Value.V_6, Suit.HEART);
		ClassicCard card6 = new ClassicCard(Value.V_7, Suit.CLUB);
		ClassicCard card7 = new ClassicCard(Value.V_8, Suit.SPADE);
		ClassicCard card8 = new ClassicCard(Value.V_9, Suit.HEART);
		ClassicCard card9 = new ClassicCard(Value.V_ACE, Suit.DIAMOND);
		ClassicCard card10 = new ClassicCard(Value.V_JACK, Suit.HEART);
		ClassicCard card11 = new ClassicCard(Value.V_KING, Suit.DIAMOND);
		ClassicCard card12 = new ClassicCard(Value.V_QUEEN, Suit.SPADE);
	}
}
