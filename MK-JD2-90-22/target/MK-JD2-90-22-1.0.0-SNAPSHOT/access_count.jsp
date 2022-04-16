<%@ page language="java"
        contentType="text/html; cgarset=UTF-8"
        pageEncoding="UTF-8"%>
<%! private int accessCount = 0; %>
<h1>Колличество обращений к странице с момента загрузки сервера:</h1>
<%= ++accessCount %>