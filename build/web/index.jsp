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
                    <script type="text/javascript">
            function myCheck()
            {
               for(var i=0;i<document.form1.elements.length-1;i++)
               {
                  if(document.form1.elements[i].value=="")
                  {
                     alert("No Empty Input Allowed");
                     document.form1.elements[i].focus();
                     return false;
                  }
               }
               return true;
            }
        </script>
            <jsp:useBean id="ub" class="mbs.myBean" scope="session" />
    </head>
    <body>

    <h1>Create User</h1>
    <div>
    <form name="form1" method ="post" action = "submitMessage1" onsubmit="return myCheck()">
        <table border="1">
            <tbody>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="username" value="" size="50" /></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" value="" size="50" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create User" name="Submit" /></td>
                </tr>
            </tbody>
        </table>
   </form>  
    </div>
        <h1>Login</h1>
        <div>
    <form name="form2" method ="post" action = "reviewMessage" >
        <table border="1">
            <tbody>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="username" value="" size="50" /></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" value="" size="50" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" name="Submit" /></td>
                </tr>
            </tbody>
        </table>
       </form>  
            </div>
   <h1>Delete User</h1>
       <div>
   </form>  
       <form name="form3" method ="post" action = "submitMessage2">
        <table border="1">
            <tbody>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="username" value="" size="50" /></td>
                </tr>
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" value="" size="50" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete" name="Submit" /></td>
                </tr>
            </tbody>
        </table>
   </form>  
                </div>
    <BR/><BR/>
    </body>
</html>
