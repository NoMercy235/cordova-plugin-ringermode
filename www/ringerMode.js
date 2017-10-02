var ringerModeExport = {};

ringerModeExport.getRingerMode = function(successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "ringerMode", "getRingerMode", []);
};

ringerModeExport.setRingerMode = function(mode, successCallback, errorCallback) {
  cordova.exec(successCallback, errorCallback, "ringerMode", "setRingerMode", [mode]);
};

module.exports = ringerModeExport;
