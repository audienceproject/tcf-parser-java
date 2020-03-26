package com.audienceproject.gdpr;

import com.audienceproject.gdpr.struct.CoreString;
import com.audienceproject.gdpr.struct.PublisherTc;
import com.audienceproject.gdpr.struct.VendorSegment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TCStringTest {

    private final String consentStringNoOptions = "COwaAK3OwaAK3GKAAAENAcCAAAAAAAAAAAAAAAAAAAAA.IF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACAAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQ.YAAAAAAAAAAAAAAAAAA";
    private final String consentStringAllOptions = "COwaAUcOwaAUcGKAAAENAcCMAP_AAAAAAAAAF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACBAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQAAAAA.IF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACAAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQ.YAAAAAAAAAAAAAAAAAA";

    @Test
    void parseCoreString() {
        TCString tcString = TCString.parse(consentStringNoOptions);
        CoreString coreString = tcString.getCoreString();

        // Version is 2.
        assertEquals(2, coreString.version());

        // Created on 2020-03-17.
        assertEquals(LocalDate.of(2020, 3, 17), tcString.createdOn().toLocalDate());
        assertEquals(LocalDate.of(2020, 3, 17), tcString.lastUpdatedOn().toLocalDate());

        // Language is 'en'.
        assertEquals("en", tcString.getConsentLanguage());

        // All purposes are set to false.
        assertAll(coreString.purposesConsent().stream().map(consent -> () -> assertFalse(consent)));
        assertAll(coreString.purposesLiTransparency().stream().map(li -> () -> assertFalse(li)));
    }

    @Test
    void parseMultipleVendors() {
        TCString tcString = TCString.parse(consentStringAllOptions);
        CoreString coreString = tcString.getCoreString();

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

}
