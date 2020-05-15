import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Function {
    public static List<String> oneFirstList=new ArrayList<>();
    public static List<String> oneFollowList=new ArrayList<>();
    /**
     * 从指定文件中读取文法
     * @param path（文件的路径）
     * @return
     * @throws IOException 
     */
    public static String readGrammarFile(String path) throws IOException{
        StringBuilder grammar=new StringBuilder();
        File file=new File(path);
        @SuppressWarnings("resource")
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String readline;
        while((readline=bufferedReader.readLine())!=null){
            grammar.append(readline+"\n");
        }
        return grammar.toString();
    }
    /**
     * 获得文法的产生式
     * @param scanner（输入的文法）
     * @return
     */
    public static List<String> getGrammar(String scanner){
        List<String> oldList=new ArrayList<>();
        String[] grammarItems=scanner.split(" |\n");
        for(int i=0;i<grammarItems.length;i++){
            oldList.add(grammarItems[i]);
        }
        return oldList;
    }
    /**
     * 获得每一条产生式
     * @param scanner（输入的文法）
     * @return
     */
    public static List<String> getGrammarItems(String scanner){
        List<String> oldList=new ArrayList<>();
        List<String> oldListItems=new ArrayList<>();
        String[] grammarItems=scanner.split(" |\n");
        for(int i=0;i<grammarItems.length;i++){
            oldList.add(grammarItems[i]);
            String[] items=grammarItems[i].split(">|\\|");
//添加每一条产生式
            for(int k=1;k<items.length;k++)
                oldListItems.add(grammarItems[i].charAt(0)+"-->"+items[k]);
        }
        return oldListItems;
    }
    /**
     * 如果vn包含str，则返回真，不包含返回false
     * @param vn
     * @param （要判断的字符串）
     * @return
     */
    public static boolean isContain(List<String> vn,String str){
        for(int i=0;i<vn.size();i++){
            if(vn.get(i).equals(str)){
                return true;
            }
        }
        return false;
    }
    /**
     * 获得所有非终结符
     * @param （输入的文法）
     * @return
     */
    public static List<String> getVN(String grammarItems){
        List<String> vn=new ArrayList<>();
        String[] string=grammarItems.split("\n");
        for(int i=0;i<string.length;i++){
            int index=string[i].indexOf("-");
            String str=string[i].substring(0, index);
            if(vn.size()==0){
                vn.add(str);
            }else{
                if(!isContain(vn, str)){
                    vn.add(str);
                }
            }
        }
        return vn;
    }
/**
 * 消除文法的左递归
 * @param oldListItems（未消除左递归的每一台产生式的集合）
 * @return
 */
    public static List<String> removeLeftRecursive(List<String> oldListItems){
        List<String> newList=new ArrayList<>();
        for(int i=0;i<oldListItems.size();i++){
            if(oldListItems.get(i).charAt(0)==oldListItems.get(i).charAt(4)){
                for(int j=0;j<oldListItems.size();j++){
                    if(oldListItems.get(j).startsWith(""+oldListItems.get(i).charAt(0))
                            &&oldListItems.get(j).length()==5){
                        newList.add(oldListItems.get(i).charAt(0)+"-->"+oldListItems.get(j).charAt(4)+oldListItems.get(i).charAt(0)+"’");
                        newList.add(oldListItems.get(i).charAt(0)+"’"+"-->"+oldListItems.get(i).substring(5, oldListItems.get(i).length())+oldListItems.get(i).charAt(0)+"’");
//~代表空
                        newList.add(oldListItems.get(i).charAt(0)+"’"+"-->"+"~");
                    }
                }
            }else{
                int tag=0;
                for(int k=0;k<newList.size();k++){
                    if(newList.get(k).contains(oldListItems.get(i).substring(1, oldListItems.get(i).length()))){
                        tag=1;
                        break;
                    }
                }
                if(tag==0){
                    newList.add(oldListItems.get(i));
                }
            }
        }
        return newList;
    }
    /**
     * 获得非终结符号的first集合
     * @param vn（非终结符号的集合）
     * @param newList（ 消除左递归后的文法）
     * @return
     */
    public static Map<String,List<String>> getFirst(List<String> vn,List<String> newList){
        Map<String,List<String>> firstList=new HashMap<>();
        for(int i=0;i<vn.size();i++){
            oneFirstList.clear();
            getOneFirst(vn.get(i),newList);
            List<String> temp=new ArrayList<>();
            for(int k=0;k<oneFirstList.size();k++){
                temp.add(oneFirstList.get(k));
            }
            firstList.put(vn.get(i), temp);

        }

        return firstList;
    }

    /**
     * 得到任意一个非终结符号的first集合
     * @param vnItem（任意一个非终结符号）
     * @param newList（消除左递归后的文法）
     * @return
     */
    public static void getOneFirst(String vnItem,List<String> newList){
        for(int i=0;i<newList.size();i++){
            if(vnItem.length()==1){
                if(newList.get(i).startsWith(vnItem)&&newList.get(i).charAt(1)=='-'){
                    int index=newList.get(i).indexOf('>')+1;
                    if(Character.isUpperCase(newList.get(i).charAt(index))){
                        getOneFirst(""+newList.get(i).charAt(index),newList);
                    }else{
                        if(!isContain(oneFirstList,""+newList.get(i).charAt(index))){
                            oneFirstList.add(""+newList.get(i).charAt(index));
                        }

                    }
                }
            }else{
                if(newList.get(i).startsWith(vnItem)){
                    int index=newList.get(i).indexOf('>')+1;
                    if(Character.isUpperCase(newList.get(i).charAt(index))){
                        getOneFirst(""+newList.get(i).charAt(index),newList);
                    }else{
                        if(!isContain(oneFirstList,""+newList.get(i).charAt(index))){
                            oneFirstList.add(""+newList.get(i).charAt(index));
                        }

                    }
                }
            }

        }
    }
    /**
     * 获得任意一个非终结符号的follow集合
     * @param vnItem（任意的一个非终结符号）
     * @param vn（终结符号的集合）
     * @param newList（消除左递归后的文法）
     * @param firstList（所有非终结符号的first集合）
     * @return
     */
    public static void getOneFollow(String vnItem,List<String> vn,List<String> newList,Map<String,List<String>> firstList){

//求follow集合的第一条
        if(vnItem.equals(vn.get(0))){
            if(!isContain(oneFollowList,"#")){
                oneFollowList.add("#");
            }
        }
//求follow集合的第二条
        for(int i=0;i<newList.size();i++){
            int index1=newList.get(i).indexOf(">")+1;
            String str=newList.get(i).substring(index1);
            if(vnItem.length()==1){
//判断E类型的
                if(str.contains(vnItem)&&str.charAt(str.indexOf(vnItem.charAt(0))+1)!='’'){
                    if(str.indexOf(vnItem.charAt(0))!=str.length()){
                        String temp=str.substring(str.indexOf(vnItem.charAt(0))+1);
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(temp);
                        for(int k=stringBuilder.length();k>1;k--){
                            if(isVN(stringBuilder.toString(),vn)){
                                break;
                            }else{
                                int length=stringBuilder.length();
                                stringBuilder.deleteCharAt(length-1);
                            }
                        }
                        if(stringBuilder.length()>0){
                            if(Character.isUpperCase(stringBuilder.charAt(0))){
                                if(firstList.containsKey(stringBuilder.toString())){
                                    List<String> list=firstList.get(stringBuilder.toString());
                                    for(int q=0;q<list.size();q++){
                                        if(!list.get(q).equals("~")){
                                            if(!isContain(oneFollowList,list.get(q))){
                                                oneFollowList.add(list.get(q));
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(!isContain(oneFollowList,stringBuilder.toString())){
                                    oneFollowList.add(stringBuilder.toString());
                                }
                            }
                        }
                    }
                }
            }else{
//判断E’类型的
                if(str.contains(vnItem)){
                    int index=str.indexOf(vnItem);
                    String left=str.substring(index+vnItem.length(), str.length());
                    StringBuilder stringBuilder=new StringBuilder();
                    stringBuilder.append(left);
                    for(int k=stringBuilder.length();k>1;k--){
                        if(isVN(stringBuilder.toString(),vn)){
                            break;
                        }else{
                            int length=stringBuilder.length();
                            stringBuilder.deleteCharAt(length);
                        }
                    }
                    if(stringBuilder.length()>0){
                        if(Character.isUpperCase(stringBuilder.charAt(0))){
                            if(firstList.containsKey(stringBuilder.toString())){
                                List<String> list=firstList.get(stringBuilder.toString());
                                for(int q=0;q<list.size();q++){
                                    if(!list.get(q).equals("~")){
                                        if(!isContain(oneFollowList,list.get(q))){
                                            oneFollowList.add(list.get(q));
                                        }
                                    }
                                }
                            }
                        }else{
                            if(!isContain(oneFollowList,stringBuilder.toString())){
                                oneFollowList.add(stringBuilder.toString());
                            }
                        }
                    }
                }
            }

        }
//求follow集合的第三条
        for(int i=0;i<newList.size();i++){
            int index1=newList.get(i).indexOf(">")+1;
            String str=newList.get(i).substring(index1);
            if(vnItem.length()==1){
                if(str.contains(vnItem)){
                    if(str.indexOf(vnItem)==str.length()&&str.charAt(str.indexOf(vnItem.charAt(0))+1)!='’'){
                        String s=newList.get(i).substring(0,newList.get(i).indexOf("-"));
                        getOneFollow(s, vn, newList, firstList);
                    }else{
                        String left=str.substring(str.indexOf(vnItem)+1);
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(left);
                        for(int k=stringBuilder.length();k>1;k--){
                            if(isVN(stringBuilder.toString(),vn)){
                                break;
                            }else{
                                int length=stringBuilder.length();
                                stringBuilder.deleteCharAt(length-1);
                            }
                        }
                        if(isVN(stringBuilder.toString(), vn)){
                            if(firstList.containsKey(stringBuilder.toString())){
                                List<String> temp=firstList.get(stringBuilder.toString());
                                if(isContain(temp)){
                                    String s=newList.get(i).substring(0,newList.get(i).indexOf("-"));
                                    getOneFollow(s, vn, newList, firstList);
                                }
                            }
                        }
                    }
                }

            }else{
                if(str.contains(vnItem)){
                    String st=newList.get(i);
                    if(st.endsWith(vnItem)){
                        if(!st.startsWith(vnItem)){
                            String s=newList.get(i).substring(0,newList.get(i).indexOf("-"));
                            getOneFollow(s, vn, newList, firstList);
                        }
                    }else{
                        String left=str.substring(str.indexOf(vnItem)+2);
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(left);
                        for(int k=stringBuilder.length();k>1;k--){
                            if(isVN(stringBuilder.toString(),vn)){
                                break;
                            }else{
                                int length=stringBuilder.length();
                                stringBuilder.deleteCharAt(length-1);
                            }
                        }
                        if(isVN(stringBuilder.toString(), vn)){
                            if(firstList.containsKey(stringBuilder.toString())){
                                List<String> temp=firstList.get(stringBuilder.toString());
                                if(isContain(temp)){
                                    String s=newList.get(i).substring(0,newList.get(i).indexOf("-"));
                                    getOneFollow(s, vn, newList, firstList);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    /**
     * 获得所有非终结符号的follow集合
     * @param vn（非终结符号的集合）
     * @param newList（消除左递归的文法）
     * @param firstList（所有非终结符号的first集合）
     * @return
     */
    public static Map<String,List<String>> getFollow(List<String> vn,List<String> newList,Map<String,List<String>> firstList){
        Map<String,List<String>> followList=new HashMap<>();
        for(int i=0;i<vn.size();i++){
            oneFollowList.clear();
            getOneFollow(vn.get(i),vn,newList,firstList);
            List<String> temp=new ArrayList<>();
            for(int k=0;k<oneFollowList.size();k++){
                temp.add(oneFollowList.get(k));
            }
            followList.put(vn.get(i),temp );
        }
        return followList;
    }
    /**
     * 判断是不是LL（1）文法
     * @param firstList
     * @param followList
     * @return
     */
    public static boolean isLL1(Map<String,List<String>> firstList,Map<String,List<String>> followList,List<String> newList,List<String> vn){
//因为消除了左递归，所以文法判断的第一条默认成立
//判断文法条件的第三条


        for(int i=0;i<vn.size();i++){
            if(firstList.get(vn.get(i)).contains("~")){
                List<String> first=new ArrayList<>();
                first.addAll(firstList.get(vn.get(i)));
                List<String> follow=new ArrayList<>();
                follow.addAll(followList.get(vn.get(i)));
                first.retainAll(follow);
                if(first.size()!=0){
                    return false;
                }
            }
        }
//判断文法的第二条
        for(int i=0;i<vn.size();i++){
            StringBuilder stringBuilder=new StringBuilder();
            for(int j=0;j<newList.size();j++){
                if(newList.get(j).startsWith(vn.get(i)+"-->")){
                    String str=newList.get(j).substring(newList.get(j).indexOf(">")+1);
                    stringBuilder.append(str+" ");
                }
            }
            String[] items=stringBuilder.toString().split(" ");
            if(items.length>1){
                for(int k=0;k<items.length;k++){
                    List<String> first=getItemFirst(items[k], firstList);
                    for(int n=k+1;n<items.length;n++){
                        List<String> second=getItemFirst(items[n], firstList);
                        first.retainAll(second);
                        if(first.size()!=0){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * 判断是不是终结符号，是则返回true，不是则返回false
     * @param ch（要判断的字符串）
     * @return
     */
    public static boolean isVN(String ch,List<String> vn){
        for(int i=0;i<vn.size();i++){
            if(ch.equals(vn.get(i))){
                return true;
            }
        }
        return false;
    }
    /**
     * 判断相应的first集合有没有空串，如果有返回true，反之为false
     * @param list
     * @return
     */
    public static boolean isContain(List<String> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("~")){
                return true;
            }
        }
        return false;
    }
    /**
     * 获得每一个非终结符号的候选首符集
     * @param str
     * @param firstlist
     * @return
     */
    public static List<String> getItemFirst(String str,Map<String,List<String>> firstlist){
        List<String> list=new ArrayList<>();
        if(Character.isUpperCase(str.charAt(0))){
            if(str.length()>1){
                if(str.charAt(1)!='’'){
                    list.addAll(firstlist.get(""+str.charAt(0)));
                }else{
                    list.addAll(firstlist.get(""+str.charAt(0)+str.charAt(1)));
                }
            }
        }else{
            list.add(""+str.charAt(0));
        }
        return list;
    }
    /**
     *  获得终结符号
     * @param newList
     * @return
     */
    public static List<String> getVT(List<String> newList){
        List<String> list=new ArrayList<>();
        for(int i=0;i<newList.size();i++){
            int index1=newList.get(i).indexOf('>')+1;
            String str=newList.get(i).substring(index1);
            for(int k=0;k<str.length();k++){
                if(!Character.isUpperCase(str.charAt(k))){
                    if(str.charAt(k)!='’'&&str.charAt(k)!='~'){
                        if(!isContain(list, ""+str.charAt(k))){
                            list.add(""+str.charAt(k));
                        }
                    }
                }
            }
        }
        return list;
    }
    /**
     * 生成LL（1）预测分析表
     * @param vn
     * @param vt
     * @param firstList
     * @param followList
     * @param newList
     * @throws IOException 
     */
    public static void print(List<String> vn,List<String> vt,Map<String,List<String>> firstList,Map<String,List<String>> followList,List<String> newList) throws IOException{
        removeFile();
        vt.add("#");
        for(int i=0;i<vt.size();i++){
            System.out.printf("\t%s",vt.get(i));
        }
        System.out.println();
        for(int i=0;i<vn.size();i++){
            System.out.printf("%s\t",vn.get(i));
            for(int k=0;k<vt.size();k++){
                String str=findItems(vn, newList, firstList, followList, ""+vt.get(k),""+vn.get(i));
                if(str!=null){
                    System.out.printf(str+"  ");
                    writeToFile(vn.get(i),vt.get(k),str);
                }else{
                    if(!firstList.get(vn.get(i)).contains(""+vt.get(k))&&firstList.get(vn.get(i)).contains("~")){
                        if(followList.get(vn.get(i)).contains(""+vt.get(k))){
                            System.out.printf(vn.get(i)+"-->~"+"  ");
                            writeToFile(vn.get(i),vt.get(k),vn.get(i)+"-->~");
                        }else{
                            System.out.printf(" \t");
                        }
                    }else{
                        System.out.printf(" \t");
                    }

                }
            }
            System.out.println();
        }
    }
    /**
     * 填充预测分析表，找到非终结符号要推出终结符号时所用的产生式
     * @param vn
     * @param newList
     * @param firstList
     * @param followList
     * @param vtItem
     * @param vnItem
     * @return
     */
    public static String findItems(List<String> vn,List<String> newList,Map<String,List<String>> firstList,Map<String,List<String>> followList,String vtItem,String vnItem){
        for(int i=0;i<newList.size();i++){
            if(vnItem.length()==1){
                if(newList.get(i).startsWith(vnItem)&&newList.get(i).charAt(1)!='’'){
                    int index=newList.get(i).indexOf(">")+1;
                    String str=newList.get(i).substring(index);
                    if(Character.isUpperCase(str.charAt(0))){
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(str);
                        for(int k=stringBuilder.length();k>1;k--){
                            if(isVN(stringBuilder.toString(),vn)){
                                break;
                            }else{
                                int length=stringBuilder.length();
                                stringBuilder.deleteCharAt(length-1);
                            }
                        }
                        if(firstList.get(stringBuilder.toString()).contains(vtItem)){
                            return newList.get(i);
                        }else{

                        }

                    }else{
                        if(vtItem.equals(""+str.charAt(0))){
                            return newList.get(i);
                        }else{

                        }
                    }
                }
            }else{
                if(newList.get(i).startsWith(vnItem)){
                    int index=newList.get(i).indexOf(">")+1;
                    String str=newList.get(i).substring(index);
                    if(Character.isUpperCase(str.charAt(0))){
                        StringBuilder stringBuilder=new StringBuilder();
                        stringBuilder.append(str);
                        for(int k=stringBuilder.length();k>1;k--){
                            if(isVN(stringBuilder.toString(),vn)){
                                break;
                            }else{
                                int length=stringBuilder.length();
                                stringBuilder.deleteCharAt(length-1);
                            }
                        }
                        if(firstList.get(stringBuilder.toString()).contains(vtItem)){
                            return newList.get(i);
                        }else{

                        }

                    }else{
                        if(vtItem.equals(""+str.charAt(0))){
                            return newList.get(i);
                        }else{

                        }
                    }
                }
            }
        }
        return null;
    }
    /**
     * 将预测分析表以三元组的形式写入文件
     * @param vn
     * @param vt
     * @param str
     * @throws IOException
     */
    public static void writeToFile(String vn,String vt,String str) throws IOException{
        String path="/Users/mahui/Desktop/table.txt";
        File file=new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write(vn+" "+vt+" "+str+"\n");
        fileWriter.close();

    }
    /**
     * 每次运行之前都删除文件，避免内容重复
     * （因为我向文件写数据是以追加的形式，所以再将预测分析表写入文件时，先清除之前的数据）
     */
    public static void removeFile(){
        String path="/Users/mahui/Desktop/table.txt";
        File file=new File(path);
        if(file.exists()){
            file.delete();
        }
    }
    /**
     * 将存储在文件中的预测分析表存储在List<Map <String,String>>
     * Map中的键是非终结符号＋空格＋终结符号，值是所用到的产生式
     * @return
     */
    public static List<Map <String,String>> readAnalyse(){
        List<Map <String,String>> analyse=new ArrayList<>();
        String path="/Users/mahui/Desktop/table.txt";
        File file=new File(path);
        if(!file.exists()){
            System.out.println("该文件不存在");
            return null;
        }else{
            try {
                @SuppressWarnings("resource")
                BufferedReader reader=new BufferedReader(new FileReader(file));
                String line;
                while((line=reader.readLine())!=null){
                    String str[]=line.split(" ");
                    Map<String,String> map=new HashMap<>();
                    map.put(str[0]+" "+str[1], str[2]);
                    analyse.add(map);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return analyse;
    }
    /**
     * 对待分析串进行预测分析
     * @param
     */
    public static void analyse(List<String> vn,List<String> vt,String startVN){
        List<Map <String,String>> analyse=readAnalyse();
        boolean flag=true;
        System.out.println("请输入待分析的串：");
        @SuppressWarnings("resource")
        Scanner scanner=new Scanner(System.in);
//输入待分析串
        String str=scanner.nextLine();
        List<String> source=new ArrayList<>();
//将＃号置入待分析串中
        for(int i=0;i<str.length();i++){
            source.add(str.charAt(i)+"");
        }
        source.add("#");
//定义符号栈
        List<String> list=new ArrayList<>();
//将＃和文法的开始符号入栈
        list.add("#");
        list.add(startVN);
        String title1="符号栈";
        String title2="输入串";
        String title3="所用产生式";
        String error="";
        String accept="accept";
        System.out.printf("%-20s%-20s%-20s\n", title1,title2,title3);
        String a=source.get(0);
        String item;
        System.out.printf("%-20s%-20s\n",list,source);
        while(flag){
//将stack栈顶的符号拖出去并放在x中
            String x=list.get(list.size()-1);
            list.remove(list.size()-1);
            if(isVT(x,vt)){
                if(x.equals(a)){
                    if(source.size()>1){
                        source.remove(0);
                    }
                    a=source.get(0);
                    System.out.printf("%-20s%-20s%-20s\n",list,source,error);
                }else{
                    System.out.printf("%-20s%-20s%-20s\n",list,source,error);
                }
            }else if(x.equals("#")){
                if(x.equals(a)){
                    flag=false;
                    System.out.printf("%-20s%-20s%-20s\n",list,source,accept);
                }else{
                    System.out.printf("%-20s%-20s%-20s\n",list,source,error);


                }
            }else if((item=findGrammarItem(x,a,analyse))!=null){
                StringBuilder s=new StringBuilder();
                s.append(item);
                StringBuilder string=new StringBuilder();
                int index=s.indexOf(">")+1;
                string.append(s.substring(index));
                if(!string.toString().equals("~")){
                    List<String> divide=divide(string, vn, vt);
                    list.addAll(divide);
                    System.out.printf("%-20s%-20s%-20s\n",list,source,item);
                }else{
                    System.out.printf("%-20s%-20s%-20s\n",list,source,item);
                }

            }else{
                System.out.printf("%-20s%-20s%-20s\n",list,source,error);


            }
        }
        System.out.println("分析完毕");

    }
    /**
     * 判断是不是终结符号，如果是返回true，反之返回false
     * @param str
     * @param newList
     * @return
     */
    public static boolean isVT(String str,List<String> newList){
        if(newList.contains(str)){
            return true;
        }
        return false;
    }
    /**
     * 通过预测分析表找寻对应的产生式
     * @param vn
     * @param vt
     * @param analyse
     * @return
     */
    public static String findGrammarItem(String vn,String vt,List<Map <String,String>> analyse){

        for(int i=0;i<analyse.size();i++){
            if(analyse.get(i).containsKey(vn+" "+vt)){
                return analyse.get(i).get(vn+" "+vt);

            }
        }
        return null;

    }
    /**
     * 将找到的产生式分割成一个一个终结符号和非终结符号
     * @param s
     * @param vn
     * @param vt
     * @return
     */
    public static List<String> divide(StringBuilder s,List<String> vn,List<String> vt){
        List<String> divide=new ArrayList<>();
        int j=s.length();
        for(int i=s.length()-1;i>=0;){
            String str=s.substring(i,j);
            if(isVN(str, vn)||isVT(str,vt)){
                divide.add(str);
                j=i;
            }
            i--;
        }
        return divide;
    }
}




