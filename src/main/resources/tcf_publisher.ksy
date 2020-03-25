meta:
  id: publisher_tc
  endian: be
seq:
  - id: segment_type
    type: b3
    enum: segment_type
  - id: pub_purposes_consent
    type: b1
    repeat: expr
    repeat-expr: 24
  - id: pub_purposes_li_transparency
    type: b1
    repeat: expr
    repeat-expr: 24
  - id: num_custom_purposes
    type: b6
  - id: custom_purposes_consent
    type: b1
    repeat: expr
    repeat-expr: num_custom_purposes
    if: num_custom_purposes > 0
  - id: custom_purposes_li_transparency
    type: b1
    repeat: expr
    repeat-expr: num_custom_purposes
    if: num_custom_purposes > 0
enums:
  segment_type:
    0: core
    1: disclosed_vendors
    2: allowed_vendors
    3: publisher_tc
