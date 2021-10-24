document.getElementById('rePassword').addEventListener('change', function(e){
    var pass = document.getElementById('password').value;
    var rePass = document.getElementById('rePassword').value;
    var errorPass = document.getElementById('errorRepassword');
    if(pass == rePass){
        errorPass.innerHTML = 'Mật khẩu hợp lệ';
        errorPass.style.color = 'blue';
    }else{
        errorPass.innerHTML = 'Mật khẩu không trùng khớp';
        errorPass.style.color = 'red';
        document.getElementById('rePassword').value='';
    }
});

