package com.example.tiktaktoe;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static final Logger logger = Logger.getLogger("MyLog");
    static String ruta = System.getProperty("user.dir") + "/log/logger.log";
    static File file = new File(ruta);
    static FileHandler fh;
    static SimpleFormatter formatter = new SimpleFormatter();

    public static void log(String log) throws IOException {
        if(fh == null){
            fh = new FileHandler(ruta,true);
            logger.addHandler(fh);
        }
        fh.setFormatter(formatter);
        logger.info(log);

    }
}
