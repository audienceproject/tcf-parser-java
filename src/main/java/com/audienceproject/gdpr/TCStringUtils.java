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

}
