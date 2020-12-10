// 全选
function checkAll(obj) {
    var status = obj.checked;
    var items = document.getElementsByName('item');
    var pageNum = document.getElementById('pageNum').innerText;
    pageNum = parseInt(pageNum);
    for (var i = (pageNum - 1) * 10; i < pageNum * 10; i++) {
        items[i].checked = status;
    }
}

// 删除按钮
function del() {
    // 打开删除框架
    document.getElementById('delBlock').style.display = 'block';
    document.getElementById('totalBackground').style.display = 'block';

    var items = document.getElementsByName('item');
    var message = [];
    for (var j = 0; j < items.length; j++) {
        if (items[j].checked) //如果item被选中
        {
            var m = items[j].parentNode.parentNode.cells[3].innerText;
            message.push(m);
        }
    }

    // var div = document.createElement("tr");
    // var text = '';
    // var daima = `<td>${text}</td><td></td><td></td>`
    // div.append(daima);
    var delNode = document.getElementById('delMessage');
    delNode.innerText = message.join('\t');
}

// 确认按钮
function confirm() {
    // 关闭删除框架
    document.getElementById('delBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';

    var items = document.getElementsByName('item');
    var items_num = 0;
    for (var j = 0; j < items.length; j++) {
        if (items[j].checked)//如果item被选中
        {
            items_num += 1;
            items[j].parentNode.parentNode.remove();
            j--;
        }
    }


    var iTable = document.getElementById('myTable');
    var iTrs = iTable.getElementsByTagName('tr');
    for (var i = 1; i < iTrs.length; i++) {
        if (i % 2 != 0)
            iTrs[i].className = 'mainTbodyTr1';
        else
            iTrs[i].className = 'mainTbodyTr2';
        var sort = iTrs[i].getElementsByTagName('td')[1];
        sort.innerText = i;
    }

    var nums = iTrs.length - 1;
    document.getElementById('nums').innerText = nums;
    nums = parseInt(nums);
    var pageSum = Math.ceil(nums / 10);
    var pageNum = document.getElementById('pageNum').innerText;
    pageNum = parseInt(pageNum);

    if (pageNum <= pageSum) {
        for (var i = (pageNum - 1) * 10 + 1; i < pageNum * 10 + 1; i++) {
            iTable.rows[i].style.display = 'table-row';
        }
        for (var i = 1; i < (pageNum - 1) * 10 + 1; i++) {
            iTable.rows[i].style.display = 'none';
        }
        for (var i = pageNum * 10 + 1; i < nums + 1; i++) {
            iTable.rows[i].style.display = 'none';
        }
    }
    if (pageNum > pageSum) {
        for (var i = (pageNum - 2) * 10 + 1; i < nums + 1; i++) {
            iTable.rows[i].style.display = 'table-row';
        }
        for (var i = 1; i < (pageNum - 2) * 10 + 1; i++) {
            iTable.rows[i].style.display = 'none';
        }
        document.getElementById('pageNum').innerText = pageNum - 1;
    }

}

// 删除中的取消按钮
function delCancel() {
    // 关闭删除框架
    document.getElementById('delBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';
}






var oStuId1 = document.getElementById("stuId1");
var oConfirm = document.getElementById("confirm");
var oDelCancel = document.getElementById("delCancel");
oStuId1.onchange = function (e) {
    $.attr(oStuId1, 'value', e.target.value);
}
oSubmit.onclick = function () {
    var stuId1 = $.attr(oStuId1, 'value');
    var data = {
        "stuId1": stuId1,
    }

    var xmlhttp = new XMLHttpRequest();
    const url = 'https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            var resp = xmlhttp.responseText;
            console.log(resp);
            const res = JSON.parse(resp);
            if (res.code === 200) {
                window.localStorage.setItem("user", res.data);
                window.location.href = './2.html'
                //把用户信息存储到浏览缓存中
            }
        } else {
            console.log(xmlhttp.readyState)
        }
    }
    console.log(JSON.stringify(data))
    xmlhttp.open('post', url, true);
    xmlhttp.send(JSON.stringify(data));
}