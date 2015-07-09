
function sleep(ms) {
    var dt = new Date();
    dt.setTime(dt.getTime() + ms);
    while (new Date().getTime() < dt.getTime());
}
sleep(5000);

document.getElementById('msgId').innerHTML = "OmniFaces 2.1 Rocks!";
