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

        if (iTds[2].innerText == null || iTds[2].innerText == '') {
        alert('账号不能为空');
        return;
    }
    else if (isNaN(iTds[2].innerText)) {
        alert('账号不符合格式');
        return;
    }
    else if (iTds[2].innerText.length != 11) {
        alert('账号长度必须为11位');
        return;
    }

    if (iTds[3].innerText == null || iTds[3].innerText == '') {
        alert('姓名不能为空');
        return;
    }
    else if (iTds[3].innerText.length > 5) {
        alert('姓名不能超过五位');
        return;
    }
    if (iTds[8].innerText== null || iTds[8].innerText == '') {
        alert('密码不能为空');
        return;
    }
    else if (iTds[8].innerText.length < 8 || iTds[8].innerText.length > 16) {
        alert('密码错误');
        return;
    }
    // 关闭修改框架
    document.getElementById('updateBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';


var oStuId2 = document.getElementById("stuId2").value;
var oName2 = document.getElementById("name2").value;
var oColg2 = document.getElementById("colg2").value;
var oProfession2 = document.getElementById("profession2").value;
var oGrade2 = document.getElementById("grade2").value;
var oStuClass2 = document.getElementById("stuClass2").value;
var oAge2 = document.getElementById("age2").value;
var oPreservation = document.getElementById("preservation");
var oUpdateCancel = document.getElementById("updateCancel");



    var data = {
        "id": oStuId2,
        "name": oName2,
        "password": oAge2,
        "telephone": oStuClass2,
        "sex":  oColg2,
    }

    var xmlhttp = new XMLHttpRequest();
    const url = 'http://localhost:8080/BMS/update';
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
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
    console.log(JSON.stringify(data));
    xmlhttp.send(JSON.stringify(data));
}

// 修改中的取消按钮
function updateCancel() {
    // 关闭修改框架
    document.getElementById('updateBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';



}




