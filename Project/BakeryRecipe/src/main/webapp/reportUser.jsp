<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <c:import url="universal.jsp" />

        <title>User Reports</title>

        <!-- Custom fonts for this template -->
        <link href="admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
        <link href="assets/css/elestyle.css" rel="stylesheet"> 
        <!-- Custom styles for this page -->
        <link href="admin/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">


    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="AdminDashBoard">
                    <div class="sidebar-brand-text mx-3">BakeryRecipe</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="AdminDashBoard">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Social network
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link" href="manageuser">
                        <i class="fa-solid fa-user"></i>
                        <span>Users</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="managerecipe">
                        <i class="fa-solid fa-bread-slice"></i>
                        <span>Recipes</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="commentlist">
                        <i class="fa-solid fa-comment"></i>
                        <span>Comments</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Report from users
                </div>

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item active">
                    <a class="nav-link" href="reportUser">
                        <i class="fa-solid fa-user"></i>
                        <span>Users report</span></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="reportrecipe">
                        <i class="fa-solid fa-bread-slice"></i>
                        <span>Recipes report</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="reportCmtList">
                        <i class="fa-solid fa-comment"></i>
                        <span>Comments report</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a href="home" class="btn btn-primary btn-home btn-icon-split">
                            <span class="icon text-white-50">
                                <i class="fa-solid fa-house"></i>
                            </span>
                            <span class="text">Back to home</span>
                        </a>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.login.name}</span>
                                    <img class="img-profile rounded-circle" src="${sessionScope.login.avatar}">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                     aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="profile.jsp">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <a class="dropdown-item" href="profileInfo.jsp">
                                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Setting
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800">User Reports</h1>
                        <p class="mb-4">User Reports is a table used to view a list of user reports about other users for invalid actions.</p>

                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">User Reports Table</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Id</th>
                                                <th>Avatar</th>
                                                <th>User</th>
                                                <th>Report Type</th>
                                                <th>Details</th>
                                                <th>Date Report</th>
                                                <th>User Report</th>
                                                <th>User status</th>
                                                <th>Report State</th>
                                                <th>User action</th>
                                                <th>Report action</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Id</th>
                                                <th>Avatar</th>
                                                <th>User</th>
                                                <th>Report Type</th>
                                                <th>Details</th>
                                                <th>Date Report</th>
                                                <th>User Report</th>
                                                <th>User status</th>
                                                <th>Report State</th>
                                                <th>User action</th>
                                                <th>Report action</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <c:forEach items="${reportuser}" var="u">
                                                <tr class="col-12 ml-auto mr-auto col">
                                                    <td class="align-middle style col-1">${u.id}</td>
                                                    <td class="col-1">
                                                        <img class="p-1 d-block w-100" src="${u.avatar}" style="aspect-ratio: 1 / 1; border: 2px solid gray;" alt="">
                                                    </td>
                                                    <td class="align-middle style col-2">${u.username}</td>
                                                    <td class="align-middle style col-1">${u.reportType}</td>
                                                    <td class="align-middle style col-2">${u.detail}</td>
                                                    <td class="align-middle style align-items-center col-2 text-nowrap">${u.getDateReport()}</td>
                                                    <td class="align-middle style col-1">${u.reporter}</td> 
                                                    <td class="align-middle col-1">
                                                        <c:if test="${u.checkStatus == 'false'}">
                                                            <span class="text-danger">Banned</span>
                                                        </c:if>
                                                        <c:if test="${u.checkStatus == 'true'}">
                                                            <span class="text-success">Active</span>
                                                        </c:if>
                                                    </td>
                                                    <td class="align-middle align-items-center col-1 text-nowrap">
                                                        <c:choose>
                                                            <c:when test="${u.status == 'Approved'}">
                                                                <c:set var="status" value="green"></c:set>
                                                            </c:when>
                                                            <c:when test="${u.status == 'Denied'}">
                                                                <c:set var="status" value="red"></c:set>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <c:set var="status" value="blue"></c:set>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <div style="color: ${status}"><b> ${u.status}</b></div>
                                                    </td>
                                                    <td class="align-middle col-1">

                                                        <form action="profile" class="d-inline">
                                                            <input type="hidden" name="userid" value="${u.userid2}">
                                                            <button class="btn btn-info btn-circle btn-sm" title="User Profile"><i class="fas fa-info-circle"></i></button>
                                                        </form>
                                                        <c:if test="${u.userRole eq 'baker'}">
                                                            <form action="reportuser" class="d-inline" onsubmit="return confirm('Do you really want to ban this user?');">
                                                                <button class="btn btn-danger btn-circle btn-sm" title="Ban"><i class="fa-solid fa-ban"></i></button>
                                                                <input type="hidden" name="userid" value="${u.userid2}">
                                                                <input type="hidden" name="active" value="false">
                                                                <input type="hidden" name="action" value="changestatus">
                                                            </form>
                                                        </c:if>
                                                        <c:if test="${u.userRole eq 'admin'}">
                                                            <form action="reportuser" class="d-inline" onsubmit="return confirm('Do you really want to remove this admin?');">
                                                                <button class="btn btn-warning btn-circle btn-sm" title="Remove Admin"><i class="fa-solid fa-user-minus"></i></button>
                                                                <input type="hidden" name="userid" value="${u.userid2}">
                                                                <input type="hidden" name="action" value="changerole">
                                                                <input type="hidden" name="role" value="baker">
                                                            </form>
                                                        </c:if>

                                                    </td>
                                                    <td class="align-middle col-1">
                                                        <div class="d-flex flex-wrap ">
                                                            <form action="reportuser" class="flex-grow-1" onsubmit="return confirm('Do you really want to approve/deny this report?');">
                                                                <input type="hidden" name="reportID" value="${u.id}">
                                                                <c:if test="${u.status == 'Process'}">
                                                                    <button class="btn btn-success btn-circle btn-sm" name="action" title="Approve Report" value="Approved"><i class="fa-solid fa-check"></i></button>
                                                                    <button class="btn btn-danger btn-circle btn-sm" name="action" title="Deny Report" value="Denied"><i class="fa-solid fa-x"></i></button>
                                                                    </c:if>
                                                            </form>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; BakeryRecipe 2022</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="admin/vendor/jquery/jquery.min.js"></script>
        <script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="admin/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="admin/vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="admin/js/demo/datatables-demo.js"></script>

        <script>
                                                                $('#dataTable').dataTable({
                                                                    "order": [0, "desc"]
                                                                });
        </script>
    </body>
</html>
