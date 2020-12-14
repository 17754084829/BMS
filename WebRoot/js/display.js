var user_ptr=0;
var user_data=null;
var user_length=null;
function timestampToTime(timestamp) {
 
        var  date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
 
        var Y = date.getFullYear() + '-';
 
        var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
 
        var D = date.getDate() + ' ';
 
        var h = date.getHours() + ':';
 
        var m = date.getMinutes() + ':';
 
        var s = date.getSeconds();
 
        return Y+M+D+h+m+s;
 
    }
function getUser() {   
var xmlhttp=new XMLHttpRequest();
const url = 'http://localhost:8080/BMS/look_alluser'
xmlhttp.onreadystatechange=function(){
    if(xmlhttp.readyState==4&&xmlhttp.status==200){
        var resp=xmlhttp.responseText;
        console.log(resp);
        const res=JSON.parse(resp);
        if(res.code === "200") {
            var htm = ''
            var d_var='';
            var i=1;
            user_data=res.data;
            user_length=res.length;
            for(let d of res.data) {
                d_var= JSON.stringify(d);
                var time=timestampToTime(d.addtime);
                htm += `
                <tr>
                <th class="col1">${i}</th>
                <th class="col2">${d.id}</th>
                <th class="col3">${d.name}</th>
                <th class="col3">${d.password}</th>
                <th class="col5">${d.telephone}</th>
                <th class="col6">${d.sex}</th>
                <th class="col7">${time}</th>
                <th class="col8">${d.roles}</th>
                <th class="col9"><a href='#' onclick="change(${d.id})">修改</a><a href='#' onclick="delxi(${d.id})">删除</a></th>
            </tr>
            `;
                i++;
            }
            document.getElementById("bodyt1").innerHTML = htm;
            window.localStorage.setItem("user", res.data);
            // window.location.href = './main.html';
        }
    }else{
        console.log(xmlhttp.readyState)
    }
}

xmlhttp.open('POST',url,true);
xmlhttp.setRequestHeader("Content-Type","application/json");
xmlhttp.send();
}
getUser();
var user_index=1;
var index=1;
var  pagenum=10;
var data=null;
var length=null;
var ptr=0;
function pre_page(){
	index--;
	index--;
	var pre=index;
	index++;
	if(index>0){
		remain=ptr-((pre+1)*pagenum);
		var end=ptr-remain;
		var i=end-pagenum;
		ptr=end;
		var htm = '';
		for(;i<end;i++){
			var d=data[i];
			 var time=timestampToTime(d.bookdate);
             htm += `
             <tr>
             <th class="coi1">${d.booknumber}</th>
             <th class="coi2">${d.bookid}</th>
             <th class="coi3">${d.bookname}</th>
             <th class="coi4">${d.stock}</th>
             <th class="coi5">${d.kind}</th>
             <th class="coi6">${d.location}</th>
             <th class="coi7">${time}</th>
             <th class="coi8">${d.author}</th>
             <th class="col9"><a href='#' onclick="unchange1(\'${d.booknumber}\')">修改</a><a href='#' onclick="delbook('${d.booknumber}')">删除</a></th>
         </tr>
         `;
		}
		document.getElementById("bodyt2").innerHTML = htm;
	}else{
		alert("已到达第一页");
	}
	
	
	
}


function pre_page_user(){
	user_index--;
	user_index--;
	var pre=user_index;
	user_index++;
	if(user_index>0){
		remain=user_ptr-((pre+1)*pagenum);
		var end=user_ptr-remain;
		var i=end-pagenum;
		user_ptr=end;
		var htm = '';
		for(;i<end;i++){
			var d=user_data[i];
			user_ptr++;
			 var time=timestampToTime(d.addtime);
             htm += `
             <tr>
             <th class="col1">${i+1}</th>
             <th class="col2">${d.id}</th>
             <th class="col3">${d.name}</th>
             <th class="col3">${d.password}</th>
             <th class="col5">${d.telephone}</th>
             <th class="col6">${d.sex}</th>
             <th class="col7">${time}</th>
             <th class="col8">${d.roles}</th>
             <th class="col9"><a href='#' onclick="change(${d.id})">修改</a><a href='#' onclick="delxi(${d.id})">删除</a></th>
         </tr>
         `;
		}
		 document.getElementById("bodyt1").innerHTML = htm;
	}else{
		alert("已到达第一页");
	}
	
	
	
}


