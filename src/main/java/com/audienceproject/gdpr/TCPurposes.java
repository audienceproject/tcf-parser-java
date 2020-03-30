package com.audienceproject.gdpr;

import com.audienceproject.gdpr.struct.CoreString;

import java.util.List;

public class TCPurposes {

    private List<Boolean> values;

    TCPurposes(List<Boolean> values) {
        this.values = values;
    }

    public boolean isPurposeAllowed(CoreString.PurposesV1 purpose) {
        return values.get(purpose.ordinal());
    }

    public boolean isPurposeAllowed(CoreString.PurposesV2 purpose) {
        return values.get(purpose.ordinal());
    }

}
