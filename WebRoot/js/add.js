function add() {
    document.getElementById('addBlock').style.display = 'block';

}
function sumbit() {
    document.getElementById('addBlock').style.display = 'none';

    // 写入表单
    // 获取表
    // var iTable = document.getElementById('myTable');
    // 获取输入值
    var name = document.getElementById('name1').value;
    var mima = document.getElementById('password1').value;
    var tel = document.getElementById('telephone1').value;
    var pattern = /^[a-zA-Z0-9]+$/;
    var reg = /^[\u2E80-\u9FFF]+$/;
    var rad = /(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$/;
    var shuzi = /^[0-9]+$/;
    if (name == null || name == '') {
        alert('用户名不能为空');
        return;
    }
    else if (name.length != 11) {
        alert('用户名必须为11位');
        return;
    } else if (!pattern.test(name)) {
        alert('用户名不能含有特殊字符以及空格');
        return;
    }
    if (mima == null || mima == '') {
        alert('密码不能为空');
        return;
    }
    else if (mima.length < 8 || mima.length > 16) {
        alert('密码必须为8-16位');
        return;
    } else if (!pattern.test(mima)) {
        alert('密码不能含有特殊字符以及空格');
        return;
    } else if (!rad.test(mima)) {
        alert('密码必须同时包含数字和字母');
        return;
    }
    if (tel == null || tel == '') {
        alert('电话不能为空');
        return;
    }
    else if (tel.length != 11) {
        alert('电话必须为11位');
        return;
    }  else if (!shuzi.test(tel)) {
        alert('电话必须为数字');
        return;
    }


    /*   var id = document.getElementById('id1').value;*/
    var name = document.getElementById('name1').value;
    var pwd = document.getElementById('password1').value;
    var telephone = document.getElementById('telephone1').value;
    var sexx = document.getElementById('sex1');
    var index = sexx.selectedIndex;
    sexx.options[index].value;
    var sex = sexx.options[index].value;
    var addtime = document.getElementById('addtime1').value;
    var role1 = document.getElementById('rols1');
    var index1 = role1.selectedIndex;
    role1.options[index1].value;
    var role = role1.options[index1].value;


    var data = {
        //       "id": id,
        "username": name,
        "password": pwd,
        "sex": sex,
        "addtime": addtime,
        "telephone": telephone,
        "roles": role,
        "usable": "1",
    }

    var xmlhttp = new XMLHttpRequest();
    //    const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = 'http://localhost:8080/BMS/add-admin'
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                window.localStorage.setItem("user", res.data);
                // window.location.href = './main.html';
                window.location.reload();
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }
    xmlhttp.open('post', url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    console.log(JSON.stringify(data));
    xmlhttp.send("name=" + name +
        "&password=" + pwd +
        "&sex=" + sex +
        "&addtime=" + addtime +
        "&telephone=" + telephone +
        "&roles=" + role +
        "&usable=1");
}

function addCancel() {
    document.getElementById('addBlock').style.display = 'none';

}



// book
function add1() {
    document.getElementById('addBook').style.display = 'block';

}
function sumbit2() {
    document.getElementById('addBook').style.display = 'none';


    var booknumber = document.getElementById('booknumber1').value;
    var bookid = document.getElementById('bookid1').value;
    var bookname = document.getElementById('bookname1').value;
    // var bookpress = document.getElementById('bookpress1').value;
    var stock = document.getElementById('stock1').value;
    var kind = document.getElementById('kind1').value;
    var location = document.getElementById('location1').value;
    var bookdate = document.getElementById('bookdate1').value;
    var author = document.getElementById('author1').value;
    var pattern = /^[a-zA-Z0-9]+$/;
    var reg = /^[\u2E80-\u9FFF]+$/;
    var shuzi = /^[0-9]+$/;
    var feifa = /^[\a-\z\A-\Z0-9\u4E00-\u9FA5]+$/;
    if (bookname == null || bookname == '') {
        alert('书名不能为空');
        return;
    }
    if (author == null || author == '') {
        alert('作者名不能为空');
        return;
    } 
    if (!shuzi.test(stock)) {
        alert('库存必须为数字');
        return;
    }
    if (! feifa.test(kind)) {
        alert('图书类别不能含有特殊字符以及空格');
        return;
    }
    if (booknumber == null || booknumber == '') {
        alert('书号不能为空');
        return;
    }
    if (booknumber.length != 4) {
        alert('书号必须为4位');
        return;
    } 

    var data = {
        "booknumber": booknumber,
        "bookid": bookid,
        "bookname": bookname,
        "stock": stock,
        "kind": kind,
        "location": location,
        "bookdate": bookdate,
        "author": author,
    }

    var xmlhttp = new XMLHttpRequest();
    //    const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = 'http://localhost:8080/BMS/add-book'
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                window.localStorage.setItem("user", res.data);
                window.location.reload();
                // window.location.href = './main.html';
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }

    xmlhttp.open('POST', url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    console.log(data);
    xmlhttp.send("booknumber=" + booknumber + "&" +
        "bookid=" + bookid +
        "&bookname=" + bookname +
        "&stock=" + stock +
        "&kind=" + kind +
        "&location=" + location +
        "&bookdate=" + bookdate +
        "&author=" + author);
}

function addCancel2() {
    document.getElementById('addBook').style.display = 'none';

}