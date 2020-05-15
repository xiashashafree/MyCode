

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainFunction {


    public static void main(String[] args) throws IOException {
        String path = "/Users/mahui/Desktop/grammar.txt";
        String grammar = Function.readGrammarFile(path);
        System.out.println("文法如下：");
        List<String> oldList = Function.getGrammar(grammar);
        System.out.println(oldList);
        System.out.println("文法的每一条产生式如下：");
        List<String> oldListItems = Function.getGrammarItems(grammar);
        System.out.println(oldListItems);
        System.out.println("所有非终结符号如下：");
        List<String> vn = Function.getVN(grammar);
        System.out.println(vn);
        System.out.println("文法的终结符号如下：");
        List<String> vt = Function.getVT(oldListItems);
        System.out.println(vt);
        System.out.println("消除左递归后的文法如下：");
        List<String> newList = Function.removeLeftRecursive(oldListItems);
        System.out.println(newList);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < newList.size(); i++) {
            stringBuilder.append(newList.get(i) + "\n");
        }
        System.out.println("消除左递归后的文法的非终结符号如下：");
        vn = Function.getVN(stringBuilder.toString());
        System.out.println(vn);
        System.out.println("消除左递归后的文法的终结符号如下：");
        vt = Function.getVT(newList);
        System.out.println(vt);
        System.out.println("first集合如下：");
        Map<String, List<String>> firstList = Function.getFirst(vn, newList);
        System.out.println(firstList);
        System.out.println("follow集合如下：");
        Map<String, List<String>> followList = Function.getFollow(vn, newList, firstList);
        System.out.println(followList);
        System.out.println("该文法是LL（1）文法吗？" + Function.isLL1(firstList, followList, newList, vn));
        if (Function.isLL1(firstList, followList, newList, vn)) {
            System.out.println("预测分析表如下：");
            Function.print(vn, vt, firstList, followList, newList);
        }
        vt = Function.getVT(newList);
        Function.analyse(vn, vt, vn.get(0));

    }
}
