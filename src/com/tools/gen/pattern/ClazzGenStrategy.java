package com.tools.gen.pattern;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.Clazz;
import com.tools.gen.utils.FileUtils;

import java.io.*;

/**
 * @author hiram 2020年11月16日 23:10
 */
public class ClazzGenStrategy extends GenStrategy<Clazz> {
    private final Template template;

    public ClazzGenStrategy() {
        Engine engine = Engine.create("ClazzGenEngine");
        engine.setDevMode(true);
        template = engine.getTemplate(new FileSource("resources", "templates/class.tmpl"));
    }

    @Override
    public String generate(Clazz clazz) {
        assert clazz != null;
        File file = new File("./result/" + clazz.getPkg().replaceAll("\\.", "/") + "/" + clazz.getName() + ".java");
        String string = template.renderToString(Kv.by("clazz", clazz));
        FileUtils.write(string.getBytes(), file);
        return string;
    }
}
