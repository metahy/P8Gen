package com.tools.gen.pattern;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.Clazz;

/**
 * @author hiram 2020年11月16日 23:10
 */
public class ClazzGenStrategy extends GenStrategy <Clazz> {
    private Template template;

    public ClazzGenStrategy() {
        Engine engine = Engine.create("ClazzGenEngine");
        engine.setDevMode(true);
        template = engine.getTemplate(new FileSource("resources", "templates/class.tmpl"));
    }

    @Override
    public String generate(Clazz clazz) {
        return template.renderToString(Kv.by("clazz", clazz));
    }
}
