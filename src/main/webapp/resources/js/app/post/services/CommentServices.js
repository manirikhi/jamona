/**
 * comment services CRUD ajax calls
 */
(function() {
    "use strict";
        
    app.service('commentService', ['$http', function ($http){       	

        	this.getComments = function(postId) {
        		return $http.get('ajax/comments.ajax',{params:{ postId : postId }});         		
        	};
        	this.deleteComment = function(commentId) {
        		return $http.get('ajax/deleteComment.ajax',
                		{	params: {
                			commentId : commentId 
                			}});         		
        	};
        	this.saveComment = function(comment) {
                return $http.post('ajax/saveComment.ajax',comment);         		
        	};
        	this.updateCommentObject = function(comment) {
                return $http.put('ajax/updateComment.ajax',comment);         		
        	};
        	this.updateComment = function(updateRequest) {
                return $http.post('ajax/updateComment.ajax',updateRequest);         		
        	};
        }]);           
})();