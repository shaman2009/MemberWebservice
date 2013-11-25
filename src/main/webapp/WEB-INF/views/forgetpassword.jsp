<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MemberApp</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">

    <!-- Add custom CSS here -->
   
    <link href= "<c:url value="/resources/css/stylish-portfolio.css" />" rel="stylesheet">
    <link href= "<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
  </head>

  <body>


  
    <!-- Full Page Image Header Area -->
    <div id="top" class="header">
      <div class="vert-text">
        <h1>Reset Password</h1>
        <h3>Please enter a new password for your <em>MemberApp</em> account in the fields below.</h3>
        <form class="form-horizontal">
          <fieldset>
          <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">New Password</label>
                <div class="controls">
                  <input type="password" style="cursor:default;" class="btn input-xlarge">
                  <p class="help-block"></p>
                </div>
              </div>

          <div class="control-group">

                <!-- Text input-->
                <label class="control-label" for="input01">Confirm</label>
                <div class="controls">
                  <input type="password" style="cursor:default;" class="btn input-xlarge">
                  <p class="help-block"></p>
                </div>
              </div>

          <div class="control-group">
                <label class="control-label"></label>

                <!-- Button -->
                <div class="controls">
                  <button class="btn btn-success">Submit</button>
                </div>
              </div>

          </fieldset>
        </form>

      </div>
    </div>
    <!-- /Full Page Image Header Area -->
  

  <!-- Bootstrap core JavaScript -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="<c:url value="/resources/js/jquery.js" />"></script>
  <script src="<c:url value="/resources/js/bootstrap.js" />"></script>


  </body>

</html>