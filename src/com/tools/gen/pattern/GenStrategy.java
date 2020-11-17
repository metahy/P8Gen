package com.tools.gen.pattern;

/**
 * @author hiram 2020年11月16日 23:05
 */
public abstract class GenStrategy <T> {
    public abstract String generate(T t);
}
