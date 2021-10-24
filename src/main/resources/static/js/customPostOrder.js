$("body").on("click",".page-postorder",function(){
    var numberPage = $(this).text();
    var beginPageOrder = (numberPage - 1) * 6;

    $.ajax({
            url:"/get-post-order-with-page",
            type:"GET",
            data:{
                beginPageOrder:beginPageOrder,
            },
            success: function(value){
                var tbodyOrder = $("#table-post-order").find("tbody");
                tbodyOrder.empty();
                tbodyOrder.append(value);
            }
        })
})