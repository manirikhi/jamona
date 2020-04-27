/**
 * Post services CRUD ajax calls
 */
(function() {
    "use strict";
        
    app.service('postService', ['$http', function ($http){       	

        	this.getPosts = function(jsonRequest) {
        		return $http.post('ajax/posts.ajax',jsonRequest);         		
        	};
        	
        	this.getPostsBySearch = function(jsonRequest) {
        		return $http.post('ajax/postsSearch.ajax',jsonRequest);         		
        	};
        	
        	this.getPost = function(postId) {
        		return $http.get('ajax/post.ajax',{	params: {
        			postId : postId 
    			}});         		
        	};
        	this.deletePost = function(postId) {
        		return $http.get('ajax/deletePost.ajax',
                		{	params: {
                			postId : postId 
                			}});         		
        	};
        	this.savePost = function(post) {
                return $http.post('ajax/savePost.ajax',post);         		
        	};
        	this.postHitCount = function(id) {
        		return $http.get('ajax/postHitCount.ajax',{params:{ id : id }});         		
        	};
        	this.updatePostRating = function(postId,rate) {
                return $http.post('ajax/updatePostRating.ajax',rate,{params:{ postId : postId }});         		
        	};
        }])           
})();