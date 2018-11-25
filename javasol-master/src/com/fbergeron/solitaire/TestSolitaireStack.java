package com.fbergeron.solitaire;

import com.fbergeron.card.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSolitaireStack {
	
	Stack st_heart;
	Stack st_spade;
	Stack st_club;
	Stack st_diamond;
	
	@Before
	public void initResources() {
		 st_heart = new Stack();
		 st_spade = new Stack();
		 st_club = new Stack();
		 st_diamond = new Stack();
		//Cria pilhas de cartas separadas por naipe
		 
		 //HEART
		 for(int i = 5; i < 13; i ++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.HEART);
			 st_heart.push(tmp);
		 }
		 
		 //CLUB
		 for(int i = 5; i < 13; i++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.CLUB);
			 st_club.push(tmp);
		 }
		 
		 //DIAMOND
		 for(int i = 5; i < 13; i++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.DIAMOND);
			 st_diamond.push(tmp);
		 }
		 
		 //SPADE
		 for(int i = 5; i < 13; i++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.SPADE);
			 st_spade.push(tmp);
		 }
		 
		
	}
	
	
	@Test
	public void testPushCardEmptyTrue() {
		//Inserir um rei numa pilha vazia
		//Deve retornar true
		SolitaireStack sStack = new SolitaireStack();
		ClassicCard card = new ClassicCard(Value.V_KING, Suit.DIAMOND);
		
		assertEquals(true, sStack.isValid(card));
	}
	
	@Test
	public void testPushCardEmptyFalse() {
		//Inserir um 10 - Heart numa pilah vazia
		//Deve retornar false
		SolitaireStack sStack = new SolitaireStack();
		ClassicCard card = new ClassicCard(Value.V_10, Suit.HEART);
		
		assertEquals(false, sStack.isValid(card));
	}
	
	@Test
	public void testPushCardTrue() {
		//Inserir um 5 de espadas numa pilha que o topo é 6 de coração
		//Deve retornar true
		SolitaireStack sStack = new SolitaireStack();
		ClassicCard card = new ClassicCard(Value.V_5, Suit.SPADE);
		sStack.push(st_heart);
		assertEquals(true, sStack.isValid(card));
	}
	
	@Test
	public void testPushCardFalse() {
		//Inserir um 5 de coração numa pilha que o topo é 6 de coração 
		//Deve retornar false
		SolitaireStack sStack = new SolitaireStack();
		ClassicCard card = new ClassicCard(Value.V_5, Suit.HEART);
		sStack.push(st_heart);
		assertEquals(false, sStack.isValid(card));
	}
}
