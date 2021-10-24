$("body").on("click",".page-car-sold",function(){
    var numberPage = $(this).text();
    var beginPage = (numberPage - 1) * 6;

    $.ajax({
        url:"/get-carSold-with-page",
        type:"GET",
        data:{
            beginPage:beginPage,
        },
        success: function(value){
            var tbodyCar = $("#table-carSold").find("tbody");
            tbodyCar.empty();
            tbodyCar.append(value);
        }
    })
})