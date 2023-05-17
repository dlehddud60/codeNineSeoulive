
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>find_password</title>

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
    #main{
        width: 1200px;
        height: 1px;
        /* border: 1px solid black; */
    
        /* position:relative; */
        /* float:none; */
        /* flex: auto; */
        justify-content: center;
        /* display:block; */
        display:flex;
        align-items: center;
        align-content: center;
        position: relative;
    }
    #other{
        position: relative;
        width:20%;
        height:450px;
        justify-content: center;
        display:inline-flex;
        /* align-items: center; */
        /* align-content: center; */
        /* border:1px dotted red; */
    }
    #other>div{
        position: relative;
        /* background-color :aqua */
    }
    #mainBloack{
        position: relative;
        height:450px;
        width:70%;
        /* border:1px solid grey; */
        justify-content: center;
        display:inline-flex;
        background-color: #FFFFFF;

    }
    #maindBloack>div{
        position: relative;
    }
    #mainBloack>div>div{
        position: relative;
        display:flex;
        /* justify-content: center; */
        align-items: center;
        align-content: center;
        width: 90%;
        height:9.5%;
        /* border:1px solid orange; */
    }
    #block{
        position: relative;
        width: 90%;
        border:1px solid #FFFFFF;
        /* background-color: aliceblue; */
        justify-self: center;
        align-items: center;
    }
    #left, #right{
        width: 5%;
        /* border: 1px solid red; */
    }
    form,input,label{
        position: relative;
        height: 30px;
    }
    #inputType0,#inputType1,#inputType2{
        /* background-color:#eee; */
        position: relative;
        width: 200px;
        height: 30px;
    }

    #send0 , #send1 , #send2{
        position: relative;
        width:70px;
        font-size: large;
    }
    .power0, .power1, .power2{
        position: block;
        /* justify-content: center; */
        font-size: large;

    }
    #sel{
        height: 30px;
        width:200px;
        font-size: large;
    }
    #returnHome{
        justify-content: center;
    }
    #returnHome>button{
        position: relative;
        width: 200px;
        height: 30px;
        font-size: large;
    }
</style>

<!-- ===================================================================================== -->
<section>
    <div id ="test">
        
    </div>

    <div id="container">
        
        <form action="#" method="get">
            <div id="main">
             <div id="other">
                 <div></div>
             </div>
             <div id="mainBloack">
                <div id="left"></div>
                 <div id="block">
                     <div></div>
                     
                     <div id="submitResult0">

                     </div>
                     <!-- 
                     <div class="power1">
                         <form action="/member/find_password" id="form1" onsubmit="return false" method="post" >
                             <label for="">이메일
                                <input id="inputType1" type="user_email" size="15" required>
                                @
                                <select name="선택해주세요" id="sel" required>
                                    <option value="">선택해주세요</option>
                                    <option value="gmail.com">gmail.com</option>
                                    <option value="kakao">kakao.com</option>
                                    <option value="kakao">naver.com</option>
                                </select>
                                <button id="send1">전송</button>
                                 <input id="inputType2" type="submit" value="전송"> 
                             </label> 
                         </form>
                     </div>
                     <div id="submitResult1"></div>
                     <div>인증번호를 전송하였습니다./ 인증번호 발송에 실패하였습니다.</div> 
                     <div class="power2">
                         <form action="/member/find_password" method="post" id="form2" onsubmit="return false">
                             <label for="">이메일 인증 번호 확인 
                                <input id="inputType2" type="password" required> 
                                <button id="send2">인증</button>
                                 <input id="inputType2" type="submit" value="인증"> 
                            </label>
                         </form>
                     </div>
                     <div id="submitResult2"></div>
                      <div id="check">인증에 성공하였습니다. / 인증번호가 일치하지 않습니다.</div> 
                     <div></div>
                     
                      -->
                     <div class="form-group email-form">
						 <label for="email">이메일</label>
						 <div class="input-group">
						<input type="text" class="form-control" name="userEmail1" id="userEmail1" placeholder="이메일" >
						<select class="form-control" name="userEmail2" id="userEmail2" >
                        <option>@gmail.com</option>
						<option>@naver.com</option>
						<option>@daum.net</option>
	

						</select>
					</div>   
					<div class="input-group-addon">
						<button type="button" class="btn btn-primary" id="mail-Check-Btn">본인인증</button>
					</div>
						<div class="mail-check-box">
					<input class="form-control mail-check-input" placeholder="인증번호 6자리를 입력해주세요!" disabled="disabled" maxlength="6">
					</div>
						<span id="mail-check-warn"></span>
					</div>
                     
                     
                     
                     <div></div>
                     <div id="returnHome"><button>확인</button></div>
                     
                     
                 </div>
                 <div id="right"></div>
             </div>
             <div id="other">
                 <div></div>
             </div>
            </div>
         </form>
    </div>
