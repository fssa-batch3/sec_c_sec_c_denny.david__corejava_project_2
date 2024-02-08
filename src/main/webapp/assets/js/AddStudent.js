// Get the modal element
var modal = document.getElementById("addstupopup");
modal.style.display = "none";
var tableClass = document.querySelector(".table");

// Get the button that opens the modal
var openModalButton = document.getElementById("openModalButton");

// Get the <span> element that closes the modal
var closeSpan = document.getElementsByClassName("close")[0];

// Open the modal when the button is clicked
openModalButton.onclick = function() {
	modal.style.display = "block";
	tableClass.style.display = "none";
}

// Close the modal when the <span> (x) is clicked
closeSpan.onclick = function() {
	modal.style.display = "none";
	tableClass.style.display = "block";
}

// Close the modal when the user clicks outside of it
window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none";
		tableClass.style.display = "block";
	}
}

var assignStudentDiv = document.querySelector(".assignStudentDiv");
assignStudentDiv.style.display = "none";
var assignButton = document.querySelectorAll(".assignButton");
var studentEmail = document.querySelectorAll(".studentEmail");
var selectedStudentEmail = document.getElementById("selectedStudentEmail");
var selectedStudentClassNum = document.getElementById("selectedStudentClassNum");
	assignButton.forEach((e, i) => {
		e.addEventListener("click", el => {
		selectedStudentEmail.value=studentEmail[i].innerText;
		assignStudentDiv.style.display = "block";
		window.location.href="#assignStudent";
		})
	})

	
	