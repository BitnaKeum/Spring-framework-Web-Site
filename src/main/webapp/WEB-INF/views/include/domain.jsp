<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>KWANG : Food Review Site</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/modern-business.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <header>
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner" role="listbox">
          <!-- Slide One - Set the background image for this slide in the line below -->
          <div class="carousel-item active" style="background-image: url('http://www.foodmadang.co.kr/userImage/SP0063/menu/0820%20385.jpg')">
            <div class="carousel-caption d-none d-md-block">
              <h3>No.1 Korea Food Review Site KWANG</h3>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Page Content -->
    <div class="container">

      <h1 class="my-4">Welcome to KWANG! we are korea no.1 food review site</h1>

      <!-- Marketing Icons Section -->
      <div class="row">
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">SEOUL</h4>
            <div class="card-body">
              <p class="card-text">Move to the SEOUL area review board</p>
            </div>
            <div class="card-footer">
           
              <button id='regBtn' type="button" onclick="location.href='/board/list_SEOUL'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">GYEONGGI </h4>
            <div class="card-body">
              <p class="card-text">Move to the GYEONGGI area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_GYEONGGI'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">INCHEON</h4>
            <div class="card-body">
              <p class="card-text">Move to the INCHEON area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_INCHEON'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        
          <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">DAEJEON </h4>
            <div class="card-body">
              <p class="card-text">Move to the DAEJEON area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_DAEJEON'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        
         <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">CHUNGCHEONG</h4>
            <div class="card-body">
             <p class="card-text">Move to the CHUNGCHEONG area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_CHUNGCHEONG'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        
         <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">KANGWON</h4>
            <div class="card-body">
              <p class="card-text">Move to the KANGWON area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_KANGWON'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        
         <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">DAEGU</h4>
            <div class="card-body">
              <p class="card-text">Move to the DAEGU area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_DAEGU'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">JEOLLA</h4>
            <div class="card-body">
              <p class="card-text">Move to the JEOLLA area review board</p>
            </div>
            <div class="card-footer">
             <button id='regBtn' type="button" onclick="location.href='/board/list_JEOLLA'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">BUSAN</h4>
            <div class="card-body">
              <p class="card-text">Move to the BUSAN area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_BUSAN'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">GYEONGSANG</h4>
            <div class="card-body">
              <p class="card-text">Move to the GYEONGSANG area review board</p>
            </div>
            <div class="card-footer">
              <button id='regBtn' type="button" onclick="location.href='/board/list_GYEONGSANG'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
        <div class="col-lg-4 mb-4">
          <div class="card h-100">
            <h4 class="card-header">JEJU</h4>
            <div class="card-body">
              <p class="card-text">Move to the JEJU area review board</p>
            </div>
            <div class="card-footer">
             <button id='regBtn' type="button" onclick="location.href='/board/list_JEJU'" class="btn btn-primary">MOVE</button>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

      <!-- Portfolio Section -->
      <h2>List of recently reviewed restaurants</h2>
       <div class="row">
     <c:forEach var="boardVO" items="${list}">
        <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card-body">
              <h4 class="card-title">
                <a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a>
              </h4>
              <p class="card-text">${boardVO.content}</p>
            </div>
        </div>
      </c:forEach>
       </div>
      <!-- /.row -->

  
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; TEAM 12</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
