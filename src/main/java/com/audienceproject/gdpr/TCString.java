package com.audienceproject.gdpr;

import com.audienceproject.gdpr.struct.CoreString;
import com.audienceproject.gdpr.struct.PublisherTc;
import com.audienceproject.gdpr.struct.VendorSegment;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

public class TCString {

    private CoreString coreString;
    private VendorSegment disclosedVendors;
    private VendorSegment allowedVendors;
    private PublisherTc publisherTc;

    private TCString(String consentString) {
        String[] segments = consentString.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        coreString = new CoreString(new UnalignedBitStream(decoder.decode(segments[0])));

        for (int i = 1; i < segments.length; i++) {
            byte[] bytes = decoder.decode(segments[i]);
            UnalignedBitStream bitStream = new UnalignedBitStream(bytes);
            int segmentType = (int) bitStream.readBitsInt(3);
            bitStream.reset();
            switch (segmentType) {
                case 1:
                    disclosedVendors = new VendorSegment(bitStream);
                    break;
                case 2:
                    allowedVendors = new VendorSegment(bitStream);
                    break;
                case 3:
                    publisherTc = new PublisherTc(bitStream);
                    break;
                default:
                    throw new RuntimeException("Invalid segment type: " + segmentType);
            }
        }
    }

    public CoreString getCoreString() {
        return coreString;
    }

    public Optional<VendorSegment> getDisclosedVendors() {
        return Optional.ofNullable(disclosedVendors);
    }

    public Optional<VendorSegment> getAllowedVendors() {
        return Optional.ofNullable(allowedVendors);
    }

    public Optional<PublisherTc> getPublisherTC() {
        return Optional.ofNullable(publisherTc);
    }

    public LocalDateTime createdOn() {
        return TCStringUtils.decodeTime(coreString.created());
    }

    public LocalDateTime lastUpdatedOn() {
        return TCStringUtils.decodeTime(coreString.lastUpdated());
    }

    public String getConsentLanguage() {
        return TCStringUtils.decodeLetterCode(coreString.consentLanguage());
    }

    public String getPublisherCountryCode() {
        return TCStringUtils.decodeLetterCode(coreString.specificJurisdictionDisclosures().publisherCc());
    }

    public static TCString parse(String consentString) {
        return new TCString(consentString);
    }

}
