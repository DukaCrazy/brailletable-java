# Braille Table

`English Version`  
- BrailleTable is a library that provides tables and utilities related to the braille system, using the Unicode Braille Patterns block as its reference.
- Version 1.0.1
- This library is considered unstable, and at the moment, there are no plans for future updates.

# Tables group (0004)

## 0004-A - Braille List
```java
    public static List<String> brailleList()
```

### Description
Returns all 64 six‑dot braille symbols.
The symbols follow the standard Unicode Braille Pattern block, ranging from U+2800 to U+283F.
### Details
- Output type: `List<String>`
- Total items: 64
- Unicode block: Braille Patterns
- Order: strictly sequential from U+2800 (⠀) to U+283F (⠿)

## 0004-BA - Braille Binary
```java
    public static List<List<Integer>> binaryList() 
```

### Description
Returns a list with 64 items, where each item is a 6‑bit array representing the binary pattern of a braille character.
The bit patterns follow the natural numeric order from 0 to 63, each formatted as a 6‑bit binary sequence (000000 → 111111).
### Details
- Output type: `List<List<Integer>>`
- Total items: 64
- Bits per item: 6
- Value range: integers 0 or 1
- Order: sequential binary representation of numbers 0–63
- Mapping: index → 6‑bit array

## 0004-BB - Braille Reverse Binary
```java
    public static List<List<Integer>> reverseBinaryList() 
```

### Description
Returns a list with 64 items, where each item is a 6‑bit array representing the binary pattern of a braille character, but in reverse bit order.
Each 6‑bit sequence is reversed from right to left, transforming abcxyz into zyxcba.
### Details
- Output type: `List<List<Integer>>`
- Total items: 64
- Bits per item: 6
- Value range: integers 0 or 1
- Order: sequential binary representation of numbers 0–63
- Transformation: each 6‑bit array is reversed
- Mapping: index → reversed 6‑bit array

## 0004-CA - Braille Binary String
```java
    public static List<String> binaryStringList()
```

### Description
Returns a list with 64 items, where each item is a 6‑bit binary string representing the braille pattern for values from 0 to 63.
Each number is formatted as a fixed‑width 6‑character binary string ("000000" → "111111").
### Details
- Output type: `List<String>`
- Total items: 64
- String length: always 6 characters
- Characters used: '0' and '1'
- Order: sequential binary representation of numbers 0–63
- Mapping: index → "binary_string"

## 0004-CB - Braille Reverse Binary String
```java
    public static List<String> reverseBinaryStringList()
```

### Description
Returns a list with 64 items, where each item is a 6‑bit binary string reversed from right to left.
Each binary string corresponds to the numbers 0 to 63, but with the bit order inverted ("abcxyz" → "zyxcba").
### Details
- Output type: `List<String>`
- Total items: 64
- String length: always 6 characters
- Characters used: '0' and '1'
- Order: sequential binary representation of numbers 0–63
- Transformation: each binary string is reversed
- Mapping: index → "reversed_binary_string"

## 0004-D - Braille Unicode
```java
    public static List<String> unicodeList()
```

### Description
Returns a list with 64 Unicode strings, each representing the hexadecimal Unicode code point of a braille character.
The values follow the standard Unicode Braille Patterns block, from U+2800 to U+283F.
### Details
- Output type: `List<String>`
- Total items: 64
- Format: hexadecimal Unicode strings (e.g., "2800", "2801", … "283F")
- Unicode block: Braille Patterns
- Order: strictly sequential from U+2800 to U+283F
- Mapping: index → "unicode_hex_string"

## 0004-E - Number of Points Per Braille 
```java
    public static List<Integer> dotCount()
```

### Description
Returns a list with 64 integers, where each value represents the number of active dots (1–6) in the corresponding braille character.
The count is computed from the binary pattern of each braille cell.
### Details
- Output type: `List<Integer>`
- Total items: 64
- Value range: integers from 0 to 6
- Order: sequential braille index (0–63)
- Mapping: index → active dot count

## 0004-F - Braille Dot Numbering List
```java
    public static List<List<Integer>> dotNumberingList()
```

### Description
Returns a list with 64 items, where each item is a list containing the active dot numbers (1–6) of the corresponding braille character.
Dot numbering follows the standard braille convention:
- 1 4
- 2 5
- 3 6
### Details
- Output type: `List<List<Integer>>`
- Total items: 64
- Dots per item: variable (0 to 6)
- Dot numbering: 1–6
- Order: sequential braille index (0–63)
- Mapping: index → [dot_numbers]

## 0004-G - Braille Dot Numbering String List
```java
    public static List<String> dotNumberingStringList()
```
### Description
Returns a list with 64 strings, where each string contains the active dot numbers of the corresponding braille character, separated by hyphens.
This format is commonly used in educational material and documentation.
### Details
- Output type: `List<String>`
- Total items: 64
- Format: "1-3-5" or "" for no dots
- Dot numbering: 1–6
- Order: sequential braille index (0–63)
- Mapping: index → "dot1-dot2-dot3"



# Mapping group (0003)

## 0003-AA - Get the Index Using the Braille Character
```java
    public static int getBrailleToIndex(String braille)
```
### Description
Returns the numeric index (0–63) of a given braille Unicode character.
The index corresponds to the character’s position in the Unicode Braille Patterns block, ranging from U+2800 to U+283F.
### Details
- Input type: `String braille (a single braille Unicode character)`
- Output type: `int`
- Valid range: 0 to 63
- Unicode block: Braille Patterns
- Mapping: braille_character → index
- Lookup source: internal static table of 64 braille symbols

## 0003-AB - Get the Braille Character Using the Index
```java
    public static String getIndexToBraille(int index)
```

### Description
Returns the braille Unicode character corresponding to the given index (0–63).
The index maps directly to the Unicode Braille Patterns block, from U+2800 to U+283F.
### Details
- Input type: `int index (a valid numeric position from 0 to 63)`
- Valid range: 0 to 63
- Output type: `String (a single braille Unicode character)`
- Unicode block: Braille Patterns
- Mapping: index → braille_character
- Lookup source: internal static table of 64 braille symbols

## 0003-B - Receives a List of Braille Characters and Returns a List of Indices
```java
    public static List<Integer> getBrailleListToIndexList(List<String> brailleList) 
```

### Description
Converts a list of braille Unicode characters into a list of their corresponding numeric indices (0–63).
Each character is mapped using the same Unicode Braille Patterns block (U+2800 to U+283F).
### Details
- Input type: `List<String> brailleList`
- Output type: `List<Integer>`
- Valid index range: 0 to 63
- Unicode block: Braille Patterns
- Mapping: [braille_char1, braille_char2, ...] → [index1, index2, ...]
- Conversion rule: each character is processed using get_braille_to_index()

