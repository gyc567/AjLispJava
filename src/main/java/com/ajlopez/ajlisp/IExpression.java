package com.ajlopez.ajlisp;

public interface IExpression {

	public abstract Object evaluate(Environment environment);

	public abstract String printString();
}