# Introduction
Java implementation of the Transparency and Consent Framework 2.0

The library is intended to parse the binary block format of the TCF 2.0 consent string, as documented here:

https://github.com/InteractiveAdvertisingBureau/GDPR-Transparency-and-Consent-Framework/blob/master/TCFv2/IAB%20Tech%20Lab%20-%20Consent%20string%20and%20vendor%20list%20formats%20v2.md#the-core-string

The parser and structured Java classes are auto-generated with Kaitai Struct (https://kaitai.io/).
The consent string has been fully specified using the Kaitai Struct language, found in the .ksy files under `src/main/resources`.

# Usage

```java
import com.audienceproject.gdpr.TCString;

String consentString = "COwaAK3OwaAK3GKAAAENAcCAAAAAAAAAAAAAAAAAAAAA.IF0EWSQgAYWwho0QUBzBAIYAfJgSCAMgSAAQIoCkFQICERBAEKiAQHAEQJAAAGBAAkACAAQAoHCBMCQABgAARiRCEQECIDRNABIBAggAKYQFAAARmikHC3ZCY702yOmQ.YAAAAAAAAAAAAAAAAAA";

TCString tcString = TCString.parse(consentString);
```

# Making Changes
If a bug is found in the implementation or the format changes, simply edit the .ksy file and run the Kaitai Struct compiler to generate new classes.
```shell
kaitai-struct-compiler -t java --java-package com.audienceproject.gdpr.struct src/main/resources/tcf_core.ksy
kaitai-struct-compiler -t java --java-package com.audienceproject.gdpr.struct src/main/resources/tcf_publisher.ksy
kaitai-struct-compiler -t java --java-package com.audienceproject.gdpr.struct src/main/resources/tcf_vendor.ksy
```
