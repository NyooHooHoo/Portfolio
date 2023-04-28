function copy(id) {
    var copyText = document.getElementById(id).innerText;
    navigator.clipboard.writeText(copyText);
}