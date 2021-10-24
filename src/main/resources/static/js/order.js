function ShowHideDiv(btnPassport, userID) {
    if (confirm("Xác nhận xe đã bán ")) {
        if (document.getElementById("money").value != "") {
            var dvPassport = document.getElementById("dvPassport");
            dvPassport.style.display = btnPassport.value == "Yes" ? "block" : "none";
            var money = parseFloat(document.getElementById("money").value)
            var carID = parseInt(document.getElementById("carID").textContent);
            var userId = parseInt(userID);
            var url = "/confirmOrder?userId=" + userId + "&carId=" + carID + "&money=" + money;
            window.location.href = url;
            console.log(url);
        } else {
            alert("vui lòng nhập số tiền đã bán xe");
        }
    } else {
        return;
    }
}

