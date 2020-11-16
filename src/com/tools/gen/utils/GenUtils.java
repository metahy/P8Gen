package com.tools.gen.utils;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.Clazz;

public class GenUtils {
    private static final Engine engine = Engine.create("GenEngine");
    private static final Template template;
    static {
        engine.setDevMode(true);
        template = engine.getTemplate(new FileSource("resources", "templates/class.tmpl"));
    }

    public static String generate(Clazz clazz) {
        return template.renderToString(Kv.by("clazz", clazz));
    }
}
