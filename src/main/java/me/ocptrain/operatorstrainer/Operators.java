
package me.ocptrain.operatorstrainer;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Riccardo
 */
public class Operators {
	
	public static class OperatorInstance implements Comparable<OperatorInstance>{
		private final String operator, classDescription;
		private final int prec;

		public OperatorInstance(String operator, String classDescription, int prec) {
			this.operator = operator;
			this.classDescription = classDescription;
			this.prec = prec;
		}
		
		public String getOperator() {
			return operator;
		}

		public String getClassDescription() {
			return classDescription;
		}

		public int getPrec() {
			return prec;
		}

		@Override
		public int compareTo(OperatorInstance o) {
			return Integer.compare(prec, o.getPrec());
		}
	}
	
	//XXX just a couple of shortcuts to have a better view of operators list, 
	//XXX I usualy don't do such things in production code, especially the dollar thing :-)
	private static List<String> $(String ... strings){
		return asList(strings);
	}
	private static OperatorPrecedenceClass op(int prec, List<String> ops, String desc, String assoc ){
		return new OperatorPrecedenceClass(prec, ops, desc, assoc);
	}
	
	
	public static final List<OperatorPrecedenceClass> LIST = List.of(
		op(16	, $("()","[]","."),	"parenthesesarray accessmember access",	"left-to-right"),
		op(15	, $("i++","i--")	,"unary post-incrementunary post-decrement",	"left-to-right"),
		op(14	, $("unary plus +","unary minus -","!","~","++i","--i"),	"unary plus - unary minus - unary logical NOT - unary bitwise NOT - unary pre-increment - unary pre-decrement",	"right-to-left" ),
		op(13	, $("(cast)","new")	,"cast - object creation",	"right-to-left"),
		op(12	, $("*", "/", "%"),	"multiplicative"	,"left-to-right"),
		op(11	, $("-","+"),	"additive - string concatenation",	"left-to-right"),
		op(10	, $("<<", ">>", ">>>"),	"shift"	,"left-to-right"),
		op(9	, $("<", "<=", ">", ">=" , "instanceof"),	"relational",	"left-to-right"),
		op(8	, $("==", "!=")	,"equality",	"left-to-right"),
		op(7	, $("&" )	,"bitwise AND",	"left-to-right"),
		op(6	, $("^" )	,"bitwise XOR",	"left-to-right"),
		op(5	, $("|" )	,"bitwise OR	",	"left-to-right"),
		op(4	, $("&&")	,"logical AND",	"left-to-right"),
		op(3	, $("||")	,"logical OR	",	"left-to-right"),
		op(2	, $("?:")	,"ternary	",	"right-to-left"),
		op(1	, $("=","+=","-=","*=","/=","%=","&=","^=","|=","<<=",">>=",">>>="),	"assignment",	"right-to-left"),
		op(0	, $("->"),	"lambda expression arrow"	,"right-to-left")
	);
	public static final List<String> OPERATORS_FLAT = getOperatorsFlat();
	
	
	public static OperatorInstance getRandomInstance(){
		var operators = new ArrayList<>(OPERATORS_FLAT);
		Collections.shuffle(operators);
		
		return lookupByOperator(operators.get(0));
	}
	
	private static OperatorInstance lookupByOperator(String op){
		return LIST.stream().filter( oc -> oc.getOperators().stream().anyMatch(op::equals) ).findFirst().map(oc -> pickInstance(oc, op)).orElseThrow();
	}
	private static OperatorInstance pickInstance(OperatorPrecedenceClass oc, String singleOperator){
		return new OperatorInstance(singleOperator, oc.getDescription(), oc.getPrecedence());
	}
	
	private static List<String> getOperatorsFlat(){
		return LIST.stream().map(OperatorPrecedenceClass::getOperators).flatMap(List::stream).collect(toList());
	}
	
}
