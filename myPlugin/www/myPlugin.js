var exec = require('cordova/exec');

exports.drmuuid = function (arg0, success, error) {
    exec(success, error, 'myPlugin', 'drmuuid', [arg0]);
};
