<#import "./page.ftl" as a>
<@a.basis>
    <div class="container" style="margin-top:30px">
        <div class="carousel slide" data-ride="carousel" id="demo">

            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li class="active" data-slide-to="0" data-target="#demo"></li>
                <li data-slide-to="1" data-target="#demo"></li>
                <li data-slide-to="2" data-target="#demo"></li>

            </ul>

            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="image/slider1.jpg">
                </div>
                <div class="carousel-item">
                    <img src="image/slider2.jpg">
                </div>
                <div class="carousel-item">
                    <img src="image/slider3.jpg">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" data-slide="prev" href="#demo">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" data-slide="next" href="#demo">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>
    </div>
</@a.basis>