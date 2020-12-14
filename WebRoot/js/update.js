function change(d) {
    document.getElementById('updateBlock').style.display = 'block';
    var id = d;
    var data = {
        "id": id,
    }
    var xmlhttp = new XMLHttpRequest();
    const url = `http://localhost:8080/BMS/find_user?id=${id}`;
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                var htm = ''
                for (let d of res.data) {
                	var time=timestampToTime(d.addtime);
                    htm += `
                    <tr>
                                    <td class="updateTableTd1">账号ID</td>
                                    <td class="updateTableTd2"><input type="text" id="id2" value="${d.id}"/></td>
                                </tr>
                                <tr>
                                    <td class="updateTableTd1">用户名</td>
                                    <td class="updateTableTd2"><input type="text" id="name2" value="${d.name}"/></td>
                                </tr>
                                <tr>
                                    <td class="updateTableTd1">密码</td>
                                    <td class="updateTableTd2"><input type="text" id="password2" value="${d.password}"/></td>
                                </tr>
                                <tr>
                                    <td class="addTableTd1">电话</td>
                                    <td class="addTableTd2"><input type="text" id="telephone2" value="${d.telephone}"/></td>
                                </tr>
                                <tr>
                                    <td class="updateTableTd1">性别</td>
                                    <td class="updateTableTd2">
                                        <select name="" id="sex2" value="${d.sex}">
                                            <option value="">男</option>
                                            <option value="">女</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="addTableTd1">录入时间</td>
                                    <td class="addTableTd2"><input type="text" id="addtime2" value="${time}"/></td>
                                </tr>
                                <tr>
                                    <td class="updateTableTd1">角色</td>
                                    <td class="updateTableTd2">
                                        <select name="" id="roles2" value="${d.roles}">
                                            <option value="">高级管理员</option>
                                            <option value="">普通管理员</option>
                                        </select>
                                    </td>
                                </tr>
                `
                }
                document.getElementById("updateMessageTable").innerHTML = htm
                window.localStorage.setItem("user", res.data);
                // document.getElementById('ch').innerHTML=resp;
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }

    xmlhttp.open('GET', url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    console.log(JSON.stringify(data));
    xmlhttp.send();


}

function baocun() {
    document.getElementById('updateBlock').style.display = 'none';

    var id2 = document.getElementById('id2').value;
    var name2 = document.getElementById('name2').value;
    var password2 = document.getElementById('password2').value;
    var telephone2 = document.getElementById('telephone2').value;
    var sex2 = document.getElementById('sex2');
    var index = sex2.selectedIndex;
    sex2.options[index].value;
    var sex2 = sex2.options[index].text;
    var addtime2 = document.getElementById('addtime2').value;
    var roles2 = document.getElementById('roles2');
    var index1 = roles2.selectedIndex;
    roles2.options[index1].value;
    var roles = roles2.options[index1].value;
    if(sex2==="男")
    	sex2="1";
    else
    	sex2="0";
    var pattern = /^[a-zA-Z0-9]+$/;
    var reg = /^[\u2E80-\u9FFF]+$/;
    var rad = /(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]+$/;
    var shuzi = /^[0-9]+$/;
    if (sex2 === "男")
        sex2 = "1";
    else
        sex2 = "0";
    if (name2 == null || name2 == '') {
        alert('用户名不能为空');
        return;
    }
    else if (name2.length != 11) {
        alert('用户名必须11位');
        return;
    } 
    if (password2 == null || password2 == '') {
        alert('密码不能为空');
        return;
    }
    else if (password2.length < 8 || password2.length > 16) {
        alert('密码必须为8-16位');
        return;
    } else if (!pattern.test(password2)) {
        alert('密码不能含有特殊字符以及空格');
        return;
    } else if (!rad.test(password2)) {
        alert('密码必须同时包含数字和字母');
        return;
    }
    if (telephone2 == null || telephone2 == '') {
        alert('电话不能为空');
        return;
    }
    else if (telephone2.length != 11) {
        alert('电话必须为11位');
        return;
    }  else if (!shuzi.test(telephone2)) {
        alert('电话必须为数字');
        return;
    }


    var data = {
        "id": id2,
        "name": name2,
        "password": password2,
        "telephone": telephone2,
        "sex": sex2,
        "addtime": addtime2,
        "roles": roles,
    }
    var xmlhttp = new XMLHttpRequest();
    //    const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = 'http://localhost:8080/BMS/update'
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
    xmlhttp.send("name="+ name2+
            "&password="+ password2+
            "&sex="+sex2+
            "&addtime="+addtime2+
            "&telephone="+ telephone2+
            "&roles="+roles+
            "&usable=1"+
            "&id="+id2);

}


