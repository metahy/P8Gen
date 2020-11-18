package com.tools.gen.pattern;

import com.jfinal.kit.Kv;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import com.jfinal.template.source.FileSource;
import com.tools.gen.entity.Interface;
import com.tools.gen.utils.FileUtils;

import java.io.File;

/**
 * @author hiram 2020年11月16日 23:16
 */
public class InterfaceGenStrategy extends GenStrategy <Interface> {
    private final Template template;

    public InterfaceGenStrategy() {
        Engine engine = Engine.create("InterfaceGenEngine");
        engine.setDevMode(true);
        template = engine.getTemplate(new FileSource("resources", "templates/interface.tmpl"));
    }

    @Override
    public String generate(Interface interFace) {
        assert interFace != null;
        File file = new File("./result/" + interFace.getPkg().replaceAll("\\.", "/") + "/" + interFace.getName() + ".java");
        String string = template.renderToString(Kv.by("interface", interFace));
        FileUtils.write(string.getBytes(), file);
        return string;
    }
}
