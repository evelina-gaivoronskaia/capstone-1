package com.techelevator;

import java.io.*;

public class Logger implements Closeable {

    private File logFile; // will hold the logfile file object
    private PrintWriter writer;  // writer is an instantiation of the PrintWriter class

    public Logger(String pathName){
        // need to initialize our attributes
        this.logFile = new File(pathName);
        // business logic -- if logFile doesn't exist, open it to write
        if (!logFile.exists()){
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // if it does, open it to append  -- need a FileWriter object passed into PrintWriter
        else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String logMessage){
        this.writer.println(logMessage);
        this.writer.flush(); // send the bytes to the file right away!
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
    }
}
