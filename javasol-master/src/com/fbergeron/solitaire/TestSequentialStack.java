package com.fbergeron.solitaire;

import com.fbergeron.card.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/*
 * Para conseguir testar os métodos protected que achei relevantes, precisei colocar
 * essa classe de teste dentro do pacote.
 * */

public class TestSequentialStack {
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
		 for(int i = 0; i < 10; i ++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.HEART);
			 st_heart.push(tmp);
		 }
		 
		 //CLUB
		 for(int i = 0; i < 10; i++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.CLUB);
			 st_club.push(tmp);
		 }
		 
		 //DIAMOND
		 for(int i = 0; i < 10; i++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.DIAMOND);
			 st_diamond.push(tmp);
		 }
		 
		 //SPADE
		 for(int i = 0; i < 10; i++) {
			 ClassicCard tmp = new ClassicCard(Value.values[i], Suit.SPADE);
			 st_spade.push(tmp);
		 }
		 
		
	}
	
	@Test
	public void pushCardStackEmptyTrue() {
		//Testa quando o jogador tentar colocar uma carta válida numa pilha vazia
		//Método deve retornar true
		SequentialStack sq = new SequentialStack();
		ClassicCard card = new ClassicCard(Value.V_ACE, Suit.CLUB);
		
		assertEquals(true, sq.isValid(card));
	}
	
	@Test
	public void pushCardStackEmptyFalse() {
		//Testa quando o jogar tenta colocar uma carta inválida numa pilha vazia 
		//Método deve retornar false
		SequentialStack sq = new SequentialStack();
		ClassicCard card = new ClassicCard(Value.V_12, Suit.HEART);
		
		assertEquals(false, sq.isValid(card));
	}
	
	@Test
	public void pushCardStackTrue() {
		//Testa quando o jogador tentar inserir uma carta válida na pilha
		SequentialStack sq = new SequentialStack();
		ClassicCard card = new ClassicCard(Value.V_JACK, Suit.HEART);
		//Carta do topo será 10 - HEART
		st_heart.reverse();
		sq.push(st_heart);
		
		//Carta inserida será 11 - HEART
		assertEquals(true, sq.isValid(card));
	}
	
	@Test
	public void pushCardStackFalse() {
		//Testa quando o jogador tentar inserir uma carta inválida na pilha
		// deve retornar false
		SequentialStack sq = new SequentialStack();
		ClassicCard card = new ClassicCard(Value.V_5, Suit.SPADE);
		//Carta do topo será 10 - DIAMOND
		st_diamond.reverse();
		sq.push(st_diamond);
		//Carta inserida será 5 - SPADE
		assertEquals(false, sq.isValid(card));
	}
	
}
