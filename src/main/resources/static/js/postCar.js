  // hien thi 1 anh
    document.getElementById("imageCar").onchange = function () {
        var fsize = $('#imageCar')[0].files[0].size;
        // dung luong lon qua 1MB
        if(fsize > 1048576){
            alert("Dung lượng file quá lớn. Vui lòng chọn ảnh khác");
            document.getElementById('imageCar').value = "";
        }else{
            var reader = new FileReader();
            reader.onload = function (e) {
            // get loaded data and render thumbnail.
            document.getElementById("image").src = e.target.result;
    };
    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
        }
    };

    // kiem tra so luong anh va hien thi list anh
    $('input#moreCarImage').change(function(){
    var files = $(this)[0].files;
    var values =  $('input#moreCarImage');
    var fileSelected = document.getElementById('moreCarImage').files;
    var sizeFile = 0;
    for(var i = 0;i<fileSelected.length;i++){
        sizeFile += fileSelected[i].size;
    }
    // kiểm tra dung lượng file va so luong file
    if(files.length != 5 || sizeFile > 1048576){
        alert("Vui lòng chọn đủ 5 file hoặc dung lượng file quá lớn");
        var input = $("#moreCarImage");
        input.replaceWith(input.val('').clone(true));
    }else{
        var fileSelected = document.getElementById('moreCarImage').files;
        if(fileSelected.length > 0){
            for(var i = 0;i<fileSelected.length;i++){
                var fileToLoad = fileSelected[i];
                var fileReader = new FileReader();
                fileReader.onload = function(fileLoaderEvent){
                    var srcData = fileLoaderEvent.target.result;
                    var newImage = document.createElement('img');
                    newImage.src = srcData;
                    document.getElementById('displayImg').innerHTML +=newImage.outerHTML;
                }
                fileReader.readAsDataURL(fileToLoad);
            }
        }
    }
});
//kiem tra giá tiền
    document.getElementById("priceFrom").oninput = function () {
        var numberPriceFrom = document.getElementById("priceFrom").value;
        var numberPriceTo = document.getElementById("priceTo").value;
        var error = document.getElementById("error");
        if(numberPriceFrom.length>=4){
        var newPrice =numberPriceFrom.substring(numberPriceFrom.length-3,0)+" tỷ "+numberPriceFrom.substring(numberPriceFrom.length,numberPriceFrom.length-3)+"Triệu"
          document.getElementById("moneyFrom").innerHTML = newPrice;
        }else{
          document.getElementById("moneyFrom").innerHTML = numberPriceFrom+"Triệu";
        }
    }

    document.getElementById("priceTo").oninput = function () {
        var numberPriceFrom = document.getElementById("priceFrom").value;
        var numberPriceTo = document.getElementById("priceTo").value;
        var error = document.getElementById("error");
         if(numberPriceTo.length>=4){
           var newPrice =numberPriceTo.substring(numberPriceTo.length-3,0)+" tỷ "+numberPriceTo.substring(numberPriceTo.length,numberPriceTo.length-3)+"Triệu"
           document.getElementById("moneyTo").innerHTML = newPrice
        }else{
          document.getElementById("moneyTo").innerHTML = numberPriceTo+"Triệu";
        }

        if(numberPriceFrom >= numberPriceTo){
            error.innerHTML = '(Giá tiền không hợp lệ)';
        }else{
        error.style.color = 'blue';
        error.innerHTML = '(Giá tiền hợp lệ)';
        }
    }