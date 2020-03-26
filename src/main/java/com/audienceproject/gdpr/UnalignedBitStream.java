package com.audienceproject.gdpr;

import io.kaitai.struct.ByteBufferKaitaiStream;

class UnalignedBitStream extends ByteBufferKaitaiStream {

    UnalignedBitStream(byte[] byteArray) {
        super(byteArray);
    }

    @Override
    public void alignToByte() {
        // Do nothing.
    }

    public void reset() {
        super.alignToByte();
        super.seek(0);
    }
}
