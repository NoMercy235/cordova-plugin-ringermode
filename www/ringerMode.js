var ringerModeExport = {};

ringerModeExport.getRingerMode = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "ringerMode", "getRingerMode", []);
};

ringerModeExport.setRingerSilent = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "ringerMode", "setRingerSilent", []);
};

ringerModeExport.setRingerVibrate = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "ringerMode", "setRingerVibrate", []);
};

ringerModeExport.setRingerNormal = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "ringerMode", "setRingerNormal", []);
};

module.exports = ringerModeExport;
