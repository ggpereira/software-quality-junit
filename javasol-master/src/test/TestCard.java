package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import org.junit.Test;
import com.fbergeron.card.*;

//@Autor: Gabriel Gomes

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
	public void testValue() {
		//Cria uma série de cards e testa se inserção dos valores foi correta
		ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
		ClassicCard card2  = new ClassicCard(Value.V_2, Suit.DIAMOND);
		ClassicCard card3 = new ClassicCard(Value.V_3, Suit.CLUB);
		ClassicCard card4 = new ClassicCard(Value.V_4, Suit.DIAMOND);
		ClassicCard card5 = new ClassicCard(Value.V_5, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_6, Suit.HEART);
		ClassicCard card7 = new ClassicCard(Value.V_7, Suit.CLUB);
		ClassicCard card8 = new ClassicCard(Value.V_8, Suit.SPADE);
		ClassicCard card9 = new ClassicCard(Value.V_9, Suit.HEART);
		ClassicCard card10 = new ClassicCard(Value.V_ACE, Suit.DIAMOND);
		ClassicCard card11 = new ClassicCard(Value.V_JACK, Suit.HEART);
		ClassicCard card12 = new ClassicCard(Value.V_KING, Suit.DIAMOND);
		ClassicCard card13 = new ClassicCard(Value.V_QUEEN, Suit.SPADE);
		
		Value[] actual = {card.getValue(), card2.getValue(), card3.getValue(), card4.getValue(), 
				card5.getValue(), card6.getValue(), card7.getValue(), card8.getValue(), card9.getValue(), card10.getValue(), 
				card11.getValue(), card12.getValue(), card13.getValue()};
		
		Value[] expected = {Value.V_1, Value.V_2, Value.V_3, Value.V_4, Value.V_5, Value.V_6, Value.V_7, 
				Value.V_8, Value.V_9, Value.V_ACE, Value.V_JACK, Value.V_KING, Value.V_QUEEN};
		
	
		
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testColorBlack() {
		//Testa se a cor da carta é retornada corretamente
		ClassicCard card  = new ClassicCard(Value.V_1, Suit.CLUB);
		assertEquals(Color.black, card.getColor());
	}
	
	@Test
	public void testColorRed() {
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		//Testa se a cor da carta é retornada corretamente
		assertEquals(Color.red, card.getColor());
	}
	
	@Test
	public void testLegalTrue() {
		ClassicCard card = new ClassicCard(Value.V_13, Suit.CLUB);
		boolean legal = true;
		card.setLegal(legal);
		assertEquals(true, card.isLegal());
	}
	
	@Test
	public void testLegalFalse() {
		//Testa se o valor retornado de isLegal é correto quando false
		ClassicCard card = new ClassicCard(Value.V_11, Suit.DIAMOND);
		boolean legal = false;
		card.setLegal(legal);
		assertEquals(false, card.isLegal());
	}
	
	
}
