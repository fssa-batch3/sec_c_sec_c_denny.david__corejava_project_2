	/**
 * 
 */
let popup = document.getElementById("popup");
popup.style.display = "none";

const form = document.getElementById('navForm');

form.addEventListener('click',function (e) {
    e.preventDefault();    
})

let assign_Student = document.getElementById("assign_student");
assign_Student.addEventListener("click",function(){
	popup.style.display = "block";
})
let assign_button = document.getElementById("assign");
assign_button.addEventListener('click',function(e){
   popup.style.display="none"
})
var close = document.getElementById("close");
close.addEventListener("click", function(){
    document.querySelector(".popup").style.display = "none";
});