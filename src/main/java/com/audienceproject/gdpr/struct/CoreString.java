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

    public enum PurposesV1 {
        STORAGE_AND_ACCESS(0),
        PERSONALIZATION(1),
        AD_SELECTION(2),
        CONTENT_DELIVERY(3),
        MEASUREMENT(4);

        private final long id;
        PurposesV1(long id) { this.id = id; }
        public long id() { return id; }
        private static final Map<Long, PurposesV1> byId = new HashMap<Long, PurposesV1>(5);
        static {
            for (PurposesV1 e : PurposesV1.values())
                byId.put(e.id(), e);
        }
        public static PurposesV1 byId(long id) { return byId.get(id); }
    }

    public enum PurposesV2 {
        STORAGE_AND_ACCESS(0),
        BASIC_SELECTION(1),
        AD_PROFILING(2),
        AD_PERSONALIZATION(3),
        CONTENT_PROFILING(4),
        CONTENT_PERSONALIZATION(5),
        AD_MEASUREMENT(6),
        CONTENT_MEASUREMENT(7),
        MARKET_RESEARCH(8),
        DEVELOP_AND_IMPROVE(9);

        private final long id;
        PurposesV2(long id) { this.id = id; }
        public long id() { return id; }
        private static final Map<Long, PurposesV2> byId = new HashMap<Long, PurposesV2>(10);
        static {
            for (PurposesV2 e : PurposesV2.values())
                byId.put(e.id(), e);
        }
        public static PurposesV2 byId(long id) { return byId.get(id); }
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
        this._io.alignToByte();
        this.consentLanguage = new LetterCode(this._io, this, _root);
        this.vendorListVersion = this._io.readBitsInt(12);
        this._io.alignToByte();
        if (version() == 1) {
            this.coreStringV1 = new CoreStringV1(this._io, this, _root);
        }
        if (version() == 2) {
            this.coreStringV2 = new CoreStringV2(this._io, this, _root);
        }
    }
    public static class LetterCode extends KaitaiStruct {
        public static LetterCode fromFile(String fileName) throws IOException {
            return new LetterCode(new ByteBufferKaitaiStream(fileName));
        }

        public LetterCode(KaitaiStream _io) {
            this(_io, null, null);
        }

        public LetterCode(KaitaiStream _io, KaitaiStruct _parent) {
            this(_io, _parent, null);
        }

        public LetterCode(KaitaiStream _io, KaitaiStruct _parent, CoreString _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.first = this._io.readBitsInt(6);
            this.second = this._io.readBitsInt(6);
        }
        private long first;
        private long second;
        private CoreString _root;
        private KaitaiStruct _parent;
        public long first() { return first; }
        public long second() { return second; }
        public CoreString _root() { return _root; }
        public KaitaiStruct _parent() { return _parent; }
    }
    public static class CoreStringV1 extends KaitaiStruct {
        public static CoreStringV1 fromFile(String fileName) throws IOException {
            return new CoreStringV1(new ByteBufferKaitaiStream(fileName));
        }

        public enum EncodingType {
            BIT_FIELD(0),
            RANGE(1);

            private final long id;
            EncodingType(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, EncodingType> byId = new HashMap<Long, EncodingType>(2);
            static {
                for (EncodingType e : EncodingType.values())
                    byId.put(e.id(), e);
            }
            public static EncodingType byId(long id) { return byId.get(id); }
        }

        public enum SingleOrRange {
            SINGLE(0),
            RANGE(1);

            private final long id;
            SingleOrRange(long id) { this.id = id; }
            public long id() { return id; }
            private static final Map<Long, SingleOrRange> byId = new HashMap<Long, SingleOrRange>(2);
            static {
                for (SingleOrRange e : SingleOrRange.values())
                    byId.put(e.id(), e);
            }
            public static SingleOrRange byId(long id) { return byId.get(id); }
        }

        public CoreStringV1(KaitaiStream _io) {
            this(_io, null, null);
        }

        public CoreStringV1(KaitaiStream _io, CoreString _parent) {
            this(_io, _parent, null);
        }

        public CoreStringV1(KaitaiStream _io, CoreString _parent, CoreString _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            purposesAllowed = new ArrayList<Boolean>((int) (24));
            for (int i = 0; i < 24; i++) {
                this.purposesAllowed.add(this._io.readBitsInt(1) != 0);
            }
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

            public VendorSection(KaitaiStream _io, CoreString.CoreStringV1 _parent) {
                this(_io, _parent, null);
            }

            public VendorSection(KaitaiStream _io, CoreString.CoreStringV1 _parent, CoreString _root) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                _read();
            }
            private void _read() {
                this.maxVendorId = this._io.readBitsInt(16);
                this.encodingType = CoreString.CoreStringV1.EncodingType.byId(this._io.readBitsInt(1));
                if (encodingType() == CoreString.CoreStringV1.EncodingType.BIT_FIELD) {
                    bitField = new ArrayList<Boolean>((int) (maxVendorId()));
                    for (int i = 0; i < maxVendorId(); i++) {
                        this.bitField.add(this._io.readBitsInt(1) != 0);
                    }
                }
                this._io.alignToByte();
                if (encodingType() == CoreString.CoreStringV1.EncodingType.RANGE) {
                    this.rangeSection = new RangeSection(this._io, this, _root);
                }
            }
            private long maxVendorId;
            private EncodingType encodingType;
            private ArrayList<Boolean> bitField;
            private RangeSection rangeSection;
            private CoreString _root;
            private CoreString.CoreStringV1 _parent;
            public long maxVendorId() { return maxVendorId; }
            public EncodingType encodingType() { return encodingType; }
            public ArrayList<Boolean> bitField() { return bitField; }
            public RangeSection rangeSection() { return rangeSection; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV1 _parent() { return _parent; }
        }
        public static class RangeSection extends KaitaiStruct {
            public static RangeSection fromFile(String fileName) throws IOException {
                return new RangeSection(new ByteBufferKaitaiStream(fileName));
            }

            public RangeSection(KaitaiStream _io) {
                this(_io, null, null);
            }

            public RangeSection(KaitaiStream _io, CoreString.CoreStringV1.VendorSection _parent) {
                this(_io, _parent, null);
            }

            public RangeSection(KaitaiStream _io, CoreString.CoreStringV1.VendorSection _parent, CoreString _root) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                _read();
            }
            private void _read() {
                this.defaultConsent = this._io.readBitsInt(1) != 0;
                this.numEntries = this._io.readBitsInt(12);
                this._io.alignToByte();
                rangeEntries = new ArrayList<RangeEntry>((int) (numEntries()));
                for (int i = 0; i < numEntries(); i++) {
                    this.rangeEntries.add(new RangeEntry(this._io, this, _root));
                }
            }
            private boolean defaultConsent;
            private long numEntries;
            private ArrayList<RangeEntry> rangeEntries;
            private CoreString _root;
            private CoreString.CoreStringV1.VendorSection _parent;
            public boolean defaultConsent() { return defaultConsent; }
            public long numEntries() { return numEntries; }
            public ArrayList<RangeEntry> rangeEntries() { return rangeEntries; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV1.VendorSection _parent() { return _parent; }
        }
        public static class RangeEntry extends KaitaiStruct {
            public static RangeEntry fromFile(String fileName) throws IOException {
                return new RangeEntry(new ByteBufferKaitaiStream(fileName));
            }

            public RangeEntry(KaitaiStream _io) {
                this(_io, null, null);
            }

            public RangeEntry(KaitaiStream _io, CoreString.CoreStringV1.RangeSection _parent) {
                this(_io, _parent, null);
            }

            public RangeEntry(KaitaiStream _io, CoreString.CoreStringV1.RangeSection _parent, CoreString _root) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                _read();
            }
            private void _read() {
                this.singleOrRange = CoreString.CoreStringV1.SingleOrRange.byId(this._io.readBitsInt(1));
                if (singleOrRange() == CoreString.CoreStringV1.SingleOrRange.SINGLE) {
                    this.singleVendorId = this._io.readBitsInt(16);
                }
                if (singleOrRange() == CoreString.CoreStringV1.SingleOrRange.RANGE) {
                    this.startVendorId = this._io.readBitsInt(16);
                }
                if (singleOrRange() == CoreString.CoreStringV1.SingleOrRange.RANGE) {
                    this.endVendorId = this._io.readBitsInt(16);
                }
            }
            private SingleOrRange singleOrRange;
            private Long singleVendorId;
            private Long startVendorId;
            private Long endVendorId;
            private CoreString _root;
            private CoreString.CoreStringV1.RangeSection _parent;
            public SingleOrRange singleOrRange() { return singleOrRange; }
            public Long singleVendorId() { return singleVendorId; }
            public Long startVendorId() { return startVendorId; }
            public Long endVendorId() { return endVendorId; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV1.RangeSection _parent() { return _parent; }
        }
        private ArrayList<Boolean> purposesAllowed;
        private VendorSection vendors;
        private CoreString _root;
        private CoreString _parent;
        public ArrayList<Boolean> purposesAllowed() { return purposesAllowed; }
        public VendorSection vendors() { return vendors; }
        public CoreString _root() { return _root; }
        public CoreString _parent() { return _parent; }
    }
    public static class CoreStringV2 extends KaitaiStruct {
        public static CoreStringV2 fromFile(String fileName) throws IOException {
            return new CoreStringV2(new ByteBufferKaitaiStream(fileName));
        }

        public CoreStringV2(KaitaiStream _io) {
            this(_io, null, null);
        }

        public CoreStringV2(KaitaiStream _io, CoreString _parent) {
            this(_io, _parent, null);
        }

        public CoreStringV2(KaitaiStream _io, CoreString _parent, CoreString _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
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

            public VendorSection(KaitaiStream _io, CoreString.CoreStringV2 _parent) {
                this(_io, _parent, null);
            }

            public VendorSection(KaitaiStream _io, CoreString.CoreStringV2 _parent, CoreString _root) {
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
            private CoreString.CoreStringV2 _parent;
            public long maxVendorId() { return maxVendorId; }
            public boolean isRangeEncoding() { return isRangeEncoding; }
            public ArrayList<Boolean> bitField() { return bitField; }
            public RangeSection rangeSection() { return rangeSection; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV2 _parent() { return _parent; }
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

            public PublisherRestrictionsSection(KaitaiStream _io) {
                this(_io, null, null);
            }

            public PublisherRestrictionsSection(KaitaiStream _io, CoreString.CoreStringV2 _parent) {
                this(_io, _parent, null);
            }

            public PublisherRestrictionsSection(KaitaiStream _io, CoreString.CoreStringV2 _parent, CoreString _root) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                _read();
            }
            private void _read() {
                this.numPubRestrictions = this._io.readBitsInt(12);
                this._io.alignToByte();
                if (numPubRestrictions() > 0) {
                    pubRestrictionEntries = new ArrayList<PubRestrictionEntry>((int) (numPubRestrictions()));
                    for (int i = 0; i < numPubRestrictions(); i++) {
                        this.pubRestrictionEntries.add(new PubRestrictionEntry(this._io, this, _root));
                    }
                }
            }
            public static class PubRestrictionEntry extends KaitaiStruct {
                public static PubRestrictionEntry fromFile(String fileName) throws IOException {
                    return new PubRestrictionEntry(new ByteBufferKaitaiStream(fileName));
                }

                public PubRestrictionEntry(KaitaiStream _io) {
                    this(_io, null, null);
                }

                public PubRestrictionEntry(KaitaiStream _io, CoreString.CoreStringV2.PublisherRestrictionsSection _parent) {
                    this(_io, _parent, null);
                }

                public PubRestrictionEntry(KaitaiStream _io, CoreString.CoreStringV2.PublisherRestrictionsSection _parent, CoreString _root) {
                    super(_io);
                    this._parent = _parent;
                    this._root = _root;
                    _read();
                }
                private void _read() {
                    this.purposeId = this._io.readBitsInt(6);
                    this.restrictionType = CoreString.CoreStringV2.PublisherRestrictionsSection.RestrictionType.byId(this._io.readBitsInt(2));
                    this._io.alignToByte();
                    this.rangeSection = new RangeSection(this._io, this, _root);
                }
                private long purposeId;
                private RestrictionType restrictionType;
                private RangeSection rangeSection;
                private CoreString _root;
                private CoreString.CoreStringV2.PublisherRestrictionsSection _parent;
                public long purposeId() { return purposeId; }
                public RestrictionType restrictionType() { return restrictionType; }
                public RangeSection rangeSection() { return rangeSection; }
                public CoreString _root() { return _root; }
                public CoreString.CoreStringV2.PublisherRestrictionsSection _parent() { return _parent; }
            }
            private long numPubRestrictions;
            private ArrayList<PubRestrictionEntry> pubRestrictionEntries;
            private CoreString _root;
            private CoreString.CoreStringV2 _parent;
            public long numPubRestrictions() { return numPubRestrictions; }
            public ArrayList<PubRestrictionEntry> pubRestrictionEntries() { return pubRestrictionEntries; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV2 _parent() { return _parent; }
        }
        public static class SpecificJurisdictionDisclosures extends KaitaiStruct {
            public static SpecificJurisdictionDisclosures fromFile(String fileName) throws IOException {
                return new SpecificJurisdictionDisclosures(new ByteBufferKaitaiStream(fileName));
            }

            public SpecificJurisdictionDisclosures(KaitaiStream _io) {
                this(_io, null, null);
            }

            public SpecificJurisdictionDisclosures(KaitaiStream _io, CoreString.CoreStringV2 _parent) {
                this(_io, _parent, null);
            }

            public SpecificJurisdictionDisclosures(KaitaiStream _io, CoreString.CoreStringV2 _parent, CoreString _root) {
                super(_io);
                this._parent = _parent;
                this._root = _root;
                _read();
            }
            private void _read() {
                this.purposeOneTreatment = this._io.readBitsInt(1) != 0;
                this._io.alignToByte();
                this.publisherCc = new LetterCode(this._io, this, _root);
            }
            private boolean purposeOneTreatment;
            private LetterCode publisherCc;
            private CoreString _root;
            private CoreString.CoreStringV2 _parent;
            public boolean purposeOneTreatment() { return purposeOneTreatment; }
            public LetterCode publisherCc() { return publisherCc; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV2 _parent() { return _parent; }
        }
        public static class RangeEntry extends KaitaiStruct {
            public static RangeEntry fromFile(String fileName) throws IOException {
                return new RangeEntry(new ByteBufferKaitaiStream(fileName));
            }

            public RangeEntry(KaitaiStream _io) {
                this(_io, null, null);
            }

            public RangeEntry(KaitaiStream _io, CoreString.CoreStringV2.RangeSection _parent) {
                this(_io, _parent, null);
            }

            public RangeEntry(KaitaiStream _io, CoreString.CoreStringV2.RangeSection _parent, CoreString _root) {
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
            private CoreString.CoreStringV2.RangeSection _parent;
            public boolean isARange() { return isARange; }
            public long startOrOnlyVendorId() { return startOrOnlyVendorId; }
            public Long endVendorId() { return endVendorId; }
            public CoreString _root() { return _root; }
            public CoreString.CoreStringV2.RangeSection _parent() { return _parent; }
        }
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
        private CoreString _parent;
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
        public CoreString _parent() { return _parent; }
    }
    private long version;
    private long created;
    private long lastUpdated;
    private long cmpId;
    private long cmpVersion;
    private long consentScreen;
    private LetterCode consentLanguage;
    private long vendorListVersion;
    private CoreStringV1 coreStringV1;
    private CoreStringV2 coreStringV2;
    private CoreString _root;
    private KaitaiStruct _parent;
    public long version() { return version; }
    public long created() { return created; }
    public long lastUpdated() { return lastUpdated; }
    public long cmpId() { return cmpId; }
    public long cmpVersion() { return cmpVersion; }
    public long consentScreen() { return consentScreen; }
    public LetterCode consentLanguage() { return consentLanguage; }
    public long vendorListVersion() { return vendorListVersion; }
    public CoreStringV1 coreStringV1() { return coreStringV1; }
    public CoreStringV2 coreStringV2() { return coreStringV2; }
    public CoreString _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
}
