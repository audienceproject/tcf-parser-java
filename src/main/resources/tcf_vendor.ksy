meta:
  id: vendor_segment
  endian: be
seq:
  - id: segment_type
    type: b3
    enum: segment_type
  - id: vendors
    type: vendor_section
enums:
  segment_type:
    0: core
    1: disclosed_vendors
    2: allowed_vendors
    3: publisher_tc
types:
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
