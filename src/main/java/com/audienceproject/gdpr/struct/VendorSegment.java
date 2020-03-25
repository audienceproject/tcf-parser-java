// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.audienceproject.gdpr.struct;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class VendorSegment extends KaitaiStruct {
    public static VendorSegment fromFile(String fileName) throws IOException {
        return new VendorSegment(new ByteBufferKaitaiStream(fileName));
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

    public VendorSegment(KaitaiStream _io) {
        this(_io, null, null);
    }

    public VendorSegment(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public VendorSegment(KaitaiStream _io, KaitaiStruct _parent, VendorSegment _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.segmentType = SegmentType.byId(this._io.readBitsInt(3));
        this._io.alignToByte();
        this.vendors = new VendorSection(this._io, this, _root);
    }
    public static class VendorSection extends KaitaiStruct {
        public static VendorSection fromFile(String fileName) throws IOException {
            return new VendorSection(new ByteBufferKaitaiStream(fileName));
        }

        public VendorSection(KaitaiStream _io) {
            this(_io, null, null);
        }

        public VendorSection(KaitaiStream _io, VendorSegment _parent) {
            this(_io, _parent, null);
        }

        public VendorSection(KaitaiStream _io, VendorSegment _parent, VendorSegment _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.maxVendorId = this._io.readBitsInt(16);
            this.isRangeEncoding = this._io.readBitsInt(1) != 0;
            if (!(isRangeEncoding())) {
                bitField = new ArrayList<Boolean>((int) (maxVendorId()));
                for (int i = 0; i < maxVendorId(); i++) {
                    this.bitField.add(this._io.readBitsInt(1) != 0);
                }
            }
            this._io.alignToByte();
            if (isRangeEncoding()) {
                this.rangeSection = new RangeSection(this._io, this, _root);
            }
        }
        private long maxVendorId;
        private boolean isRangeEncoding;
        private ArrayList<Boolean> bitField;
        private RangeSection rangeSection;
        private VendorSegment _root;
        private VendorSegment _parent;
        public long maxVendorId() { return maxVendorId; }
        public boolean isRangeEncoding() { return isRangeEncoding; }
        public ArrayList<Boolean> bitField() { return bitField; }
        public RangeSection rangeSection() { return rangeSection; }
        public VendorSegment _root() { return _root; }
        public VendorSegment _parent() { return _parent; }
    }
    public static class RangeSection extends KaitaiStruct {
        public static RangeSection fromFile(String fileName) throws IOException {
            return new RangeSection(new ByteBufferKaitaiStream(fileName));
        }

        public RangeSection(KaitaiStream _io) {
            this(_io, null, null);
        }

        public RangeSection(KaitaiStream _io, VendorSegment.VendorSection _parent) {
            this(_io, _parent, null);
        }

        public RangeSection(KaitaiStream _io, VendorSegment.VendorSection _parent, VendorSegment _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.numEntries = this._io.readBitsInt(12);
            this._io.alignToByte();
            rangeEntries = new ArrayList<RangeEntry>((int) (numEntries()));
            for (int i = 0; i < numEntries(); i++) {
                this.rangeEntries.add(new RangeEntry(this._io, this, _root));
            }
        }
        private long numEntries;
        private ArrayList<RangeEntry> rangeEntries;
        private VendorSegment _root;
        private VendorSegment.VendorSection _parent;
        public long numEntries() { return numEntries; }
        public ArrayList<RangeEntry> rangeEntries() { return rangeEntries; }
        public VendorSegment _root() { return _root; }
        public VendorSegment.VendorSection _parent() { return _parent; }
    }
    public static class RangeEntry extends KaitaiStruct {
        public static RangeEntry fromFile(String fileName) throws IOException {
            return new RangeEntry(new ByteBufferKaitaiStream(fileName));
        }

        public RangeEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public RangeEntry(KaitaiStream _io, VendorSegment.RangeSection _parent) {
            this(_io, _parent, null);
        }

        public RangeEntry(KaitaiStream _io, VendorSegment.RangeSection _parent, VendorSegment _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.isARange = this._io.readBitsInt(1) != 0;
            this.startOrOnlyVendorId = this._io.readBitsInt(16);
            if (isARange()) {
                this.endVendorId = this._io.readBitsInt(16);
            }
        }
        private boolean isARange;
        private long startOrOnlyVendorId;
        private Long endVendorId;
        private VendorSegment _root;
        private VendorSegment.RangeSection _parent;
        public boolean isARange() { return isARange; }
        public long startOrOnlyVendorId() { return startOrOnlyVendorId; }
        public Long endVendorId() { return endVendorId; }
        public VendorSegment _root() { return _root; }
        public VendorSegment.RangeSection _parent() { return _parent; }
    }
    private SegmentType segmentType;
    private VendorSection vendors;
    private VendorSegment _root;
    private KaitaiStruct _parent;
    public SegmentType segmentType() { return segmentType; }
    public VendorSection vendors() { return vendors; }
    public VendorSegment _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
