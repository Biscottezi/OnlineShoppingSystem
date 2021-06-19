<%-- 
    Document   : BlogDetails
    Created on : Jun 19, 2021, 11:34:38 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blog Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/BlogDetails.css">
    </head>
    <body>
        
        <!--Header-->
        <%@include file="header.jsp" %>
        
        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-2">
                    <div class="col">
                        <form action="" class="col-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-9" name="txtSearchProduct">
                            <button type="submit" id="search-button" class="col-3">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <div class="category">
                            <a href="">Smartphone</a>
                        </div>
                        <div class="category">
                            <a href="">Laptop</a>
                        </div>
                        <div class="category">
                            <a href="">Smartwatch</a>
                        </div>
                        <div class="category">
                            <a href="">Earphone</a>
                        </div>
                    </div>
                </div>

                <!--Main content-->
                <div class="main-content container col-10">
                    <div class="col">
                        <h1>Tư vấn</h1>
                        <h3>Đã có giá bán dự kiến iPad Pro M1 2021 tại Thế Giới Di Động, giá khởi điểm vẫn tốt như thế hệ tiền nhiệm</h3>
                        <p>Tân Long - 19/2/2020</p>
                        <img src="img/post-thumbnail.jpg" alt="" class="post-img">
                        <p class="post-body">
                            Apple trong sự kiện Spring Load đã bất ngờ cho ra mắt dòng iPad Pro 2021 trang bị chip tự phát triển Apple M1 và loại màn hình mini-LED mới. Dòng iPad Pro M1 đã được đông đảo người dùng đón nhận và đánh giá tốt. Đáp ứng mong đợi của khách hàng, Thế Giới Di Động sẽ kinh doanh chính hãng iPad Pro M1 mới.
                            Hiện tại, Thế Giới Di Động đã liệt kê các mẫu iPad Pro M1 2021 với hai bản 11 inch và 12.9 inch trên trang sản phẩm, khách hàng đã có thể đăng ký nhận thông tin ngay khi hàng về. 

                            Đặc biệt Thế Giới Di Động cũng đã đưa ra mức giá dự kiến của iPad Pro M1 2021, khởi điểm từ 21.990.000 đồng, nâng lên 37.990.000 đồng cho bản có cấu hình cao nhất. Một mức giá tốt bởi giá khởi điểm của iPad Pro M1 2021 không tăng nhiều so với thế hệ tiền nhiệm iPad Pro 2020.

                            Đã có giá dự kiến iPad Pro M1 2021
                            Có rất nhiều nâng cấp trên dòng iPad Pro M1 2021, như trang bị chip M1 với 8 nhân CPU và 8 nhân GPU, 16 nhân xử lý AI. Apple tự tin khẳng định iPad Pro M1 2021 có hiệu năng CPU nhanh hơn 50% và khả năng xử lý đồ họa tốt hơn 40% so với thế hệ tiền nhiệm.

                            Với phiên bản 12.9 inch, người dùng sẽ được sử dụng loại màn hình Liquid Retina XDR có tỷ lệ tương phản 1.000.000:1, cho chất lượng hình ảnh và các thước phim sống động một cách hoàn hảo. Đó chính là loại màn hình mini-LED mới dự kiến sẽ được sử dụng nhiều trong tương lai.

                            Apple đã mang 5G đến iPad Pro M1 2021, hứa hẹn khả năng tải xuống tệp tin, video, ứng dụng một cách nhanh chóng và tiện hơn. Dòng iPad Pro M1 2021 cũng có chuẩn kết nối Wi-Fi 6 mới, cho kết nối thêm nhanh và ổn định.

                            Bạn sẽ sắm iPad Pro M1 2021 chứ?
                        </p>
                    </div>
                </div>
            </div>
        </main>
        
        <!--Footer-->
        <%@include file="footer.html" %>
        
    </body>
</html>
