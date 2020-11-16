package com.tools.gen.pattern;

/**
 * @author hiram 2020年11月16日 23:19
 */
public class GenContext<T> {

    private GenStrategy<T> genStrategy;

    public GenContext(GenStrategy<T> genStrategy) {
        this.genStrategy = genStrategy;
    }

    public String generate(T t) {
        return genStrategy.generate(t);
    }
}
