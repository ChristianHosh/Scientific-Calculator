package calculator.project2ds;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;


public class Project2 extends Application {

    final static Button btn_sin = new Button("SIN");
    final static Button btn_cos = new Button("COS");
    final static Button btn_tan = new Button("TAN");
    final static Button btn_leftPar = new Button("(");
    final static Button btn_rightPar = new Button(")");
    final static Button btn_factorial = new Button("!");
    final static Button btn_off = new Button("OFF");

    final static Button btn_pi = new Button("π");
    final static Button btn_yToPowerOfN = new Button("Xⁿ");
    final static Button btn_squared = new Button("X²");
    final static Button btn_root = new Button("√X");
    final static Button btn_eToPowerOfN = new Button("eⁿ");
    final static Button btn_LN = new Button("LN");
    final static Button btn_log = new Button("LOG");
    final static Button btn_1overX = new Button("1/X");

    final static Button btn_num0 = new Button("0");
    final static Button btn_num1 = new Button("1");
    final static Button btn_num2 = new Button("2");
    final static Button btn_num3 = new Button("3");
    final static Button btn_num4 = new Button("4");
    final static Button btn_num5 = new Button("5");
    final static Button btn_num6 = new Button("6");
    final static Button btn_num7 = new Button("7");
    final static Button btn_num8 = new Button("8");
    final static Button btn_num9 = new Button("9");

    final static Button btn_decimal = new Button(".");
    final static Button btn_mod = new Button("%");
    final static Button btn_sub = new Button("-");
    final static Button btn_sum = new Button("+");
    final static Button btn_mult = new Button("*");
    final static Button btn_dev = new Button("/");

    final static Button btn_clear = new Button("C");
    final static Button btn_clearAll = new Button("CA");
    final static Button btn_backspace = new Button("←");
    final static Button btn_negative = new Button("(-)");
    final static Button btn_equals = new Button("=");

    final static TextField textfield_expression = new TextField();
    final static TextField textfield_postfix = new TextField();
    final static TextField textfield_result = new TextField();

    final static Color color_first = Color.web("#EDE6E3");

    final static String color_firstString = "#EDE6E3";
    final static String color_secondString = "#DADAD9";
    final static String color_thirdString = "F06449";
    final static String color_fourthString = "#5BC3EB";
    final static String color_fifthString = "#073B3A";
    final static String color_sixthString = "#53131E";

    final static HBox row1 = new HBox();
    final static HBox row2 = new HBox();
    final static HBox row3 = new HBox();
    final static HBox row4 = new HBox();
    final static HBox row5 = new HBox();

    final static double PI = Math.PI;
    final static double E = Math.E;

