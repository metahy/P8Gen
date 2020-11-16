package com.tools.gen.pattern;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.Interface;

/**
 * @author hiram 2020年11月16日 23:16
 */
public class InterfaceGenStrategy extends GenStrategy <Interface> {
    private Template template;

    public InterfaceGenStrategy() {
        Engine engine = Engine.create("InterfaceGenEngine");
        engine.setDevMode(true);
        template = engine.getTemplate(new FileSource("resources", "templates/interface.tmpl"));
    }

    @Override
    public String generate(Interface interFace) {
        return template.renderToString(Kv.by("interface", interFace));
    }
}
