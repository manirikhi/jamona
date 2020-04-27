package com.ems.blog.web.mvc.controller.ajax;

import java.io.IOException;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Post;
import com.ems.blog.model.Rate;
import com.ems.blog.service.PostServiceImpl;
import com.ems.blog.web.mvc.json.JsonRequest;
import com.ems.blog.web.mvc.json.JsonRpc;

@Controller
public class PostAjaxController {
	private static final Logger LOGGER = Logger.getLogger(PostAjaxController.class);
	@Autowired
	@Qualifier("postService")
	private PostServiceImpl postService;
	
	@RequestMapping(value="ajax/savePost", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Boolean> savePost(@Valid @RequestBody Post post,BindingResult result) throws BlogException {
		if(result.hasErrors()){
			throw new BlogException(result.getFieldError().getDefaultMessage());
		}
		return new JsonRpc<Boolean>(postService.savePost(post));
	}

	@RequestMapping(value="ajax/posts", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Page<Post>> getPosts(@RequestBody JsonRequest jsonRequest) throws BlogException {
		return new JsonRpc<Page<Post>>(postService.getPostList(jsonRequest));
	}
	
	@RequestMapping(value="ajax/postsSearch", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Page<Post>> getPostsBySearch(@RequestBody JsonRequest jsonRequest) throws BlogException {
		return new JsonRpc<Page<Post>>(postService.getPostListBySearch(jsonRequest));
	}

	@RequestMapping(value="ajax/deletePost", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<Boolean> deleteUser(@RequestParam String  postId) throws BlogException {
		return new JsonRpc<Boolean>(postService.deletePost(postId));
	}
	
	@RequestMapping(value="/Posts/update", method = RequestMethod.PUT)
	@ResponseBody
	public JsonRpc<Boolean> updateUser(@Valid @RequestBody Post post) throws BlogException {
		return new JsonRpc<Boolean>(postService.updatePost(post));
	}
	
	@RequestMapping(value="ajax/post", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<Post> getUserById(@RequestParam("postId") String  postId) throws BlogException {
	    return new JsonRpc<Post>(postService.getPostById(postId));
	}
	
	@RequestMapping(value="ajax/postHitCount")
	@ResponseStatus(value = HttpStatus.OK)
	public void postHitCount(@RequestParam("id") String id){
		postService.updateHitCount(id);
	}
	
	@RequestMapping(value="ajax/updatePostRating", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Boolean> updatePostRating(@RequestParam("postId") String  postId,@RequestBody Rate rate) throws BlogException, JsonParseException, JsonMappingException, IOException {
		return new JsonRpc<Boolean>(postService.updatePostRating(postId, rate));
	}
}
