package calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;
import java.util.List;

public class calculator extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Farm_main screen = new Farm_main();
        Scene scene = new Scene(screen.getScene(),400,370 );
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("简易计算器");
        primaryStage.show();
    }

}
class Farm_main {

    //Create a screen
    static TextArea textArea = new TextArea("0"); //显示输出
    static boolean restart = false;

    public BorderPane getScene() {

        BorderPane pane = new BorderPane(); //整体布局

        BorderPane pane_screen = new BorderPane(); // 显示器布局
        VBox KeyBoard = new VBox();// 键盘布局; 上下两层
        GridPane kb_1 = new GridPane();
        GridPane kb_2 = new GridPane();


        // 显示器布局
        Text title = new Text("Made by Mr. 吴翰琦");
        textArea.setPrefRowCount(1);//显示位置
        textArea.setPrefWidth(300);
        textArea.setFont(Font.font(30));
        textArea.setDisable(false); // Display
        textArea.setEditable(false);// 不可编辑
        pane_screen.setTop(title);
        pane_screen.setCenter(textArea);

        //布局键盘 1
        btn__style_1 btn_Backspace = new btn__style_1("Backspace");
        btn__style_1 btn_CE = new btn__style_1("CE");
        btn__style_1 btn_C = new btn__style_1("C");

        //Button Action
        btn_Backspace.setOnAction(e -> {
            int len = textArea.getText().length();
            if(len > 1) {
                textArea.deleteText(len-1,len);
            } else {
                if (textArea.getText().charAt(0) != '0') {
                    textArea.setText("0");
                }
            }
        });
        btn_C.setOnAction(e -> textArea.setText("0"));

        btn_CE.setOnAction(e -> {
            // find the last sign in expression
            int point= 0;
            char[] match = {'+','-','*','÷','√'};

            for (int i = 0; i < textArea.getText().length(); i++) {
                for (int j = 0; j < match.length; j++){
                    if (textArea.getText().charAt(i) == match[j]) {
                        point = i;
                    }
                }
            }
            if (point == 0) {
                textArea.setText("0");
            } else {
                textArea.setText(textArea.getText().substring(0,point));
            }
        });

        kb_1.setHgap(5);
        kb_1.setVgap(5);
        kb_1.addRow(1,btn_Backspace,btn_CE,btn_C);


        // 布局键盘 2

        btn_style_2 btn_7 = new btn_style_2("7");
        btn_style_2 btn_8 = new btn_style_2("8");
        btn_style_2 btn_9 = new btn_style_2("9");
        btn_style_2 btn_div = new btn_style_2("/");
        btn_style_2 btn_sqrt = new btn_style_2("sqrt");

        btn_style_2 btn_4 = new btn_style_2("4");
        btn_style_2 btn_5 = new btn_style_2("5");
        btn_style_2 btn_6 = new btn_style_2("6");
        btn_style_2 btn_mul = new btn_style_2("*");
        btn_style_2 btn_mod = new btn_style_2("%");

        btn_style_2 btn_1 = new btn_style_2("1");
        btn_style_2 btn_2 = new btn_style_2("2");
        btn_style_2 btn_3 = new btn_style_2("3");
        btn_style_2 btn_sub = new btn_style_2("-");
        btn_style_2 btn_rec = new btn_style_2("1/x");


        btn_style_2 btn_0 = new btn_style_2("0");
        btn_style_2 btn_neg = new btn_style_2("+/-");
        btn_style_2 btn_dot = new btn_style_2(".");
        btn_style_2 btn_add = new btn_style_2("+");
        btn_style_2 btn_equ = new btn_style_2("=");



        // Button Action
        btn_0.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("0");
            } else {
                textArea.appendText("0");
            }
            if (Farm_main.restart) {
                if (Action.isSet(textArea.getText())) {
                    textArea.setText("0");
                }
                Farm_main.restart = false;
            }
        });
        btn_1.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("1");
            } else {
                textArea.appendText("1");
            }
            if (Farm_main.restart) {
                if (Action.isSet(textArea.getText())) {
                    textArea.setText("1");
                }
                Farm_main.restart = false;

            }});
        btn_2.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("2");
            } else {
                textArea.appendText("2");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("2");
                }
                Farm_main.restart = false;

            }});
        btn_3.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("3");
            } else {
                textArea.appendText("3");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("3");
                }
                Farm_main.restart = false;

            }});
        btn_4.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("4");
            } else {
                textArea.appendText("4");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("4");
                }
                Farm_main.restart = false;

            }});
        btn_5.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("5");
            } else {
                textArea.appendText("5");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("5");
                }
                Farm_main.restart = false;

            }});
        btn_6.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("6");
            } else {
                textArea.appendText("6");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("6");
                }
                Farm_main.restart = false;

            }});
        btn_7.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("7");
            } else {
                textArea.appendText("7");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("7");
                }
                Farm_main.restart = false;

            }});
        btn_8.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("8");
            } else {
                textArea.appendText("8");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("8");
                }
                Farm_main.restart = false;

            }});
        btn_9.setOnAction(e -> {
            if(textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                textArea.setText("9");
            } else {
                textArea.appendText("9");
            }
            if (Farm_main.restart) {
                if (!Action.isSet(textArea.getText())) {
                    textArea.setText("9");
                }
                Farm_main.restart = false;

            }});

        btn_dot.setOnAction(e -> {
            if (Action.SignCheck(textArea.getText(),'.')){
                textArea.appendText(".");
            }
        });
        btn_add.setOnAction(e -> {
            if(Action.SignCheck(textArea.getText(),'+')){
                textArea.appendText("+");
            }
        });
        btn_sub.setOnAction(e -> {
            if (Action.SignCheck(textArea.getText(),'-')) {
                if (textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                    textArea.setText("-");
                } else {
                    textArea.appendText("-");
                }
            }
        });
        btn_mul.setOnAction(e -> {
            if(Action.SignCheck(textArea.getText(),'*')) {
                textArea.appendText("*");
            }
        });
        btn_div.setOnAction(e -> {
            if(Action.SignCheck(textArea.getText(),'÷')){
                textArea.appendText("÷");
            }
        });
        btn_sqrt.setOnAction(e -> {
            if (Action.SignCheck(textArea.getText(),'√')) {
                if (textArea.getText().length() == 1 && textArea.getText().charAt(0) == '0') {
                    textArea.setText("√");
                } else {
                    textArea.appendText("√");
                }
            }
        });
        btn_mod.setOnAction( e -> {
            if(Action.SignCheck(textArea.getText(),'%')){
                textArea.appendText("%");
            }
        });

        btn_neg.setOnAction( e -> {
            char[] match = {'+','-','*','÷'};
            //找出最后一个运算符的位置
            int point = -1;
            for(int i = 0; i < textArea.getText().length(); i++) {
                for (int j = 0; j < match.length; j++){
                    if (textArea.getText().charAt(i) == match[j]) {
                        point = i;
                    }
                }
            }
            if (point == -1){
                textArea.setText("-"+textArea.getText());
            } else if (textArea.getText().charAt(point) =='-') {
                StringBuffer str =new StringBuffer(textArea.getText());
                str.replace(point,point+1,"+");
                textArea.setText(str.toString());
            }
            else if (textArea.getText().charAt(point) =='+') {
                StringBuffer str = new StringBuffer(textArea.getText());
                str.replace(point, point + 1, "-");
                textArea.setText(str.toString());
            } else {
                StringBuffer str = new StringBuffer(textArea.getText());
                str.insert(point+1,'-');
                textArea.setText(str.toString());
            }
            System.out.println(textArea.getText());
        });

        btn_rec.setOnAction(e ->{
            try {
                textArea.setText(String.valueOf(1/Double.parseDouble(Action.getAns(textArea.getText()))));
                Farm_main.restart = true;
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        });

        btn_equ.setOnAction(e -> {
            try {
                textArea.setText(String.valueOf(Action.getAns(textArea.getText())));
                Farm_main.restart = true;
            } catch (ScriptException scriptException) {
                scriptException.printStackTrace();
            }
        });


        // Display
        kb_2.setHgap(5);
        kb_2.setVgap(5);
        kb_2.addRow(1, btn_7, btn_8, btn_9,btn_div,btn_sqrt);
        kb_2.addRow(2, btn_4, btn_5, btn_6, btn_mul, btn_mod);
        kb_2.addRow(3, btn_1, btn_2, btn_3, btn_sub, btn_rec);
        kb_2.addRow(4, btn_0, btn_neg, btn_dot, btn_add, btn_equ);


        KeyBoard.getChildren().add(kb_1);
        KeyBoard.getChildren().add(kb_2);

        pane.setPadding(new Insets(10,10,10,10));
        pane.setTop(pane_screen);
        pane.setCenter(KeyBoard);

        return pane;
    }

    class btn__style_1 extends Button { //按钮样式1
        btn__style_1() {
            super();
            super.setFont(Font.font(15));
            super.setPrefSize(120,45);
        }
        btn__style_1(String text) {
            super(text);
            super.setFont(Font.font(15));
            super.setPrefSize(120,45);
        }
    }
    class btn_style_2 extends  Button { //按钮样式2
        btn_style_2() {
            super();
            super.setFont(Font.font(15));
            super.setPrefSize(80,45);
        }
        btn_style_2(String text) {
            super(text);
            super.setFont(Font.font(15));
            super.setPrefSize(80,45);
        }
    }
}

