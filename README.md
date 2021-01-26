# NotiFX
Cross-platform JavaFX library for notifications

### Under Construction - Not yet for public use

## Platforms to be supported
- Windows 10
- MacOS (current version, past versions would be nice too)
- Linux
  - GNOME
  - KDE
  - XFCE
  - others???

## TODO
- Investigate native TrayIcon implementation for system tray icons on each platform
- Investigate native notifications
  - Windows (Action Center style) notifications
  - MacOS popup notifications
  - Linux
- Incorporate basic modal/non-modal dialogs
- Notifications that appear then fade away.

## Goals
- NotiFX should be written in pure JavaFX or native code (C/C++)
- NotiFX should **not** use AWT or Swing
- NotiFX API should follow JavaFX convention where possible
- NotiFX should be modular, and able to be run with the latest OpenJDK release
- NotiFX should **not** have any external dependencies apart from test scope software

## Development
- Minor fixes/implementation can be committed directly
- Major fixes or improvements should have a pull request or issue created
- Code style should be uniform, Sun Java style or Google's Java style guidelines
  should be followed unless any rule would make the code more difficult to understand
