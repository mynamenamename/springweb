
$(function(){
  
  //댓글추가 버튼이 눌려졌을때
  $('#replyConfirm').click(function(){
     //사용자 입력값 받아오기
     
   /*
   var param  ={bno     : $('#bno').val(), 
                replyer : $('#replyer').val(),
                reply   : $('#reply').val()  }; */
   
   
   var param= $('#replyFrm').serialize();     
   //밑에꺼가 더 편함~! 폼태그에서 넘어오는거 직렬화로 가져오기
           
           
  // alert(param);              
  // console.log(param);
  
  //사용자 모르게 넘기고 화면은 가만히 둬야되니께(비동기통신)
  $.ajax({
    type   : 'post',  //입력할꺼니까
    url    : '../replies/new',   //요청 받기 - controller *경로주의*
    data   : param,
    success: function(result){
       //alert(result);
       $('#reply').val('');  //입력 성공하면 지워버리기~!
       replyList();          //입력 성공하고 입력한거 다시 가져와 버리기~!
    
    },
    error  : function(err){
       alert('error');
       console.log(err);
     }
    
  }); //end of ajax
  
  }); //end of click (댓글추가)
  
  
  //목록보기 ajax
  replyList();
  
  function replyList(){
     $.ajax({
        type : 'get',
        url : '../replies',    //상대경로
        // data : 보내는 데이터 없음
        dataType : 'json',      // 라이브러리 필요
        success : function(result){
              //alert(result);
              //console.log(result);
              
             let replyTbl = $('#replyList'); 
             replyTbl.empty();   //미리 비워버리기~!
             
             for( row of result) 
             {
               //console.log(row);
               var tr = $('<tr/>');
               tr.append( $('<td/>').html(row['rno']) ); // replyVO 에서 찾을 수 있음
               // <tr><td>1</td></tr>
               tr.append( $('<td/>').html(row['replyer']) ); // 동일
               tr.append( $('<td/>').html(row['reply']) ); // 동일
               tr.append( $('<td/>').html(row['replydate']) );
               
               tr.append( '<td><button class="delete">삭제</button></td>'); //id는 부착하면 안됨 여러개니까!!
               tr.append( '<td><button class="modify">수정</button></td>');
               
               replyTbl.append(tr);
               
             }
              
              },
        error : function(err){
              alert('error');
              console.log(err);   
                 }
     
     
     });
  }//end of replyList();
         
    //삭제버튼을 클릭했을 때
    //******************** 동적으로 생성된 버튼은 일반적인 이벤트 발생이 불가함~!!!!
    //  --->>> on() 
  /*  $('.delete').on('click', function(){
            alert('ok');
     }); */
     
     $('#replyList').on('click','.delete', function(){
      var btn = $(this);
      var rno = $(this).parents('tr').children().eq(0).text(); 
                          //삭제 눌러진 애의 게시글번호 얻어오기
    //alert(rno);   
  
  
    //댓글 삭제 ajax
     $.ajax({
     
     type   :  'delete',
     url    :  '../replies/' + rno,
     success: function(result){
       replyList();
     },
     error  : function(err){
        alert('error');
        
     
     
     }
     
     
     
     });
       
       
       
      
      
     }); //end of #replyList 
           
      
         
         


});