// 修改中的取消按钮
function upCancel() {
    document.getElementById('updateBlock').style.display = 'none';
}



// 书
function unchange1(d) {
	document.getElementById('updateBk').style.display = 'block';
    console.log(d);

    var booknumber = d;
    var data = {
        "booknumber": booknumber,
    }
    var xmlhttp = new XMLHttpRequest();
    const url = `http://localhost:8080/BMS/find_book?booknumber=${booknumber}`;
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                var htm = ''
                for (let d of res.data) {
                	var time=timestampToTime(d.bookdate);
                    htm += `
                    <tr>
                    <td class="updateTableTd1">书号</td>
                    <td class="updateTableTd2">
                    <input id="booknumber2" value="${d.booknumber}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">编号</td>
                    <td class="updateTableTd2"><input id="bookid2" value="${d.bookid}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">书名</td>
                    <td class="updateTableTd2"><input id="bookname2" value="${d.bookname}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">库存</td>
                    <td class="updateTableTd2"><input id="stock2" value="${d.stock}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">类别</td>
                    <td class="updateTableTd2"><input id="kind2" value="${d.kind}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">位置</td>
                    <td class="updateTableTd2"><input id="location2" value="${d.location}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">录入时间</td>
                    <td class="updateTableTd2"><input id="bookdate2" value="${time}"></td>
                    </tr>
                    <tr>
                    <td class="updateTableTd1">作者</td>
                    <td class="updateTableTd2"><input id="author2" value="${d.author}"></td>
                    </tr>         
                `
                }
                document.getElementById("updateMessageTable1").innerHTML = htm;
                window.localStorage.setItem("user", res.data);
                // document.getElementById('ch').innerHTML=resp;
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }

    xmlhttp.open('GET', url, true);
    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
    console.log(JSON.stringify(data));
    xmlhttp.send();


}

function baocun2() {
    document.getElementById('updateBk').style.display = 'none';
    var booknumber2 = document.getElementById('booknumber2').value;
    var bookid2 = document.getElementById('bookid2').value;
    var bookname2 = document.getElementById('bookname2').value;
    var stock2 = document.getElementById('stock2').value;
    var kind2 = document.getElementById('kind2').value;
    var location2 = document.getElementById('location2').value;
    var bookdate2 = document.getElementById('bookdate2').value;
    var author2 = document.getElementById('author2').value;
    var pattern = /^[\a-\z\A-\Z0-9\u4E00-\u9FA5]+$/;
    var reg = /^[\u2E80-\u9FFF]+$/
    var shuzi = /^[0-9]+$/
    if (bookname2 == null || bookname2 == '') {
        alert('书名不能为空');
        return;
    } else if (!pattern.test(bookname2)) {
        alert('书名不能含有特殊字符以及空格');
        return;
    }
    if (author2 == null || author2 == '') {
        alert('作者名不能为空');
        return;
    } else if (!pattern.test(author2)) {
        alert('书名不能含有特殊字符以及空格');
        return;
    }
    if (!shuzi.test(stock2)) {
        alert('库存必须为数字');
        return;
    }
    if (!pattern.test(kind2)) {
        alert('图书类别不能含有特殊字符以及空格');
        return;
    }

    var data = {
        "booknumber": booknumber2,
        "bookid": bookid2,
        "bookname": bookname2,
        "stock": stock2,
        "kind": kind2,
        "locationn": location2,
        "bookdate": bookdate2,
        "author": author2,
    }
    var xmlhttp = new XMLHttpRequest();
    //    const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = 'http://localhost:8080/BMS/update/book'
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
    xmlhttp.send("booknumber="+booknumber2+
            "&bookid="+bookid2+
            "&bookname="+bookname2+
            "&stock="+stock2+
            "&kind="+kind2+
            "&location="+location2+
            "&bookdate="+bookdate2+
            "&author="+author2);

}

// 修改中的取消按钮
function upCancel3() {
    document.getElementById('updateBk').style.display = 'none';
}



