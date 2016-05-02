<%@page import="com.brainmentors.ims.common.utils.ConfigReader"%>
<%@page import="com.brainmentors.ims.cache.dto.CacheDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.brainmentors.ims.common.utils.CacheConstants"%>
<%@page import="com.brainmentors.ims.common.listener.CacheListener"%>
<%@page import="com.brainmentors.ims.common.dao.CacheDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="Brain Mentors Pvt Ltd">
     <link rel="icon" href="images/favicon.png"> 

    <title><%=ConfigReader.getProjectName() %></title>
	<link rel="stylesheet" href="css/font-awesome.min.css">
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/robotofont.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/jumbotron.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">	

      </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a  class="navbar-brand" href="#"><i  class="fa fa-cart-plus fa-2x" aria-hidden="true"></i><%=ConfigReader.getProjectName() %></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" method="post" action="login">
            <div class="form-group input-group">
             <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw" aria-hidden="true"></i></span>
              <input type="text" name="email" placeholder="Email" class="form-control">
            </div>
            <div class="form-group input-group">
            <span class="input-group-addon"><i class="fa fa-key fa-fw" aria-hidden="true"></i></span>
              <input type="password" name="pwd" placeholder="Password" class="form-control">
            </div>
            <div class="form-group input-group">
            <span class="input-group-addon"><i class="fa fa-users" aria-hidden="true"></i></span>
               <select class="form-control ">
               
  						<%
List<CacheDTO> cacheList =CacheListener.getCacheMap(CacheConstants.ROLE_KEY);
for(CacheDTO cacheDTO : cacheList){
%>
<option <%=cacheDTO.getDesc() %>><%=cacheDTO.getValue() %></option>
<%
}
%>
  						<!--  <option>Admin</option>
						 <option>Stock keeper</option>
						  -->
				</select> 
            </div>
            <button type="submit" class="btn btn-success"><i class="fa fa-user fa-fw"></i>Sign in</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1><%=ConfigReader.getProjectFullName() %></h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>WareHouse Management</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Stock Maintain</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Report Generation</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; 2015 Company, Inc.</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.12.3.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
    
  </body>
</html>
