/**
 * compose new post controller
 */
(function() {
    'use strict';
    app.controller("MainController",['$rootScope','parseCookie','$state','$scope','$window','postService','localStorageService','commentService',
                                     function($rootScope,parseCookie,$state,$scope,$window,postService,localStorageService,commentService) {
    /*	$rootScope.parseCookie = function(cookie){
    		var val = $cookies.get(cookie);
        	if(val)
        		return val.substring(1,val.length-1);
    	};*/
    	console.log('main Controller');
  /*  	// Default config to set rating defaults
    	function initDefaults(){
    		$rootScope.userEmail = parseCookie.getCookie('email');
    		$rootScope.userName = parseCookie.getCookie('userName');
			$rootScope.userCreationDate = parseCookie.getCookie('creationDate');
			$rootScope.userId = parseCookie.getCookie('userId');
			$rootScope.max = 5;
	    	$rootScope.isReadonly = false;
    	}
    	
    	$rootScope.hoveringOver = function(value) {
    		$rootScope.overStar = value;
    		$rootScope.percent = 100 * (value / $rootScope.max);
		};
		
    	function initPost(postId,permalink){
    			$state.go('blogs.view',{ postId : postId,permalink : permalink });
    			postService.getPost(postId).then(function(data){
					if(data.data.error){
						dialogs.notify('Notificacion',data.data.message,{size:'sm'});
					}
					else{
						if(data.data.result){
							$rootScope.post = data.data.result;
							commentService.getComments(postId).then(function(data) {
								$rootScope.comments = data.data.result;
							});
						}
						else{
							initPosts();
						}
						
					}
				});
    	}; 
    	
    	function initPosts(){
    		$state.go('blogs');
    		var criteria = {
    				pageRequest : {
    					start : 0,
    					limit : 5,
    					field : 'id',
    					dir : "DESC",
    					page : 1
    				},
    				filter : {},
    				includeList : {
    					fields : [ 'title','creationDate','authorId','authorName','authorEmail','category','shortContent','hitCount','rating','tags','permalink' ]
    				}
    			};
    			postService
    					.getPosts(criteria)
    					.then(
    							function(data) {
    								$rootScope.posts = data.data.result.content;
    								$rootScope.totalPosts = data.data.result.totalElements;
    								localStorageService.set('posts',data.data.result.content);
    								localStorageService.set('totalPosts',data.data.result.totalElements);
    							});
    	}
    	
    	function initilize(){
    		initDefaults();
    		var hash = $window.location.hash;
    		var hashList = hash.split('/');
    		if(hash.indexOf('/view/') != -1){
    			var postId = hashList[hashList.length-2];
    			var permalink = hashList[hashList.length-1];
    			console.log('post id '+postId);
    			console.log('permalink id '+permalink);
    			if(postId != undefined && postId != null && postId != "" && postId.length > 0){
    				initPost(postId,permalink);
    			}
    			else{
    				initPosts();
    			}
    		}else{
    			if(hash.indexOf('/blogs') != -1){
        			initPosts();
        		}
    		}
    		
    	};
    	
    	initilize();*/
}]);

})();