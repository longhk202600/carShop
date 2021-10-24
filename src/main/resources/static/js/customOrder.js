$("body").on("click",".page-order",function(){
    var numberPage = $(this).text();
    var beginPageOrder = (numberPage - 1) * 6;

    $.ajax({
            url:"/get-order-with-page",
            type:"GET",
            data:{
                beginPageOrder:beginPageOrder,
            },
            success: function(value){
                var tbodyOrder = $("#table-order").find("tbody");
                tbodyOrder.empty();
                tbodyOrder.append(value);
            }
        })
})