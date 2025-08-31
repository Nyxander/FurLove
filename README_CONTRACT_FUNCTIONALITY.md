# Adoption Contract Functionality

## Overview
The adoption records GUI (`adoptimetGUI.java`) now includes comprehensive contract management capabilities through a dedicated "Kontrata" (Contract) button. This feature allows users to view, generate, save, and print adoption contracts.

## New Contract Button
- **Location**: Added next to the "Edito" button in the adoption records interface
- **Appearance**: Yellow button with black text, labeled "Kontrata"
- **Functionality**: Opens a comprehensive contract management dialog

## Contract Dialog Features

### 1. Contract Details Panel (Left Side)
- **Contract Number**: Auto-generated (KONT-XXXXXX format)
- **Contract Date**: Current date (auto-filled)
- **Applicant Name**: Full name from adoption record
- **Animal Information**: Name and species
- **Adoption Date**: Date from adoption record
- **Fee**: Adoption fee with currency symbol
- **Terms & Conditions**: Editable text area with default terms

### 2. Contract Text Panel (Center)
- **Professional Contract Format**: Structured adoption contract text
- **Auto-generated Content**: Based on adoption record data
- **Read-only Display**: Prevents accidental modifications
- **Scrollable**: Handles long contracts

### 3. Action Buttons (Bottom)
- **Ruaj Kontratën** (Save Contract): Saves contract to file and database
- **Printo Kontratën** (Print Contract): Opens contract for printing
- **Mbyll** (Close): Closes the dialog

## Contract Content Structure

### Header Section
```
KONTRATË E ADOPTIMIT
==========================================

Nr. Kontratës: KONT-XXXXXX
Data e Kontratës: YYYY-MM-DD
```

### Parties Section
```
NËNËSHKRUESIT:
1. Qendra për Kafshe Endacake "FurLove"
   Adresa: _____________________________
   Përfaqësues: ________________________

2. Aplikanti: [Full Name]
   Adresa: _____________________________
   Telefoni: ___________________________
   Email: ______________________________
```

### Contract Object
```
OBJEKTI I KONTRATËS:
Kafsha: [Animal Name] ([Species])
Data e Adoptimit: [Date]
Tarifa: [Fee] €
```

### Terms and Conditions
Default terms include:
1. Applicant responsibility for animal care
2. Proper living conditions and nutrition
3. Regular veterinary checkups
4. No transfer to third parties
5. Return policy if care cannot continue
6. Center support and advice
7. Contract validity period

### Signature Section
```
NËNËSHKRIMET:

Përfaqësuesi i Qendrës:    _________________    Data: _________

Aplikanti:                   _________________    Data: _________
```

## Technical Implementation

### File Management
- **Storage Location**: `contracts/` directory (auto-created)
- **File Naming**: `contract_[adoptionID].txt`
- **Database Integration**: Contract file path stored in `adoptime.kontrat` field

### Database Updates
- **Contract Path**: Automatically updated when contract is saved
- **File Reference**: Links adoption record to contract file
- **Data Consistency**: Maintains relationship between records and contracts

### Print Functionality
- **Desktop Integration**: Uses Java Desktop API
- **Text Editor**: Opens contract in default text editor
- **Print Instructions**: User guided to File -> Print option

## How to Use

### Step-by-Step Process
1. **Select Adoption Record**: Click on any row in the adoption table
2. **Click Contract Button**: Click the yellow "Kontrata" button
3. **Review Contract**: Check all details and terms
4. **Customize Terms**: Edit terms and conditions if needed
5. **Save Contract**: Click "Ruaj Kontratën" to save
6. **Print Contract**: Click "Printo Kontratën" for printing

### Contract Customization
- **Terms Editing**: Modify default terms in the left panel
- **Auto-generation**: Contract text updates automatically
- **Professional Format**: Maintains consistent structure

## File System Integration

### Directory Structure
```
project_root/
├── contracts/
│   ├── contract_1.txt
│   ├── contract_2.txt
│   └── contract_3.txt
└── src/
    └── furlove/
        ├── adoptimetGUI.java
        └── AdoptionContractDialog.java
```

### File Format
- **Extension**: `.txt` (plain text)
- **Encoding**: System default (UTF-8 recommended)
- **Content**: Structured contract text with proper formatting

## Error Handling

### Validation
- **Row Selection**: Ensures adoption record is selected
- **Data Loading**: Handles missing or invalid data gracefully
- **File Operations**: Catches and reports file system errors

### User Feedback
- **Success Messages**: Confirms contract save and print operations
- **Error Messages**: Clear explanation of any issues
- **File Locations**: Shows where contracts are saved

## Security Features

### Data Protection
- **Read-only Display**: Prevents accidental contract modification
- **File Permissions**: Uses standard file system security
- **Database Integrity**: Maintains referential integrity

### Access Control
- **Modal Dialog**: Prevents interaction with main window
- **Data Validation**: Ensures all required fields are present
- **Error Prevention**: Validates data before saving

## Benefits

### For Users
- **Professional Contracts**: Standardized adoption agreements
- **Easy Management**: Simple interface for contract operations
- **Print Ready**: Contracts formatted for printing
- **Digital Storage**: Organized file management

### For Organization
- **Legal Compliance**: Proper contract documentation
- **Record Keeping**: Complete adoption history
- **Professional Image**: Standardized contract format
- **Audit Trail**: Trackable contract modifications

## Future Enhancements

### Potential Improvements
- **PDF Generation**: Direct PDF output
- **Digital Signatures**: Electronic signature support
- **Template System**: Multiple contract templates
- **Email Integration**: Direct contract delivery
- **Multi-language**: Support for different languages

