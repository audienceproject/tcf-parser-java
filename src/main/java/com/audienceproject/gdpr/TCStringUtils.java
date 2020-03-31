package com.audienceproject.gdpr;

import com.audienceproject.gdpr.struct.CoreString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class TCStringUtils {

    public static LocalDateTime decodeTime(long deciseconds) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(deciseconds * 100), ZoneId.systemDefault());
    }

    public static String decodeLetterCode(CoreString.LetterCode letterCode) {
        char a = (char) (letterCode.first() + 97);
        char b = (char) (letterCode.second() + 97);
        return String.valueOf(a) + b;
    }

    public static TCPurposes decodePurposes(List<Boolean> values) {
        return new TCPurposes(values);
    }

    public static boolean isVendorPresentInSection(CoreString.CoreStringV2.VendorSection vendorSection, int vendorId) {
        if (vendorSection.isRangeEncoding())
            return isVendorPresentInRange(vendorSection.rangeSection(), vendorId);
        else
            return vendorId <= vendorSection.maxVendorId() && vendorSection.bitField().get(vendorId - 1);
    }

    public static boolean isVendorPresentInRange(CoreString.CoreStringV2.RangeSection rangeSection, int vendorId) {
        return rangeSection.rangeEntries().stream().anyMatch(entry -> {
            if (entry.isARange())
                return vendorId >= entry.startOrOnlyVendorId() && vendorId <= entry.endVendorId();
            else
                return vendorId == entry.startOrOnlyVendorId();
        });
    }

}
