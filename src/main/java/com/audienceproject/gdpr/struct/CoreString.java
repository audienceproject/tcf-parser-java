// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

package com.audienceproject.gdpr.struct;

import io.kaitai.struct.ByteBufferKaitaiStream;
import io.kaitai.struct.KaitaiStruct;
import io.kaitai.struct.KaitaiStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class CoreString extends KaitaiStruct {
    public static CoreString fromFile(String fileName) throws IOException {
        return new CoreString(new ByteBufferKaitaiStream(fileName));
    }

    public enum RestrictionType {
        NOT_ALLOWED(0),
        REQUIRE_CONSENT(1),
        REQUIRE_LEGITIMATE_INTEREST(2),
        UNDEFINED(3);

        private final long id;
        RestrictionType(long id) { this.id = id; }
        public long id() { return id; }
        private static final Map<Long, RestrictionType> byId = new HashMap<Long, RestrictionType>(4);
        static {
            for (RestrictionType e : RestrictionType.values())
                byId.put(e.id(), e);
        }
        public static RestrictionType byId(long id) { return byId.get(id); }
    }

    public CoreString(KaitaiStream _io) {
        this(_io, null, null);
    }

    public CoreString(KaitaiStream _io, KaitaiStruct _parent) {
        this(_io, _parent, null);
    }

    public CoreString(KaitaiStream _io, KaitaiStruct _parent, CoreString _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root == null ? this : _root;
        _read();
    }
    private void _read() {
        this.version = this._io.readBitsInt(6);
        this.created = this._io.readBitsInt(36);
        this.lastUpdated = this._io.readBitsInt(36);
        this.cmpId = this._io.readBitsInt(12);
        this.cmpVersion = this._io.readBitsInt(12);
        this.consentScreen = this._io.readBitsInt(6);
        this.consentLanguage = this._io.readBitsInt(12);
        this.vendorListVersion = this._io.readBitsInt(12);
        this.tcfPolicyVersion = this._io.readBitsInt(6);
        this.isServiceSpecific = this._io.readBitsInt(1) != 0;
        this.useNonStandardStacks = this._io.readBitsInt(1) != 0;
        this.specialFeatureOptIns = this._io.readBitsInt(12);
        purposesConsent = new ArrayList<Boolean>((int) (24));
        for (int i = 0; i < 24; i++) {
            this.purposesConsent.add(this._io.readBitsInt(1) != 0);
        }
        purposesLiTransparency = new ArrayList<Boolean>((int) (24));
        for (int i = 0; i < 24; i++) {
            this.purposesLiTransparency.add(this._io.readBitsInt(1) != 0);
        }
        this._io.alignToByte();
        this.specificJurisdictionDisclosures = new SpecificJurisdictionDisclosures(this._io, this, _root);
        this.vendorConsent = new VendorSection(this._io, this, _root);
        this.vendorLegitimateInterest = new VendorSection(this._io, this, _root);
        this.publisherRestrictions = new PublisherRestrictionsSection(this._io, this, _root);
    }
    public static class VendorSection extends KaitaiStruct {
        public static VendorSection fromFile(String fileName) throws IOException {
            return new VendorSection(new ByteBufferKaitaiStream(fileName));
        }

        public VendorSection(KaitaiStream _io) {
            this(_io, null, null);
        }

        public VendorSection(KaitaiStream _io, CoreString _parent) {
            this(_io, _parent, null);
        }

        public VendorSection(KaitaiStream _io, CoreString _parent, CoreString _root) {
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
        private CoreString _root;
        private CoreString _parent;
        public long maxVendorId() { return maxVendorId; }
        public boolean isRangeEncoding() { return isRangeEncoding; }
        public ArrayList<Boolean> bitField() { return bitField; }
        public RangeSection rangeSection() { return rangeSection; }
        public CoreString _root() { return _root; }
        public CoreString _parent() { return _parent; }
    }
    public static class RangeSection extends KaitaiStruct {
        public static RangeSection fromFile(String fileName) throws IOException {
            return new RangeSection(new ByteBufferKaitaiStream(fileName));
        }

        public RangeSection(KaitaiStream _io) {
            this(_io, null, null);
        }

        public RangeSection(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public RangeSection(KaitaiStream _io, KaitaiStruct _parent, CoreString _root) {
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
        private CoreString _root;
        private KaitaiStruct _parent;
        public long numEntries() { return numEntries; }
        public ArrayList<RangeEntry> rangeEntries() { return rangeEntries; }
        public CoreString _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class PublisherRestrictionsSection extends KaitaiStruct {
        public static PublisherRestrictionsSection fromFile(String fileName) throws IOException {
            return new PublisherRestrictionsSection(new ByteBufferKaitaiStream(fileName));
        }

        public PublisherRestrictionsSection(KaitaiStream _io) {
            this(_io, null, null);
        }

        public PublisherRestrictionsSection(KaitaiStream _io, CoreString _parent) {
            this(_io, _parent, null);
        }

        public PublisherRestrictionsSection(KaitaiStream _io, CoreString _parent, CoreString _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.numPubRestrictions = this._io.readBitsInt(12);
            this._io.alignToByte();
            pubRestrictionEntries = new ArrayList<PubRestrictionEntry>((int) (numPubRestrictions()));
            for (int i = 0; i < numPubRestrictions(); i++) {
                this.pubRestrictionEntries.add(new PubRestrictionEntry(this._io, this, _root));
            }
        }
        public static class PubRestrictionEntry extends KaitaiStruct {
            public static PubRestrictionEntry fromFile(String fileName) throws IOException {
                return new PubRestrictionEntry(new ByteBufferKaitaiStream(fileName));
            }

            public PubRestrictionEntry(KaitaiStream _io) {
                this(_io, null, null);
            }

            public PubRestrictionEntry(KaitaiStream _io, CoreString.PublisherRestrictionsSection _parent) {
                this(_io, _parent, null);
            }

            public PubRestrictionEntry(KaitaiStream _io, CoreString.PublisherRestrictionsSection _parent, CoreString _root) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                _read();
            }
            private void _read() {
                this.purposeId = this._io.readBitsInt(6);
                this.restrictionType = CoreString.RestrictionType.byId(this._io.readBitsInt(2));
                this._io.alignToByte();
                this.rangeSection = new RangeSection(this._io, this, _root);
            }
            private long purposeId;
            private RestrictionType restrictionType;
            private RangeSection rangeSection;
            private CoreString _root;
            private CoreString.PublisherRestrictionsSection _parent;
            public long purposeId() { return purposeId; }
            public RestrictionType restrictionType() { return restrictionType; }
            public RangeSection rangeSection() { return rangeSection; }
            public CoreString _root() { return _root; }
            public CoreString.PublisherRestrictionsSection _parent() { return _parent; }
        }
        private long numPubRestrictions;
        private ArrayList<PubRestrictionEntry> pubRestrictionEntries;
        private CoreString _root;
        private CoreString _parent;
        public long numPubRestrictions() { return numPubRestrictions; }
        public ArrayList<PubRestrictionEntry> pubRestrictionEntries() { return pubRestrictionEntries; }
        public CoreString _root() { return _root; }
        public CoreString _parent() { return _parent; }
    }
    public static class SpecificJurisdictionDisclosures extends KaitaiStruct {
        public static SpecificJurisdictionDisclosures fromFile(String fileName) throws IOException {
            return new SpecificJurisdictionDisclosures(new ByteBufferKaitaiStream(fileName));
        }

        public SpecificJurisdictionDisclosures(KaitaiStream _io) {
            this(_io, null, null);
        }

        public SpecificJurisdictionDisclosures(KaitaiStream _io, CoreString _parent) {
            this(_io, _parent, null);
        }

        public SpecificJurisdictionDisclosures(KaitaiStream _io, CoreString _parent, CoreString _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.purposeOneTreatment = this._io.readBitsInt(1) != 0;
            this.publisherCc = this._io.readBitsInt(12);
        }
        private boolean purposeOneTreatment;
        private long publisherCc;
        private CoreString _root;
        private CoreString _parent;
        public boolean purposeOneTreatment() { return purposeOneTreatment; }
        public long publisherCc() { return publisherCc; }
        public CoreString _root() { return _root; }
        public CoreString _parent() { return _parent; }
    }
    public static class RangeEntry extends KaitaiStruct {
        public static RangeEntry fromFile(String fileName) throws IOException {
            return new RangeEntry(new ByteBufferKaitaiStream(fileName));
        }

        public RangeEntry(KaitaiStream _io) {
            this(_io, null, null);
        }

        public RangeEntry(KaitaiStream _io, CoreString.RangeSection _parent) {
            this(_io, _parent, null);
        }

        public RangeEntry(KaitaiStream _io, CoreString.RangeSection _parent, CoreString _root) {
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
        private CoreString _root;
        private CoreString.RangeSection _parent;
        public boolean isARange() { return isARange; }
        public long startOrOnlyVendorId() { return startOrOnlyVendorId; }
        public Long endVendorId() { return endVendorId; }
        public CoreString _root() { return _root; }
        public CoreString.RangeSection _parent() { return _parent; }
    }
    private long version;
    private long created;
    private long lastUpdated;
    private long cmpId;
    private long cmpVersion;
    private long consentScreen;
    private long consentLanguage;
    private long vendorListVersion;
    private long tcfPolicyVersion;
    private boolean isServiceSpecific;
    private boolean useNonStandardStacks;
    private long specialFeatureOptIns;
    private ArrayList<Boolean> purposesConsent;
    private ArrayList<Boolean> purposesLiTransparency;
    private SpecificJurisdictionDisclosures specificJurisdictionDisclosures;
    private VendorSection vendorConsent;
    private VendorSection vendorLegitimateInterest;
    private PublisherRestrictionsSection publisherRestrictions;
    private CoreString _root;
    private KaitaiStruct _parent;
    public long version() { return version; }
    public long created() { return created; }
    public long lastUpdated() { return lastUpdated; }
    public long cmpId() { return cmpId; }
    public long cmpVersion() { return cmpVersion; }
    public long consentScreen() { return consentScreen; }
    public long consentLanguage() { return consentLanguage; }
    public long vendorListVersion() { return vendorListVersion; }
    public long tcfPolicyVersion() { return tcfPolicyVersion; }
    public boolean isServiceSpecific() { return isServiceSpecific; }
    public boolean useNonStandardStacks() { return useNonStandardStacks; }
    public long specialFeatureOptIns() { return specialFeatureOptIns; }
    public ArrayList<Boolean> purposesConsent() { return purposesConsent; }
    public ArrayList<Boolean> purposesLiTransparency() { return purposesLiTransparency; }
    public SpecificJurisdictionDisclosures specificJurisdictionDisclosures() { return specificJurisdictionDisclosures; }
    public VendorSection vendorConsent() { return vendorConsent; }
    public VendorSection vendorLegitimateInterest() { return vendorLegitimateInterest; }
    public PublisherRestrictionsSection publisherRestrictions() { return publisherRestrictions; }
    public CoreString _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
