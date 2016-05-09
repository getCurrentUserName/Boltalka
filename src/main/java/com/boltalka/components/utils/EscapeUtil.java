package com.boltalka.components.utils;

import org.springframework.stereotype.Component;

/**
 * Created by LucidMinds on 09.05.16.
 * package com.boltalka.components.utils;
 */
@Component
public class EscapeUtil {

    public String escape(String text) {
        text = text.replaceAll("\r\n", "<br/>");
        text = text.replaceAll("\n", "<br/>");
        text = text.replaceAll("\\r?\\n", "<br />");
        text = text.replace("  ", " &emsp;");
        return text;
    }
}
