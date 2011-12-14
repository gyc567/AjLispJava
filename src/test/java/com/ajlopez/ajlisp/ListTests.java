package com.ajlopez.ajlisp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ajlopez.ajlisp.primitives.First;

public class ListTests {

	@Test
	public void createWithConstant() {
		List list = new List(1);
		assertEquals(1, list.first());
		assertNull(list.rest());
	}

	@Test
	public void createWithTwoAtoms() {
		IExpression a = new Atom("a");
		IExpression b = new Atom("b");
		
		List list = new List(a, new List(b));
		assertEquals(a, list.first());
		assertNotNull(list.rest());
		assertEquals(b, ((List)list.rest()).first());
	}

	@Test
	public void evaluateListWithFirst()
	{
		Environment environment = new Environment();
		First first = new First();
		Atom a = new Atom("a");
		List list = new List(a);
		Atom b = new Atom("b");
		environment.setValue("b", list);
		
		List expr = new List(first, new List(b));
		
		Object result = expr.evaluate(environment);
		
		assertEquals(a, result);
	}
}

