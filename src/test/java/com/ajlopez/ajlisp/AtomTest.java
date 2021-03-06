package com.ajlopez.ajlisp;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtomTest {

	@Test
	public void createAtom() {
		Atom atom = new Atom("foo");
		assertEquals("foo", atom.getName());
	}

	@Test
	public void evaluateAtom() {
		IExpression atom = new Atom("foo");
		Environment environment = new Environment();
		
		assertNull(atom.evaluate(environment));
		
		environment.setValue("foo", 1);
		
		assertEquals(1, atom.evaluate(environment));
	}

	@Test
	public void equalsAtoms() {
		Atom atom = new Atom("foo");
		Atom atom2 = new Atom("foo");
		Atom atom3 = new Atom("bar");
		
		assertEquals(atom, atom2);
		assertEquals(atom.hashCode(), atom2.hashCode());
		assertEquals(atom2, atom);
		assertFalse(atom.equals(atom3));
		assertFalse(atom3.equals(atom));
	}
}