class Action {
    // 纯数字正则表达式
    private static String DIGIT_REGEX = "[0-9]+";
    // 字符集合
    private static List<String> SIGN = Arrays.asList("+", "-", "*","÷","%","√",".");
    //符号输入合法性检查
    static boolean SignCheck(String text,char add_sign){
        //额外判断, 如果text为零那么不能添加除 根号 负号以外的符号
        if (text.length() == 1 && text.charAt(0) == '0') {
            if (add_sign == '-' || add_sign == '√') {
                return true;
            }
            return false;
        }
        // 额外判断, 根号等价于数字
        if (add_sign == '√') {
            return true;
        }
        for (String s : SIGN) {
            if (text.endsWith(s)) {
                return false;
            }
        }
        return true;
    }
    //计算结果
    static String getAns(String text) throws ScriptException {
        //先检查表达式合法性,  最后一个不能为除%外的符号
        for (String s : SIGN) {
            if(text.endsWith("%")) {
                break;
            }
                if (text.endsWith(s)) {
                return "Error";
            }
        }
        text = text.replace('÷','/');
        text = text.replace("%","/100");
        text = text.replace("√","Math.sqrt(");
        // 根号处理

        String q = text.replace("(","");
        int max_count = q.length()-text.length();
        /*
        添加原则: 对于某一个未匹配的括号 总是寻找之后第一个非数字字符之前
         */
        int point = 0;
        int match = 0;
        int count = 0;
        for (;point < text.length(); point++) {
            if (text.charAt(point) == '(') {
                for (match = point+1; match < text.length(); match++) {
                    if ( (text.charAt(match) >= '0' && text.charAt(match) <= '9') || text.charAt(match) == ')'){
                        continue;
                    }
                    count ++;
                    StringBuffer str =new StringBuffer(text);
                    str.insert(match-1,')');
                    text = str.toString();
                }
            }
        }
        if (count != max_count) {
            text = text + ')';
        }
        /*
         额外处理: 支持 9\sqrt(9)的形式
         实现方法: M前如果不是括号, 就添加*
         */
        for (point = 1; point < text.length(); point ++) {
            if(text.charAt(point) == 'M' && text.charAt(point-1) >= '0' && text.charAt(point-1) <= '9' ) {
                StringBuffer str =new StringBuffer(text);
                str.insert(point,'*');
                text = str.toString();
            }
        }
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");

        String result = String.valueOf(scriptEngine.eval(text));
        return String.valueOf(result);
    }
    //判断是否含有运算符
    static boolean isSet(String text) {
        if (text.charAt(0) == '-') {
            text = text.substring(1);
        }
        return text.matches(DIGIT_REGEX);
    }
}