</section>

<div>
<script>
    // 아이디 확인
    
    $('#mail-Check-Btn').click(function() {
		const eamil = $('#userEmail1').val() + $('#userEmail2').val(); // 이메일 주소값 얻어오기!
		console.log('완성된 이메일 : ' + eamil); // 이메일 오는지 확인
		const checkInput = $('.mail-check-input') // 인증번호 입력하는곳 
		
		$.ajax({
			type : 'get',
			url : '<c:url value ="/member/find_passowrd?email="/>'+eamil, // GET방식이라 Url 뒤에 email을 뭍힐수있다.
			success : function (data) {
				console.log("data : " +  data);
				checkInput.attr('disabled',false);
				code =data;
				alert('인증번호가 전송되었습니다.')
			}			
		}); // end ajax
	}); // end send eamil
	
	// 인증번호 비교 
	// blur -> focus가 벗어나는 경우 발생
	$('.mail-check-input').blur(function () {
		const inputCode = $(this).val();
		const $resultMsg = $('#mail-check-warn');
		
		if(inputCode === code){
			$resultMsg.html('인증번호가 일치합니다.');
			$resultMsg.css('color','green');
			$('#mail-Check-Btn').attr('disabled',true);
			$('#userEamil1').attr('readonly',true);
			$('#userEamil2').attr('readonly',true);
			$('#userEmail2').attr('onFocus', 'this.initialSelect = this.selectedIndex');
	         $('#userEmail2').attr('onChange', 'this.selectedIndex = this.initialSelect');
		}else{
			$resultMsg.html('인증번호가 불일치 합니다. 다시 확인해주세요!.');
			$resultMsg.css('color','red');
		}
	});
    
//     var send0 = document.getElementById("send0");
//     let passId = "hacu";
//     send0.addEventListener("click",function ghi(){
//         var form0 = document.getElementById("form0");
//         var id = document.getElementById("inputType0").value;

//         if(passId != id){
//             document.getElementById("submitResult0").innerText = "아이디가 일치하지 않습니다.";
//             document.getElementById("submitResult0").style.color="red";
//         }else{
//             document.getElementById("submitResult0").innerText = "아이디가 일치합니다.";
//             document.getElementById("submitResult0").style.color="black";
//         } // end if-else
        
//     });


//     // 이메일 확인
//    var send1 = document.getElementById("send1");
//    let passEmail = "intelinger";
//    send1.addEventListener("click",function abc(){
//     var form1 = document.getElementById("form1");
//     var email = document.getElementById("inputType1").value;
    
    
//     if(passEmail != email){
//         document.getElementById("submitResult1").innerText = "인증번호 발송에 실패하였습니다.";
//         document.getElementById("submitResult1").style.color="red";
//     }else{
//         document.getElementById("submitResult1").innerText = "인증번호를 전송하였습니다.";
//         document.getElementById("submitResult1").style.color="black";
//     } // end if-else

// }); // end send.addEventListener 

//     // 이메일 인증번호 확인
//     var send2 = document.getElementById("send2");
//     let passpw = 000000;
//     send2.addEventListener("click",function def(){
//         var form2 = document.getElementById("form2");
//         var pw = document.getElementById("inputType2").value;

//         if(passpw == pw){
//             document.getElementById("submitResult2").innerText = "인증에 성공하였습니다.";
//             document.getElementById("submitResult2").style.color="black";
//          }else{
//             document.getElementById("submitResult2").innerText = "인증번호가 일치하지 않습니다.";
//             document.getElementById("submitResult2").style.color="red";
//         } // end if-else
//     });

</script>
</div>



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