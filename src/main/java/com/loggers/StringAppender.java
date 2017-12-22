package com.loggers;

import org.apache.log4j.Layout;
import org.apache.log4j.WriterAppender;
import java.io.StringWriter;

public class StringAppender extends WriterAppender {
    private static volatile StringWriter testWriter;
    private Layout layout;

    public StringAppender() {
        testWriter = new StringWriter();
    }

    public StringAppender(Layout layout) {
        testWriter = new StringWriter();
        setLayout(layout);
        activateOptions();
    }


    public void activateOptions() {
        setWriter(testWriter);
        super.activateOptions();
    }

    public static String getLoggedMessages() {
        return testWriter.toString();
    }

    public static void resetAppender() {
        testWriter.getBuffer().setLength(0);


    }


}
