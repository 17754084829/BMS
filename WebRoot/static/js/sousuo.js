
function search1() {
    // 打开查看框架
    // document.getElementById('sousuoBlock').style.display = 'block';
    // document.getElementById('totalBackground').style.display = 'block';

    var id = document.getElementById("na").value; 
    // document.getElementById('ch').innerHTML=oName;
    var data={
        "id":id, 

    }
    var xmlhttp=new XMLHttpRequest();
    // const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = 'http://localhost:8080/BMS/find_user?id=${id}';
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            var resp=xmlhttp.responseText;
            
            console.log(resp);
            const res=JSON.parse(resp);
            if(res.code === 200) {
                var htm = ''
                for(let d of res.page.list) {
                    htm += `
                    <tr>
                    <th class="col1"><input type="checkbox" onclick="checkAll(this)" /></th>
                    <th class="col2">${d.id}</th>
                    <th class="col3">${d.name}</th>
                    <th class="col4">${d.telephone}</th>
                    <th class="col5">${d.sex}</th>
                    <th class="col6">${d.role}</th>
                    <th class="col7">${d.addtime}</th>
                  
                </tr>
                `
                }
                document.getElementById("bodyt").innerHTML = htm
                window.localStorage.setItem("user", res.data);
                // document.getElementById('ch').innerHTML=resp;
            }
        }else{
            console.log(xmlhttp.readyState)
        }
    }
    
    xmlhttp.open('POST',url,true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    console.log(JSON.stringify(data));
    xmlhttp.send(); 
    
    document.getElementById('sousuoBlock').style.display = 'block';
}
// function ex(){
//     document.getElementById("search").style.display="none";
// }

// 搜索中的取消按钮
function sousuoCancel() {
    // 关闭搜索框架
    document.getElementById('sousuoBlock').style.display = 'none';
    document.getElementById('totalBackground').style.display = 'none';
}



