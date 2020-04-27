package com.ems.blog.web.mvc.controller.ajax;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ems.blog.exception.BlogException;
import com.ems.blog.model.Comment;
import com.ems.blog.service.CommentServiceImpl;
import com.ems.blog.web.mvc.json.JsonRpc;
import com.ems.blog.web.mvc.json.UpdateRequest;


@Controller
public class CommentAjaxController {
	@Autowired
	CommentServiceImpl commentService;
	
	@RequestMapping(value="/ajax/saveComment", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Boolean> savePost(@Valid @RequestBody Comment comment,BindingResult result) throws BlogException {
		if(result.hasErrors()){
			throw new BlogException(result.getFieldError().getDefaultMessage());
		}
		return new JsonRpc<Boolean>(commentService.addComment(comment));
	}
	
	@RequestMapping(value="/ajax/comments", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<List<Comment>> getComments(String postId) throws BlogException {
		return new JsonRpc<List<Comment>>(commentService.getComments(postId));
	}

	@RequestMapping(value="/ajax/updateComment", method = RequestMethod.PUT)
	@ResponseBody
	public JsonRpc<Boolean> updateComment(@Valid @RequestBody Comment Comment) throws BlogException {
		return new JsonRpc<Boolean>(commentService.updateComment(Comment));
	}
	
	@RequestMapping(value="/ajax/updateComment", method = RequestMethod.POST)
	@ResponseBody
	public JsonRpc<Boolean> updateComment(@RequestBody UpdateRequest updateRequest) throws BlogException {
		return new JsonRpc<Boolean>(commentService.update(updateRequest));
	}
	
	@RequestMapping(value="/ajax/deleteComment", method = RequestMethod.GET)
	@ResponseBody
	public JsonRpc<Boolean> deleteComment(@RequestParam("commentId") String commentId) throws BlogException {
		return new JsonRpc<Boolean>(commentService.deleteComment(commentId));
	}
}