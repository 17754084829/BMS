function delxi(d) {
    console.log(d);
    if (confirm('确定删除?') == false)
        return false;
    confirmm(d);
}
function confirmm(d) {
    console.log(d);
    var id = d;
    var data = {
        "id": id,

    }
    var xmlhttp = new XMLHttpRequest();
    const url = `http://localhost:8080/BMS/deleteadmin`
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                window.localStorage.setItem("user", res.data);
                window.location.reload();
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }

    xmlhttp.open('POST', url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    console.log(JSON.stringify(data));
    xmlhttp.send("id="+id);

    // document.getElementById('delBlock').style.display = 'none';
}


function delbook(r) {
    console.log(r);
    // document.getElementById('delBlock').style.display = 'block';
    if (confirm('确定删除?') == false)
        return false;
    confirom(r);
}
function confirom(r) {
    console.log(r);
    var bookname = r;
    var data = {
        "bookname": bookname,
    }
    var xmlhttp = new XMLHttpRequest();
    const url = `http://localhost:8080/BMS/deletedbook`
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            // console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                window.localStorage.setItem("user", res.data);
                window.location.reload();
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }

    xmlhttp.open('POST', url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    console.log(JSON.stringify(data));
    xmlhttp.send("booknumber="+bookname);

    // document.getElementById('delBlock').style.display = 'none';
}
