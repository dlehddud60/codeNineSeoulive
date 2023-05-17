
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>course_write</title>

    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="/resources/static/css/layout/reset.css">
    <!-- layout css -->
    <link rel="stylesheet" href="/resources/static/css/layout/header.css">
    <link rel="stylesheet" href="/resources/static/css/layout/footer.css">
    <!-- main css -->
    <link rel="stylesheet" href="/resources/static/css/layout/main.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/889f069cfd.css" crossorigin="anonymous">

    <link rel="stylesheet" href="css/course_write_copy.css">
    

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/889f069cfd.js" crossorigin="anonymous"></script>

  
</head>


<body>

    <div id="header">
        <div class="wrap">
            <h1 class="logo">
                 <a href="#"><img src="/resources/static/img/img-logo.png" width="240" height="60"></a>
            </h1>
            <ul class="bn">
                <a href="#" class="fl">
                    <li>여행지</li>
                </a>
                <a href="#" class="fl">
                    <li>일정</li>
                </a>

                <a href="#" class="fl">
                    <li>자유게시판</li>
                </a>

            </ul>

            <ul class="bn">

                <a href="#" class="fr">
                    <li>회원가입</li>
                </a>
                <a href="#" class="fr">
                    <li>로그인</li>
                </a>

            </ul>

        </div>

    </div>

    <style>
        #container{
            height:100vh;
            /* display: blo; */
        }
        #form{
            height: 100vh;
            display: flex;
        }
        .write_func{
            height:10vh;
            width: 1200px;
            border: 1px solid black;
        }


        .write_day_top {
            border-bottom: 1px solid #DDD;
            /* width: 500px; */
            padding: 20px;

        }

        .Total_Place>div {
            border-bottom: 1px solid #DDD;
            padding: 20px;
        }

        #tables {
            border: 1px solid blue;
            width: 450px;
            height: 100px;
        }

        #main {
            width: 1200px;
            height: auto;
            /* border: 1px solid black; */

            /* position:relative; */
            /* float:none; */
            /* flex: auto; */
            /* justify-content: center; */
            /* display:block; */
            display: flex;
            align-items: center;
            align-content: center;
            /* position: relative; */
        }

        .Total_Day {
            /* position: flex; */
            width: 20%;
            height: 450px;
            /* justify-content: center; */
            /* display: flex; */
            border: 1px solid yellow;
            /* align-items: center; */
            /* align-content: center; */
            /* border:1px dotted red; */
        }

        .Total_Day>#day {
            display: flex;
            align-items: center;
            justify-content: center;
            /* width: 20%; */
        }

        #map {
            position: relative;
            width: 40%;
            height: 450px;
            /* justify-content: center; */
            /* display: inline-flex; */
            border: 1px solid blue;
        }

        #map>img {
            width: 100%;
            height: 100%;
        }

        #mainBloack {
            /* position: relative; */
            height: 450px;
            width: 40%;
            border: 1px solid grey;
            /* justify-content: center; */
            display: flex;
            /* background-color: red; */
        }

        #Subject {
            display: grid;
        }



        #travle_btn {
            justify-content: center;
            display: flex;
            align-items: center;
        }

        #travle_day {
            justify-content: center;
            display: flex;
            align-items: center;
        }

        .InputBtn {

            align-items: center;
            justify-content: center;


        }

        .InsertBtn,
        .DeleteBtn {
            width: 100px;
            height: 30px;
            font-size: large;

        }

        .Register {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .RegisterBtn {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 100px;
            height: 30px;
            font-size: large;
        }

        #test {
            display: flex;
        }
        
    </style>
    <!-- ===================================================================================== -->

    
        <section>
            <div id="container">
                <form action="#" method="get">
                    <div class="write_func">

                        <label for="birthday">출발일자:</label>
                        <input type="date" name="start_date">
                        <input type="button" value="day추가">
                    </div>
                    <div id="big" class="big">
                        <div id="main" class="main">
                            <div class="Total_Day">
                                <div id="day" class="">
                                    <!-- <table>
                                        <tr>
                                            <td>day 1일차</td>
                                        </tr>
                                    </table> -->
                                    day 1일차 
                                </div>
                            </div>
                            <div id="mainBloack">
                                <div id="Subject">
                                    <div class="write_day_top">
                                        <table id="tables" class="tables">
                                            <tr>

                                                <td>2023년 4월 1일</td>

                                            </tr>
                                            <tr>
                                                <td>
                                                    N일차, 서울숲부터 남산까지 뚜벅여행 그리고 닥시 뚜벅뚜벅
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                    <!-- <p>칸 띄우기</p> -->
                                    <div class="Total_Place">
                                        <div id="write_day" class="">

                                            <table id="table_S" class="table_D">
                                                <tr>
                                                    <td>
                                                        <div>
                                                            <input type="search" id="myInput" onsearch="myFunction()"
                                                                placeholder="여행지를 검색해주세요">
                                                            <input type="button" class="InputBtn" value="검색">
                                                            <input type="button" class="InputBtn" value="사진변경">

                                                            <p id="demo"></p>
                                                            <script>
                                                                function myFunction() {
                                                                    var x = document.getElementById("myInput");
                                                                    document.getElementById("demo").innerHTML = "You are searching for: " + x.value;
                                                                }
                                                            </script>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <div id="travle_btn">
                                        <br>
                                        <button id="InsertPlace" class="InsertBtn" type="button">여행지추가</button>
                                        <button id="DeletePlace" class="DeleteBtn" type="button">여행지삭제</button>
                                        <br>
                                    </div>

                                </div>
                            </div>
                            <div id="map"><img src="/resources/static/img/KHAkademy.png" alt=""></div>
                        </div>
                    
                    
                        <hr>
                        <!-- <div id="ltest">left</div> -->
                    
                        <div id="test">
                            <div></div>

                            <div id="middle">

                            </div>

                            <div></div>
                        </div>
                    
                       
                        <!-- <div id="rtest">right</div> -->
                    </div>
                    <div id="travle_day">
                        <form action="">
                            <div id="travle_day">
                                <button id="InsertDay" class="InsertBtn" type="button">여행일추가</button>
                                <button id="DeleteDay" class="DeleteBtn" type="button">여행일삭제</button>
                            </div>
                        </form>
                        <form action="">
                            <div class="Register">
                                <button id="RegisterBtn" class="RegisterBtn" type="button">등록</button>
                            </div>
                        </form>
                    </div>
                </form>
            </div>
        </section>
    

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>

    <script>


        var InsertPlace = document.getElementById("#InsertPlace");

        $(function () {
            var num1 = 0;
            var num2 = num1;
            $('#InsertPlace').click(function () {

                $(document).ready(function () {
                    var temp1 = $('#write_day').clone().appendTo('.Total_Place').attr('id', 'write_day' + num1).addClass("write_day" + num1);

                    num2 = num1++;

                });
            }); // #InsertPlace

            $('#DeletePlace').click(function () {
                console.log("num1 : ", num1);
                console.log("num2 : ", num2);
                // var temp2 = $('.Total_Place').remove('.write_day'+num2);
                // $('.Total_Place').replace('.write_day'+num2);
                $('.write_day' + num2 + 1).replaceAll('.write_day' + num2);
                num1--;
                num2--;
            });
            $('#InsertDay').click(function () {

                $(document).ready(function () {
                    var temp1 = $('#big').clone().appendTo('#test').attr('id', 'middle' + num1).addClass("middle" + num1);
                    var temp2 = document.getElementById()
                    num2 = num1++;

                });
                $(document).ready(function(){
                    
                });
            }); // #InsertPlace

            $('#DeleteDay').click(function () {
                console.log("num1 : ", num1);
                console.log("num2 : ", num2);
                // var temp2 = $('.Total_Place').remove('.write_day'+num2);
                // $('.Total_Place').replace('.write_day'+num2);
                $('.middle' + num2 + 1).replaceAll('.middle' + num2);
                num1--;
                num2--;
            });

        }); // jq


        // InsertPlace.addEventListener(function () {

        //     var i = 0;
        //     var InsertTag = InsertPlace.cloneNode;

        //     InsertTag = document.cloneNode(InsertPlace);

        // });

        // var var1 = document.queryselector(".")
    </script>


    <!-- ===================================================================================== -->

    <aside>
        <div class="quick_box">
            <p>QUICK LINK</p>
            <ul>
                <li><a href="#a">날씨</a></li>
                <li><a href="#a">문의</a></li>
                <li class="top"><a href="#a"><i class="fas fa-caret-up"></i></a></li>
                <li class="bottom"><a href="#a"><i class="fas fa-caret-down"></i></a></li>
            </ul>
        </div>

    </aside>

    <footer>
        <div class="footer_wrap">
            <div class="footer_box">
                <div class="logo_box">
                   <a href="#a"><img src="/resources/static/img/img-footer-logo.png" /></a>
                </div>
                <div>
                    <ul>
                        <li><a href="#a">이용약관</a></li>
                        <li><a href="#a">개인정보처리방침</a></li>
                        <li><a href="#a">사이트맵</a></li>
                    </ul>
                    <p class="copyright">Copyright © seoullive. All Rights Reserved</p>
                </div>
            </div>
        </div>
    </footer>

</body>

</html>