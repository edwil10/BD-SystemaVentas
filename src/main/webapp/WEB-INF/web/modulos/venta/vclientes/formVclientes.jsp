<%-- 
    Document   : formVclientes
    Created on : 05-dic-2018, 12:45:25
    Author     : edwil
--%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<script src='/webjars/AdminLTE/2.4.2/bower_components/jquery/dist/jquery.min.js'></script>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Main content -->
    <section class="content">    
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Formulario de Registro Ventas Detalles</h3>
            </div>
            <c:url var="urlsave" value="${pageContext.request.contextPath}/${urlAccion}" />
            <frm:form modelAttribute="modeloVclientes" method="post" action="${urlsave}" class="form-horizontal" >

                <div class="box-body">
                    <div class="form-group">
                        <frm:hidden path="idCliente" />
                        <frm:label path="nombre" class="col-sm-2 control-label" >Nombre</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="nombre" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="paterno" class="col-sm-2 control-label" >Paterno</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="paterno" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="materno" class="col-sm-2 control-label" >Materno</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="materno" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="estado" class="col-sm-2 control-label" >estado</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="estado" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idTipoCliente.idTipoCliente" class="col-sm-2 control-label" >IdTipoCliente</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idTipoCliente.idTipoCliente" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="ruc" class="col-sm-2 control-label" >RUC</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="ruc" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="numdoc_ident" class="col-sm-2 control-label" >Nº doc ident</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="numdoc_ident" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="fecha_nacimiento" class="col-sm-2 control-label" >Fecha nacimiento</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="fecha_nacimiento" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idTipodocidentidad.idTipodocidentidad" class="col-sm-2 control-label" >IdTipodocidentidad</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idTipodocidentidad.idTipodocidentidad" class="form-control" />
                        </div>
                    </div>
                    
                    <div class="form-group">                    
                        <frm:label path="celularcontacto" class="col-sm-2 control-label" >Celular contacto</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="celularcontacto" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idCodigoPostal.idCodigoPostal" class="col-sm-2 control-label" >IdCodigoPostal</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idCodigoPostal.idCodigoPostal" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="direccion_fiscal" class="col-sm-2 control-label" >Direccion fiscal</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="direccion_fiscal" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="direccion" class="col-sm-2 control-label" >Direccion</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="direccion" class="form-control" />
                        </div>
                    </div>                                       
                    
  
                </div>
                <!-- /.box-body -->

               
                    <div class="box-footer" style="margin-left: 80px">                
                        <input type="submit" value="Guardar" class="btn btn-primary" />
                
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/vcliMain" class="btn btn-primary">Cancelar</a> 
                </div>            
            </frm:form>
        </div>

    </section> 
    <script type="text/javascript">
        $(function () {
            //$('#datetimepicker1').datetimepicker();
            $('#datepicker').datepicker({
                //format: 'dd-MMM-yyyy'
                format: 'yyyy/mm/dd'
            });

            var dato = $('#datepicker').val();
            var dato2 = dato.replace('-', '/')

            $('#datepicker').val(dato2.replace('-', '/'));
            //alert(dato2.replace('-','/'));
        });
    </script>     
</div> 
