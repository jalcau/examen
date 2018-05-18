  <%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
  
  
  
   <form class="form-signin" action="consultas" method="post">     
   
   
   

      <div class="form-label-group">
        <input type="text" class="form-control"
               name="codigo" 
               value=""
               placeholder="CodigoPostal" 
               required autofocus>
               
        <label for="usuario">Codigo Postal (1-5)</label>
      </div>
 
 
 
 
  <button class="btn btn-lg btn-success btn-block" type="submit">Buscar</button>
  </form>
  
  
  <jsp:include page="templates/footer.jsp"></jsp:include>