function next_page_user(){
	if(user_length-user_index*pagenum>0){
		user_index++;
		let start=(user_index-1)*pagenum;
		let i=start;
		var htm='';
		var i_index=1;
		for(;start<(((user_length-user_index*pagenum)>0)?i+10:i+(user_length-(user_index-1)*pagenum));start++){
			var d=user_data[start];
			user_ptr++;
			 var time=timestampToTime(d.addtime);
			 htm += `
	             <tr>
	             <th class="col1">${i_index}</th>
	             <th class="col2">${d.id}</th>
	             <th class="col3">${d.name}</th>
	             <th class="col3">${d.password}</th>
	             <th class="col5">${d.telephone}</th>
	             <th class="col6">${d.sex}</th>
	             <th class="col7">${time}</th>
	             <th class="col8">${d.roles}</th>
	             <th class="col9"><a href='#' onclick="change(${d.id})">修改</a><a href='#' onclick="delxi(${d.id})">删除</a></th>
	         </tr>
	         `;
			 i_index++;
		}
		 document.getElementById("bodyt1").innerHTML = htm;
	}
	else
		alert("当前为最后一页");
}


function next_page(){
	if(length-index*pagenum>0){
		index++;
		let start=(index-1)*pagenum;
		let i=start;
		var htm='';
		for(;start<(((length-index*pagenum)>0)?i+10:i+(length-(index-1)*pagenum));start++){
			var d=data[start];
			ptr++;
			 var time=timestampToTime(d.bookdate);
             htm += `
             <tr>
             <th class="coi1">${d.booknumber}</th>
             <th class="coi2">${d.bookid}</th>
             <th class="coi3">${d.bookname}</th>
             <th class="coi4">${d.stock}</th>
             <th class="coi5">${d.kind}</th>
             <th class="coi6">${d.location}</th>
             <th class="coi7">${time}</th>
             <th class="coi8">${d.author}</th>
             <th class="col9"><a href='#' onclick="unchange1(\'${d.booknumber}\')">修改</a><a href='#' onclick="delbook('${d.booknumber}')">删除</a></th>
         </tr>
         `;
		}
		 document.getElementById("bodyt2").innerHTML = htm;
	}
	else
		alert("当前为最后一页");
}
// function geBook() {
    
    var xmlhttp=new XMLHttpRequest();
    const url = 'http://localhost:8080/BMS/look_allbook'
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            var resp=xmlhttp.responseText;
            console.log(resp);
            const res=JSON.parse(resp);
            if(res.code === "200") {
                var htm = '';
                data=res.data;
                length=res.length;
                for(let d of res.data) {
                    d_var= JSON.stringify(d);
                    var time=timestampToTime(d.bookdate);
                    htm += `
                    <tr>
                    <th class="coi1">${d.booknumber}</th>
                    <th class="coi2">${d.bookid}</th>
                    <th class="coi3">${d.bookname}</th>
                    <th class="coi4">${d.stock}</th>
                    <th class="coi5">${d.kind}</th>
                    <th class="coi6">${d.location}</th>
                    <th class="coi7">${time}</th>
                    <th class="coi8">${d.author}</th>
                    <th class="col9"><a href='#' onclick="unchange1(\'${d.booknumber}\')">修改</a><a href='#' onclick="delbook('${d.booknumber}')">删除</a></th>
                </tr>
                `
                }
                document.getElementById("bodyt2").innerHTML = htm;
                window.localStorage.setItem("user", res.data);
                // window.location.href = './main.html
            }
        }else{
            console.log(xmlhttp.readyState)
        }
    }
    
    xmlhttp.open('POST',url,true);
    xmlhttp.setRequestHeader("Content-Type","application/json");
    xmlhttp.send();
// }
// getBook()