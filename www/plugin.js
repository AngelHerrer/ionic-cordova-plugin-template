
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MiPlugin';

var MiPlugin = {
  otp: function (name, successCallback, errorCallback){
        exec(successCallback, errorCallback, PLUGIN_NAME, "OtpVirtual", [name]);
  }
};

module.exports = MiPlugin;
