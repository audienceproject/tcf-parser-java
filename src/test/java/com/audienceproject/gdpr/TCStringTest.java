package com.audienceproject.gdpr;

import com.audienceproject.gdpr.struct.CoreString;
import com.audienceproject.gdpr.struct.PublisherTc;
import com.audienceproject.gdpr.struct.VendorSegment;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TCStringTest {

    private final String consentStringV1 = "BOEFEAyOEFEAyAHABDENAI4AAAB9vABAASA";
    private final String consentStringNoOptions = "COwaAK3OwaAK3GKAAAENAcCAAAAAAAAAAAAAAAAAAAAA.IF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACAAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQ.YAAAAAAAAAAAAAAAAAA";
    private final String consentStringAllOptions = "COwaAUcOwaAUcGKAAAENAcCMAP_AAAAAAAAAF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACBAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQAAAAA.IF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACAAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQ.YAAAAAAAAAAAAAAAAAA";

    @Test
    void parseConsentStringV1() {
        TCString tcString = TCString.parse(consentStringV1);
        CoreString coreString = tcString.getCoreString();

        // Version is 1.
        assertEquals(1, coreString.version());

        // Created on 2017-11-07.
        assertEquals(LocalDate.of(2017, 11, 7), tcString.createdOn().toLocalDate());
        assertEquals(LocalDate.of(2017, 11, 7), tcString.lastUpdatedOn().toLocalDate());

        assertEquals(7, coreString.cmpId());
        assertEquals(1, coreString.cmpVersion());
        assertEquals(3, coreString.consentScreen());
        assertEquals(8, coreString.vendorListVersion());

        // Language is 'en'.
        assertEquals("en", tcString.getConsentLanguage());

        // Purposes 1, 2 and 3 are allowed.
        TCPurposes purposes = tcString.getV1PurposesAllowed();
        assertTrue(purposes.isPurposeAllowed(CoreString.PurposesV1.STORAGE_AND_ACCESS));
        assertTrue(purposes.isPurposeAllowed(CoreString.PurposesV1.PERSONALIZATION));
        assertTrue(purposes.isPurposeAllowed(CoreString.PurposesV1.AD_SELECTION));
        assertFalse(purposes.isPurposeAllowed(CoreString.PurposesV1.CONTENT_DELIVERY));
        assertFalse(purposes.isPurposeAllowed(CoreString.PurposesV1.MEASUREMENT));

        CoreString.CoreStringV1.VendorSection vendorSection = coreString.coreStringV1().vendors();
        assertEquals(2011, vendorSection.maxVendorId());
        assertEquals(CoreString.CoreStringV1.EncodingType.RANGE, vendorSection.encodingType());

        CoreString.CoreStringV1.RangeSection rangeSection = vendorSection.rangeSection();
        assertTrue(rangeSection.defaultConsent());
        assertEquals(1, rangeSection.numEntries());

        CoreString.CoreStringV1.RangeEntry rangeEntry = rangeSection.rangeEntries().get(0);
        assertEquals(CoreString.CoreStringV1.SingleOrRange.SINGLE, rangeEntry.singleOrRange());
        assertEquals(9, rangeEntry.singleVendorId());
        assertNull(rangeEntry.startVendorId());
        assertNull(rangeEntry.endVendorId());
    }

    @Test
    void parseCoreString() {
        TCString tcString = TCString.parse(consentStringNoOptions);

        // Version is 2.
        assertEquals(2, tcString.getCoreString().version());

        // Created on 2020-03-17.
        assertEquals(LocalDate.of(2020, 3, 17), tcString.createdOn().toLocalDate());
        assertEquals(LocalDate.of(2020, 3, 17), tcString.lastUpdatedOn().toLocalDate());

        // Language is 'en'.
        assertEquals("en", tcString.getConsentLanguage());

        // All purposes are set to false.
        TCPurposes consent = tcString.getV2PurposesConsent();
        assertAll(Arrays.stream(CoreString.PurposesV2.values()).map(purpose ->
                () -> assertFalse(consent.isPurposeAllowed(purpose))));

        TCPurposes legitimateInterest = tcString.getV2PurposesLegitimateInterest();
        assertAll(Arrays.stream(CoreString.PurposesV2.values()).map(purpose ->
                () -> assertFalse(legitimateInterest.isPurposeAllowed(purpose))));
    }

    @Test
    void parseMultipleVendors() {
        TCString tcString = TCString.parse(consentStringAllOptions);

        // Version is 2.
        assertEquals(2, tcString.getCoreString().version());

        CoreString.CoreStringV2 coreString = tcString.getCoreString().coreStringV2();
        assertFalse(coreString.vendorConsent().isRangeEncoding());
        assertEquals(744, coreString.vendorConsent().maxVendorId());
        assertEquals(744, coreString.vendorConsent().bitField().size());

        assertTrue(tcString.getDisclosedVendors().isPresent());
        VendorSegment disclosedVendors = tcString.getDisclosedVendors().get();

        assertFalse(disclosedVendors.vendors().isRangeEncoding());
        assertEquals(744, disclosedVendors.vendors().maxVendorId());
        assertEquals(744, disclosedVendors.vendors().bitField().size());

        assertFalse(tcString.getAllowedVendors().isPresent());

        assertTrue(tcString.getPublisherTC().isPresent());
        PublisherTc publisherTc = tcString.getPublisherTC().get();
        assertAll(publisherTc.pubPurposesConsent().stream().map(consent -> () -> assertFalse(consent)));
        assertAll(publisherTc.pubPurposesLiTransparency().stream().map(li -> () -> assertFalse(li)));
    }

    @Test
    void parseVendorConsent() {
        TCString noOptions = TCString.parse(consentStringNoOptions);
        assertFalse(noOptions.vendorHasConsent(394));

        TCString allOptions = TCString.parse(consentStringAllOptions);
        assertTrue(allOptions.vendorHasConsent(394));
    }

}
