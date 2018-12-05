<%-- 
    Document   : formVentas
    Created on : 04-dic-2018, 21:09:38
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
                <h3 class="box-title">Formulario de Registro Ventas</h3>
            </div>
            <c:url var="urlsave" value="${pageContext.request.contextPath}/${urlAccion}" />
            <frm:form modelAttribute="modelovtc" method="post" action="${urlsave}" class="form-horizontal" >

                <div class="box-body">
                    <div class="form-group">
                        <frm:hidden path="idMovVnt" />
                        <frm:label path="idVenta" class="col-sm-2 control-label" >IdVentas</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idVenta" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="tipo_venta" class="col-sm-2 control-label" >Tipo Ventas</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="tipo_venta" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="fecha_venta" class="col-sm-2 control-label" >Fecha Ventas</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="fecha_venta" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="fecha_doc" class="col-sm-2 control-label" >Fecha Doc</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="fecha_doc" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="fecha_venc" class="col-sm-2 control-label" >Fecha Venc</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="fecha_venc" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="serie" class="col-sm-2 control-label" >Serie</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="serie" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="numvnt" class="col-sm-2 control-label" >Numero venta</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="numvnt" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="export_import" class="col-sm-2 control-label" >Expor e Impor</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="export_import" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="glosa" class="col-sm-2 control-label" >Glosa</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="glosa" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="base_imp" class="col-sm-2 control-label" >Base imponible</frm:label>
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
                        <frm:label path="isc" class="col-sm-2 control-label" >ISC</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="isc" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="importe" class="col-sm-2 control-label" >Importe</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="importe" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="descuento" class="col-sm-2 control-label" >Descuentos</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="descuento" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="anticipo" class="col-sm-2 control-label" >Anticipo</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="anticipo" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="saldo" class="col-sm-2 control-label" >Saldo</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="saldo" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="tipo_cambio" class="col-sm-2 control-label" >Tipo cambio</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="tipo_cambio" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="estado" class="col-sm-2 control-label" >Estado</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="estado" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="ip" class="col-sm-2 control-label" >IP</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="ip" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="mod_fecha" class="col-sm-2 control-label" >Mod fecha</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="mod_fecha" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="mod_tipo" class="col-sm-2 control-label" >Mod tipo</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="mod_tipo" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="mod_serie" class="col-sm-2 control-label" >Mod serie</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="mod_serie" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="mod_numdoc" class="col-sm-2 control-label" >Mod Nº doc</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="mod_numdoc" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="comentario" class="col-sm-2 control-label" >Comentario</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="comentario" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="obscredito" class="col-sm-2 control-label" >Obscredito</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="obscredito" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idComprobante" class="col-sm-2 control-label" >IdComprobante</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idComprobante" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idUsuario" class="col-sm-2 control-label" >IdUsuario</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idUsuario" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idTipomoneda" class="col-sm-2 control-label" >IdTipomoneda</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idTipomoneda" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idCliente" class="col-sm-2 control-label" >IdCliente</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idCliente" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">                    
                        <frm:label path="idVoucher" class="col-sm-2 control-label" >IdVoucher</frm:label>
                            <div class="col-sm-10">
                            <frm:input path="idVoucher" class="form-control" />
                        </div>
                    </div>
        

                </div>
                <!-- /.box-body -->

               
                    <div class="box-footer" style="margin-left: 80px">                
                        <input type="submit" value="Guardar" class="btn btn-primary" />
                
                    &nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/ventMain" class="btn btn-primary">Cancelar</a> 
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

