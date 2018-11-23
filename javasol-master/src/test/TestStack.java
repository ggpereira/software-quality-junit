package test;
import org.junit.Test;
import com.fbergeron.card.*;
import static org.junit.Assert.*;

import java.awt.Point;

//@Autor: Gabriel Gomes
public class TestStack {
	@Test
	public void testCountStackEmpty() {
		//Testa a quantidade cartas com a pilha vazia
		Stack stack = new Stack();
		
		assertEquals(0, stack.cardCount());
	}
	
	@Test
	public void testCountStackFilled() {
		//Testa o valor atual da quantidad de cartas na pilha
		Stack stack = new Stack();
		ClassicCard card = new ClassicCard(Value.V_1, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		
		assertEquals(4, stack.cardCount());
		
	}
	
	@Test
	public void testCardStackContainsTrue() {
		//Testa se o retorno de stack contains é correto para true
		Stack stack = new Stack();
		ClassicCard card = new ClassicCard(Value.V_1, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		
		ClassicCard cardTest = new ClassicCard(Value.V_1, Suit.DIAMOND);
		
		assertEquals(true, stack.contains(cardTest));
	}
	
	@Test
	public void testCardStackContainsFalse() {
		//Testa se o retorno de stack contains é correto para false
		Stack stack = new Stack();
		ClassicCard card = new ClassicCard(Value.V_1, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		
		ClassicCard cardTest = new ClassicCard(Value.V_1, Suit.SPADE);
		
		assertEquals(false, stack.contains(cardTest));
	}
	
	@Test
	public void testStackPop() {
		//Testa se o topo da pilha é o último elemento inserido
		Stack stack = new Stack();

		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		assertEquals(card4, stack.pop());	
	}
	
	@Test
	public void testFirstFaceUpFalse() {
		//Testa para caso não haja nenhuma carta virada para cima
		Stack stack = new Stack();
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);

		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		stack.push(card5);
		stack.push(card6);
		stack.push(card7);
		
		assertEquals(-1, stack.firstFaceUp());
	}
	
	@Test
	public void testFirstFaceUp() {
		//Testa se o valor certo para first face up é retornado caso haja alguma carta virada para cima
		Stack stack = new Stack();
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
		
		
		card7.flip();
		
		stack.push(card);   //0
		stack.push(card2);  //1
		stack.push(card3);  //2
		stack.push(card4);  //3
		stack.push(card5);  //4
		stack.push(card6);  //5
		stack.push(card7);  //6 flip
		
		
		assertEquals(6, stack.firstFaceUp());
	}
	
	
	@Test
	public void testPopAllCards() {
		//Testa pop() passando card como parâmetro
		Stack stack = new Stack();
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
		
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		stack.push(card5);
		stack.push(card6);
		stack.push(card7);
		
		//Retira todos as cartas da pilha pelo parâmetro card
		stack.pop(card);

		
		assertEquals(0, stack.cardCount());
	}
	
	@Test 
	public void testPopCards() {
		//Testa passando um card como parâmetro
		//Testa removendo valores da pilha, e verificando se a quantidade de cartas que sobram é a correta
		//Além disso testa se o novo topo da pilha está correto 
		Stack stack = new Stack();
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
	
		
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		stack.push(card5);
		stack.push(card6);
		stack.push(card7);
		
		stack.pop(card4);
		
		assertEquals(3, stack.cardCount());
		assertEquals(card3, stack.pop());
	}
	
	@Test
	public void testPopCardsInt() {
		//Testa passando o numero de itens a serem removidos da pilha 
		//testa se a novo valor retornado por cardcount é correto
		//testa se o topo da pilha é retornado corretamente
		Stack stack = new Stack();
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
	
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		stack.push(card5);
		stack.push(card6);
		stack.push(card7);
		
		stack.pop(4);
		
		assertEquals(3, stack.cardCount());
		assertEquals(card3, stack.pop());
	}
	
	@Test
	public void testPushStack() {
		//Insere um stack e verifica se a inserção foi correta
		//Considera-se a inserção correta se o topo é retornado corretamente
		Stack stack = new Stack();
		Stack test = new Stack();
		
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
		
		
		stack.push(card5);
		stack.push(card6);
		stack.push(card7); 
		
		//Passa a ser novo topo
		test.push(card);
		test.push(card2);
		test.push(card3);
		test.push(card4);
		
		//Insere test em stack
		stack.push(test);
		
		assertEquals(card, stack.pop());
	}
	
	@Test
	public void testReverse() {
		Stack stack = new Stack();
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
		
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		stack.push(card5);
		stack.push(card6);
		stack.push(card7);
		
		//card7 deveria ser o topo da pilha, mas com reverse card(1) passa a ser o novo topo
		stack.reverse();
		
		assertEquals(card, stack.pop());
	}
	
	@Test
	public void testReverseTwoTimes() {
		Stack stack = new Stack();
		
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		ClassicCard card2 = new ClassicCard(Value.V_10, Suit.SPADE);
		ClassicCard card3 = new ClassicCard(Value.V_13, Suit.HEART);
		ClassicCard card4 = new ClassicCard(Value.V_2, Suit.CLUB);
		ClassicCard card5 = new ClassicCard(Value.V_11, Suit.DIAMOND);
		ClassicCard card6 = new ClassicCard(Value.V_2, Suit.SPADE);
		ClassicCard card7 = new ClassicCard(Value.V_13, Suit.SPADE);
		
		stack.push(card);
		stack.push(card2);
		stack.push(card3);
		stack.push(card4);
		stack.push(card5);
		stack.push(card6);
		stack.push(card7);
		
		//card deveria ser o topo da pilha, mas com reverse 2 vezes card7 passa a ser o novo topo
		stack.reverse();
		stack.reverse();
		
		assertEquals(card7, stack.pop());
	}
	
	@Test
	public void testLocation() {
		//Verifica se o local da pilha é inserido e retornado corretamente
		Stack stack = new Stack();
		
		stack.setLocation(5, 6);
		
		Point p =  stack.getLocation();
				
		assertEquals(5, p.getX(), 0);
		assertEquals(6, p.getY(), 6);
	}
	
	@Test
	public void testClickedCard() {
		//Testa se a carta clicada é retornada corretamente
		Stack stack = new Stack();
		ClassicCard card = new ClassicCard(Value.V_10, Suit.DIAMOND);
		card.setLocation(8, 7);
		
		stack.push(card);
		
		Point p = new Point(8, 7);
		
		assertEquals(card, stack.getClickedCard(p));
	}
	
	@Test
	public void testSpredingDelta() {
		//Testa inserção e retorno correto do delta
		Stack stack = new Stack();
		stack.setSpreadingDelta(5);
		assertEquals(5, stack.getSpreadingDelta());
	}
	
	@Test
	public void testDirection() {
		//Testa inserção e retorno em direction
		Stack stack = new Stack();
		stack.setSpreadingDirection(485);
		assertEquals(485, stack.getSpreadingDirection());
	}

}
