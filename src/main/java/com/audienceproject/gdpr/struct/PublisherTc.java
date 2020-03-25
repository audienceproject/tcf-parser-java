// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.audienceproject.gdpr.struct;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PublisherTc extends KaitaiStruct {
    public static PublisherTc fromFile(String fileName) throws IOException {
        return new PublisherTc(new ByteBufferKaitaiStream(fileName));
    }

    public enum SegmentType {
        CORE(0),
        DISCLOSED_VENDORS(1),
        ALLOWED_VENDORS(2),
        PUBLISHER_TC(3);

        private final long id;
        SegmentType(long id) { this.id = id; }
        public long id() { return id; }
        private static final Map<Long, SegmentType> byId = new HashMap<Long, SegmentType>(4);
        static {
            for (SegmentType e : SegmentType.values())
                byId.put(e.id(), e);
        }
        public static SegmentType byId(long id) { return byId.get(id); }
    }

    public PublisherTc(KaitaiStream _io) {
        this(_io, null, null);
    }

    public PublisherTc(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public PublisherTc(KaitaiStream _io, KaitaiStruct _parent, PublisherTc _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.segmentType = SegmentType.byId(this._io.readBitsInt(3));
        pubPurposesConsent = new ArrayList<Boolean>((int) (24));
        for (int i = 0; i < 24; i++) {
            this.pubPurposesConsent.add(this._io.readBitsInt(1) != 0);
        }
        pubPurposesLiTransparency = new ArrayList<Boolean>((int) (24));
        for (int i = 0; i < 24; i++) {
            this.pubPurposesLiTransparency.add(this._io.readBitsInt(1) != 0);
        }
        this.numCustomPurposes = this._io.readBitsInt(6);
        if (numCustomPurposes() > 0) {
            customPurposesConsent = new ArrayList<Boolean>((int) (numCustomPurposes()));
            for (int i = 0; i < numCustomPurposes(); i++) {
                this.customPurposesConsent.add(this._io.readBitsInt(1) != 0);
            }
        }
        if (numCustomPurposes() > 0) {
            customPurposesLiTransparency = new ArrayList<Boolean>((int) (numCustomPurposes()));
            for (int i = 0; i < numCustomPurposes(); i++) {
                this.customPurposesLiTransparency.add(this._io.readBitsInt(1) != 0);
            }
        }
    }
    private SegmentType segmentType;
    private ArrayList<Boolean> pubPurposesConsent;
    private ArrayList<Boolean> pubPurposesLiTransparency;
    private long numCustomPurposes;
    private ArrayList<Boolean> customPurposesConsent;
    private ArrayList<Boolean> customPurposesLiTransparency;
    private PublisherTc _root;
    private KaitaiStruct _parent;
    public SegmentType segmentType() { return segmentType; }
    public ArrayList<Boolean> pubPurposesConsent() { return pubPurposesConsent; }
    public ArrayList<Boolean> pubPurposesLiTransparency() { return pubPurposesLiTransparency; }
    public long numCustomPurposes() { return numCustomPurposes; }
    public ArrayList<Boolean> customPurposesConsent() { return customPurposesConsent; }
    public ArrayList<Boolean> customPurposesLiTransparency() { return customPurposesLiTransparency; }
    public PublisherTc _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