    final static CursorStack cursorStack = new CursorStack(500);
    @Override
    public void start(Stage stage) {
        AnchorPane root = new AnchorPane();
        VBox innerRoot = new VBox();
        root.getChildren().add(innerRoot);
        anchorNode(innerRoot);
        innerRoot.setStyle("-fx-background-color: " + color_firstString);
        innerRoot.setAlignment(Pos.CENTER);
        innerRoot.setSpacing(5);
        innerRoot.getChildren().addAll(textfield_expression,textfield_postfix,textfield_result,row1,row2,row3,row4,row5,btn_equals);
        innerRoot.setFillWidth(true);

        setUpAllButtonsDesign();
        setUpButtonsActions();
        for (HBox hbox: Arrays.asList(row1,row2,row3,row4,row5)) {
            hbox.setSpacing(2.5);
            hbox.setAlignment(Pos.BASELINE_LEFT);
            hbox.setStyle("-fx-background-color: " + color_firstString);
        }
        for (TextField textField: Arrays.asList(textfield_expression,textfield_postfix,textfield_result)){
            textField.setEditable(true);
            textField.setFont(Font.font(22));
        }



        Scene scene = new Scene(root, 380, 480);
        stage.setTitle("Project 2: COMP242: Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private String calculatePostfix(String expression) {
        System.out.println("New Calculation:");
        String result;
        String[] postfix = expression.split(" ");
        int stack = cursorStack.createStack();
        try {
            for (String current : postfix) {
                double op2, op1, res;
                switch (current) {
                    case "+":
                        op2 = (double) cursorStack.pop(stack);
                        op1 = (double) cursorStack.pop(stack);
                        res = op1 + op2;
                        System.out.println(op1 + " + " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "-":
                        op2 = (double) cursorStack.pop(stack);
                        op1 = (double) cursorStack.pop(stack);
                        res = op1 - op2;
                        System.out.println(op1 + " - " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "*":
                        op2 = (double) cursorStack.pop(stack);
                        op1 = (double) cursorStack.pop(stack);
                        res = op1 * op2;
                        System.out.println(op1 + " * " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "/":
                        op2 = (double) cursorStack.pop(stack);
                        op1 = (double) cursorStack.pop(stack);
                        res = op1 / op2;
                        System.out.println(op1 + " / " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "%":
                        op2 = (double) cursorStack.pop(stack);
                        op1 = (double) cursorStack.pop(stack);
                        res = op1 % op2;
                        System.out.println(op1 + " % " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "^":
                        op2 = (double) cursorStack.pop(stack);
                        op1 = (double) cursorStack.pop(stack);
                        res = Math.pow(op1, op2);
                        System.out.println(op1 + " ^ " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "cos":
                        op2 = (double) cursorStack.pop(stack);
                        res = Math.cos(Math.toRadians(op2));
                        System.out.println("Cos " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "sin":
                        op2 = (double) cursorStack.pop(stack);
                        res = Math.sin(Math.toRadians(op2));
                        System.out.println("sin " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "tan":
                        op2 = (double) cursorStack.pop(stack);
                        res = Math.tan(Math.toRadians(op2));
                        System.out.println("tan " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "√":
                        op2 = (double) cursorStack.pop(stack);
                        res = Math.sqrt(op2);
                        System.out.println("√ " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "ln":
                        op2 = (double) cursorStack.pop(stack);
                        res = Math.log(op2);
                        System.out.println("ln " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "log":
                        op2 = (double) cursorStack.pop(stack);
                        res = Math.log10(op2);
                        System.out.println("log " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "!":
                        op2 = (double) cursorStack.pop(stack);
                        res = factorial(op2);
                        System.out.println("factorial " + op2 + " = " + res);
                        cursorStack.push(stack, res);
                        break;
                    case "e":
                        cursorStack.push(stack, E);
                        break;
                    case "π":
                        cursorStack.push(stack, PI);
                        break;
                    default:
                        try {
                            double casted = Double.parseDouble(current);
                            System.out.println("Pushed " + casted + " Into Stack");
                            cursorStack.push(stack, casted);
                        } catch (Exception ignored) {
                        }
                        break;
                }
            }
        }catch (Exception e){
            return "Expression is Wrong!";
        }
        if (cursorStack.isEmpty(stack))
            return "Expression is Wrong!";
        try {
            result = String.valueOf(cursorStack.pop(stack));
            return result;
        }catch (Exception e){
            return "Expression is Wrong!";
        }
    }

    private double factorial(double n) {
        if (n <= 0)
            return 1;
        else
            return(n * factorial(n-1));
    }

    private String toPostfix(String expression) {
        int stack = cursorStack.createStack();
        StringBuilder postfixExpression = new StringBuilder();
        String[] infix = expression.split(" ");
        for (String currentSplit : infix) {
            if (isDigitOrLetter(currentSplit)) {
                postfixExpression.append(" ").append(currentSplit);

            } else if (currentSplit.contains("(")) {
                cursorStack.push(stack, currentSplit);

            } else if (currentSplit.contains(")")) {
                String top = (String) cursorStack.peek(stack);
                while (!cursorStack.isEmpty(stack) && !top.contains("(")) {
                    postfixExpression.append(" ").append(cursorStack.pop(stack));
                    top = (String) cursorStack.peek(stack);
                }
                cursorStack.pop(stack);
            } else if (isOperator(currentSplit)) {
                if (cursorStack.isEmpty(stack)) {
                    cursorStack.push(stack, currentSplit);
                } else {
                    if (precedence(currentSplit) > precedence(cursorStack.peek(stack))) {
                        cursorStack.push(stack, currentSplit);
                    } else if (precedence(currentSplit) == precedence(cursorStack.peek(stack)) &&
                            currentSplit.equals("^")) {
                        cursorStack.push(stack, currentSplit);
                    } else {
                        while (!cursorStack.isEmpty(stack) &&
                                precedence(currentSplit) <= precedence(cursorStack.peek(stack))) {
                            postfixExpression.append(" ").append(cursorStack.pop(stack));
                        }
                        cursorStack.push(stack, currentSplit);
                    }
                }
            }
        }
        while (!cursorStack.isEmpty(stack)){
            postfixExpression.append(" ").append(cursorStack.pop(stack));
        }
        if (postfixExpression.toString().contains(")") || postfixExpression.toString().contains("(")) return "Wrong postfix Expression!";
        return postfixExpression.toString();
    }

    private static boolean isOperator(String s) {
        return switch (s) {
            case "+", "-", "*", "/", "%", "^", "cos", "sin", "tan", "√", "ln", "log", "!" -> true;
            default -> false;
        };
    }

    public int precedence(Object s) {
        try{
            String ch = (String) s;
            switch (ch)
            {
                case "+":
                case "-":
                    return 1;

                case "*":
                case "/":
                case "%":
                    return 2;

                case "^":
                case "√":
                case "!":
                    return 3;

                case "cos":
                case "sin":
                case "tan":
                case "ln":
                case "log":
                    return 4;
            }
        }catch (Exception ignored){}
        return -1;
    }

    private static boolean isDigitOrLetter(String s){
        if (s.equals("π") || s.equals("e"))
            return true;
        try {
            double digit = Double.parseDouble(s);
            return true;
        } catch    (NumberFormatException e) {
            return false;
        }
    }

    private void setUpAllButtonsDesign() {
        for (Button btn: Arrays.asList(btn_sin,btn_cos,btn_tan,btn_factorial)){
            btn.setStyle("-fx-background-color: " + color_thirdString);
            btn.setPrefSize(50,25);
        }
        for (Button btn: Arrays.asList(btn_leftPar,btn_rightPar)){
            btn.setStyle("-fx-background-color: " + color_secondString);
            btn.setPrefSize(50,25);
        }
        btn_off.setStyle("-fx-background-color: " + color_sixthString);
        btn_off.setTextFill(color_first);
        btn_off.setPrefSize(50,25);

        for (Button btn: Arrays.asList(btn_pi,btn_yToPowerOfN,btn_squared,btn_root,btn_eToPowerOfN,btn_LN,btn_log,btn_1overX,btn_equals)){
            btn.setStyle("-fx-background-color: " + color_thirdString);
            btn.setPrefSize(50,50);
        }
        btn_equals.setPrefWidth(380);

        for (Button btn: Arrays.asList(btn_num0,btn_num1,btn_num2,btn_num3,btn_num4,btn_num5,btn_num6,btn_num7,btn_num8,btn_num9)){
            btn.setStyle("-fx-background-color: " + color_fourthString);
            btn.setPrefSize(50,50);
        }
        for (Button btn: Arrays.asList(btn_decimal,btn_negative)){
            btn.setStyle("-fx-background-color: " + color_secondString);
            btn.setPrefSize(50,50);
        }
        for (Button btn: Arrays.asList(btn_mod,btn_dev,btn_mult,btn_sub,btn_sum)){
            btn.setStyle("-fx-background-color: " + color_fifthString);
            btn.setTextFill(color_first);
            btn.setPrefSize(50,50);
        }
        for (Button btn: Arrays.asList(btn_clear,btn_clearAll,btn_backspace)){
            btn.setStyle("-fx-background-color: " + color_sixthString);
            btn.setTextFill(color_first);
            btn.setPrefSize(50,50);
        }

        for (Button btn: Arrays.asList(btn_sin,btn_cos,btn_tan,btn_leftPar,btn_rightPar,btn_factorial,btn_off,
                btn_pi,btn_yToPowerOfN,btn_num7,btn_num8,btn_num9,btn_dev,btn_negative,
                btn_squared,btn_root,btn_num4,btn_num5,btn_num6,btn_mult,btn_clearAll,
                btn_eToPowerOfN,btn_LN,btn_num1,btn_num2,btn_num3,btn_sub,btn_clear,
                btn_log,btn_1overX,btn_num0,btn_decimal,btn_mod,btn_sum,btn_backspace,btn_equals)){
            btn.setStyle(btn.getStyle() + "; -fx-cursor: hand;");
        }

        row1.getChildren().addAll(btn_sin,btn_cos,btn_tan,btn_leftPar,btn_rightPar,btn_factorial,btn_off);
        row2.getChildren().addAll(btn_pi,btn_yToPowerOfN,btn_num7,btn_num8,btn_num9,btn_dev,btn_negative);
        row3.getChildren().addAll(btn_squared,btn_root,btn_num4,btn_num5,btn_num6,btn_mult,btn_clearAll);
        row4.getChildren().addAll(btn_eToPowerOfN,btn_LN,btn_num1,btn_num2,btn_num3,btn_sub,btn_clear);
        row5.getChildren().addAll(btn_log,btn_1overX,btn_num0,btn_decimal,btn_mod,btn_sum,btn_backspace);


    }

    private void setUpButtonsActions(){

        btn_off.setOnAction(e -> System.exit(0));

        btn_clear.setOnAction(e -> textfield_expression.setText(""));

        btn_clearAll.setOnAction(e -> {
            textfield_expression.setText("");
            textfield_result.setText("");
            textfield_postfix.setText("");
        });

        btn_backspace.setOnAction(e -> textfield_expression.setText(textfield_expression.getText().substring(0,textfield_expression.getText().length()-1)));

        for (Button numberBtn : Arrays.asList(btn_num0,btn_num1,btn_num2,btn_num3,btn_num4,btn_num5,btn_num6,btn_num7,btn_num8,btn_num9)){
            numberBtn.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + numberBtn.getText()));
        }

        btn_decimal.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + "."));

        for (Button operatorBtn : Arrays.asList(btn_mod,btn_dev,btn_mult,btn_sub,btn_sum)){
            operatorBtn.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " " + operatorBtn.getText() + " "));
        }

        for (Button triBtn : Arrays.asList(btn_sin,btn_cos,btn_tan)){
            triBtn.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " " + triBtn.getText().toLowerCase() + " "));
        }

        for (Button parBtn : Arrays.asList(btn_leftPar,btn_rightPar)){
            parBtn.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " " + parBtn.getText() + " "));
        }

        btn_1overX.setOnAction(e -> textfield_expression.setText("1 / ( " + textfield_expression.getText() + " )"));

        btn_negative.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " -"));

        btn_eToPowerOfN.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " e ^ "));

        btn_pi.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " " + btn_pi.getText() + " "));

        btn_squared.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " ^ 2"));

        btn_yToPowerOfN.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " ^ "));

        btn_root.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " √ "));

        btn_LN.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " ln "));

        btn_log.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " log "));

        btn_factorial.setOnAction(e -> textfield_expression.setText(textfield_expression.getText() + " ! "));

        btn_equals.setOnAction(calculateButton);

    }

    EventHandler<ActionEvent> calculateButton = actionEvent -> {
        String postfix = toPostfix(textfield_expression.getText());
        textfield_postfix.setText(postfix);
        String result = calculatePostfix(postfix);
        textfield_result.setText(result);
    };

    private void anchorNode(Node node){
        AnchorPane.setLeftAnchor(node, (double) 5);
        AnchorPane.setRightAnchor(node, (double) 5);
        AnchorPane.setTopAnchor(node, (double) 5);
        AnchorPane.setBottomAnchor(node, (double) 5);
    }

    public static void main (String[]args){
        launch();
        }
    }