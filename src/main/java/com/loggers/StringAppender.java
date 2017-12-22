package com.loggers;

import org.apache.log4j.Layout;
import org.apache.log4j.WriterAppender;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class StringAppender extends WriterAppender {
    private static volatile Writer testWriter;
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
        String log = testWriter.toString();
        try {
            testWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return log;
    }

    public static void resetAppender(){
            testWriter=new StringWriter();
        try {
            testWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
