package com.loggers;

import org.apache.log4j.Layout;
import org.apache.log4j.WriterAppender;
import java.io.StringWriter;

/**
 * Implementation of WriterAppender to work with STRING and Buffer
 *
 */
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

    /**
     * Setting string writer as default writer
     */
    public void activateOptions() {
        setWriter(testWriter);
        super.activateOptions();
    }

    /**
     *
     * @return string of messages in buffer
     */
    public static String getLoggedMessages() {
        return testWriter.toString();
    }

    /**
     * Clears log buffer
     */
    public static void resetAppender() {
        testWriter.getBuffer().setLength(0);
    }
}
