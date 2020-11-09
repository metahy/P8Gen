package com.tools.gen.utils;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.Clazz;

public class GenUtils {

    public static String generate(Clazz clazz) {
        Engine engine = Engine.create("GenEngine");
        engine.setDevMode(true);
        Template template = engine.getTemplate(new FileSource("resources", "class.tmpl"));
        return template.renderToString(Kv.by("clazz", clazz));
    }
}
