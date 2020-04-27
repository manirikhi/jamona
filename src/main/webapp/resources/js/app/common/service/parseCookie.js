/**
 * Post services CRUD ajax calls
 */
(function() {
    "use strict";
        app.factory('parseCookie', function($cookies) {
            var factory = {};
            
            factory.getCookie = function(cookie) {
            	var val = $cookies.get(cookie);
            	if(val)
            		return val.substring(1,val.length-1);
            };
            return factory;
         });
})();