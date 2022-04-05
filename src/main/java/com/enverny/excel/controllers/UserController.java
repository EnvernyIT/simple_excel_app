package com.enverny.excel.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.enverny.excel.ExcelMethods.UserExcelExporter;
import com.enverny.excel.entities.User;
import com.enverny.excel.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	private UserServices userService;
	
    @GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<User> listUsers = userService.listAll();
         
        UserExcelExporter excelExporter = new UserExcelExporter(listUsers);
         
        excelExporter.export(response);    
    }  

}
