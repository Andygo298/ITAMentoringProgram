package week.fourth.task2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CodecInputStream extends FilterInputStream {

    protected CodecInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        byte c = (byte) super.read();
        byte newC = (byte)(c - 64);
        if (newC < 0){
            newC = (byte)(128 + newC);
        }
        return c == -1 ? c : newC;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte)(b[i] - 64);
            if (b[i] < 0){
                b[i] = (byte)(128 + b[i]);
            }
        }
        return super.read(b, off, len);
    }
}