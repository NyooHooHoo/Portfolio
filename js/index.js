function copy(id) {
    var copyText = document.getElementById(id).innerText;
    navigator.clipboard.writeText(copyText);
    document.getElementById(id + "-msg").style.visibility = "visible";
    setTimeout(function() {
        $('#' + id + '-msg').fadeOut('fast');
    }, 700);
    $('#' + id + '-msg').fadeIn(0);
}

