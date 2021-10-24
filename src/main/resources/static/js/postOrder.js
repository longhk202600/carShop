 $('input[type=submit]').click(function(e) {
       //Prevent default submission of form
       e.preventDefault();

       $.post({
          url : '/post-order',
          contentType: "application/json; charset=utf-8",
          data : JSON.stringify(json),
          success : function(res) {
              console.log(res)
          }
       })
     });