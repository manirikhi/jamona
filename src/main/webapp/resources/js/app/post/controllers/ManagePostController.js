/**
 * compose new post controller
 */
(function() {
    'use strict';
    app.controller("ManagePostController",['$scope','postService','$rootScope','dialogs',
                                            function($scope,postService,$rootScope,dialogs) {
    	$scope.deletePost = function(postId){
    		postService.deletePost(postId).then(function(data){
    			var dlg = dialogs.confirm();
    			dlg.result.then(function(result){
    				if(data.error){
    					dialogs.notify('Notificacion','Error while deleting post',{size:'sm'});
    				}
    				else{
    					$rootScope.listUserPosts($rootScope.userEmail);
    					dialogs.notify('Notificacion','Post deleted successfully!',{size:'sm'});
    				}
				});
    			
    			
    		});
    	}
}]);
		
})();