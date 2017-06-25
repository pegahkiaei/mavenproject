function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

 function show(aval) {
    if (aval == "ترم اول95-96") {
	hiddenDiv2.style.display='none';
	
    hiddenDiv.style.display='block';
    Form.fileURL.focus();
    } 
	
    else if (aval == "ترم دوم95-96"){
    hiddenDiv.style.display='none';
	
	hiddenDiv2.style.display='block';
    Form.fileURL.focus();
    }
	
   
  }


