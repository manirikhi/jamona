/**
 * User services CRUD ajax calls
 */

  "use strict";
        
    app.service('userService', ['$http', function ($http){       	
        	this.saveUser = function(user) {
                return $http.post('ajax/saveUser.ajax', 
                		user);         		
        	};
        	this.userList = function(jsonRequest){
        		return $http.post('ajax/users.ajax',jsonRequest);
        	};
        	this.deleteUser = function(userId){
        		return $http.get('ajax/deleteUser.ajax',{params:{ userId : userId }});
        	};
        	this.updateUser = function(user) {
                return $http.put('ajax/updateUser.ajax', 
                		user);         		
        	};
         }]);           
