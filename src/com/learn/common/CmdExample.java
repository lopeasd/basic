package com.learn.common;

import java.util.logging.Logger;

/**
 *ProcessBuilder
 * Runtime
 */
public class CmdExample {
    public static void main(String[] args) {
        Logger global = Logger.getGlobal();
        try {
            ProcessBuilder proc = new ProcessBuilder("\"D:\\application\\sts-4.0.2.RELEASE\\SpringToolSuite4.exe\"");
            proc.start();
        } catch (Exception e) {
            System.out.println("Error executing notepad.");
        }
    }

}
