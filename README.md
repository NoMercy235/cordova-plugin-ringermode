# cordova-plugin-ringermode
A simple Cordova plugin for getting and setting the status of the ringer. Currently, it only works for Android and has been tested on both emulators and real devices. As far as I have tested, it only work with Android 5.0+, but it might also work with Android 4.4 (not tested).

This plugin exposes the following methods:

 - `getRingerMode` - Returns the current mode of the ringer
 - `setRingerSilent`, `setRingerVibrate` and `setRingerNormal` - Sets the ringer to the designated mode.

Setup Guide
=======

`cordova plugin add cordova-plugin-ringermode`

or

`cordova plugin add https://github.com/NoMercy235/cordova-plugin-ringermode.git`

Disclaimer
=======
This plugin was created as response to the following question on StackOverflow: https://stackoverflow.com/questions/38452187/get-device-silent-status

This plugin is an extension of this: https://github.com/RasimKanca/cordova-plugin-ringermode


License
=======
MIT