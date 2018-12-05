<%-- 
    Document   : formVentasDetalles
    Created on : 05-dic-2018, 7:39:19
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
            <frm:form modelAttribute="modelovtc" method="post" action="${urlsave}" class="form-horizontal" >

                <div class="box-body">
                    <div class="form-group">
                        <frm:hidden path="idVentaDetalle" />
                        <frm:label path="idVenta" class="col-sm-2 control-label" >IdVentas</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idVenta" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="dc" class="col-sm-2 control-label" >DC</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="dc" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="detalle" class="col-sm-2 control-label" >Detalle</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="detalle" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="cantidad" class="col-sm-2 control-label" >Cantidad Doc</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="cantidad" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="preciounit" class="col-sm-2 control-label" >Precio Unitario</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="preciounit" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="base_imp" class="col-sm-2 control-label" >base Imponible</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="base_imp" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="igv" class="col-sm-2 control-label" >IGV</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="igv" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="importe" class="col-sm-2 control-label" >Importe</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="importe" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="estado" class="col-sm-2 control-label" >Estado</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="estado" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="exonerados" class="col-sm-2 control-label" >Exonerados</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="exonerados" class="form-control" />
                        </div>
                    </div>
                    
                    <div class="form-group">                    
                        <frm:label path="inafectos" class="col-sm-2 control-label" >Inafectos</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="inafectos" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="impuestoigv" class="col-sm-2 control-label" >Impuesto IGV</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="impuestoigv" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="fecha_entrega" class="col-sm-2 control-label" >Fecha Entrega</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="fecha_entrega" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idTrabajador" class="col-sm-2 control-label" >IdTrabajador</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idTrabajador" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idAlmacenProducto.idAlmacenProducto" class="col-sm-2 control-label" >IdAlmacenProducto</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idAlmacenProducto.idAlmacenProducto" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idMovVnt.idMovVnt" class="col-sm-2 control-label" >IdMovVnt</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idMovVnt.idMovVnt" class="form-control" />
                        </div>
                    </div>
                    
                </div>
                <!-- /.box-body -->

               
                    <div class="box-footer" style="margin-left: 80px">                
                        <input type="submit" value="Guardar" class="btn btn-primary" />
                
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/ventDMain" class="btn btn-primary">Cancelar</a> 
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


