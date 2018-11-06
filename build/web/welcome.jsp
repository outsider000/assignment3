<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <Style>
    h1,p{text-align: center;}
    .bookName{ font-family: 'Courier New', Courier, monospace; font-size: large;}
    table{
    margin:auto;
    }
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Message</title>
             <jsp:useBean id="ub" class="mbs.myBean" scope="session" />
    </head>
    <body>

    <h1>Create User</h1>
    <div>
        <h1>Welcome</h1>
                <p><jsp:getProperty name="ub" property="name" /></p>
                <p><jsp:getProperty name="ub" property="status" /></p>
                </div>
    <BR/><BR/>
    </body>
</html>
