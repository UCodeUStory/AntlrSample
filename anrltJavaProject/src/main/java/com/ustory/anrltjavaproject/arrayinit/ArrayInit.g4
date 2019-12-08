grammar ArrayInit;
//
init    : '{' value (',' value)*'}';//必须匹配至少一个value ，（）*代表重复的内容，可以有更多个,value的结构

value   :init
	|INT;

INT	:	[0-9]+;
WS	:	[\t\r\n]+ ->skip;



