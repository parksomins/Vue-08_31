<!--프론트엔드 부분-->
(function ($) {
    let indexBtn = [];  // 인덱스 버튼들
   let pagination = {
        total_pages : 0,
        total_elements : 0,
        current_page : 0,
        current_elements : 0
    };

   // 페이지 정보
    let showPage = new Vue({   //user.html에 있는 div id를 가져옴
        el : "#showPage",
        data : {
            totalElements : {},  //ajax로 전달한 response 데이터를 {}안에 쏙쏙 넣어주게됨
            currentPage: {}
        }
    });

    // 데이터 리스트
    let itemList = new Vue({
        el : "#itemList",  // div id가 itemList인 것에 데이터가 찍히게 됨
        data : {
            itemList : {}
        }
    });

    searchStart(0);
    // $(document).ready(function(){
    //     searchStart(0)
    // });
    // 위에 searchStart(0)값이 아래 index에 들어가게됨
    function searchStart(index){
        console.log("index : " + index);
        // UserApiController 레스트가 호출되는데 @Mapping이 ("/api/user")인 부분이 호출됨
        $.get("/api/user?page="+index, function(response){
           console.dir(response);

           indexBtn = [];
           pagination = response.pagination;

           // 전체 페이지
            showPage.totalElements = pagination.currentElements; //console에 찍힌 pagination안에 current_elements 값을 가져옴
            showPage.currentPage = pagination.currentPage + 1; // 0이 날라오기 때문에 +1을 해줌

            // 검색 데이터
            itemList.itemList = response.data; // console 안에 Object 안의 데이터를 가져옴
        });
    }

})(jQuery);
