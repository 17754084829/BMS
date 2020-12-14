
function searc(){
    var id = document.getElementById("na").value; 
    // document.getElementById('ch').innerHTML=oName;
    var data={
        "id":id, 

    }
    var xmlhttp=new XMLHttpRequest();
    // const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = `http://localhost:8080/BMS/find_user?id=${id}`;
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            var resp=xmlhttp.responseText;
            
            console.log(resp);
            const res=JSON.parse(resp);
            if(res.code === "200") {
                var htm = '';
                var i=1;
                for(let d of res.data) {
                    htm += `
                    <tr>
                    <th class="col1">${i}</th>
                    <th class="col2">${d.id}</th>
                    <th class="col3">${d.name}</th>
                    <th class="col4">${d.password}</th>
                    <th class="col5">${d.telephone}</th>
                    <th class="col6">${d.sex}</th>
                    <th class="col7">${d.addtime}</th>
                    <th class="col8">${d.roles}</th>
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
    
    xmlhttp.open('GET',url,true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    console.log(JSON.stringify(data));
    xmlhttp.send(); 
    
    document.getElementById("search").style.display="block";
}
function ex(){
    document.getElementById("search").style.display="none";
}


// 书

function searchh(){
    var bookname = document.getElementById("nae").value; 
    // document.getElementById('ch').innerHTML=oName;
    var data={
        "bookname":bookname, 

    }
    var xmlhttp=new XMLHttpRequest();
    // const url='https://www.fastmock.site/mock/4ee972e9afb65497481bd86c5891dece/_shop_01/api';
    const url = `http://localhost:8080/BMS/find_book?bookname=${bookname}`;
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            var resp=xmlhttp.responseText;
            
            console.log(resp);
            const res=JSON.parse(resp);
            if(res.code === "200") {
                var htm = '';
                var i=1;
                for(let d of res.data) {
                    htm += `
                    <tr>
                    <th class="coi1">${i}</th>
                    <th class="coi2">${d.booknumber}</th>
                    <th class="coi3">${d.bookid}</th>
                    <th class="coi4">${d.bookname}</th>
                    <th class="coi5">${d.stock}</th>
                    <th class="coi6">${d.kind}</th>
                    <th class="coi7">${d.location}</th>
                    <th class="coi8">${d.bookdate}</th>
                    <th class="coi9">${d.author}</th>
                </tr>                
                `;
                    i++;
                }
                document.getElementById("bodyt3").innerHTML = htm
                window.localStorage.setItem("user", res.data);
                // document.getElementById('ch').innerHTML=resp;
            }
        }else{
            console.log(xmlhttp.readyState)
        }
    }
    
    xmlhttp.open('GET',url,true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    console.log(JSON.stringify(data));
    xmlhttp.send(); 
    
    document.getElementById("searchbook").style.display="block";
}
function exh(){
    document.getElementById("searchbook").style.display="none";
}