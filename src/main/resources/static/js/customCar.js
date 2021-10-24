$("body").on("click",".page-car",function(){
    var numberPage = $(this).text();
    var beginPage = (numberPage - 1) * 6;

    $.ajax({
        url:"/get-car-with-page",
        type:"GET",
        data:{
            beginPage:beginPage,
        },
        success: function(value){
            var tbodyCar = $("#table-CarInShowroom").find("tbody");
            tbodyCar.empty();
            tbodyCar.append(value);
        }
    })
})