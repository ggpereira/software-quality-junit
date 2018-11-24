package test;


import java.awt.AWTException;
import java.awt.BufferCapabilities;
import java.awt.Button;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Point;
import java.awt.PopupMenu;

import org.junit.Test;
import com.fbergeron.solitaire.*;

public class TestSolitaire {
	@Test(expected = NullPointerException.class)
	public void testAddCompException() {
		//Passa um componente nulo para o método e espera um NullPointerException
		Solitaire s = new Solitaire(true);
		Component comp = null;
		s.add(comp);
	}
	
	@Test(expected = NullPointerException.class) 
	public void testAddPmenuException(){
		//Passa um componente nulo para o método e espera um NullPointerException
		Solitaire s = new Solitaire(true);
		PopupMenu popMenu = null;
		s.add(popMenu);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCompIllegalArgument() {
		//Passa um indíce nulo e espera que um IllegalArgumentException seja lançado
		Solitaire s = new Solitaire(true);
		
		Component comp = new Button();
		int index = - 89;
		s.add(comp, index);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCompNullException(){
		//Passa um component null e espera  NullPointerException
		Solitaire s = new Solitaire(true);
		Component comp = null;
		Object obj = new Object();
		
		s.add(comp, obj);
	}
	
	@Test(expected = NullPointerException.class)
	public void testComponentOrientationException() {
		//Passa um objeto ComponentOrientation null e espera um NullPointerException
		Solitaire s = new Solitaire(true);
		ComponentOrientation o = null;
		s.applyComponentOrientation(o);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testKeysSetException() {
		//Insere um inteiro fora da faixa de valores definidas como parâmetros do método e espera um IllegalArgumentException
		Solitaire s = new Solitaire(true);
		s.areFocusTraversalKeysSet(-89);
	}
	
	@Test(expected = NullPointerException.class)
	public void testContainsExceptions() {
		//Passa um objeto nulo para o método e espera uma exceção do tipo NullPointerException
		Solitaire s = new Solitaire(true);
		Point p = null;
		s.contains(p);	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBufferStrategyException() {
		//Insere passa como parâmetro um número de buffers menor que 1 e espera um IllegalArgument Exception
		Solitaire s = new Solitaire(true);
		s.createBufferStrategy(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBufferExceptionIllegal() throws AWTException{
		//Passa como parâmetro BufferCapabilities caps = null e espera um IllegalArgumentException 
		Solitaire s = new Solitaire(true);
		BufferCapabilities bcp = new BufferCapabilities(null, null, null);
		s.createBufferStrategy(1, bcp);
	}
	
	@Test(expected = NullPointerException.class)
	public void testFindComponentNull() {
		//Passa um objeto Point Null e espera NullPointerException
		Solitaire s = new Solitaire(true);
		Point p = null;
		s.findComponentAt(p);
	}
	
}
