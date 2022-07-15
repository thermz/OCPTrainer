/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.ocptrain.operatorstrainer;

import java.util.List;

/**
 *
 * @author Riccardo
 */
public final class OperatorPrecedenceClass {
	private final int precedence;
	private final List<String> operators;
	private final String description;
	private final String associativity;

	public OperatorPrecedenceClass(int precedence, List<String> operators, String description, String associativity) {
		this.precedence = precedence;
		this.operators = operators;
		this.description = description;
		this.associativity = associativity;
	}

	public int getPrecedence() {
		return precedence;
	}

	public List<String> getOperators() {
		return operators;
	}

	public String getDescription() {
		return description;
	}

	public String getAssociativity() {
		return associativity;
	}

	@Override
	public String toString() {
		return "OperatorPrecedenceClass{" + "precedence=" + precedence + ", operators=" + operators + ", description=" + description + ", associativity=" + associativity + '}';
	}
	
}
