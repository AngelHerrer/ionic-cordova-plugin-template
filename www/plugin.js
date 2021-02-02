cordova.define("mi-plugin.plugin", function(require, exports, module) {

var exec = require('cordova/exec');

var PLUGIN_NAME = 'MiPlugin';

var MiPlugin = {
  otp: function (name, successCallback, errorCallback){
        exec(successCallback, errorCallback, PLUGIN_NAME, "OtpVirtual4", [name]);
  }
};

module.exports = MiPlugin;

});
