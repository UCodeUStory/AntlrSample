package com.ustory.anrltjavaproject.project.arrayInit;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * 作为我们的第一个ANTLR项目，我们会构造一个语法，它是C语言或其继承者Java语法的一个很小的子集。
 * ，像是{1，2，3}和{1，{2，3}，4}这样
 * ，我们可以将short值当作Unicode字符，
 */
public class Translate {

    public static void main(String args[]) {

        System.out.println("-------Main-------");

        try {
            //新建一个CharStream,从标准输入读取数据
            ANTLRInputStream ais = new ANTLRInputStream(System.in);
            //新建一个词法分析器，处理输入的CharStream
            ArrayInitLexer lexer = new ArrayInitLexer(ais);

            //新建一个词法符号的缓冲区，用于存储词法分析器将生成的词法符号
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            //新建一个语法分析器，处理词法符号缓冲区中的内容
            ArrayInitParser parser = new ArrayInitParser(tokens);

            ParseTree tree = parser.init(); //针对init规则，开始语法分析


            System.out.println(tree.toStringTree(parser));//用LISP风格打印生成的树

            /**
             * 这里输入结束时需要按command+D
             */

            // 新建一个通用的、能够触发回调函数的语法分析树遍历器
            ParseTreeWalker walker = new ParseTreeWalker();

            //遍历语法分析过程中的生成的语法分析树，触发回调
            walker.walk(new ShortToUnicodeString(),tree);
            System.out.println("----main---end");
            /**
             * 测试通过用例
             * {1,2,3}
             * {1,{2}}
             * {{2}}
             * {1,2,{3,4}}
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
