// 修改按钮
function update(obj) {
    // 打开修改框架
    document.getElementById('updateBlock').style.display = 'block';
    document.getElementById('totalBackground').style.display = 'block';

    // 获取当前行
    var iTr = obj.parentNode.parentNode;

    // 获取当前行中的所有单元格
    iTds = iTr.getElementsByTagName('td');

    // 将新增框架中的输入框中内容设为当前行对应的内容
    document.getElementById('stuId2').value = iTds[2].innerText;
    document.getElementById('name2').value = iTds[3].innerText;
    document.getElementById('colg2').value = iTds[4].innerText;
    document.getElementById('profession2').value = iTds[5].innerText;
    document.getElementById('grade2').value = iTds[6].innerText;
    document.getElementById('stuClass2').value = iTds[7].innerText;
    document.getElementById('age2').value = iTds[8].innerText;
}

// 保存按钮
function preservation() {
    // 将新内容写入
    iTds[2].innerText = document.getElementById('stuId2').value;
    iTds[3].innerText = document.getElementById('name2').value;
    iTds[4].innerText = document.getElementById('colg2').value;
    iTds[5].innerText = document.getElementById('profession2').value;
    iTds[6].innerText = document.getElementById('grade2').value;
    iTds[7].innerText = document.getElementById('stuClass2').value;
    iTds[8].innerText = document.getElementById('age2').value;
    // 关闭修改框架
    document.getElementById('updateBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';
}

// 修改中的取消按钮
function updateCancel() {
    // 关闭修改框架
    document.getElementById('updateBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';
}




var oStuId2 = document.getElementById("stuId2");
var oName2 = document.getElementById("name2");
var oColg2 = document.getElementById("colg2");
var oProfession2 = document.getElementById("profession2");
var oGrade2 = document.getElementById("grade2");
var oStuClass2 = document.getElementById("stuClass2");
var oAge2 = document.getElementById("age2");
var oPreservation = document.getElementById("preservation");
var oUpdateCancel = document.getElementById("updateCancel");
oStuId1.onchange = e => {
    $.attr(oStuId2, 'value', e.target.value);
}
oName2.onchange = function (e) {
    // oName.setAttribute('value', e.target.value)
    $.attr(oName2, 'value', e.target.value);
}
oColg2.onchange = e => {
    $.attr(oColg2, 'value', e.target.value);
}
oAge2.onchange = e => {
    $.attr(oAge2, 'value', e.target.value);
}
oSubmit.onclick = function () {
    var stuId2 = $.attr(oStuId2, 'value');
    var name2 = $.attr(oName2, 'value');
    var colg2 = $.attr(oColg2, 'value');
    var age2 = $.attr(oAge2, 'value');

    var data = {
        "stuId2": stuId2,
        "name2": name2,
        "colg2": colg2,
        "age2": age2,
    }

    var xmlhttp = new XMLHttpRequest();
    const url = 'https://http://localhost:8080/BMS/update';
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === "200") {
                window.localStorage.setItem("user", res.data);
                window.location.href = './2.html'
                //把用户信息存储到浏览缓存中
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }
    console.log(JSON.stringify(data));
    xmlhttp.open('post', url, true);
    xmlhttp.send(data);
}
