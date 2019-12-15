package com.ustory.anrltjavaproject.project.arrayInit;


/**
 * Convert short array inits like {1,2,3} to "\u0001\u0002\u0003"
 * 一个翻译小例子
 */
public class ShortToUnicodeString extends ArrayInitBaseListener {
    /**
     * Translate { to "
     */
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {


        System.out.println('"');
    }

    /**
     * Translate } to "
     */
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.println('"');
    }

    /**
     * Translate integers to 4-digit hexadecimal strings prefixed with \\u
     */
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        // Assumes no nested array initializers

        if (null == ctx.INT()) {
            return;
        }
        System.out.println("value=" + ctx.INT());
//        int value = Integer.valueOf(ctx.INT().getText());
//        System.out.printf("\\u%04x", value);
    }
}
