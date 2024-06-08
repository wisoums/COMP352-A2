public class ExpressionEval {
    private String expression;
    private StackPerso<String> opStk;

    private StackPerso<String> valStk;
    public StackPerso<String> getValStk() {
        return valStk;
    }

    //Getters & Setters
    public void setValStk(StackPerso<String> valStk) {
        this.valStk = valStk;
    }
    public StackPerso<String> getOpStk() {
        return opStk;
    }
    public void setOpStk(StackPerso<String> opStk) {
        this.opStk = opStk;
    }
    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }

    //Constructor
    public ExpressionEval(){
        this.expression="";
        valStk= new StackPerso<String>(5);
        opStk= new StackPerso<String>(5);
    }

    public ExpressionEval(String expression){
        this.expression=expression;
        valStk= new StackPerso<String>(5);
        opStk= new StackPerso<String>(5);
    }

    public static void doOp(){ //when the operand has a smaller precedence then the previous operand

    }
    public void repeatOps(){

    }
    public static boolean isNumber(char c) {
        if (!Character.isDigit(c)){
            return false;
        }
        return true;
    }

    public static boolean isOperand(char c) {
        if (c=='^'||c=='*'||c=='/'||c=='+'||c=='-'){
            return true;
        }
        return false;
    }
    public static int nextToken(String s) {
        int token=0;
        for (int i = 0; i < s.length(); i++) {
            if (isNumber(s.charAt(i))) {

            }
        }
        return 0;
    }
    public void evalExp(){
        String token="";
        for (int i=0; i<expression.length(); i++){
            if (isNumber(expression.charAt(i))&&!isNumber(expression.charAt(i+1))){
                token+=expression.charAt(i);
            }else if(!isNumber(expression.charAt(i))){
                continue;
            }
            else{
                token+=expression.charAt(i);
            }
        }

    }

}
