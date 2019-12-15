grammar ArrayInit;
//语法文件 用grammar定义 并且后面的名字要和文件名字一直
/**
* 通过header 指定package 生成的java文件都会带有包名，而我们运行解析器
 @header {
 package antlrtest;
 }
*
*/
init    : '{' value (',' value)*'}';//必须匹配至少一个value ，（）*代表重复的内容，可以有更多个,value的结构

value   :init
	|INT;

INT	:	[0-9]+;  //定义词法符号Int
WS	:	[\t\r\n]+ ->skip; //跳开空白符号


/**

通过antlr4 ArrayInit.g4（语法文件）生成词法语法解析器

通过javac *.java 编译所有当前目录java文件

生成文件作用

ArrayInitLexer.java 这是词法分析器的定义，他是由ANLTR分析词法规则生成的，词法分析器的作用就是将输入的字符分解
成词汇符号（也就是Token）

ArrayInitParser.java 这语法分析器，这个语法分析器专门用来识别我们的"数组语言，也就是我们开头定义的结构"，
在该类中，每个规则都有对应的方法，除此之外，还有些其他的辅助代码

ArrayInit.tokens  我们定义的词法符号对应一个数字类型，这种对应关系就存储在这文件中

ArrayInitListener.java
ArrayInitBaseListener.java 默认情况下，生成的语法分析器能将输入文本转换为一棵语法分析树。在遍历语法分析树时，遍历器
能够触发一系列事件（"回调"），并通知我们提供的监听对象。
ArrayListener接口给出了这些回调方法定义，我们可以实现他来完成自定义的功能，ArrayInitBaseListener是该接口的默认实现
为其中的每个方法提供一个空实现。ArrayInitBaseListener类使得我们只需要覆盖那些我们感兴趣的回调方法（通过-visitor命令行参数
可以生成语法分析树的访问器）

demo 将short数组转成String字符串对象



******注意******
ANTLR语法比正则表达式功能更强大，比如{}嵌套{}接口正则表达式识别不出来，因为他没有存储的概念，无法记住之前匹配的输入

通过grun ArrayInit init -tokens 测试生成的语法分析器，回车输入

{99,1,2} 回车 UNIX系统输入ctrl +D（目的手动输入一个EOF）来结束输入并打印

如果想看语法分析器的识别过程可以使用-tree来查看

通过grun ArrayInit init -tree 会打印LISP风格语法树

通过grun ArrayInit init -gui 可以进行可视化观看

**/
