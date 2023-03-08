## 3.0.1 - 2023-03-08

## Fixed
- Removed `symbol` as mandatory parameter in `currentAllOpenOrders()` within `UMAccount.java` and `CMAccount.java` classes

## Updated
- Bumped `org.json` package version to `20230227`

## 3.0.0 - 2023-03-06

### Added
- HTTP Proxy Support

### Updated
- Removed unnecessary `secretKey` parameter from `UserData` classes

## 2.0.0 - 2023-01-12

### Fixed
- `POST /v1/marginType` - Changed `marginType` from Integer to String

### Changed
- Changed package path from `com.binance.connector` to `com.binance.connector.futures` to avoid conflicts with the Binance Spot API connector.

## 1.0.0 - 2022-12-06

### Added
- Initial code release
