package com.ajlopez.ajlisp.primitives;

import com.ajlopez.ajlisp.Atom;
import com.ajlopez.ajlisp.Environment;
import com.ajlopez.ajlisp.IForm;
import com.ajlopez.ajlisp.List;

public class Definem implements IForm {
	private static Definem instance = new Definem();
	
	private Definem() {		
	}
	
	public static Definem getInstance() {
		return instance;		
	}
	
	public Object evaluate(Environment environment, List arguments) {
		Atom atom = (Atom)arguments.first();
		List list = (List)arguments.rest();
		
		Object value = MLambda.getInstance().evaluate(environment, list);
		
		environment.getTopEnvironment().setValue(atom.getName(), value);

		return value;
	}
}