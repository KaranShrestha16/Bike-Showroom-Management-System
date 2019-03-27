 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Add Purchase</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">
  <!-- daterange picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap-daterangepicker/daterangepicker.css">
  <!-- bootstrap datepicker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- iCheck for checkboxes and radio inputs -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/iCheck/all.css">
  <!-- Bootstrap Color Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
  <!-- Bootstrap time Picker -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.css">
  <!-- Select2 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/select2/dist/css/select2.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support o${pageContext.request.contextPath}/resources/f HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="staffDashboard" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">Bike Showroom</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
      
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
               <img src="${pageContext.request.contextPath}/resources/images/${imageName}" height="30" width="30" class="img-circle"  alt="User Image" >
               <span class="hidden-xs">${ activeUser }</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                 <img src="${pageContext.request.contextPath}/resources/images/${imageName}" height="30" width="30"  class="img-circle"  alt="User Image" >
                <p>
                 ${activeUser}
                </p>
              
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="staffProfile" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="logout" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
     <img src="${pageContext.request.contextPath}/resources/images/${imageName}" height="30" width="30"  class="img-circle" width="120px"  height="120px" alt="User Image" >
          </div>
        <div class="pull-left info">
          <p>${activeUser }</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
   <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>      
       <li class="  treeview menu-open">
          <a href="staffDashboard">
            <i class="fa fa-dashboard  "></i> <span>Dashboard</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="staffDashboard"><i class="fa fa-circle-o"></i> Dashboard</a></li>
            
          </ul>
        </li>
        
          
        
         <li class=" treeview menu-open">
          <a href="addCustomer">
            <i class="fa  fa-user "></i> <span>Customer</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li ><a href="addCustomer"><i class="fa fa-circle-o"></i> Add Customer</a></li>
            <li ><a href="viewCustomerStaff"><i class="fa fa-circle-o"></i> View Customer</a></li>
          </ul>
        </li>
          
          <li class=" treeview menu-open">
          <a href="addSupplier">
            <i class="fa  fa-truck "></i> <span>Supplier</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a  href="addSupplier"><i class="fa fa-circle-o"></i> Add Supplier</a></li>
            <li> <a href="viewSuppliersStaff"><i class="fa fa-circle-o"></i> View Supplier</a></li>
          </ul>
        </li>
        
         <li class="active treeview menu-open">
          <a href="addPurchase">
            <i class="fa fa-shopping-bag"></i> <span>Purchase</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class=" treeview-menu">
            <li class="active"><a href="addPurchase"><i class="fa fa-circle-o"></i> Add Purchase</a></li>
            <li ><a href="viewPurchaseStaff"><i class="fa fa-circle-o"></i> View Purchase</a></li>
          </ul>
        </li>
        
          <li class="treeview menu-open">
          <a href="addProduct">
            <i class="fa fa-briefcase"></i> <span>Product</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
		    <li ><a href="addProduct"><i class="fa fa-circle-o"></i> Add Product</a></li> 
            <li ><a href="viewProductStaff"><i class="fa fa-circle-o"></i> View Product</a></li>
          </ul>
        </li>
        
        
         <li class=" treeview menu-open">
          <a href="viewSales">
            <i class="fa fa-shopping-cart"></i> <span>Sales</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="addSales"><i class="fa fa-circle-o"></i> Add Sales</a></li>
            <li ><a href="viewSalesStaff"><i class="fa fa-circle-o"></i> View Sales</a></li>
          </ul>
        </li>      
        
           
         <li class=" treeview menu-open">
          <a href="Report">
            <i class="fa fa-calendar"></i> <span>Report</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="purchaseReoprt"><i class="fa fa-circle-o"></i> Purchase Report</a></li>
            <li ><a href="salesReport"><i class="fa fa-circle-o"></i> Sales Report</a></li>
          </ul>
        </li>    
         
         <li class=" treeview menu-open">
          <a href="generateBill">
            <i class="fa fa-file-text"></i> <span>Bill</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="generateBill"><i class="fa fa-circle-o"></i> Generate Bill</a></li>
          </ul>
        </li>
        
        <li class=" treeview menu-open">
          <a href="help">
            <i class="fa fa-file-text"></i> <span>Help</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="help"><i class="fa fa-circle-o"></i> Help</a></li>
          </ul>
        </li>
        
     </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
      Add Purchase
        <small>Preview</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="staffDashboard"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li><a href="addProduct">Purchase</a></li>
         <li><a href="addProduct"> Add Purchase</a></li>
        
        
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- SELECT2 EXAMPLE -->
      <div class="box box-default">
        <div class="box-header with-border">
          

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
          </div>
        </div>
        <!-- /.box-header -->
        <div class="box-body">
          <div class="row">
            <div class="col-md-12" >
            <form action="addPurchase" method="post" enctype="multipart/form-data">
              <div class="box-body">
              
			<div class="col-xs-5">
                <label>Purchase Date</label>
                <div class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" name="purchase_date" class="form-control pull-right" id="datepicker" required>
                </div>
                <!-- /.input group -->
              </div>
              
				<div class="col-xs-5">
                <label>Supplier Name</label>
                <select class="form-control select2" name="supplierName" style="width: 100%;">
                  <option selected="selected" value="">Please Select Supplier Name</option>
                  <c:forEach var="supplier" items="${supplierList}">
                  <option value ="${supplier.supplierName }">${ supplier.supplierName}</option>
                  </c:forEach>
                </select>
                
                </div>
                
                
            
                <div class="col-xs-5">
                <label>Product Name</label>
                <select class="form-control select2" name="productName"    id="pp" style="width: 100%;">
                  <option selected="selected" value="">Please Select Product Name</option>
                  <c:forEach var="product"   items="${productList}">
                  <option value ="${product.productName}"  >${ product.productName}</option>
                  </c:forEach>
                </select>
                </div>
                
                
               
                

              <div class="col-xs-5">
                 <label>Purchase Price<small>(Per Each)</small></label>
                 <div class="input-group">
	                <span class="input-group-addon">$</span>
	                <input type="number"  name="purchasePrice" id="price" class="form-control"  >
	                <span class="input-group-addon">.00</span>
	           </div>
             </div>
              <div class="col-xs-5">
                 <label>Sales Price<small>(Per Each)</small></label>
                 <div class="input-group">
	                <span class="input-group-addon">$</span>
	                <input type="number"  name="salesPrice" class="form-control"  >
	                <span class="input-group-addon">.00</span>
	           </div>
             </div>
             
               <div class="col-xs-5">
                 <label>Quantity</label>
                 <div class="input-group">
	                <span class="input-group-addon">$</span>
	                <input type="number" name="quantity" onkeyup="find()" id="quantity" class="form-control"  >
	                <span class="input-group-addon">.00</span>
	            </div>
             </div>
             
             
              <div class="col-xs-5">
                 <label>Total Price</label>
                 <div class="input-group">
	                <span class="input-group-addon">$</span>
	                <input type="text" name="totalPurchase" id="total"  class="form-control"  >
	                <span class="input-group-addon">.00</span>
	            </div>
	          
	            
	           
             </div>                                   
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary"> Purchased</button>
              </div>
               </form>
            
            
            
         	</div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
        </div>
        <!-- /.box-body -->
        

               
    <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer>

  
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- InputMask -->
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<!-- date-range-picker -->
<script src="${pageContext.request.contextPath}/resources/bower_components/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- bootstrap color picker -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
<!-- bootstrap time picker -->
<script src="${pageContext.request.contextPath}/resources/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="${pageContext.request.contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<!-- Page script -->

<!-- Page script -->
<script >




  $(function () {
    //Initialize Select2 Elements
    $('.select2').select2()

  

    //Date picker
    $('#datepicker').datepicker({
      autoclose: true
    })
   
  })
  
  function find() {
    
    var price= document.getElementById('price').value;
    var quantity= document.getElementById('quantity').value;
	var total=price*quantity;
    document.getElementById('total').value =total;
   
    
  }
  
  function getproduct(){
	  
	  var productId =  document.getElementById('productId').value; //b
      var req;
      if(window.XMLHttpRequest)
      {
        req = new XMLHttpRequest();
        
      }
      else req = new ActiveXObject("Microsoft.XMLHTTP");
      req.onreadystatechange = function()
      {
        if(req.readyState==4)
        {
          document.getElementById('error').innerHTML = req.responseText;
        }
      
    req.open("GET", "jsGetProductDetails?productId="+productId, true);
    req.send();
    }
  
  
  }


  
</script>

</body>
</html>

