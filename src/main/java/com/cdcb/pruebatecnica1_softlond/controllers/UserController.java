package com.cdcb.pruebatecnica1_softlond.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter; 

import com.cdcb.pruebatecnica1_softlond.services.*;
import com.cdcb.pruebatecnica1_softlond.domain.*;
import com.cdcb.pruebatecnica1_softlond.repositories.*;

public class UserController extends HttpServlet {
	private IService<User> userService 
		= new UserService(new UserRepository("banco.db"));

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("User");
		resp.setContentType("application/json");
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
