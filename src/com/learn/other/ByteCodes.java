package com.learn.other;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ByteCodes {


        private final static int DEFAULT_ROW_SIZE = 16;

        private List<Byte> byteList = new ArrayList<>();

        private InputStream input;

        private int rowCount;

        private ByteCodes(){  }

        private ByteCodes(InputStream input) throws IOException {
            this(input, DEFAULT_ROW_SIZE);
        }

        private ByteCodes(InputStream input, int rowCount) throws IOException {
            this.rowCount = rowCount;
            this.input = input;
            read();
        }

        private void read() throws IOException {
            int b = -1;
            while ((b = input.read()) != -1) {
                byteList.add((byte)b);
            }
        }

        public static ByteCodes readFrom(String filename) throws IOException {
            return readFrom(filename, DEFAULT_ROW_SIZE);
        }

        public static ByteCodes readFrom(InputStream input) throws IOException {
            return new ByteCodes(input);
        }

        public static ByteCodes readFrom(String filename, int rowCount) throws IOException {
            InputStream input = new FileInputStream(filename);
            return new ByteCodes(input, rowCount);
        }

        public static ByteCodes readFrom(InputStream input, int rowCount) throws IOException {
            return new ByteCodes(input, rowCount);
        }

        public ByteCodes show() throws UnsupportedEncodingException {
            StringBuilder sb = new StringBuilder();
            sb.append("Address   ");
            for(int i = 0 ; i < rowCount ; i ++){
                sb.append(String.format("%02X ", i));
            }
            sb.append(String.format("  |   Dump   %n"));

            int b = -1, rowIndex = 0;
            byte[] rowBytes = new byte[rowCount];
            for(int i = 0 ; i < byteList.size() ; i++){
                if(i % rowCount == 0){
                    sb.append( (i==0?"":"  |") + new String(rowBytes, 0, rowIndex) + (i==0?"":"|"));
                    sb.append(String.format( (i==0?"":"%n") + "%08X: ", i));
                    rowIndex = 0;
                }
                sb.append( String.format("%02X ", byteList.get(i)));

                byte curByte = byteList.get(i);

                if(curByte == '\n' || curByte == '\r' || curByte == '\t'){
                    rowBytes[rowIndex++] = '.';
                } else {
                    rowBytes[rowIndex++] = byteList.get(i);
                }
            }
            System.out.println(sb);
            return this;
        }


}
