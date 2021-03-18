<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js">
    document.addEventListener('DOMContentLoaded', function() {
      var elems = document.querySelectorAll('.datepicker');
      var instances = M.Datepicker.init(elems, options);
    });    
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/
    bootstrap.min.js"></script>
   


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
   
<body style="background:url(image/natural.jpg);background-size:cover;background-attachment:fixed">
  <div class="container">
     <div class="row">
       <div class="col m4 offset-m4">
         <div class="card">
            <div class="card-content">
              <h4 style="margin-top:4px"><center>Register</center></h4>
               <div class="form center-align">
                 <form action="registerServlet" method="post" id="myform">                    
                    <input type="text" placeholder="Enter Name" name="name"/>
                    <input type="text" placeholder="Enter Father's Name" name="fname"/>
                    <input type="date" placeholder="Choose Date OF Birth" name="dob" class="datepicker">    

                    <label><input name="group1" type="radio" checked /><span>Male</span></label>
                    <label><input name="group1" type="radio" checked /><span>Female</span></label>
              
                    
     			   <input id="email" type="email" placeholder="email" class="validate">
        		   <span class="helper-text" data-error="Invalid Email id" data-success="right"></span>
      			        
                   <input type="text" placeholder="Address" name="address"/><br>
                   
                   <input type="text" id="txt_username"  placeholder="enter username" name="uname"/>
                   <!-- Response -->
                   <div id="uname_response" ></div>
                     
                  <input type="password" placeholder="Enter password" name="pswd1"/>
                  <input type="password" placeholder="Repeat Password" name="pswd2"/>
                  
                   <input type="number" placeholder="Contact number" name="contact"/>
                    <input type="text" placeholder="Designation" name="desig"/>
                    <input type="text" placeholder="Personal ID" name="id"/>
                    <input type="number" placeholder="Salary" name="salary"/>
                   
                    <input type="submit" class="btn green" value="Submit" id="register" name="register" >
                    
                    <input type="Reset" class ="btn grey" value ="Reset">
                    <input type="button" class="btn red"  value="Cancel">
                  
                 </form>
               </div>
               <div class="loader center-align" style= "margin-top:15px;display:none;">
               <div class="preloader-wrapper big active">
      <div class="spinner-layer spinner-blue">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-red">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-yellow">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>

      <div class="spinner-layer spinner-green">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>
    </div>  
               
               
               <h5>Please wait....</h5>
               </div>
            </div>
         </div>
       </div>
     
     </div>

  <script>
  
  (document).ready(function(){

     $("#txt_username").keyup(function(){

        var username = $(this).val().trim();

        if(username != ''){

           $.ajax({
              url: 'usernameCheck',
              type: 'post',
              data: {username: username},
              success: function(response){

                  $('#uname_response').html(response);

               }
           });
        }else{
           $("#uname_response").html("");
        }

      });

   });
  </script>
     
</body>
</html>