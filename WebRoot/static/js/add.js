

function add() {
    // 打开新增框架
    document.getElementById('addBlock').style.display = 'block';
    document.getElementById('totalBackground').style.display = 'block';
}

// 提交按钮
function sumbit() {
    // 关闭新增框架
    document.getElementById('addBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';

    // 写入表单
    // 获取表
    var iTable = document.getElementById('myTable');
    // 获取输入值
    var stuId = document.getElementById('stuId1').value;
    var name = document.getElementById('name1').value;
    var colg = document.getElementById('colg1').value;
    var profession = document.getElementById('profession1').value;
    var grade = document.getElementById('grade1').value;
    var stuClass = document.getElementById('stuClass1').value;
    var age = document.getElementById('age1').value;
    var nums = iTable.rows.length;

    if (stuId == null || stuId == '') {
        alert('账号不能为空');
        return;
    }
    else if (isNaN(stuId)) {
        alert('账号不符合格式');
        return;
    }
    else if (stuId.length != 11) {
        alert('账号长度必须为11位');
        return;
    }

    if (name == null || name== '') {
        alert('姓名不能为空');
        return;
    }
    else if (name.length > 4) {
        alert('姓名不能超过五位');
        return;
    }
    if (age == null || age == '') {
        alert('密码不能为空');
        return;
    }
    else if (age.length < 8 || age.length > 16) {
        alert('密码错误');
        return;
    }


    // 创建一行tr
    var iTr = document.createElement('tr');

    // 隔行换色
    if (nums % 2 != 0) {
        iTr.className = 'mainTbodyTr1';
    }
    else {
        iTr.className = 'mainTbodyTr2';
    }

    // 将tr添加到table中
    iTable.appendChild(iTr);

    // 创建选择按钮
    var sel = document.createElement('input');
    sel.setAttribute('type', 'checkbox');
    sel.setAttribute('name', 'item');

    // 创建单元格td，并添加属性、内容
    var iTd1 = document.createElement('td');
    iTd1.className = "col1";
    iTd1.appendChild(sel);
    var iTd2 = document.createElement('td');
    iTd2.className = "col2";
    iTd2.appendChild(document.createTextNode(nums));
    var iTd3 = document.createElement('td');
    iTd3.className = "col3";
    iTd3.appendChild(document.createTextNode(stuId));
    var iTd4 = document.createElement('td');
    iTd4.className = "col4";
    iTd4.appendChild(document.createTextNode(name));
    var iTd5 = document.createElement('td');
    iTd5.className = "col5";
    iTd5.appendChild(document.createTextNode(colg));
    var iTd6 = document.createElement('td');
    iTd6.className = "col6";
    iTd6.appendChild(document.createTextNode(profession));
    var iTd7 = document.createElement('td');
    iTd7.className = "col7";
    iTd7.appendChild(document.createTextNode(grade));
    var iTd8 = document.createElement('td');
    iTd8.className = "col8";
    iTd8.appendChild(document.createTextNode(stuClass));
    var iTd9 = document.createElement('td');
    iTd9.className = "col9";
    iTd9.appendChild(document.createTextNode(age));
    var iTd10 = document.createElement('td');
    iTd10.className = "col10";
    var examine = document.createElement('input');
    examine.id = 'examine';
    examine.setAttribute('type', 'button');
    examine.setAttribute('value', '查看');
    examine.setAttribute('onclick', 'examine(this)');
    var update = document.createElement('input');
    update.id = 'update';
    update.setAttribute('type', 'button');
    update.setAttribute('value', '修改');
    update.setAttribute('onclick', 'update(this)');
    iTd10.appendChild(examine);
    iTd10.appendChild(update);

    // 将单元格添加到行
    iTr.appendChild(iTd1);
    iTr.appendChild(iTd2);
    iTr.appendChild(iTd3);
    iTr.appendChild(iTd4);
    iTr.appendChild(iTd5);
    iTr.appendChild(iTd6);
    iTr.appendChild(iTd7);
    iTr.appendChild(iTd8);
    iTr.appendChild(iTd9);
    iTr.appendChild(iTd10);

    // // 将新增框架中的输入框值初始化
    // document.getElementById('stuId1').value = null;
    // document.getElementById('name1').value = null;
    // document.getElementById('colg1').value = null;
    // document.getElementById('profession1').value = null;
    // document.getElementById('grade1').value = null;
    // document.getElementById('stuClass1').value = null;
    // document.getElementById('age1').value = null;

    // document.getElementById('nums').innerText = nums;

    var pageNum = document.getElementById('pageNum').innerText;
    pageNum = parseInt(pageNum);
    for (var i = 10 * pageNum + 1; i <= nums; i++) {
        iTable.rows[i].style.display = 'none';

    }

    var oStuId1 = document.getElementById("stuId1").value;
    var oName1 = document.getElementById("name1").value;
    var oColg1 = document.getElementById("colg1").value;
    var oProfession1 = document.getElementById("profession1").value;
    var oGrade1 = document.getElementById("grade1").value;
    var oStuClass1 = document.getElementById("stuClass1").value;
    var oAge1 = document.getElementById("age1").value;
    var oSubmit = document.getElementById("submit");
    var oAddCancel = document.getElementById("addCancel");
    var data = {
        "id": oStuId1,
        "username": oName1,
        "password": oAge1,
        "sex": oColg1,
        "addtime": oProfession1,
        "roles": oGrade1,
        "telephone": oStuClass1,
        "usable": "1",
    }

    var xmlhttp = new XMLHttpRequest();
    const url = 'http://localhost:8080/BMS/look_alluser';
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            // document.getElementById("addMain").innerHTML = resp;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === 200) {
                window.localStorage.setItem("user", res.data);
                // window.location.href = './admin.html'
                //把用户信息存储到浏览缓存中
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }
    xmlhttp.open('post', url, true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    console.log(JSON.stringify(data))
    xmlhttp.send(JSON.stringify(data));

     // 将新增框架中的输入框值初始化
     document.getElementById('stuId1').value = null;
     document.getElementById('name1').value = null;
     document.getElementById('colg1').value = null;
     document.getElementById('profession1').value = null;
     document.getElementById('grade1').value = null;
     document.getElementById('stuClass1').value = null;
     document.getElementById('age1').value = null;
     document.getElementById('nums').innerText = nums;
}

// 新增中的取消按钮
function addCancel() {
    // 关闭新增框架
    document.getElementById('addBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';
}

// 新增按钮




