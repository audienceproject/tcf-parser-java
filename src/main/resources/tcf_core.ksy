meta:
  id: core_string
  endian: be
seq:
  - id: version
    type: b6
  - id: created
    type: b36
  - id: last_updated
    type: b36
  - id: cmp_id
    type: b12
  - id: cmp_version
    type: b12
  - id: consent_screen
    type: b6
  - id: consent_language
    type: letter_code
  - id: vendor_list_version
    type: b12
  - id: tcf_policy_version
    type: b6
  - id: is_service_specific
    type: b1
  - id: use_non_standard_stacks
    type: b1
  - id: special_feature_opt_ins
    type: b12
  - id: purposes_consent
    type: b1
    repeat: expr
    repeat-expr: 24
  - id: purposes_li_transparency
    type: b1
    repeat: expr
    repeat-expr: 24
  - id: specific_jurisdiction_disclosures
    type: specific_jurisdiction_disclosures
  - id: vendor_consent
    type: vendor_section
  - id: vendor_legitimate_interest
    type: vendor_section
  - id: publisher_restrictions
    type: publisher_restrictions_section
types:
  letter_code:
    seq:
      - id: first
        type: b6
      - id: second
        type: b6
  specific_jurisdiction_disclosures:
    seq:
      - id: purpose_one_treatment
        type: b1
      - id: publisher_cc
        type: letter_code
  vendor_section:
    seq:
      - id: max_vendor_id
        type: b16
      - id: is_range_encoding
        type: b1
      - id: bit_field
        if: not is_range_encoding
        type: b1
        repeat: expr
        repeat-expr: max_vendor_id
      - id: range_section
        if: is_range_encoding
        type: range_section
  publisher_restrictions_section:
    seq:
      - id: num_pub_restrictions
        type: b12
      - id: pub_restriction_entries
        type: pub_restriction_entry
        repeat: expr
        repeat-expr: num_pub_restrictions
        if: num_pub_restrictions > 0
    types:
      pub_restriction_entry:
        seq:
          - id: purpose_id
            type: b6
          - id: restriction_type
            type: b2
            enum: restriction_type
          - id: range_section
            type: range_section
  range_section:
    seq:
      - id: num_entries
        type: b12
      - id: range_entries
        type: range_entry
        repeat: expr
        repeat-expr: num_entries
  range_entry:
    seq:
      - id: is_a_range
        type: b1
      - id: start_or_only_vendor_id
        type: b16
      - id: end_vendor_id
        type: b16
        if: is_a_range
enums:
  restriction_type:
    0: not_allowed
    1: require_consent
    2: require_legitimate_interest
    3: undefined
